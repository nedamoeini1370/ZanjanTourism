package com.hitech.src.utility;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hitech.qtourism.R;

public class ImageAdapter extends PagerAdapter {
Context context;
private int[] GalImages = new int[] {
R.drawable.img1,
R.drawable.img2,
R.drawable.img3
};
public ImageAdapter(Context context){
this.context=context;
}
@Override
public int getCount() {
return GalImages.length;
}

 
@Override
public Object instantiateItem(ViewGroup container, int position) {
ImageView imageView = new ImageView(context);
int padding = context.getResources().getDimensionPixelSize(R.dimen.help_margin);
imageView.setPadding(padding, padding, padding, padding);
imageView.setScaleType(ImageView.ScaleType.FIT_XY);
imageView.setImageResource(GalImages[position]);
((ViewPager) container).addView(imageView, 0);
return imageView;
}
 
@Override
public void destroyItem(ViewGroup container, int position, Object object) {
((ViewPager) container).removeView((ImageView) object);
}
@Override
public boolean isViewFromObject(View arg0, Object arg1) {
	return arg0 == ((ImageView) arg1);
}
}