package com.hitech.src;

import java.lang.reflect.Field;

import com.gc.materialdesign.views.ButtonRectangle;
import com.hitech.qtourism.R;
import com.hitech.src.utility.App;
import com.hitech.src.utility.TextViewPlus;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class Dashboard extends ActionBarActivity implements
		android.view.View.OnClickListener {

	private ButtonRectangle btnGallery;
	private ButtonRectangle btnTouristPlaces;
	private ButtonRectangle btnAboutUs;
	private ButtonRectangle btnQazvinBio;
	//private ButtonRectangle btnTourismInfo;
	private ButtonRectangle btnQazvinMap;
	private ButtonRectangle btnService;
	//private ButtonRectangle btnImportantCenter;
	
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;
	private LinearLayout drawer;
	private String[] navMenuTitles;

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
			setContentView(R.layout.activity_dashboard);
			setTitle(null);
			mContext = this; 
			
			//getSupportActionBar().setIcon(R.drawable.title);
			//getOverflowMenu();
			btnGallery = (ButtonRectangle) findViewById(R.id.btn_menu6);
			btnGallery.setOnClickListener(this);
			
			btnTouristPlaces = (ButtonRectangle) findViewById(R.id.btn_menu4);
			btnTouristPlaces.setOnClickListener(this);
			
			btnAboutUs = (ButtonRectangle) findViewById(R.id.btn_menu8);
			btnAboutUs.setOnClickListener(this);
			
			btnQazvinBio = (ButtonRectangle) findViewById(R.id.btn_menu1);
			btnQazvinBio.setOnClickListener(this);
			
			
			//btnTourismInfo = (ButtonRectangle) findViewById(R.id.btn_menu2);
			//btnTourismInfo.setOnClickListener(this);
			
			//btnImportantCenter = (ButtonRectangle) findViewById(R.id.btn_menu7);
			//btnImportantCenter.setOnClickListener(this);
			
			btnQazvinMap = (ButtonRectangle) findViewById(R.id.btn_menu3);
			btnQazvinMap.setOnClickListener(this);
			
			btnService = (ButtonRectangle) findViewById(R.id.btn_menu5);
			btnService.setOnClickListener(this);
			
			Animation rtl = AnimationUtils.loadAnimation(this, R.anim.rtl_animation);
			Animation ltr = AnimationUtils.loadAnimation(this, R.anim.ltr_animation);
			
			//btnGallery.setTypeface(App.SetTypeFace(mContext));
			btnQazvinBio.startAnimation(rtl);
			btnQazvinMap.startAnimation(rtl);
			btnGallery.startAnimation(rtl);
			
			//btnImportantCenter.startAnimation(rtl);
			
			//btnTourismInfo.startAnimation(ltr);
			btnTouristPlaces.startAnimation(ltr);
			btnService.startAnimation(ltr);
			btnAboutUs.startAnimation(ltr);
			
			drawer = (LinearLayout) findViewById(R.id.right_drawer);
			mTitle = mDrawerTitle = getTitle();

			
			mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

			
			mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
					R.drawable.ic_menu, // nav menu toggle icon
					R.string.app_name, // nav drawer open - description for
										// accessibility
					R.string.app_name // nav drawer close - description for
										// accessibility
			)
			{
				public void onDrawerClosed(View view) {
					// calling onPrepareOptionsMenu() to show action bar icons
					supportInvalidateOptionsMenu();

				}

				public void onDrawerOpened(View drawerView) {
					// calling onPrepareOptionsMenu() to hide action bar icons
					supportInvalidateOptionsMenu();

				}
			};
			mDrawerLayout.setDrawerListener(mDrawerToggle);

			if (savedInstanceState == null) {
				// on first time display view for first nav item
				displayView(0);
			}

			RelativeLayout languageholder = (RelativeLayout) findViewById(R.id.language_holder);
			languageholder.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					displayView(0);
				}
			});

			RelativeLayout colorholder = (RelativeLayout) findViewById(R.id.color_holder);
			colorholder.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					displayView(1);
				}
			});

								
		} catch (Exception e) {
			//App.ShowMessageBox(this, e.toString());
		}
	}
	/*@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}*/
	/* private void getOverflowMenu() {

		    try {
		       ViewConfiguration config = ViewConfiguration.get(this);
		       Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
		       if(menuKeyField != null) {
		           menuKeyField.setAccessible(true);
		           menuKeyField.setBoolean(config, false);
		       }
		   } catch (Exception e) {
		       e.printStackTrace();
		   }
		 }*/
	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			if (!mDrawerLayout.isDrawerOpen(drawer)) {
				mDrawerLayout.openDrawer(drawer);
			} else
				mDrawerLayout.closeDrawer(drawer);
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	private void displayView(int position) {
		// update the main content by replacing fragments
		try {
			
			mDrawerLayout.closeDrawer(drawer);
			switch (position) {
			case 0:
				break;
			case 1:
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		try {
			getMenuInflater().inflate(R.menu.activity_main, menu);
			menu.removeItem(R.id.back_to_home);
			menu.removeItem(R.id.actin_back);
			menu.removeItem(R.id.silent);
		} catch (Exception e) {
		}
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		try {
			boolean drawerOpen = mDrawerLayout.isDrawerOpen(drawer);
			menu.findItem(R.id.exit).setVisible(!drawerOpen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.onPrepareOptionsMenu(menu);
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
			
		case R.id.actin_setting:
			try {
				if (!mDrawerLayout.isDrawerOpen(drawer)) {
					mDrawerLayout.openDrawer(drawer);
				} else
					mDrawerLayout.closeDrawer(drawer);
			} catch (Exception e) {
				e.printStackTrace();
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
//			 else if (view == btnTourismInfo) {
//					try {
//					    intent = new Intent(this, TourismInfo.class);
//						startActivity(intent);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//			 }
//			 else if (view == btnImportantCenter) {
//					try {
//					    intent = new Intent(this, ImportantCenterOfTown.class);
//						startActivity(intent);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//			 }
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
