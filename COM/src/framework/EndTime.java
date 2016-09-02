package framework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EndTime {
	public static Date endTime() throws ParseException {
        DateFormat end = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date newdate = new Date();
		String date = end.format(newdate);
        Date endDate = end.parse(date);
		System.out.println("Calculating the test scenario end time....");
		return endDate;
	}
}
