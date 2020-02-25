package com.teddysears.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class to handle extra work
 */
public class Utils {

    /**
     * Method for getting a date based on a string
     * @param date The date we want to have
     * @return The date ceated
     */
    public static Date GetNewDateBasedOnString(String date)
    {
        SimpleDateFormat formatter1 = new SimpleDateFormat ("DD/MM/YYYY");
        try {
            return formatter1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
