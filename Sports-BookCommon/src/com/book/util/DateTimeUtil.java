package com.book.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	public static Date parseToDateObject(String yyyyDashMMDashdd) throws ParseException {
		final String format = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(format);
		final Date dateObject;

		dateObject = df.parse(yyyyDashMMDashdd);

		return dateObject;
	}
	
	public static Date parseTimeToDateObject(String HHColonmmColonss) throws ParseException {
		final String format = "HH:mm:ss";
		DateFormat df = new SimpleDateFormat(format);
		final Date dateObject = df.parse(HHColonmmColonss);

		return dateObject;
	}
	
}
