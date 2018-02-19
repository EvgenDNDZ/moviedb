package com.railsreactor.moviedbapp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Evgeny Kubay on 2/18/18.
 */

public class DateUtils {
    public static String fullFormat = "yyyy-MM-dd";
    public static String dateWithMonthName  = "MMM dd, yyyy";
    public static String dateYear  = "yyyy";

    public static Date getDateFromString(String dateAsString, String format){
        DateFormat sourceFormat = new SimpleDateFormat(format, Locale.getDefault());
        try {
            return sourceFormat.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDateAsString(Date date, String format){
            try {
                return new SimpleDateFormat(format, Locale.getDefault()).format(date);
            } catch (Exception e) {
                return "";
            }
    }
}
