package com.hitech.src;

import com.hitech.qtourism.R;
import com.hitech.src.utility.TextViewPlus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;

public class AboutUs extends ActionBarActivity {
	 
	private Context mContext;
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_about_us);
	  setTitle(null);
	  mContext = this; 
		
	  //getSupportActionBar().setIcon(R.drawable.title);
	  ImageView img_animation = (ImageView) findViewById(R.id.img_animation);
	 // ImageView img_animation2 = (ImageView) findViewById(R.id.img_animation2);
	  TranslateAnimation animation = new TranslateAnimation(-400.0f, 0.0f,0.0f, 0.0f);
	  animation.setDuration(3000);
	  animation.setRepeatCount(0);
	  animation.setRepeatMode(2);
	  animation.setFillAfter(true);
	  img_animation.startAnimation(animation);
	  
	  /*TranslateAnimation animation2 = new TranslateAnimation(400.0f,0.0f,0.0f, 0.0f);
	  animation2.setDuration(3000);
	  animation2.setRepeatCount(0);
	  animation2.setRepeatMode(2);
	  animation2.setFillAfter(true);
	  img_animation2.startAnimation(animation2);
	 */
	 }
	 
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			try {
				getMenuInflater().inflate(R.menu.activity_main, menu);
				menu.removeItem(R.id.actin_setting);
			} catch (Exception e) {
			}
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar actions click
			switch (item.getItemId()) {
			
			case R.id.exit:
				try {
					this.finish();
				} catch (Exception e) {
					e.printStackTrace();
					this.finish();
				}
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
		}
		
	
	@Override
	public void setTitle(CharSequence title) {
		try {
			getSupportActionBar().setDisplayShowCustomEnabled(true);
			getSupportActionBar().setDisplayShowTitleEnabled(false);
			LayoutInflater inflator = LayoutInflater.from(mContext);
			View v = inflator.inflate(R.layout.titleview, null);
			((TextViewPlus) v.findViewById(R.id.title)).setText(title);
			getSupportActionBar().setCustomView(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
