package com.hitech.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.hitech.qtourism.R;
import com.hitech.src.utility.TextViewPlus;

@SuppressLint("ShowToast")
public class OnlineMapActivity extends FragmentActivity implements LocationListener {

	GoogleMap mGoogleMap;
	
	double mLatitude = 0;
	double mLongitude = 0;
	Context mcontext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		// Set localization to fa
		String language= "fa";
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN)
        {
           config.setLocale(locale);
           getBaseContext().createConfigurationContext(config);
        }
        else 
        { //deprecated 
           config.locale = locale;
           getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        }
        
        try{
        mcontext = this.getApplicationContext();
		setTitle(null);
		setContentView(R.layout.activity_online_map);
        }
        catch (Exception e) {
			Toast.makeText(mcontext, e.toString(), 5000).show();
		}
		

		// Getting Google Play availability status
		int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());

		if (status != ConnectionResult.SUCCESS) { // Google Play Services are
													// not available
			int requestCode = 10;
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
			dialog.show();

		}
       else { // Google Play Services are available

			// Getting reference to the SupportMapFragment
			SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

			// Getting Google Map
			mGoogleMap = fragment.getMap();

			// Enabling MyLocation in Google Map
			mGoogleMap.setMyLocationEnabled(true);

			// load the traffic now
	        mGoogleMap.setTrafficEnabled(true);
	       
			// Getting LocationManager object from System Service
			// LOCATION_SERVICE
			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

			// Creating a criteria object to retrieve provider
			Criteria criteria = new Criteria();

			// Getting the name of the best provider
			String provider = locationManager.getBestProvider(criteria, true);

			// Getting Current Location From GPS
			Location location = locationManager.getLastKnownLocation(provider);

			if (location != null) {
				float zoomLevel = 14.0f; //This goes up to 21
				LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
				mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, zoomLevel));
				mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(zoomLevel));
				onLocationChanged(location);
			}

			locationManager.requestLocationUpdates(provider, 20000, 0, this);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onLocationChanged(Location location) {
		mLatitude = location.getLatitude();
		mLongitude = location.getLongitude();
		LatLng latLng = new LatLng(mLatitude, mLongitude);
		mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
		mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(14));
		// load the traffic now
        mGoogleMap.setTrafficEnabled(true);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}
	@Override
	public void setTitle(CharSequence title) {
		try {
			getActionBar().setDisplayShowCustomEnabled(true);
			getActionBar().setDisplayShowTitleEnabled(false);

			LayoutInflater inflator = LayoutInflater.from(mcontext);
			View v = inflator.inflate(R.layout.titleview, null);

			((TextViewPlus) v.findViewById(R.id.title)).setText(title);
			getActionBar().setCustomView(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}