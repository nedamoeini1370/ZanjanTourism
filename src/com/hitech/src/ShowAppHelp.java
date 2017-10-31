package com.hitech.src;
import com.gc.materialdesign.views.ButtonRectangle;
import com.hitech.src.utility.ImageAdapter;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.hitech.qtourism.R;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
public class ShowAppHelp extends Activity implements android.view.View.OnClickListener {
	Context mcontext;
	private SharedPreferences appHelpPrefs;
	private ViewPager viewPager;
	private ButtonRectangle btn_next;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_help);
	mcontext = this;
    viewPager = (ViewPager) findViewById(R.id.pager);
    btn_next = (ButtonRectangle)findViewById(R.id.btn_next);
	ImageAdapter adapter = new ImageAdapter(this);
	viewPager.setAdapter(adapter);
	CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
	indicator.setViewPager(viewPager);
	btn_next.setOnClickListener(this);
	indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
				@Override
				public void onPageSelected(int position) {
					try {
						viewPager.setCurrentItem(position);
						if(position ==2)
						  btn_next.setVisibility(View.VISIBLE);
						else
							btn_next.setVisibility(View.INVISIBLE);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				@Override
				public void onPageScrolled(int position,
						float positionOffset, int positionOffsetPixels) {
				}

				@Override
				public void onPageScrollStateChanged(int state) {
				}
			});

	
	}


	@Override
	public void onClick(View view) {
		try {
				Intent intent;
	        	if (view == btn_next) {
	    			try {
	    				appHelpPrefs = mcontext.getSharedPreferences("remember", 0);
	    				SharedPreferences.Editor prefsEditor = appHelpPrefs.edit();
	    				prefsEditor.putBoolean("isViewed", true);	
	    				prefsEditor.commit();
					    intent = new Intent(mcontext, Dashboard.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 
	}