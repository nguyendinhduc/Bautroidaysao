package com.kandy.bai4_android;

import java.util.Random;

 
import java.awt.*;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

public class StarSky implements Comparable<StarSky>{
	private int y,x;

	public static final int SOUNT_STAR = 300;
	private int size;
	private Random rd = new Random();
	private int randomRun;
	public StarSky() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void initStar(int widthScreen, int heightScreen) {
		x = rd.nextInt(widthScreen);
		y = rd.nextInt(heightScreen);
		
		//Log.d("nguyen van a", ((Integer)widthScreen).toString());
		size = rd.nextInt(200)+30;
		randomRun = rd.nextInt(2);
		//Color c = new Color
		
	}
	public void drawStar(Canvas canvas, Paint p ) {
		if ( randomRun == 0 ) p.setStyle(Style.STROKE);
		else p.setStyle(Style.FILL);
		p.setTextSize(size);
		
		p.setColor(Color.rgb(rd.nextInt(250), rd.nextInt(250), rd.nextInt(250)));
		canvas.drawText("*", x, y, p);
	}
	public void addX() {
		x++;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Random getRd() {
		return rd;
	}
	public void setRd(Random rd) {
		this.rd = rd;
	}
	public static int getSountStar() {
		return SOUNT_STAR;
	}
	@Override
	public int compareTo(StarSky another) {
		// TODO Auto-generated method stub
		if ( this.x == another.x ) return 0;
		else {
			if ( this.x < another.x ) return -1;
			else return 1;
		}
	}
}
