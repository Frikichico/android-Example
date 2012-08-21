package com.rahul.tabbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);

		TextView txtView = (TextView) findViewById(R.id.txtDisplayedTab);
		txtView.setText("Third Tab is Selected");
	}


}
