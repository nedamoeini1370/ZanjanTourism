package com.hitech.src;

import com.gc.materialdesign.views.ButtonRectangle;
import com.hitech.qtourism.R;
import com.hitech.src.utility.TextViewPlus;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TourismInfo extends ActionBarActivity implements
		android.view.View.OnClickListener {

	private ButtonRectangle btnCapitalCities;
	private ButtonRectangle btnTravelLanguage;
	private Context mContext;

	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	private void forceRTLIfSupported() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			getWindow().getDecorView().setLayoutDirection(
					View.LAYOUT_DIRECTION_LTR);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			//forceRTLIfSupported();
			setContentView(R.layout.activity_tourism_info);
			setTitle(null);
			//getSupportActionBar().setIcon(R.drawable.title);
			btnCapitalCities = (ButtonRectangle) findViewById(R.id.btn_menu2);
			btnCapitalCities.setOnClickListener(this);
			
			btnTravelLanguage = (ButtonRectangle) findViewById(R.id.btn_menu1);
			btnTravelLanguage.setOnClickListener(this);
			
			mContext = this;
		} catch (Exception e) {
		}
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
	public void onClick(View view) {
		try {
				Intent intent;
	        	if (view == btnCapitalCities) {
	    			try {
					   intent = new Intent(this, CapitalCities.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
	    			}
	    	  else if (view == btnTravelLanguage) {
		    			try {
						   intent = new Intent(this, TravelLanguage.class);
							startActivity(intent);
						} catch (Exception e) {
							e.printStackTrace();
						}
			}  
		} catch (Exception e) {
			e.printStackTrace();
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
