package com.example.applyworkout;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MinView extends View{ 
	//dekllarerar
	//fäger
	Paint stil, stil2, stil3, stil4, stil5, stil6, stil7;
	Paint[] styleColor = new Paint[6];
	//hur många olika vikter?
	int W = 3;
	//positon
	int[][] yPos;
	
	//
	int[] counter = new int[3];
	int fstX, fstY;
	int u;
	
	String text, text2;
	
	Random generator = new Random();
	
	
	
	
		GrafActivity GA = new GrafActivity();
		String readText = GA.nogot;
		
   
	

		
	
	//int [] yPos = {1,3,5,6,5,7,10,3,5,33,5,7,10,3,5,20,5,7,10,23,7};
	//int [] xPos = {1,2,3,4,5,6};
	
	public MinView(Context cxt)throws Exception { 
		super(cxt);
		//initsierar färger
		stil = new Paint(Paint.ANTI_ALIAS_FLAG); 
		stil.setColor(Color.CYAN);
		stil2 = new Paint(Paint.ANTI_ALIAS_FLAG); 
		stil2.setColor(Color.BLACK);
		stil3 = new Paint(Paint.ANTI_ALIAS_FLAG); 
		stil3.setColor(Color.LTGRAY);
		stil4 = new Paint(Paint.ANTI_ALIAS_FLAG); 
		stil4.setColor(Color.MAGENTA);
		stil5 = new Paint(Paint.ANTI_ALIAS_FLAG); 
		stil5.setColor(Color.GREEN);
		stil6 = new Paint(Paint.ANTI_ALIAS_FLAG); 
		stil6.setColor(Color.BLUE);
		styleColor[0]= stil;
		styleColor[1]= stil2;
		styleColor[2]= stil3;
		styleColor[3]= stil4;
		styleColor[4]= stil5;
		styleColor[5]= stil6;

		
		 	
		
	 
	 } 
	
	
	 
	


	protected void onDraw(Canvas cvs){ 
		 
		 //mellanrum
		 int pVal = 20;//rutnäst variabel
		 //sätt bakgrund
		 cvs.drawColor(Color.WHITE);
		 
			yPos = new int[W][30];
			
			
			
			for(int q = 0; q < W; q++){
				for(int e = 0; e < 30; e++){
					yPos[q][e] = generator.nextInt(50) + 1;
					counter[q]++;
				}
			}
		
		 //input
		 int padding = pVal;
		 /*
		 int i = (getHeight()/2);
		 int i2 = (getHeight()/2)%pVal;
		 i2 = pVal - i2;
		 i += i2;
		 //i = i*-1;*//*
		 for(int m = 0; m<W; m++){
			 for(int g = 0; g<counter[g]-1; ){
				 text += Integer.toString(yPos[m][g]);
			 }
		 }
		/*
		 int r =  (getWidth());
		 int r2 = (getWidth())%pVal;
		 r2 = pVal - r2;
		 r += r2;
		 */
		 
		 fstX = padding;
		 fstY = (53*padding)/2;
		 // Frame of the Graph
		 	//top
		 //cvs.drawLine(padding, padding, getWidth()-padding, padding, stil);
		 	//rigth
		// cvs.drawLine(getWidth()-padding, padding, getWidth()-padding, i, stil);
		 	//bottom
		 cvs.drawLine(fstX*2,  fstY, 33*fstX, fstY, stil);
		 	//left
		 cvs.drawLine(fstX*2,  fstY, fstX*2, padding, stil);
		 // end of frame...
		 
		// Frame of the stats
		 			//top
				 //cvs.drawLine(padding, padding+i, getWidth()-padding, padding+i, stil);
				 	//rigth
				 //cvs.drawLine(getWidth()-padding, padding+i, getWidth()-padding, getHeight()-padding, stil);
				 	//bottom
				 //cvs.drawLine(getWidth()-padding, getHeight()-padding, padding, getHeight()-padding, stil);
				 	//left
				 //cvs.drawLine(padding, getHeight()-padding, padding, padding+i, stil);
		// end of frame...
		 
		// cvs.drawText(text, 30, 30, stil2);
		 
		
		 
		 //Grid
		 /*
		 while(i>padding){
			cvs.drawLine(padding, i, getWidth()-padding, i, stil3);
			
			 i-=pVal;
		 }
		 
		 
		 i = (getHeight()/2);
		 i2 = (getHeight()/2)%pVal;
		 i2 = pVal- i2;
		 i += i2;
		 
		 while(r>padding){
			cvs.drawLine(r, padding, r, i, stil3);
			
			 r-=pVal;
		 }*/
		 
	
		 
		 
		 //output
		 /*
		 for(int b = 0; b < W; b++){
			 for(int t = 0; t<counter[b]-1; t++){
				 if(t<counter[b]-2){
				 cvs.drawLine(((t+1)*pVal)+pVal*3, i-( yPos[b][t]*pVal), ((t+2)*pVal)+pVal*3, i-( yPos[b][t+1]*pVal), styleColor[b+3]);
				 }
				 cvs.drawCircle(((t+1)*pVal) + pVal*3,i-( yPos[b][t]*pVal), 2, styleColor[b+3]);
			 }
		 }*/
		 
		 for(int b = 0; b < W; b++){
			 for(int t = 0; t<counter[b]; t++){
				 if(t<counter[b]-1){
					 cvs.drawLine((fstX*(t+1))+fstX*2, fstY-( yPos[b][t]*(pVal/2)), (fstX*(t+2))+fstX*2, fstY-( yPos[b][t+1]*(pVal/2)), styleColor[b+3]);
					 }
					 cvs.drawCircle((fstX*(t+1))+fstX*2,fstY-( yPos[b][t]*(pVal/2)), 3, styleColor[b+3]);
					 text = Integer.toString(t+1);
					 cvs.drawText(text, (fstX*(t+1))+fstX*2, fstY+padding, stil2);
					 u++;
					 if( u < 10 ){
						 text = "0"+u;
						 cvs.drawText(text, fstX, fstY-(u*(pVal/2))+4, stil2);
						 cvs.drawText(text, fstX, fstY-(u*(pVal/2))+4, stil2);
						 cvs.drawText(text, fstX, fstY-(u*(pVal/2))+4, stil2);
					 }else if(u < 51 ){
						 text = Integer.toString(u);
						 cvs.drawText(text, fstX, fstY-(u*(pVal/2))+4, stil2);
						 cvs.drawText(text, fstX, fstY-(u*(pVal/2))+4, stil2);
						 cvs.drawText(text, fstX, fstY-(u*(pVal/2))+4, stil2);
					 }
					 
				
					 //cvs.drawCircle(fstX,fstY-(u*(pVal/2)), 3, styleColor[1]);
					
			 }
			 
		 }
		 
		 //Text 
		 if(readText != null){
			 cvs.drawText(readText, padding, padding, stil2);
		 }
		 //Paint paint = new Paint();  
		 //paint.setColor(Color.BLACK); 
		 //paint.setTextSize(30); 
		 //cvs.drawText("Some Text", padding, i + padding*5, paint);
		 
	
	 }



	 
}