package com.example.applyworkout;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class store extends Activity {
	
	//FileOutputStream fos;
	EditText dateText;
	TextView TW;
	String FILENAME = "myStorage.txt";
	String string = "hello World ";
	String intSpin1, intSpin2;
	Spinner spn1 = (Spinner)findViewById(R.id.spinner1);
	Spinner spn2 = (Spinner)findViewById(R.id.spinner2);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store);
		
		
	}
	
	
	

	public void ckStore(View view) throws Exception{
		//dateText = (EditText)findViewById(R.id.editDT);
		//String dT = dateText.getText().toString();
		
		//TW = (TextView)findViewById(R.id.idT);
		intSpin1 = spn1.getSelectedItem().toString();
		intSpin2 = spn2.getSelectedItem().toString();
		
		

		
		FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		byte[] buf = string.getBytes();
		fos.write(buf);
		fos.close();
		
		
		FileInputStream out = openFileInput(FILENAME);
		int read = -1;
		StringBuffer buffer = new StringBuffer();
		while((read = out.read())!=-1){
			buffer.append((char)read);
		}
		
		//Log.d("Rasmus", buffer.toString());
		
		String nogot = buffer.substring(0, buffer.indexOf(" "));
		nogot += " " + buffer.substring(buffer.indexOf(" ")+1);
		//String filepath = getFilesDir().toString() + "/contact.txt";
		//FileOutputStream out = new FileOutputStream(filepath, true);
		//out.write(dT.getBytes());
		//out.close();
		
		TW.setText(nogot);
		
		Intent grafIntent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(grafIntent);
	
	}

	 

}
