package com.example.applyworkout;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;

//Skapar Activity klass
public class ResSelect extends Activity {
	//Deklarerar Spinner och st�ng variablar
	String Spin1,Spin2;
	Spinner spn1;
	Spinner spn2;
	//Spinner spn1 = (Spinner)findViewById(R.id.spinner1);
	//Spinner spn2 = (Spinner)findViewById(R.id.spinner2);
	
	//Skapande metod
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//s�tt layouten till selectvyn 
		setContentView(R.layout.activity_res_select);
		
		//TAR KONTROLL �VER TV� SPINNERS
		spn1 = (Spinner)findViewById(R.id.spinner1);
		spn2 = (Spinner)findViewById(R.id.spinner2);
	}
	
	//klickfunktion till Select
	public void ckSel(View view) throws Exception{
		
		//H�mtar inputv�rden datuum och �vning
		Spin1 = spn1.getSelectedItem().toString();
		Spin2 = spn2.getSelectedItem().toString();
	  
		//byt till n�sta Activity klass GrafActivity
		Intent selIntent = new Intent(getApplicationContext(), GrafActivity.class);
		
		//skicka med instiks variablar
		selIntent.putExtra("EX2", Spin1);
		selIntent.putExtra("MO2", Spin2);
		
		startActivity(selIntent);
	   	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.res_select, menu);
		return true;
	}

}
