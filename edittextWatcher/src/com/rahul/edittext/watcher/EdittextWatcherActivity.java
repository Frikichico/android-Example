package com.rahul.edittext.watcher;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EdittextWatcherActivity extends Activity {
	/** Called when the activity is first created. */
	 EditText mPasswordLength;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		
		mPasswordLength = (EditText) findViewById(R.id.editText1);
		mPasswordLength.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s)
			{
				//int count = mPasswordLength.getText().toString().length();
				Toast.makeText(EdittextWatcherActivity.this, "after text changed",
						Toast.LENGTH_SHORT).show();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				Toast.makeText(EdittextWatcherActivity.this, "beforetextchanged",
						Toast.LENGTH_SHORT).show();
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				Toast.makeText(EdittextWatcherActivity.this, "ontextchanged",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
		 public void btnClick(View v)  
		    {  
		        if(mPasswordLength.getText().toString().length()==0)  
		        {  
		        	mPasswordLength.setError("please input text");
		        	Toast.makeText(EdittextWatcherActivity.this, "Enter the some text",
							Toast.LENGTH_SHORT).show();
		        }  
		    } 
	
}