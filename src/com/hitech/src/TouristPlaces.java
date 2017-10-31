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

public class TouristPlaces extends ActionBarActivity implements android.view.View.OnClickListener {

	private ButtonRectangle btnHitoricalAttraction;
	private ButtonRectangle btnMuseumAttraction;
	private ButtonRectangle btnReligiousSites;
	private ButtonRectangle btnShoppingCenter;
	
	// Footer
	private ButtonRectangle btnGallery;
	private ButtonRectangle btnTouristPlaces;
	private ButtonRectangle btnAboutUs;
	private ButtonRectangle btnQazvinBio;
	private ButtonRectangle btnQazvinMap;
	private ButtonRectangle btnService;
	
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
			setContentView(R.layout.activity_tourist_places);
			setTitle(null);
			//getSupportActionBar().setIcon(R.drawable.title);
			btnHitoricalAttraction = (ButtonRectangle) findViewById(R.id.btn_menu1);
			btnHitoricalAttraction.setOnClickListener(this);
			
			btnMuseumAttraction = (ButtonRectangle) findViewById(R.id.btn_menu3);
			btnMuseumAttraction.setOnClickListener(this);
			
			btnReligiousSites = (ButtonRectangle) findViewById(R.id.btn_menu4);
			btnReligiousSites.setOnClickListener(this);
			
			btnShoppingCenter = (ButtonRectangle) findViewById(R.id.btn_menu2);
			btnShoppingCenter.setOnClickListener(this);
		
			mContext = this;
			
		    /// Footer
		    btnGallery = (ButtonRectangle) findViewById(R.id.btn_footer_menu5);
      		btnGallery.setOnClickListener(this);
      		
      		btnTouristPlaces = (ButtonRectangle) findViewById(R.id.btn_footer_menu3);
      		btnTouristPlaces.setOnClickListener(this);
      		
      		btnAboutUs = (ButtonRectangle) findViewById(R.id.btn_footer_menu7);
      		btnAboutUs.setOnClickListener(this);
      		
      		btnQazvinBio = (ButtonRectangle) findViewById(R.id.btn_footer_menu2);
      		btnQazvinBio.setOnClickListener(this);
      		
      		btnQazvinMap = (ButtonRectangle) findViewById(R.id.btn_footer_menu4);
      		btnQazvinMap.setOnClickListener(this);
      		
      		btnService = (ButtonRectangle) findViewById(R.id.btn_footer_menu6);
      		btnService.setOnClickListener(this);
			
			
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
	        	if (view == btnHitoricalAttraction) {
	    			try {
					   intent = new Intent(this, HistoricalAttraction.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}  
	        	
	        	if (view == btnMuseumAttraction) {
	    			try {
					   intent = new Intent(this, MuseumAttraction.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
			} 
	        
	        	if (view == btnReligiousSites) {
	    			try {
					   intent = new Intent(this, ReligiousSites.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
	        	
	        	if (view == btnShoppingCenter) {
	    			try {
					   intent = new Intent(this, ShoppingCenters.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
	        	
	        	
           // Footer
	        	
	       if (view == btnGallery) {
	    			try {
					   intent = new Intent(this, ImageGallery.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
			} else if (view == btnTouristPlaces) {
				try {
				    intent = new Intent(this, TouristPlaces.class);
					startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
	        	
			 else if (view == btnAboutUs) {
					try {
					    intent = new Intent(this, AboutUs.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			 else if (view == btnService) {
					try {
					    intent = new Intent(this, HotelAttraction.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
			 else if (view == btnQazvinBio) {
					try {
					    intent = new Intent(this, QazvinBio.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
			 else if (view == btnQazvinMap) {
					try {
					    intent = new Intent(this, QazvinMap.class);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}
			 }
			 else if (view == btnService) {
					try {
					    intent = new Intent(this, Services.class);
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
