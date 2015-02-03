package com.example.applyworkout;

import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class ShowRes extends Activity {
	
	//Deklarerar variablar se vid vidare beskrivning
	TextView ExText, Rep, Set, Com, rbText, TW;
	String FileName = "/";
	String intSpin1, intSpin2;
	Spinner spn1;
	Spinner spn2;
	String temp;
	String EX, rep, set, rb, tW;
	
	//String FILENAME = "EXBase.txt";
	
	//Skapande metod
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//s�tter layouten till visa resutat
		setContentView(R.layout.activity_show_res);
		
		//ta kontroll �ver datum spinners
		spn1 = (Spinner)findViewById(R.id.spinner1);
		spn2 = (Spinner)findViewById(R.id.spinner2);
	}
	
	
	
	
	//klickfunktion till resutlat knappen
	public void ckRes(View v) throws Exception{
		
		//h�mta input fr�n tidigare klass
		Intent intent = getIntent();
		EX = intent.getStringExtra("EX");
		rep = intent.getStringExtra("rep");
		set = intent.getStringExtra("set");
		//String comment = intent.getStringExtra("comment");
		rb = intent.getStringExtra("rb");
		tW = intent.getStringExtra("tW");
		
		//ta kontroll �ver datum
		intSpin1 = spn1.getSelectedItem().toString();
		intSpin2 = spn2.getSelectedItem().toString();
		
		//g�r om alla v�rden till lista
		String[] str = {/*EX,*/ intSpin2, rep, set, /*comment,*/tW , rb};
		
		//ers�tt mellanrum i filnamnet och l�gg till �vning i filnamnet
		FileName += EX.replaceAll("[\n\r]", "");
		FileName = FileName.replaceAll("[\n\r]", "");
		
		// l�gg till datum i filnamn
		FileName += intSpin1 + ".txt";
		
		
		//FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		
		//letar upp fil och om den inte finns skapas en ny
		String filepath = getFilesDir().toString() + FileName;
		FileOutputStream out = new FileOutputStream(filepath, true);
		
		// g�r igenom hela listan 
		for(int i = 0; i <str.length; i++){
			//skriver och g�r om str�ngen till filen
			out.write((str[i]+" ").getBytes());
		}
		//g�r slutt�cken
		out.write(("_").getBytes());
		out.close();
		
		//byt till n�sta Activity klass MainActivity
		Intent grafIntent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(grafIntent);
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_res, menu);
		return true;
	}
	

}
