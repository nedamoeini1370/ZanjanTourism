package com.hitech.src;

import java.util.HashMap;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.hitech.qtourism.R;
import com.hitech.src.utility.TextViewPlus;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ImageGallery extends ActionBarActivity implements BaseSliderView.OnSliderClickListener {

	private Context mContext;

	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	private void forceRTLIfSupported() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			getWindow().getDecorView().setLayoutDirection(
					View.LAYOUT_DIRECTION_LTR);
		}
	}

	  private SliderLayout mDemoSlider;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	forceRTLIfSupported();
			mContext = this;
			setTitle(null);
			setContentView(R.layout.activity_image_slider);
			//getSupportActionBar().setIcon(R.drawable.title);
	        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
	        // for online image's        
	        /*HashMap<String,String> url_maps = new HashMap<String, String>();
	        url_maps.put("Description", "http://picUrl.com");
	        url_maps.put("Description", "http://picUrl.com");
	        url_maps.put("Description", "http://picUrl.com");
	        url_maps.put("Description", "http://picUrl.com");*/
	        
	        // for offline image's
	        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
	        //file_maps.put("Description,url)"
	        file_maps.put("بنای رخت‌شوی‌خانه یا مجموعهٔ تاریخی رخت‌شوی‌خانه در قلب بافت تاریخی شهر زنجان که منطبق بر حصار قدیمی شهر می‌باشد، در یک منطقهٔ پرتراکم مسکونی احداث شده‌است. مردم شهر لباس و رخت خود را در آن محل می‌شسته‌اند. چنین کاربری برای یک بنای عمومی در جهان مشابه ندارد یا کم‌نظیر است. این بنا در حال حاضر تعمیر و مرمت شده و به عنوان موزهٔ مردم‌شناسی مورد استفاده قرار می‌گیرد و مردم می‌توانند از آن بازدید کنند. این بنا در سال‌های گذشته به جهت وجود هوای سرد در زمستان‌ها برای بانوان زنجانی ساخته شده‌است.",R.drawable.hammameqajar);
	        file_maps.put("مردان نمکی نامی است که به شش مومیایی کشف‌شده در زمستان سال ۱۳۷۲ (1993 میلادی) در معدن نمک چهرآباد استان زنجان داده شده‌است. در میان آن‌ها جسد یک زن و یک پسر نوجوان نیز وجود دارد. تعدادی از مردان نمکی بر اثر ادامهٔ کار معدن با بولدوزر، به‌شدت آسیب دیده‌اند. در سال 2008 بهره‌برداری از معدن متوقف شد و جسد ششمین مرد نمکی به دلیل کمبود امکانات لازم برای نگهداری از آن، دست نخورده در معدن باقی ماند..",R.drawable.qazvinchehelsotun);
	        file_maps.put("عمارت دارایی [۱] یا (دیوان استیفاء) در بافت تاریخی شهر زنجان (سبزه میدان) قرار گرفته، ظاهراً این بخش از شهر در اواخر دوره فاجار و اوائل حکومت رضاخانی تقریباً مقارن با اواخر جنگ جهانی دوم از سوی دولت وقت بصورت مجموعهای به اماکن و ساختمانهای دولتی اختصاص می یابد که عبارت بودند از عمارت دارایی در باغی معروف به همین نام، بنای دخانیات، اداره غله، انبار قند و شکر", R.drawable.qazvinchehelsotun);

	        for(String name : file_maps.keySet()){
	            TextSliderView textSliderView = new TextSliderView(this);
	            // initialize a SliderLayout
	            textSliderView
	                    .description(name)
	                   // .fullDescription("چمن متحرک یا «چملی گول»، یکی از بی‌نظیرترین پدیده‌های طبيعي ایران و حتی جهان است که در دل طبیعت زيباي «تکاب» جا خوش کرده و هنوز رازی سر به مُهر به شمار می‌رود.")
	                    .image(file_maps.get(name))
	                    .setScaleType(BaseSliderView.ScaleType.CenterInside)//size of image's.you can set fit to fill page.
	                    .setOnSliderClickListener(this);

	            //add your extra information, you can set image url for download image or share it.
	           textSliderView.getBundle().putString("extra",name);
	           mDemoSlider.addSlider(textSliderView);
	        }
	        //slider setting's
	        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.CubeIn);
	        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
	        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
	        mDemoSlider.setDuration(11000);//11Sec
	      }

	    @Override
	    public void onSliderClick(BaseSliderView slider) {
	    	//ِimplement for share image or download it.
	       // Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
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
}
