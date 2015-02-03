package com.example.applyworkout;

import java.io.FileInputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class GrafActivity extends Activity {
	//Deklarerar
	Paint stil;
	String FILENAME, EX, MO, nogot;
	TextView j;
	
	//Skapande funktion
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_graf);
			//testar
			try {
				//kallar p� l�s funktion
				read();
				//f�ngar om n�got �r fel
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//skriv ut fel
				e1.printStackTrace();
			}
			//testar
			try {
				//byt till n�sta Activity klass MinView
				setContentView(new MinView(this));
				//f�ngar om n�got �r fe
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//skriv ut fel
				e.printStackTrace();
			}
			
		}
	
	public void read()throws IOException{
		//h�mtar variablar fr�n tidigare klass
		Intent intent = getIntent();
		EX = intent.getStringExtra("EX2");
		MO = intent.getStringExtra("MO2");
		//s�tter ihopp �vning och datum till filnamn
		FILENAME = EX + MO + ".txt";
		//lokaliserar fil o �ppnar den
		 FileInputStream out = openFileInput(FILENAME);
			int read = -1;
			StringBuffer buffer = new StringBuffer();
			while((read = out.read())!=-1){
				buffer.append((char)read);
			}
			
			//Log.d("Rasmus", buffer.toString());
			
			nogot = buffer.substring(0);
			//j.setText(nogot);
	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.graf, menu);
		return true;
	}

}
