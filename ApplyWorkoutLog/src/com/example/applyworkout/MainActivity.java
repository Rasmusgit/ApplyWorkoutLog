package com.example.applyworkout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

//Skapar Activity klass
public class MainActivity extends Activity {
	
	//Deklarerar ett en textvy
	private TextView lbl;
	
	
	//Skapande funktion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sätter layouten till startvyn
        setContentView(R.layout.start); 
    }
    
    //klickfunktion till knappen New
    public void ckNew(View v){ 
    	//byt till nästa Activity klass PageNew
    	 Intent newIntent = new Intent(this, PageNew.class); 
    	 startActivity(newIntent); 
    }
    
    //klickfunktion till Knappen Load
    public void ckLoad(View v){ 
    	//byt till nästa Activity klass ResSelect
	   	 Intent loadIntent = new Intent(this, ResSelect.class); 
	   	 startActivity(loadIntent);
    	
    }
   
    //klickfunktion till Knappen Profile
    public void ckPro(View v){ 
    	//byt till nästa Activity klass ProfileActivity
	   	 Intent proIntent = new Intent(this, BarChartExampleActivity.class); 
	   	 startActivity(proIntent);
    	
    } 


    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
}
