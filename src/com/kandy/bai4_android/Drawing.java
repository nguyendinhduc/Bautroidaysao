package com.kandy.bai4_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class Drawing extends View implements Runnable{
	private Paint p = new Paint();
	public static int width, height;
	private Thread th;
	private ManagerStart managerStart;
	public Drawing(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		getWidthHeightScreen();
		initComcom();
		
	}
	
	public void getWidthHeightScreen() {
		WindowManager window = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metric= new DisplayMetrics();
		window.getDefaultDisplay().getMetrics(metric);

		width = metric.widthPixels;
		height = metric.heightPixels;
		managerStart = new ManagerStart(width, height);
	}
	public Drawing(Context context, AttributeSet attrs) {
		super(context, attrs);
		getWidthHeightScreen();
		initComcom();

	}

	public Drawing(Context context) {
		super(context);
		getWidthHeightScreen();
		initComcom();
		
	}
	public void initComcom() {
		p.setStyle(Style.STROKE);
		setBackgroundColor(Color.CYAN);
		p.setStrokeWidth(5);
//		p.setColor(Color.RED);
//		p.setTextSize(200);
		th = new Thread(this);
		th.start();

	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//		canvas.drawLine(20, 20, 400, 400, p);
		//		p.setStrokeWidth(5);
		//		canvas.drawText("*", 200, 200, p);
		managerStart.drawAllStart(canvas, p);

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Calendar c = Calendar.getInstance();
			
		while ( true ) {
			//managerStart = new ManagerStart(width, height);
			if (MainActivity.stateRun) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				managerStart.moveStart();
				managerStart.referestArrStart();
				postInvalidate();
			}
		}
	}
	

}
