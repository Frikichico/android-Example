package com.rahul.android.Gestures;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Bundle;
import android.provider.Contacts;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class GesturesActivity extends ListActivity implements OnGesturePerformedListener {
	private GestureLibrary mLibrary;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Populate the activity with the names of our contacts
        Cursor query = managedQuery(Contacts.People.CONTENT_URI,
        		new String[] { Contacts.People._ID, Contacts.People.DISPLAY_NAME },
        		null, null, Contacts.People.DEFAULT_SORT_ORDER);

        ListAdapter adapter = new SimpleCursorAdapter(this,
        		android.R.layout.simple_list_item_1, query,
        		new String[] { Contacts.People.DISPLAY_NAME },
        		new int[] { android.R.id.text1 });
        
        setListAdapter(adapter);
		

        //	mLibrary = GestureLibraries.fromRawResource(getApplicationContext(),
			//	R.raw.actions);
		 mLibrary = GestureLibraries.fromRawResource(this, R.raw.actions);
		if (!mLibrary.load()) {
			finish();
		}

		GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
		gestures.addOnGesturePerformedListener(this);
	}

	/*
	 * public void onGesturePerformed(GestureOverlayView overlay, Gesture
	 * gesture) { ArrayList<Prediction> predictions =
	 * mLibrary.recognize(gesture);
	 * 
	 * // We want at least one prediction if (predictions.size() > 0) {
	 * Prediction prediction = predictions.get(0); // We want at least some
	 * confidence in the result if (prediction.score > 1.0) { // Show the spell
	 * Toast.makeText(this, prediction.name, Toast.LENGTH_SHORT).show(); } }
	 */
	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
		ArrayList<Prediction> predictions = mLibrary.recognize(gesture);
		if (predictions.size() > 0 && predictions.get(0).score > 1.0) {
			String action = predictions.get(0).name;
			if ("action_add".equals(action)) {
				Toast.makeText(this, "Adding a contact", Toast.LENGTH_SHORT)
						.show();
			} else if ("action_delete".equals(action)) {
				Toast.makeText(this, "Removing a contact", Toast.LENGTH_SHORT)
						.show();
			} else if ("action_refresh".equals(action)) {
				Toast.makeText(this, "Reloading contacts", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

}