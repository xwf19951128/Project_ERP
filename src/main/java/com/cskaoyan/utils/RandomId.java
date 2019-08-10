package com.cskaoyan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomId {
    public final static String getRandomId(){
        StringBuffer sb=new StringBuffer();
        Date date=new Date();
        String pattern="yyyyMMddHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sb.append(sdf.format(date));
        int s;
        for(int i=0;i<12;i++){
            s=(int)(Math.random()*10);
            sb.append(s);
        }
        return sb.toString();
    }

    public final static String getShortRandomId(){
        StringBuffer sb=new StringBuffer();
        Date date=new Date();
        String pattern="yyyyMMddHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sb.append(sdf.format(date));
        int s;
        for(int i=0;i<3;i++){
            s=(int)(Math.random()*10);
            sb.append(s);
        }
        return sb.toString();
    }
}
