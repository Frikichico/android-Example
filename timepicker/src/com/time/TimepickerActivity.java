package com.time;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimepickerActivity extends Activity implements OnClickListener{
	TextView myTime;
	Button myButton;
	
	  int mHour;
	  int mMinute;
	  static final int TIME_ID= 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myButton=(Button)findViewById(R.id.main_change_button);
        myTime=(TextView)findViewById(R.id.main_timeDisplay);
        
        myButton.setOnClickListener(this);
        
        Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // display the current date
        updateDisplay();
    }
	private void updateDisplay() {
		// TODO Auto-generated method stub
		 myTime.setText(
			        new StringBuilder()
			                .append(pad(mHour)).append(":")
			                .append(pad(mMinute)));
		
	}
	private Object pad(int c) {
		 if (c >= 10)
		        return String.valueOf(c);
		    else
		        return "0" + String.valueOf(c);
	}
		   
	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if(v.getId()==(R.id.main_change_button))
		{
			 showDialog(TIME_ID);

		}
	}	
			private TimePickerDialog.OnTimeSetListener mTimeSetListener =
		    new TimePickerDialog.OnTimeSetListener() {
		        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		            mHour = hourOfDay;
		            mMinute = minute;
		            updateDisplay();
		        }
		    };
	
		  //  @Override
		    protected Dialog onCreateDialog(int id) {
		        switch (id) {
		        case TIME_ID:
		            return new TimePickerDialog(this,
		                    mTimeSetListener, mHour, mMinute, false);
		        }
		        return null;
		    }

    
}