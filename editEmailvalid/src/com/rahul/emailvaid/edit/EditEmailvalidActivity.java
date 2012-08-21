package com.rahul.emailvaid.edit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditEmailvalidActivity extends Activity {
	/** Called when the activity is first created. */
	EditText editTextEmail;
	String strEmailAddress;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		editTextEmail = (EditText) findViewById(R.id.editTextEmail);
	}

	String regEx = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
			+ "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
			+ "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";

	/*
	 * "^(([\w-]+\.)+[\w-]+|([a-zA-Z]{1}|[\w-]{2,}))@"
	 * +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\.([0-1]?"
	 * +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\."
	 * +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\.([0-1]?"
	 * +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
	 * +"([a-zA-Z]+[\w-]+\.)+[a-zA-Z]{2,4})$";
	 */
	/*
	 * (?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|
	 * "(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])
	 * *
	 * ")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9]
	 * )
	 * ?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-
	 * 9
	 * ]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-
	 * \x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
	 */
	public void btnValidateEmailAddress(View v) {
		strEmailAddress = editTextEmail.getText().toString().trim();

		Matcher matcherObj = Pattern.compile(regEx).matcher(strEmailAddress);

		if (matcherObj.matches()) {
			Toast.makeText(v.getContext(), strEmailAddress + " is valid",
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(v.getContext(), strEmailAddress + " is InValid",
					Toast.LENGTH_SHORT).show();
		}
	}
}