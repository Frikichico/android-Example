package com.rahul.localization;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LOcalizationActivity extends Activity {
    /** Called when the activity is first created. */
	 Button b;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       b = (Button)findViewById(R.id.flag_button);
       b.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.flag));

        // build dialog box to display when user clicks the flag
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_text)
            .setCancelable(false)
            .setTitle(R.string.dialog_title)
            .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                }
            });
        final AlertDialog alert = builder.create();

        // set click listener on the flag to show the dialog box 
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                alert.show();
            }
            });
    }
}