package com.hitech.src.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableMuseumsListDataPump   {
    public static HashMap getData() {
        HashMap expandableListDetail = new HashMap();
        List arrayList = new ArrayList();
        arrayList.add("زنجان خ زینبیه غربی عمارت ذوالفقاری");
        expandableListDetail.put("موزه باستان شناسی و مردان نمکی", arrayList);
        
        arrayList = new ArrayList();
        arrayList.add( "زنجان خ زینبیه غربی عمارت دارایی");
        expandableListDetail.put("موزه صنایع دستی", arrayList);
        
        arrayList = new ArrayList();
        arrayList.add( "زنجان خ خواجه نصیر");
        expandableListDetail.put("موزه شهدا", arrayList);
        
        arrayList = new ArrayList();
        arrayList.add( "زنجان خ سعدی وسط کوچه رختشویخانه");
        expandableListDetail.put("موزه مردم شناسی رختشویخانه", arrayList);
        
        arrayList = new ArrayList();
        arrayList.add( "زنجان ورودی میانه به زنجان پارک جنگلی ارم");
        expandableListDetail.put("موزه تاريخي طبيعي زنجان ", arrayList);
        
        arrayList = new ArrayList();
        arrayList.add( "ابهر بقعه پیر احمد زهر نوش ");
        expandableListDetail.put("موزه باستان شناسی ابهر ", arrayList);
  
        return expandableListDetail;
    }
}
