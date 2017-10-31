package com.hitech.src;

import com.hitech.qtourism.R;
import com.hitech.src.utility.ImportantCenterOfTownListAdapter;
import com.hitech.src.utility.TextViewPlus;
import com.hitech.src.utility.TravelLanguageListAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;

public class ImportantCenterOfTown extends ActionBarActivity implements
android.view.View.OnClickListener {
	

    ListView lv;
    Context mContext;

    public static String [] prgmNameList ={"دانشگاه زنجان","دانشگاه زنجان","دانشگاه زنجان","دانشگاه زنجان"};
    public static String [] prgmTelList ={"تلفن : 3051 (24) 98+ ","تلفن : 3051 (24) 98+ ","تلفن : 3051 (24) 98+ ","تلفن : 3051 (24) 98+ "};
    public static String [] prgmAddressList ={"زنجان ، دانشگاه زنجان","زنجان ، دانشگاه زنجان","زنجان ، دانشگاه زنجان","زنجان ، دانشگاه زنجان"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mContext=this;
        setTitle(null);
       // getSupportActionBar().setIcon(R.drawable.title);
        lv=(ListView) findViewById(R.id.listView);
        //lv.setAdapter(new ListAdapter(this, prgmNameList,prgmImages));
        ImportantCenterOfTownListAdapter myAdapter = new ImportantCenterOfTownListAdapter(this, prgmNameList,prgmTelList,prgmAddressList);
        SwingBottomInAnimationAdapter  animationAdapter = new SwingBottomInAnimationAdapter (myAdapter);
        animationAdapter.setAbsListView(lv);
        lv.setAdapter(animationAdapter);
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
		//Intent intent;
    	/*if (view == btnGallery) {
			try {
			   intent = new Intent(this, ImageGallery.class);
				startActivity(intent);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}  */
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
