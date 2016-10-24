package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;

public class TimestampGenerator {

	public static Timestamp getTimestamp() {
		java.util.Date date= new java.util.Date();
		return new Timestamp(date.getTime());
	}
	
	public static String getFormattedDate() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String result = sdf.format(date);
		return result;
	}
	
	public static String getTruncatedDate(Timestamp value) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String result = sdf.format(value);	
		if(result.equals("01/01/70")){
			// this date simply means no date value was recorded; leave it blank
			result = "";
		}
		return result;
	}
	
	public static Timestamp createTimestamp(String value) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date date = dateFormat.parse(value);
		long time = date.getTime();
		return new Timestamp(time);
	}
}
