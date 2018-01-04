package com.highpeak.Ediscovery.utils;

import java.sql.Date;
import java.util.Calendar;

public class DateUtil {

	
	 public static final String DD_MM_YYYY = "dd-MM-yyyy";
	 
	 public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	 
	  public static final Long MLLISECONDS_IN_DAY = 86400000l;
	  
	  public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

	private static final String DateTimeZone = null;

	  private DateUtil() {
		  super();
	  }
	  
	  public static Date getDateTime( final long calendar )
	    {
	        return new Date(calendar);
	    }

	  
	  /*public static Long currentTimeMillis()
	    {
	        return new Date(0).withZone(DateTimeZone.UTC).getMillis();
	    }*/
}
