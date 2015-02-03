package com.example.applyworkout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;


public class PageNew extends Activity {
		
		//Deklarerar alla typer av input
		public Spinner spEX;
		public EditText eSet, eRep, eComment, DP, textWeigth;
		public RatingBar RB;
		public String comment, set, rep, EX, rb, tW;
		
		
		//Skapande metod
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			//sätter layouten till new page
			setContentView(R.layout.activity_page_new);
			
			//tar kontroll över inputfuntioner
			//övning
			spEX = (Spinner)findViewById(R.id.spinnerEX);
			//antal set
			eSet = (EditText)findViewById(R.id.editSet);
			//antal repitioner
			eRep = (EditText)findViewById(R.id.editRep);
			//vikt
			textWeigth = (EditText)findViewById(R.id.textWeigth);
			//commentar
			eComment = (EditText)findViewById(R.id.editComment);
			//rankning
			RB = (RatingBar)findViewById(R.id.ratingMode);
			
			
		}
	
		//klickfunktion till submit
		public void ckSubmit(View v){
			
			//Hämta inputvärderna hänvisar till funktioner ovan
			EX = spEX.getSelectedItem().toString();
			comment = eComment.getText().toString();
			set = eSet.getText().toString();
			rep = eRep.getText().toString();
			tW = textWeigth.getText().toString();
			rb = String.valueOf(RB.getRating());
			
			//byt till nästa Activity klass  visa ShowRes
		   	Intent IntentSubmit = new Intent(getApplicationContext(), ShowRes.class);
		   	
		   	//skicka med instiks information
		   	IntentSubmit.putExtra("EX", EX);
		   	IntentSubmit.putExtra("set", set);
		   	IntentSubmit.putExtra("comment", comment);
		   	IntentSubmit.putExtra("rep", rep);
		   	IntentSubmit.putExtra("tW", tW);
		   	IntentSubmit.putExtra("rb", rb);
		   	
		   	startActivity(IntentSubmit);
			 
		}
		
	
		 
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.page_new, menu);
			return true;
		}
		
	
	    
	}

