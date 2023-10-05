package com.example.demo.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static DateFormat DAY_MONTH_YEAR_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public static String format(Date date) {
        return DAY_MONTH_YEAR_FORMAT.format(date);
    }
}
