package twodays;
import java.util.Calendar;
import java.util.Date;


public class twodays {
	
	 public static int differentDaysByMillisecond(Date date1,Date date2)
	    {
	        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return days;
	    }
	 
	 
	    public static int daysBetween(Date date1,Date date2)  
	    {  
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(date1);  
	        long time1 = cal.getTimeInMillis();               
	        cal.setTime(date2);  
	        long time2 = cal.getTimeInMillis();  
	        long between_days=(time2-time1)/(1000*3600*24); 
	        
	        return Integer.parseInt(String.valueOf(between_days));         
	    }  

}

	 
	