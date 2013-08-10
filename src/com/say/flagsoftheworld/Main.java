package com.say.flagsoftheworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {
	
	Typeface tf;
	Button play;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
	
		initControls();
		
		
	}

	private void initControls() {
		// TODO Auto-generated method stub
		tf = Typeface.createFromAsset(getAssets(), "fonts/hillock.ttf");
		
		play = (Button) findViewById (R.id.btnPlay);
		
		play.setTypeface(tf);
		play.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, GameActivity.class);
		startActivity(i);

	}

}
