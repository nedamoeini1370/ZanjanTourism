package com.hitech.src;
import com.gc.materialdesign.views.ButtonRectangle;
import com.hitech.qtourism.R;
import com.hitech.src.utility.ExpandableHistoricalListDataPump;
import com.hitech.src.utility.ExpandableListAdapter;
import com.hitech.src.utility.TextViewPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

	public class HistoricalAttraction extends ActionBarActivity implements android.view.View.OnClickListener {
		    ExpandableListView expandableListView;
		    ExpandableListAdapter expandableListAdapter;
		    List<String> expandableListTitle;
		    HashMap<String, List<String>> expandableListDetail;
		    private Context mContext;
		    
		    // Footer
			private ButtonRectangle btnGallery;
			private ButtonRectangle btnTouristPlaces;
			private ButtonRectangle btnAboutUs;
			private ButtonRectangle btnQazvinBio;
			private ButtonRectangle btnQazvinMap;
			private ButtonRectangle btnService;
		    
		    @Override
		    protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.activity_expandable_list);
		        setTitle(null);
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
		        
		     //   getSupportActionBar().setIcon(R.drawable.title);
		        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
		        expandableListDetail = ExpandableHistoricalListDataPump.getData();
		        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
		        expandableListAdapter = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);
		        expandableListView.setAdapter(expandableListAdapter);
		        expandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {

		            @Override
		            public void onGroupExpand(int groupPosition) {
		               /* Toast.makeText(getApplicationContext(),
		                        expandableListTitle.get(groupPosition) + " ÈÇÒ ÔÏ.",
		                        Toast.LENGTH_SHORT).show();*/
		            }
		        });

		        expandableListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

		            @Override
		            public void onGroupCollapse(int groupPosition) {
		             /*   Toast.makeText(getApplicationContext(),
		                        expandableListTitle.get(groupPosition) + " ÈÓÊå ÔÏ.",
		                        Toast.LENGTH_SHORT).show();*/

		            }
		        });

		        expandableListView.setOnChildClickListener(new OnChildClickListener() {
		            @Override
		            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
						//		                Toast.makeText(getApplicationContext(),
						//		                        expandableListTitle.get(groupPosition)
						//		                                + " -> "
						//		                                + expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT
						//		                )
		               //         .show();
		                return false;
		            }
		        });
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
		}