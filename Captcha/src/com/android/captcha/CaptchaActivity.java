package com.android.captcha;

import com.android.captcha.MathCaptcha.MathOptions;
import com.android.captcha.TextCaptcha.TextOptions;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CaptchaActivity extends Activity {

	ImageView im;
	Button btn;
	TextView ans;
	EditText editanswer;
	Captcha c;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        im = (ImageView)findViewById(R.id.imageView1);
        btn = (Button)findViewById(R.id.button1);
        ans = (TextView)findViewById(R.id.textView1);
        editanswer = (EditText) findViewById(R.id.editText1);
        
        displayCaptcah();
        
    }
	
	private void displayCaptcah() {
		// TODO Auto-generated method stub
		 //c = new TextCaptcha(300, 100, 5, TextOptions.NUMBERS_AND_LETTERS);
		 c = new MathCaptcha(300, 100, MathOptions.PLUS_MINUS_MULTIPLY); 
	        im.setImageBitmap(c.image);
			im.setLayoutParams(new LinearLayout.LayoutParams(c.width *2, c.height *2));
	        im.setImageBitmap(c.image);
			im.setLayoutParams(new LinearLayout.LayoutParams(c.width *2, c.height *2));
		
	}

	public void showcaptcha(View v){
		
		
	
		String answer = editanswer.getText().toString();
		
		if(answer.equals("")){
			Toast.makeText(getApplicationContext(), "Enter the value of the captcha",Toast.LENGTH_SHORT).show();
		}
		else {
			
			int a=Integer.parseInt(answer);
			int b= Integer.parseInt(c.answer);
			Toast.makeText(getApplicationContext(), "value of the a:"+a,Toast.LENGTH_SHORT).show();
			
			if(a == b){
				ans.setText("Success !!!");
				displayCaptcah();
				editanswer.setText("");
				
			}
			else {
				ans.setText("Try again!!!");
				displayCaptcah();
				editanswer.setText("");
			}
		}
		
			
		
		
	}
	
}