package com.kandy.bai4_android;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Paint;

public class ManagerStart {
	private ArrayList<StarSky> arrStart = new ArrayList<>();
	private StarSky star;
	public ManagerStart(int wightScreen, int heightScreen) {
		// TODO Auto-generated constructor stub
		for ( int i = 0; i < StarSky.SOUNT_STAR; i++ ) {
			star = new StarSky();
			star.initStar(wightScreen, heightScreen);
			arrStart.add(star);
		}
	}
	public void drawAllStart(Canvas canvas, Paint p ) {
		try {
			for ( int i = 0; i < StarSky.SOUNT_STAR; i++ ) {
				arrStart.get(i).drawStar(canvas, p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public void moveStart() {
		for ( StarSky arr : arrStart ) {
			arr.addX();
		}
	}
	public void referestArrStart() {
		if ( findStartXMin() >= Drawing.width/8 ) {
			StarSky tem;
			Random rd = new Random();
			for ( int i = 0; i < StarSky.SOUNT_STAR; i++ ) {
				if ( arrStart.get(i).getX() >=Drawing.width ) {
					tem = arrStart.remove(i);
					tem.setX(rd.nextInt(Drawing.width/8+1));
					arrStart.add(i, tem);
				}
			}
		}
	}
	public int findStartXMin() {
		return Collections.min(arrStart).getX();
	}
	
	
}
