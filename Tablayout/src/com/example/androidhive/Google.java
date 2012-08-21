package com.example.androidhive;

import com.example.androidhive.abc.Activites_Activity;
import com.example.androidhive.sax.SAXParserActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Google extends Activity implements OnItemClickListener{
	
	ListView lview3;  
	private ListviewAdapter adapter; 
  
    private static String month[] = {"ENTREPRENEUR NEWS","FORBES NEWS","GOOGLE NEWS","YAHOO NEWS"};  
  
    private static String desc[] = {"Entrepreneur desc","Forbes desc","Google desc",  
        "Yahoo desc"};  
  
   
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.google);
  
        lview3 = (ListView) findViewById(R.id.listView);  
        adapter = new ListviewAdapter(this, month, desc);  
        lview3.setAdapter(adapter);  
        lview3.setOnItemClickListener(this);
               
    }
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	    switch(position){
	        case 0:
	            Intent firstIntent = new Intent(this, Activites_Activity.class);
	            startActivity(firstIntent);
	            break;  
	        case 1:
	            Intent secondIntent = new Intent(this, SAXParserActivity.class);
	            startActivity(secondIntent);
	                    break;


	   }    

	}
    
	/*@Override  
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {  
        // TODO Auto-generated method stub  
        Toast.makeText(this, "Title => "+month[position]+" n Description => "+desc[position], Toast.LENGTH_SHORT).show();
        
        
        Intent in1= new Intent(this,Activites_Activity.class);
        startActivity(in1);
    }  */
}  