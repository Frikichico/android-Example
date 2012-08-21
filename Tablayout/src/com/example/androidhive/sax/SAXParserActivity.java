package com.example.androidhive.sax;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.example.androidhive.InboxActivity;
import com.example.androidhive.R;
import com.example.androidhive.abc.ActivitiesBean;
import com.example.androidhive.abc.ActivityAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class SAXParserActivity extends Activity {
	
	private ProgressDialog pDialog;
     ItemBean data;
     
    ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
	private myAdapter rssadaptor = null;
	ListView lview;

	static final String KEY_CATLOG = "CATALOG"; // parent node
	static final String KEY_CD = "CD";
	static final String KEY_TITLE = "title";
	static final String KEY_ARTIST = "Artist";
	static final String KEY_COUNTRY = "Contry";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.google);
		
		new LoadInbox().execute();
	}
	
	
	public class LoadInbox extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(SAXParserActivity.this);
			pDialog.setMessage("Loading sax parser...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * getting XML DATA
		 * */
		protected String doInBackground(String... args) {
					
			try {
				
				/**
				 * Create a new instance of the SAX parser
				 **/
				SAXParserFactory saxPF = SAXParserFactory.newInstance();
				SAXParser saxP = saxPF.newSAXParser();
				XMLReader xmlR = saxP.getXMLReader();

				URL url = new URL("http://www.xmlfiles.com/examples/cd_catalog.xml"); // URL of the XML
				
				/** 
				 * Create the Handler to handle each of the XML tags. 
				 **/
				XMLHandler myXMLHandler = new XMLHandler();
				xmlR.setContentHandler(myXMLHandler);
				xmlR.parse(new InputSource(url.openStream()));
				
			} catch (Exception e) {
				System.out.println(e);
			}

			data = XMLHandler.data;
			
			/** 
			 * Run a for loop to set All the TextViews with text until 
			 * the size of the array is reached.
			 * 
			 **/
			for (int i = 0; i < data.getTitle().size(); i++) {
				
				//System.out.println("value of i==============>"+i);
				HashMap<String, String> map = new HashMap<String, String>();
				
				//System.out.println("value of title==============>"+ data.getTitle().get(i));
				 
				map.put("title", data.getTitle().get(i));
				map.put("Artist", data.getArtist().get(i));
				map.put("Contry", data.getCountry().get(i));

				 items.add(map);
									
				//rssadaptor = new myAdapter(SAXParserActivity.this, items);
			}
					

			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog after getting all products
			pDialog.dismiss();
			displayAdapter();
		
		}
	
	}
	
	public void displayAdapter()
	{
		lview = (ListView) findViewById(R.id.listView);
		System.out.println("value of i==============>"+items);
		// Getting adapter by passing xml data ArrayList
		rssadaptor = new myAdapter(this, items);
		lview.setAdapter(rssadaptor);
		
	}
}