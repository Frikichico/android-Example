package com.android.pdfreader;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class PDFReaderActivity extends Activity {
	WebView mWebView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        mWebView =(WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setPluginsEnabled(true);
        mWebView.loadUrl("https://docs.google.com/gview?embedded=true&url=");
        //mWebView.loadUrl("http://docs.google.com/gview?embedded=true&url=http://myurl.com/demo.pdf");
      //  mWebView.loadUrl("https://docs.google.com/a/gloscon.com/file/d/0B6x_2wsXrcOfNzRjMWM1ZmYtNGY5ZC00OTQ5LWE3MWQtZTE3YzBkYTkzNGFj/edit?pli=1");
    }
}