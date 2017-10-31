package com.hitech.src;

import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;
import com.hitech.qtourism.R;

public class SplashScreen extends Activity {

	// Splash screen timer
	private static int SPLASH_TIME_OUT = 4000;

	protected PowerManager.WakeLock mWakeLock;
	private ImageView img_animation;
	private SharedPreferences appHelpPrefs;
	    /**
	     * The thread to process splash screen events
	     */
	    private Thread  mSplashThread;

	    private ImageView myimage;


	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        // Splash screen view
	        setContentView(R.layout.activity_splash);

	        myimage = (ImageView) findViewById(R.id.imgLogo);

	        final SplashScreen sPlashScreen = this;
	        rotateAnimation();
	        
	        // The thread to wait for splash screen events
	        mSplashThread = new Thread() {
	            @Override
	            public void run() {
	                try {
	                    synchronized (this) {
	                        // Wait given period of time or exit on touch
	                        wait(6000);
	                    }
	                    
	                    finish();
		                // Run next activity
		                
		                Intent intent = new Intent();
		                //appHelpPrefs = sPlashScreen.getSharedPreferences("remember",MODE_WORLD_READABLE);
		    			//boolean isViewed = appHelpPrefs.getBoolean("isViewed",false);
		    			
		    			//if(isViewed)
		    			  intent.setClass(sPlashScreen, Dashboard.class);
		    			//else
		    			//  intent.setClass(sPlashScreen, ShowAppHelp.class);
		    			
		                startActivity(intent);
	                }
	                catch (InterruptedException ex) {
	                	Toast.makeText(getApplicationContext(), ex.toString(),4000).show();
	                }
	            }

	        };

	        mSplashThread.start();
	    }


	    /**
	     * Processes splash screen touch events
	     */
	    @Override
	    public boolean onTouchEvent(MotionEvent evt)
	    {
	        if (evt.getAction() == MotionEvent.ACTION_DOWN)
	        {
	            synchronized (mSplashThread) {
	                mSplashThread.notifyAll();
	            }
	        }
	        return true;
	    }


	    private void rotateAnimation() {
	    	RotateAnimation rotate  = new RotateAnimation(0.0f, 1080.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
			ScaleAnimation scale = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
			                 Animation.RELATIVE_TO_SELF, 0.5f,
			                 Animation.RELATIVE_TO_SELF, 0.5f);
			AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
			AnimationSet set = new AnimationSet(true);
			set.addAnimation(rotate);
			set.addAnimation(scale);
			set.addAnimation(alpha);
			set.setDuration(5000);
	    	myimage.startAnimation(set);
	      //Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
	      //myimage.startAnimation(animation);
	    }
	}
