package com.hitech.src.utility;

import com.hitech.qtourism.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class CapitalCitiesListAdapter extends BaseAdapter{   
    String [] result;
    Context context;
    String [] resultCapitalCity;
      private static LayoutInflater inflater=null;
    public CapitalCitiesListAdapter(Activity mainActivity, String[] prgmNameList, String[] prgmCapitalNameList) {
        // TODO Auto-generated constructor stub
        result= prgmNameList;
        context= mainActivity;
        resultCapitalCity= prgmCapitalNameList;
         inflater = ( LayoutInflater )context.
                 getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView tv2;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;       
             rowView = inflater.inflate(R.layout.list_view_travel_language_item, null);
             holder.tv2=(TextView) rowView.findViewById(R.id.textViewRight);
             holder.tv=(TextView) rowView.findViewById(R.id.textViewLeft);       
         holder.tv.setText(result[position]);
         holder.tv2.setText(resultCapitalCity[position]);        
         rowView.setOnClickListener(new OnClickListener() {            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
              //  Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });   
        return rowView;
    }

}