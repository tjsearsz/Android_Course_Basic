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
                                                new SimpleDateFormat ("yyyy/MM/dd HH:mm");

    private static final SimpleDateFormat CalendarFormatter =
                                                new SimpleDateFormat ("MMMM dd");

    private static final SimpleDateFormat YearFormatter =
                                                new SimpleDateFormat ("YYYY");

    private static final SimpleDateFormat TimeFormatter =
            new SimpleDateFormat ("HH:mm");

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
     * Method for getting a string of a date (year, month, day, hour, minute)
     * @param date The date we want to have
     * @return string representation of the date
     */
    public static String DateToString(Date date)
    {
        return formatter.format(date);
    }

    /**
     * Method for getting a string of a date (month, day)
     * @param date The date we want to have
     * @return string representation of the date
     */
    public static String MonthDayDateToString(Date date)
    {

        return CalendarFormatter.format(date);
    }

    /**
     * Method for getting a string of a date (Year)
     * @param date The date we want to have
     * @return string representation of the date
     */
    public static String YearDateToString(Date date)
    {

        return YearFormatter.format(date);
    }

    /**
     * Method for getting a string of the time (Hour minute)
     * @param time The time we want to have
     * @return string representation of the time
     */
    public static String TimeDateToString(Date time)
    {

        return TimeFormatter.format(time);
    }
}
