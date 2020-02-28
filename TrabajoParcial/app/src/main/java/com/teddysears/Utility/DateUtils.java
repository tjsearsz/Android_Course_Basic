package com.teddysears.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class to handle extra work related to dates
 */
public class DateUtils {

    //Creating the new date based on the parameter
    private static final SimpleDateFormat formatter =
                                                new SimpleDateFormat ("dd/MM/YYYY HH:mm");

    /**
     * Method for getting a date based on a string
     * @param date The date we want to have
     * @return The date created
     */
    public static Date StringToDate(String date)
    {
        //In case of failing, we send an empty date
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * Method for getting a string of a date
     * @param date The date we want to have
     * @return string representation of the date
     */
    public static String DateToString(Date date)
    {
        return formatter.format(date);
    }
}
