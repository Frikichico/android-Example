package net.londatiga.android.whatsnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.SharedPreferences;

import android.view.LayoutInflater;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends Activity {
	private static final String PRIVATE_PREF = "myapp";
	private static final String VERSION_KEY = "version_number";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        init();
    }
    
    private void init() {
    	SharedPreferences sharedPref= getSharedPreferences(PRIVATE_PREF, Context.MODE_PRIVATE);
    	int currentVersionNumber = 0;
		
		int savedVersionNumber	= sharedPref.getInt(VERSION_KEY, 0);
		
		try {
   	 		PackageInfo pi 	= getPackageManager().getPackageInfo(getPackageName(), 0);
    	 	currentVersionNumber = pi.versionCode;
   	 	} catch (Exception e) {}
   	 	
   	 	
   	 	if (currentVersionNumber > savedVersionNumber) {   	 		
   	 		showWhatsNewDialog();
   	 		
   	 		Editor editor = sharedPref.edit();
   	 		
   	 		editor.putInt(VERSION_KEY, currentVersionNumber);
   	 		editor.commit();
   	 	}
	}
    
    private void showWhatsNewDialog() {
    	LayoutInflater inflater = LayoutInflater.from(this);		
		
        View view	= inflater.inflate(R.layout.dialog_whatsnew, null);
      	
  	  	Builder builder	= new AlertDialog.Builder(this);

	  	builder.setView(view).setTitle("Whats New")
	  	.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	  		@Override
	  		public void onClick(DialogInterface dialog, int which) {
	  			dialog.dismiss();
	  		}
	    });
  	
	  	builder.create().show();
    }
}