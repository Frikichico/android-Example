package com.example.androidhive.abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public class util {

	
	//private static DefaultHttpClient httpClient;
	public static DefaultHttpClient httpClient;
	
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 * 
	 * Purpose: Used to make a webcall with fixed username and password
	 * For register
	 */
	public static String makeWebCall(String url, String uname,String mail, String name, String address, String occupation, String dateofbirth)
	{
		DefaultHttpClient client = new DefaultHttpClient();
		
		HttpPost post = new HttpPost(url);
		
		 List<NameValuePair> params = new ArrayList<NameValuePair>();
		
	        params.add(new BasicNameValuePair("name",uname));
	        params.add(new BasicNameValuePair("mail", mail));
	        params.add(new BasicNameValuePair("profile_name",name));
	        params.add(new BasicNameValuePair("profile_address", address));
	        params.add(new BasicNameValuePair("profile_occupation", occupation));
	        params.add(new BasicNameValuePair("DateOfBirth", dateofbirth));
	       	      
        UrlEncodedFormEntity formEntity = null;
		try {
			formEntity = new UrlEncodedFormEntity(params);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        post.setEntity(formEntity);
        
		try {
			//post.setEntity(new StringEntity(requestString));
			
			HttpResponse response = client.execute(post);
			System.out.println("=========> Responsehello => "+response);
			int statusCode = response.getStatusLine().getStatusCode();
			
			if (statusCode == HttpStatus.SC_OK)
			{
				HttpEntity entity = response.getEntity();
				InputStream is = entity.getContent();
				return iStream_to_String(is);
			}
			else
			{
				return "Hello This is status ==> :"+String.valueOf(statusCode);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 *  Makewebcall For login
	 * @param url
	 * @param uname
	 * @param pass
	 * @return
	 */
	public static String makeWebCall(String url, String uname, String pass) {
		DefaultHttpClient client = new DefaultHttpClient();

		HttpPost post = new HttpPost(url);

		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair("username", uname));
		params.add(new BasicNameValuePair("password", pass));

		UrlEncodedFormEntity formEntity = null;
		try {
			formEntity = new UrlEncodedFormEntity(params);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		post.setEntity(formEntity);

		try {
			// post.setEntity(new StringEntity(requestString));

			HttpResponse response = client.execute(post);
			System.out.println("=========> Responsehello => " + response);
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				InputStream is = entity.getContent();
				return iStream_to_String(is);
			} else {
				return "Hello This is status ==> :"
						+ String.valueOf(statusCode);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	/**
	 * 		
	 * @param url
	 * @param username
	 * @param mail
	 * @param subject
	 * @param message
	 * @return
	 * 
	 * 		for the contact us Form
	 */
	
	public static String makeWebCall(String url, String username,String mail, String subject, String message)
	{
		DefaultHttpClient client = new DefaultHttpClient();
		
		HttpPost post = new HttpPost(url);
		
		 List<NameValuePair> params = new ArrayList<NameValuePair>();
		
	        params.add(new BasicNameValuePair("name",username));
	        params.add(new BasicNameValuePair("mail", mail));
	        params.add(new BasicNameValuePair("profile_address", subject));
	        params.add(new BasicNameValuePair("profile_occupation", message));
	        
	       	      
        UrlEncodedFormEntity formEntity = null;
		try {
			formEntity = new UrlEncodedFormEntity(params);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        post.setEntity(formEntity);
        
		try {
			//post.setEntity(new StringEntity(requestString));
			
			HttpResponse response = client.execute(post);
			System.out.println("=========> Responsehello => "+response);
			int statusCode = response.getStatusLine().getStatusCode();
			
			if (statusCode == HttpStatus.SC_OK)
			{
				HttpEntity entity = response.getEntity();
				InputStream is = entity.getContent();
				return iStream_to_String(is);
			}
			else
			{
				return "Hello This is status ==> :"+String.valueOf(statusCode);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	/**
	 * 
	 * @param url
	 * @param requestString - is the JSON Request string
	 * @return String
	 */
	public static String makeWebCall(String url, String requestString)
	{
		DefaultHttpClient client = new DefaultHttpClient();
		
		HttpPost post = new HttpPost(url);
		System.out.println("=========> post => "+post);
		try {
			post.setHeader("Content-Type", "application/json; charset=utf-8");
			
			post.setEntity(new StringEntity(requestString));
			//System.out.println("=========> post.setentity => "+post);
			HttpResponse response = client.execute(post);
			//System.out.println("=========> Responsehello => "+response);
			int statusCode = response.getStatusLine().getStatusCode();
			
			if (statusCode == HttpStatus.SC_OK)
			{
				HttpEntity entity = response.getEntity();
				InputStream is = entity.getContent();
				return iStream_to_String(is);
			}
			else
			{
				return "Hello "+String.valueOf(statusCode);
			}
			} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 *  For activities
	 * @param url
	 * @return
	 */
	
	public static String makeWebCall(String url) {

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet httpRequest = new HttpGet(url);
      //  HttpPost post = new HttpPost(url);

        try {

        	HttpResponse httpResponse = client.execute(httpRequest);
           
        	 final int statusCode = httpResponse.getStatusLine().getStatusCode();

             if (statusCode != HttpStatus.SC_OK) {
              /*  Log.i(getClass().getSimpleName(),
                    "Error => " + statusCode + " => for URL " + url);*/
                return null;
             }
             
            // HttpEntity entity = httpResponse.getEntity();
			//	InputStream is = entity.getContent();
             HttpEntity entity = httpResponse.getEntity();

             InputStream instream = null;

             if (entity != null) {
                  instream = entity.getContent();
             }
             
				return iStream_to_String(instream);
        }
        catch (IOException e) {
        	httpRequest.abort();
          // Log.w(getClass().getSimpleName(), "Error for URL =>" + url, e);
        }

        return null;

     }
	/*public static String makeWebCall(String url) {

		//HttpPost httppost = new HttpPost(url.toString()); //2
	    

       // DefaultHttpClient client = new DefaultHttpClient();

        HttpGet httpRequest = new HttpGet(url);
     //   HttpPost post = new HttpPost(url);

        try {

        	HttpResponse httpResponse = ((AbstractHttpClient) util.httpClient).execute(httpRequest); //2
        	//HttpResponse httpResponse = client.execute(httpRequest);
           
        	 final int statusCode = httpResponse.getStatusLine().getStatusCode();

             if (statusCode != HttpStatus.SC_OK) {
                Log.i(getClass().getSimpleName(),
                    "Error => " + statusCode + " => for URL " + url);
                return null;
             }
             HttpEntity entity = httpResponse.getEntity(); //2
           //  HttpEntity entity = httpResponse.getEntity();
             
             InputStream instream = null;//2
//2
             if (entity != null) {
            	 instream = entity.getContent();
            	 return iStream_to_String(instream);
             }
             //2
             
				//InputStream is = entity.getContent();
				
        }
        catch (IOException e) {
        	httpRequest.abort();
          // Log.w(getClass().getSimpleName(), "Error for URL =>" + url, e);
        }

        return null;

	}*/

	public static String iStream_to_String(InputStream is1) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(is1), 4096);
		String line;
		StringBuilder sb = new StringBuilder();
		try {
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String contentOfMyInputStream = sb.toString();
		return contentOfMyInputStream;
	}

}