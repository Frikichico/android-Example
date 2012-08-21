package com.rahul.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JAVAtoJSONActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView txt = (TextView) findViewById(R.id.textview);
           
        /**
         *  convert the JSON from the JAVA
         *  
         *  Like this type of JSON [{"value":"test"}]
         *  
         */
        
        JSONObject JSONValue = new JSONObject();
       	//List<String> list = new ArrayList<String>();
    	// list is used for the Create the "[" , "]"
       	
       	JSONArray jsonarray = new JSONArray();
      	try {

			JSONValue.put("value", "test");
			
			//list.add(JSONValue.toString());
			jsonarray.put(JSONValue);
			
			txt.setText(jsonarray.toString());
			System.out.println("=============> value of the list :"+jsonarray);
			
			//JSONValue.put("jsonValues", list.toString());
			 
			 System.out.println("=============> value of the json :"+JSONValue);

		} catch (Exception e) {
		}
		
        
        /**
         *  convert the JSON from the JAVA
         *  
         *  Like this type of JSON {"6":{"tid":"6"}}
         *  
         */
        
		
		/*JSONObject JSONValue1 = new JSONObject();
       	//List<String> list1 = new ArrayList<String>();	
       	int  a=6; 
		
       	try {

       		JSONObject Json = new JSONObject();
       		Json.put("tid", ""+a);
			
			JSONValue1.put(""+a, Json);
			
			//list1.add(JSONValue1.toString());
			
			//txt.setText(JSONValue1.toString());
			System.out.println("=============> value of the list :"+JSONValue1);
						
		} 
       	    catch (Exception e) {
		}*/
        
        
        
		try {
			JSONStringer combineallnode123 = new JSONStringer().object().key("type").value("idea").key("title").value("HELLO").key("field_story_idea").
					value("sfsfjsdjjdxjd").key("field_founder_profile_refrence").value("111").
					key("field_idea_budget").value("2").key("field_idea_details").
					value("dfdvxcvvdvvdv").key("taxonomy").value(jsonarray).endObject();
			
			System.out.println("hello this is responce"+combineallnode123);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
        
      
	}
}