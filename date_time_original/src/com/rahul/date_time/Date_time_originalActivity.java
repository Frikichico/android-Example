package com.rahul.date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class Date_time_originalActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.main);
        
		Calendar c = Calendar.getInstance();
		//Toast.makeText(this,"Current time => "+c.getTime(), Toast.LENGTH_SHORT).show();
		System.out.println("Current time => "+c.getTime());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = df.format(c.getTime());
		// formattedDate have current date/time
		Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();
		
		//fro different methods df1,df2,df3
		SimpleDateFormat df1 = new SimpleDateFormat("dd-MMM-yyyy");  
		String formattedDate1 = df1.format(c.getTime());  
		  
		SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");  
		String formattedDate2 = df2.format(c.getTime());  
		  
		SimpleDateFormat df3 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");  
		String formattedDate3 = df3.format(c.getTime());  
		  
		System.out.println("=========> Date 1 => "+formattedDate1);  
		System.out.println("=========> Date 2 => "+formattedDate2);  
		System.out.println("=========> Date 3 => "+formattedDate3);  
		
		//Log.e(formattedDate1, formattedDate1);
		
	  // Now we display formattedDate value in TextView
		TextView txtView = new TextView(this);
		txtView.setText("Current Date and Time : "+formattedDate);
		txtView.setGravity(Gravity.CENTER);
		txtView.setTextSize(20);
		setContentView(txtView);
		
		/*TextView txtView1 = new TextView(this);
		txtView1.setText("Current time => "+c.getTime());
		txtView1.setGravity(Gravity.BOTTOM);
		txtView1.setTextSize(20);
		setContentView(txtView1);*/
	}
	
}