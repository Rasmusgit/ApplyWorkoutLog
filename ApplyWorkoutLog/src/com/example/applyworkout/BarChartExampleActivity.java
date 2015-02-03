package com.example.applyworkout;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;

public class BarChartExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart_example);
        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {  
        	      new GraphViewData(1, 40)  
        	      , new GraphViewData(2, 12)  
        	      , new GraphViewData(3, 7)
        	      , new GraphViewData(2, 8)
        	      , new GraphViewData(2, 10)
        	      , new GraphViewData(3, 26)
        	      , new GraphViewData(1, 37)
        	      , new GraphViewData(1, 53)
        	      , new GraphViewData(3, 253)
      	});  
        	GraphView graphView = new BarGraphView(  
        	      this // context  
        	      , "Job Status Graph" // heading  
        	);  
        	graphView.addSeries(exampleSeries); // data  
        	LinearLayout layout = (LinearLayout) findViewById(R.id.layout);  
        	layout.addView(graphView);  
    }
  }