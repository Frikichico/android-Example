package com.example.androidhive.sax;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.androidhive.R;
import com.example.androidhive.sax.SAXParserActivity.LoadInbox;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends BaseAdapter 
{
	private Activity activity;
    private ArrayList<HashMap<String, String>> ITEMS;
    private static LayoutInflater inflater=null;
   // public ImageLoader imageLoader; 
    private int[] colors = new int[] { 0x30ffffff, 0x30808080 };
    public myAdapter(Activity loadInbox, ArrayList<HashMap<String, String>> d) {
        activity = loadInbox;
        ITEMS=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // imageLoader=new ImageLoader(activity.getApplicationContext());
        //System.out.println("value of adapter==============>"+d);
    }


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ITEMS.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	private class ViewHolder
	{
		TextView Titletxt;
		TextView Artisttxt;
		TextView countrytxt;
		
	}
		
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
				
		ViewHolder item;
		LayoutInflater inflater = activity.getLayoutInflater();
		
		if(view==null)
		{
			 view = inflater.inflate(R.layout.lview_row, null);
			item = new ViewHolder();
			
			item.Titletxt= (TextView) view.findViewById(R.id.txtViewTitle);
			item.Artisttxt = (TextView) view.findViewById(R.id.txtViewDescription);
			item.countrytxt = (TextView) view.findViewById(R.id.txtViewDate);
						
			view.setTag(item);
		}
		else
		{
			item = (ViewHolder) view.getTag();
		}
		
		  int colorPos = position % colors.length;
		  view.setBackgroundColor(colors[colorPos]);
		
		
		  HashMap<String, String> data = new HashMap<String, String>();
	        data = ITEMS.get(position);
	    
	        item.Titletxt.setText(data.get(SAXParserActivity.KEY_TITLE));
	        item.Artisttxt.setText(data.get(SAXParserActivity.KEY_ARTIST));
	        item.countrytxt.setText(data.get(SAXParserActivity.KEY_COUNTRY));
	        
	       // imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);
			      	
		return view;
	}
}