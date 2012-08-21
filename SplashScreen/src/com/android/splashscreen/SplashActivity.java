package com.android.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.support.v4.app.NavUtils;

public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        Handler h = new Handler();
       h.postDelayed(new SplashHandler(), 4000);
    }

    class SplashHandler implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(),Main.class) );
			SplashActivity.this.finish();
			
		}
    	
    }
        
}

/*
public class SplashScreen extends Activity {

	private static final int STOPSPLASH = 0;

	private static final long SPLASHTIME = 100;
	SessionID session;

	private Handler splashHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case STOPSPLASH:

				  session = new SessionID();
				
				SharedPreferences userDetails = getSharedPreferences(
						"userdetails", MODE_PRIVATE);
				Editor edit = userDetails.edit();
				edit.clear();
				edit.commit();
				SessionID.setUserID(0);
				
				// remove SplashScreen from view
				Intent intent = new Intent(SplashScreen.this,
						CheerfoolznativeActivity.class);
				startActivity(intent);
				break;
			}
			super.handleMessage(msg);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		Message msg = new Message();
		msg.what = STOPSPLASH;
		splashHandler.sendMessageDelayed(msg, SPLASHTIME);
	}
}*/



/*Handler handler;

public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
     this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    
    setContentView(R.layout.splash);

     handler = new Handler();

    new AsyncTask<Void, Void, Void>() {

    @Override
    protected Void doInBackground(Void... params) {
            //Do some heavy stuff
            return null;
        } 

        @Override
        public void onPostExecute(Void result){
            handler.post(new Runnable(){
                 @Override
                 public void run(){
                    // setContentView(R.layout.main);
                      
                        Intent intent = new Intent(SplashScreen.this, AndroidTabAndListView.class);
    startActivity(intent);
                 }
            });
        }
   };
}
}*/