package com.stuff;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class HellofromstuffActivity extends Activity implements OnClickListener{
	
	Button button;
	EditText edittext;
	CheckBox checkbox;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button = (Button) findViewById(R.id.main_button);
        button.setOnClickListener(this);
        
         checkbox= (CheckBox) findViewById(R.id.main_checkbox);
        checkbox.setOnClickListener(this);
        
        
         final ToggleButton togglebutton = (ToggleButton) findViewById(R.id.main_togglebutton);
         togglebutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (togglebutton.isChecked()) {
		            Toast.makeText(HellofromstuffActivity.this, "Checked", Toast.LENGTH_SHORT).show();
		        } else {
		            Toast.makeText(HellofromstuffActivity.this, "Not checked", Toast.LENGTH_SHORT).show();
		        }
			}
		});
         
         
         
        
         RadioButton radio_red = (RadioButton) findViewById(R.id.main_radio_red);
         RadioButton radio_blue = (RadioButton) findViewById(R.id.main_radio_blue);
         
        OnClickListener radio_listener=new OnClickListener() {
        	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RadioButton rb = (RadioButton) v;
		        Toast.makeText(HellofromstuffActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
			}
		};
		radio_red.setOnClickListener(radio_listener);
        radio_blue.setOnClickListener(radio_listener);
        

        
        edittext = (EditText) findViewById(R.id.main_edittext);
        edittext.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
			 if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
	                    (keyCode == KeyEvent.KEYCODE_ENTER)) 
				{
					Toast.makeText(HellofromstuffActivity.this, edittext.getText(), Toast.LENGTH_SHORT).show();
                  return true;
				}
				
				return false;
			}
		});
        
        
        final RatingBar ratingbar = (RatingBar) findViewById(R.id.main_ratingbar);
        	ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
				
				@Override
				public void onRatingChanged(RatingBar ratingBar, float rating,
						boolean fromUser) {
					// TODO Auto-generated method stub
					Toast.makeText(HellofromstuffActivity.this, "New Rating: " + rating, Toast.LENGTH_SHORT).show();

				}
			});
        
    }
    
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==(R.id.main_button))
		{
		Toast.makeText(HellofromstuffActivity.this, "Beep Bop", Toast.LENGTH_SHORT).show();
		}
		if(v.getId()==(R.id.main_checkbox))
		{
			
	        CheckBox chk=(CheckBox) v;
			if (chk.isChecked()) {
	            Toast.makeText(HellofromstuffActivity.this, "Selected", Toast.LENGTH_SHORT).show();
	        } else {
	            Toast.makeText(HellofromstuffActivity.this, "Not selected", Toast.LENGTH_SHORT).show();
	        }

		}
				
	}
}