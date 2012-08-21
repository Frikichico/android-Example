package com.paresh.readfilesdcard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class ReadFileSDCardActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Find the view by its id
        TextView tv = (TextView)findViewById(R.id.fileContent);
        
        File dir = Environment.getExternalStorageDirectory();
        //File yourFile = new File(dir, "path/to/the/file/inside/the/sdcard.ext");
        
        //Get the text file
        File file = new File(dir,"hello.txt");
        // i have kept text.txt in the sd-card
      
        if(file.exists())   // check if file exist
        {
        	  //Read text from file
            StringBuilder text = new StringBuilder();
          
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
            }
            catch (IOException e) {
                //You'll need to add proper error handling here
            }
            //Set the text
            tv.setText(text);
        }
        else
        {
        	tv.setText("Sorry file doesn't exist!!");
        }
     }  
}