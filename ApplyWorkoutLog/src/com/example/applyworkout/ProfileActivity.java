package com.example.applyworkout;

import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends Activity {
	//deklarerar textvy, Textfält och strängar
	TextView headProfile;
	EditText editName, editLength, editWeigth, editMotiv;
	String FILENAME = "profile.txt";

	//Skapande metod
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//sätter layouten till profilvyn
		setContentView(R.layout.activity_profile);
		//ta kontrol över textfält och textvyer
		headProfile = (TextView)findViewById(R.id.headProfile);
		editName = (EditText)findViewById(R.id.editName);
		editLength = (EditText)findViewById(R.id.editLength);
		editWeigth = (EditText)findViewById(R.id.editWeigth);
		editMotiv = (EditText)findViewById(R.id.editMotiv);
	}
	
	
	//klickfunktion till knappen Save
	public void ckSave(View view) throws Exception{
		
		//String strInput = "";
		
		//skapa lista för text input information
		String[] saveVal = {
								editName.getText().toString(),
								editLength.getText().toString(),
								editWeigth.getText().toString(),
								editMotiv.getText().toString()
								
							};
		/*
		String filepath = getFilesDir().toString() + "/profile.txt";
		FileOutputStream out = new FileOutputStream(filepath, true);
		for(int q = 0; q < saveVal.length; q++){
			out.write(saveVal[q].getBytes());
			//out.write(System.getProperty("line.separator"));
			out.write("\n".getBytes());
		}*/
		
		//läser in text och gör om till bytes och lagrar i ett ext dokument
		//FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		for(int i = 0; i <saveVal.length; i++){
			fos.write((saveVal[i]+" ").getBytes());
		}
		fos.close();
		
		//out.write(System.getProperty("line.separator").getBytes());
		
		//out.close();
		//byt till nästa Activity klass MainActivity
		 Intent newIntent = new Intent(this, MainActivity.class); 
   	 	startActivity(newIntent); 
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

}
