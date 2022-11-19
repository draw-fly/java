package com.example.demo.springboot.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    private static Date getDateAdd(int days){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -days);
        System.out.println(sf.format(c.getTime()));
        return c.getTime();
    }
    private static  List<String> getDaysBetwwen(int days){ //最近几天日期
        List<String> dayss = new ArrayList<>();
        Calendar start = Calendar.getInstance();
        start.setTime(getDateAdd(days));
        long startTIme = start.getTimeInMillis();
        Calendar end = Calendar.getInstance();
        end.setTime(new Date());
        long endTime = end.getTimeInMillis();
        long oneDay = 1000 * 60 * 60 * 24L;
        long time = startTIme;
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(df.format(d));
            dayss.add(df.format(d));
            time += oneDay;
        }
        return dayss;
    }

    public void Tes1(){

        String [] arr = new String[7];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = null;
        for (int i=0;i<7;i++){
            c=Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, -i);
            arr[6-i] =sdf.format(c.getTime());
        }
        for (String s : arr) {
            System.err.println(s);
        }
    }

    public static void main(String[] args) {
        List<String> dates = getDaysBetwwen(7);
        System.out.println(dates.toString());
    }
}
