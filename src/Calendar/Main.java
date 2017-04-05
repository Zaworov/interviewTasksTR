package FivthTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Date startDate = getStringStartDateFromUserAndParseItToDateFormat();
		Date endDate = getStringStopDateFromUserAndParseItToDateFormat();
		System.out.println("Start date: " + startDate);
		System.out.println("End date" + endDate);
		System.out.println("***");
		System.out.println("Here's the list of week days in provided period: ");
		List<Date> listResultDates = getDaysBetweenDatesAndCreateList(startDate, endDate);
		for (Date element : listResultDates) { 
			System.out.println(element);
		}
	}

	static Scanner sc = new Scanner(System.in);
	
	public static String getUserInput() {
		return sc.nextLine().trim();
	}
	
	public static Date getStringStartDateFromUserAndParseItToDateFormat () throws ParseException { 
		System.out.println("Please type START date in format DD.MM.YYYY");
		String userInput = getUserInput();
		Date startDate = parseStringToDate(userInput);
		return startDate;
	}
	
	public static Date getStringStopDateFromUserAndParseItToDateFormat () throws ParseException { 
		System.out.println("Please type STOP date in format DD.MM.YYYY");
		String userInput = getUserInput();
		Date stopDate = parseStringToDate(userInput);
		return stopDate;
	}
	
	static List<Date> getDaysBetweenDatesAndCreateList(Date startDate, Date endDate) {
		List<Date> listOfdates = new ArrayList<>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);

		while (calendar.getTime().getTime() <= endDate.getTime()) {
			Date result = calendar.getTime();
			if (calendar.get(Calendar.DAY_OF_WEEK) != 7 && calendar.get(Calendar.DAY_OF_WEEK) != 1) { 
			listOfdates.add(result);
			}
			calendar.add(Calendar.DATE, 1);
		}
		return listOfdates;
	}

	public static Date parseStringToDate(String stringDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date parsedDate = null;
		try {
		parsedDate = sdf.parse(stringDate);
		} catch (ParseException pe) { 
			System.out.println("Coœ posz³o nie tak z parsowaniem.");
		}
		return parsedDate;
}

}
