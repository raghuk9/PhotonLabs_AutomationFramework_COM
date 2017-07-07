package framework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartTime {
	
	
	public static Date startTime() throws ParseException
	{
		DateFormat start=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date newdate=new Date();
		String date=start.format(newdate);
		
		Date startDate=start.parse(date);
		System.out.println("Calculating the scenario start time.....");
		return startDate;
	}

}
