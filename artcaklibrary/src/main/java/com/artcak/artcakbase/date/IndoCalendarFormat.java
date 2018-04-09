package com.artcak.artcakbase.date;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class IndoCalendarFormat {
    private static final String[] days_short = {"Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"};
    private static final String[] days = {"Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
    private static final String[] months = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    private static final String[] months_short = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sept", "Okt", "Nov", "Des"};

    public static String getDayName(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return days[(dayOfWeek - 1)];
    }

    public static String getShortDay(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return days_short[(dayOfWeek - 1)];
    }

    public static String getMonthName(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        final int month = calendar.get(Calendar.MONTH);
        return days[month];
    }

    public static String getDate(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        final int month = calendar.get(Calendar.MONTH);
        return calendar.get(Calendar.DAY_OF_MONTH) + " " + months[month] + " " + calendar.get(Calendar.YEAR);
    }

    public static String getDefaultDate(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        final int month = calendar.get(Calendar.MONTH);
        String year = "";
        if (getCurrentYear()!=calendar.get(Calendar.YEAR)){
            year = " "+getCurrentYear();
        }
        return days[calendar.get(Calendar.DAY_OF_WEEK)-1] + ", " +
                calendar.get(Calendar.DAY_OF_MONTH) + " " +
                months[month] + year + " " +
                (String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)).length()==1 ? "0"+calendar.get(Calendar.HOUR_OF_DAY): calendar.get(Calendar.HOUR_OF_DAY))+ "." +
                (String.valueOf(calendar.get(Calendar.MINUTE)).length()==1 ? "0"+calendar.get(Calendar.MINUTE): calendar.get(Calendar.MINUTE));
    }

    public static String getFullDate(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        final int month = calendar.get(Calendar.MONTH);
        return days[(dayOfWeek - 1)] + ", " + calendar.get(Calendar.DAY_OF_MONTH) + " " + months[month] + " " + calendar.get(Calendar.YEAR);
    }

    public static long getCurrentTime(){
        SimpleDateFormat dateStandartFormatter = new SimpleDateFormat(DateFormat.SYSTEM_DATETIME_STANDARD);
        String currentTime = dateStandartFormatter.format(new Date());
        long time =0;
        try {
            time = dateStandartFormatter.parse(currentTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static int getCurrentYear(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getCurrentTime());
        return calendar.get(Calendar.YEAR);
    }

    public static String getDateMouthShort(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        final int month = calendar.get(Calendar.MONTH);
        return calendar.get(Calendar.DAY_OF_MONTH) + " " + months_short[month];
    }

    public static String getDefaultDate(String date, String dateFormat) {
        SimpleDateFormat dateStandartFormatter = new SimpleDateFormat(dateFormat, Locale.US);
        long time = 0;
        try {
            time = dateStandartFormatter.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (time==0){
            return date;
        }else{
            return IndoCalendarFormat.getDefaultDate(time);
        }
    }

    public static String getCurrentTimeDefaultDate(){
        return getDefaultDate(getCurrentTime());
    }
}
