package com.say.flagsoftheworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView tv1, tv2, tv3, tv4;
	ImageView iv1, iv2, iv3, iv4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		initControls();
		
	}
	
	private void initControls() {
		// TODO Auto-generated method stub
		
		tv1 = (TextView) findViewById (R.id.tv1);
		tv2 = (TextView) findViewById (R.id.tv2);
		tv3 = (TextView) findViewById (R.id.tv3);
		tv4 = (TextView) findViewById (R.id.tv4);
		
		iv1 = (ImageView) findViewById (R.id.imageView1);
		iv2 = (ImageView) findViewById (R.id.imageView2);
		iv3 = (ImageView) findViewById (R.id.imageView3);
		iv4 = (ImageView) findViewById (R.id.imageView4);
		
		iv1.setOnTouchListener(new MyTouchListener());
		iv2.setOnTouchListener(new MyTouchListener());
		iv3.setOnTouchListener(new MyTouchListener());
		iv4.setOnTouchListener(new MyTouchListener());
		
		tv1.setOnDragListener(new MyDragListener());
		tv2.setOnDragListener(new MyDragListener());
		tv3.setOnDragListener(new MyDragListener());
		tv4.setOnDragListener(new MyDragListener());
		
	}
	
	private final class MyTouchListener implements OnTouchListener {
	    public boolean onTouch(View view, MotionEvent motionEvent) {
	      if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
	        ClipData data = ClipData.newPlainText("", "");
	        DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
	        view.startDrag(data, shadowBuilder, view, 0);
	        view.setVisibility(View.INVISIBLE);
	        return true;
	      } else {
	        return false;
	      }
	      
	    }
	}

	private boolean dropEventNotHandled(DragEvent dragEvent) {
		        return !dragEvent.getResult();
	}
	
	class MyDragListener implements OnDragListener {

	    @Override
	    public boolean onDrag(View v, DragEvent event) {
	    	//handle the dragged view being dropped over a drop view
	    	View view = (View) event.getLocalState();
	    	
	      switch (event.getAction()) {
	      case DragEvent.ACTION_DRAG_STARTED:
	    	  
	        break;
	      case DragEvent.ACTION_DRAG_ENTERED:
	      
	        break;
	      case DragEvent.ACTION_DRAG_EXITED:
	    	  
	        break;
	      case DragEvent.ACTION_DROP:
	    	
	        //Drawable dropshadow = getResources().getDrawable(R.drawable.dropshadow);
	        
	        //view dragged item is being dropped on
			//ImageView dropTarget = (ImageView) v;
			
			//view being dragged and dropped
			//ImageView dropped = (ImageView) view;
			
	        	  String temp = "a";
	        	  if(temp.equals(view.getTag())){
	        		  view.setVisibility(View.INVISIBLE);
	        		  
	        		  Log.d(temp, "Correct Image");
	        	  }	else {
	        		  Log.d("b", "Wrong Image");
	        		  view.setVisibility(View.VISIBLE);
	        	  }
	          
	        	  /*
	  			//if an item has already been dropped here, there will be a tag
	  			Object tag = dropTarget.getTag();
	  			
	  			//if there is already an item here, set it back visible in its original place
	  			if(tag!=null)
	  			{
	  			    //the tag is the view id already dropped here
	  			    int existingID = (Integer)tag;
	  			    //set the original view visible again
	  			    findViewById(existingID).setVisibility(View.VISIBLE);
	  			}
	  			
	  			//set the tag in the target view to the ID of the view being dropped
	  			dropTarget.setTag(dropped.getId());
	  			*/
	        
	        break;
	      case DragEvent.ACTION_DRAG_ENDED:
	    	   if (dropEventNotHandled(event)) 
	    		  view.setVisibility(View.VISIBLE);
	    	break;
	      default:
	        break;
	      }
	      return true;
	    }
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
