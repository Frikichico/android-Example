package com.rahul.tabbar;

import junit.framework.Protectable;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.StaticLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class TabbardemoActivity extends TabActivity implements OnTabChangeListener{
	
	/** when change background color then use 
	 * 	implements OnTabChangeListener 
	 * in above line*/
	
	/** Called when the activity is first created. */
	
	public TabHost tabHost;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		 
	     tabHost = getTabHost();
		
		//for change background color use setOnTabChangedListener method
		tabHost.setOnTabChangedListener(this);
		
		TabHost.TabSpec spec;
		Intent intent;

		intent = new Intent().setClass(this, FirstActivity.class);
		spec = tabHost.newTabSpec("First").setIndicator("First")
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, SecondActivity.class);
		spec = tabHost.newTabSpec("Second").setIndicator("Second")
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ThirdActivity.class);
		spec = tabHost.newTabSpec("Third").setIndicator("Third")
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, FourthActivity.class);
		spec = tabHost.newTabSpec("Fourth").setIndicator("Fourth")
				.setContent(intent);
		tabHost.addTab(spec);
		
		/*Write the below code in onCreate() method to define 
		 * initial background color & Image for the 
		 * selected and unselected tab*/
		
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#8A4117"));
		/*	For the set background image
		 * tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.india);*/
			 
		
		}
		tabHost.getTabWidget().setCurrentTab(0);
		tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#C35817"));
		/*	For the set background image
		 * tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.canada);*/
		  
	}

		/*implement the OnTabChangeListener to current activity
		 *  and then override the onTabChanged() method. 
		 *  In that method, write the below code to define color & image
		 *  for selected tab and unselected tab.*/
	
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub  
        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)  
        {
          	 tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#8A4117"));
          	/*	For the set background image
          	 *  tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.india);
          	 */
         }
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#C35817"));  
        /*	For the set background image
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.canada);
        */
  	}

	
}