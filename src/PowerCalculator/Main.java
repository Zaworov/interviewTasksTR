package SecondTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		List<String> listOfDates = getCleanDateList("exporthtmldata.html");
		List<Integer> exportActualSumsList = getActualSumsForEachDay("exporthtmldata.html");
		List<Integer> exportForecastSumsList = getForecastSumsForEachDay("exporthtmldata.html");
		List<Integer> importActualSumsList = getActualSumsForEachDay("importhtmldata.html");
		List<Integer> importForecastSumsList = getForecastSumsForEachDay("importhtmldata.html");
		List<String> actualTransfer = getTranserForEachDay(importActualSumsList, exportActualSumsList, "actual");
		List<String> forecastTransfer = getTranserForEachDay(importForecastSumsList, exportForecastSumsList, "forecast");

		for (int i = 0; i < listOfDates.size(); i++) { 
			System.out.println("Actual export: " + listOfDates.get(i) + ": " + exportActualSumsList.get(i));
			System.out.println("Actual import: " + listOfDates.get(i) + ": " + importActualSumsList.get(i));
			System.out.println(actualTransfer.get(i) + "\n");
			System.out.println("Forecast export: " + listOfDates.get(i) + ": " + exportForecastSumsList.get(i));
			System.out.println("Forecast import: " + listOfDates.get(i) + ": " + importForecastSumsList.get(i));
			System.out.println(forecastTransfer.get(i) + "\n");
			System.out.println("***");
		}
	}

	static String getRawString(String path) throws FileNotFoundException {
		String rawStringInput = " ";
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			rawStringInput = rawStringInput + scanner.nextLine();
		}
		scanner.close();
		return rawStringInput.trim();
	}

	static List<Integer> getNumbersFromRawString(String filePath) throws FileNotFoundException {
		String rawString = getRawString(filePath);
		String[] list = rawString.split(">");
		String firstForecastCondition = "<td class=\"txtrVERIF\" align=\"right\" style=\"width:60px;\"";
		String secondForecastCondition = "<td class=\"txtVERIF\" align=\"right\" style=\"width:60px;\"";
		String firstActualCondition = "<td class=\"txtrPREV\" align=\"right\" style=\"width:60px;\"";
		String secondActualCondition = "<td class=\"txtPREV\" align=\"right\" style=\"width:60px;\"";
		List<Integer> listOfNumericResults = new LinkedList<>();
		int value = 0;

		for (int i = 0; i < list.length; i++) {
			if (list[i].trim().equals(firstForecastCondition) || list[i].trim().equals(secondForecastCondition)) {
				value = Integer.parseInt(list[i + 1].substring(0, 4));
				listOfNumericResults.add(value);
			}
			if (list[i].trim().equals(firstActualCondition) || list[i].trim().equals(secondActualCondition)) {
				value = Integer.parseInt(list[i + 1].substring(0, 4));
				listOfNumericResults.add(value);
			}
		}
		return listOfNumericResults;
	}

	static List<List<Integer>> getNumbersInDayOrder(String filePath) throws FileNotFoundException {
		List<Integer> messyListOfNumbers = getNumbersFromRawString(filePath);
		List<List<Integer>> listOfNumbersInDayOrder = new ArrayList<>();

		List<Integer> dayOne = new ArrayList<>();
		List<Integer> dayTwo = new ArrayList<>();
		List<Integer> dayThree = new ArrayList<>();
		List<Integer> dayFour = new ArrayList<>();
		List<Integer> dayFive = new ArrayList<>();
		List<Integer> daySix = new ArrayList<>();
		List<Integer> daySeven = new ArrayList<>();
		List<Integer> dayEight = new ArrayList<>();
		List<Integer> dayNine = new ArrayList<>();
		List<Integer> dayTen = new ArrayList<>();
		List<Integer> dayEleven = new ArrayList<>();
		List<Integer> dayTwelve = new ArrayList<>();
		List<Integer> dayThirteen = new ArrayList<>();
		List<Integer> dayFourteen = new ArrayList<>();
		List<Integer> dayFifteen = new ArrayList<>();

		int loopsCounter = 0;
		int counter = 0;
		int day = 1;
		for (int i = 0; i < messyListOfNumbers.size(); i = i + 15) {
			counter++;
			// System.out.println("day:" + day + " // " + counter + " // " + i +
			// " // " + messyListOfNumbers.get(i));
			switch (day) {
			case 1:
				dayOne.add(messyListOfNumbers.get(i));
				break;
			case 2:
				dayTwo.add(messyListOfNumbers.get(i));
				break;
			case 3:
				dayThree.add(messyListOfNumbers.get(i));
				break;
			case 4:
				dayFour.add(messyListOfNumbers.get(i));
				break;
			case 5:
				dayFive.add(messyListOfNumbers.get(i));
				break;
			case 6:
				daySix.add(messyListOfNumbers.get(i));
				break;
			case 7:
				daySeven.add(messyListOfNumbers.get(i));
				break;
			case 8:
				dayEight.add(messyListOfNumbers.get(i));
				break;
			case 9:
				dayNine.add(messyListOfNumbers.get(i));
				break;
			case 10:
				dayTen.add(messyListOfNumbers.get(i));
				break;
			case 11:
				dayEleven.add(messyListOfNumbers.get(i));
				break;
			case 12:
				dayTwelve.add(messyListOfNumbers.get(i));
				break;
			case 13:
				dayThirteen.add(messyListOfNumbers.get(i));
				break;
			case 14:
				dayFourteen.add(messyListOfNumbers.get(i));
				break;
			case 15:
				dayFifteen.add(messyListOfNumbers.get(i));
				break;
			}

			if (counter == 24) {
				day++;
				loopsCounter++;
				i = loopsCounter - 15;
				counter = 0;
			}
			if (day == 16) {
				break;
			}
		}
		listOfNumbersInDayOrder.add(dayOne);
		listOfNumbersInDayOrder.add(dayTwo);
		listOfNumbersInDayOrder.add(dayThree);
		listOfNumbersInDayOrder.add(dayFour);
		listOfNumbersInDayOrder.add(dayFive);
		listOfNumbersInDayOrder.add(daySix);
		listOfNumbersInDayOrder.add(daySeven);
		listOfNumbersInDayOrder.add(dayEight);
		listOfNumbersInDayOrder.add(dayNine);
		listOfNumbersInDayOrder.add(dayTen);
		listOfNumbersInDayOrder.add(dayEleven);
		listOfNumbersInDayOrder.add(dayTwelve);
		listOfNumbersInDayOrder.add(dayThirteen);
		listOfNumbersInDayOrder.add(dayFourteen);
		listOfNumbersInDayOrder.add(dayFifteen);

		return listOfNumbersInDayOrder;
	}

	static List<String> getPseudoBooleansFromRawString(String filePath) throws FileNotFoundException {
		String rawString = getRawString(filePath);
		String[] list = rawString.split(">");
		String firstActualCondition = "<td class=\"txtrVERIF\" align=\"right\" style=\"width:60px;\"";
		String secondActualCondition = "<td class=\"txtVERIF\" align=\"right\" style=\"width:60px;\"";
		String firstForecastCondition = "<td class=\"txtrPREV\" align=\"right\" style=\"width:60px;\"";
		String secondForecastCondition = "<td class=\"txtPREV\" align=\"right\" style=\"width:60px;\"";
		List<String> listOfPseudoBooleanResults = new LinkedList<>();

		for (int i = 0; i < list.length; i++) {
			if (list[i].trim().equals(firstActualCondition) || list[i].trim().equals(secondActualCondition)) {
				listOfPseudoBooleanResults.add("isActual");
			}
			if (list[i].trim().equals(firstForecastCondition) || list[i].trim().equals(secondForecastCondition)) {
				listOfPseudoBooleanResults.add("isForecast");
			}
		}
		return listOfPseudoBooleanResults;
	}

	static List<List<String>> getPseudoBooleansInDayOrder(String filePath) throws FileNotFoundException {
		List<String> messyListOfPseudoBooleans = getPseudoBooleansFromRawString(filePath);
		List<List<String>> listOfPseudoBooleanInDayOrder = new ArrayList<>();

		List<String> dayOne = new ArrayList<>();
		List<String> dayTwo = new ArrayList<>();
		List<String> dayThree = new ArrayList<>();
		List<String> dayFour = new ArrayList<>();
		List<String> dayFive = new ArrayList<>();
		List<String> daySix = new ArrayList<>();
		List<String> daySeven = new ArrayList<>();
		List<String> dayEight = new ArrayList<>();
		List<String> dayNine = new ArrayList<>();
		List<String> dayTen = new ArrayList<>();
		List<String> dayEleven = new ArrayList<>();
		List<String> dayTwelve = new ArrayList<>();
		List<String> dayThirteen = new ArrayList<>();
		List<String> dayFourteen = new ArrayList<>();
		List<String> dayFifteen = new ArrayList<>();

		int loopsCounter = 0;
		int counter = 0;
		int day = 1;
		for (int i = 0; i < messyListOfPseudoBooleans.size(); i = i + 15) {
			counter++;
			switch (day) {
			case 1:
				dayOne.add(messyListOfPseudoBooleans.get(i));
				break;
			case 2:
				dayTwo.add(messyListOfPseudoBooleans.get(i));
				break;
			case 3:
				dayThree.add(messyListOfPseudoBooleans.get(i));
				break;
			case 4:
				dayFour.add(messyListOfPseudoBooleans.get(i));
				break;
			case 5:
				dayFive.add(messyListOfPseudoBooleans.get(i));
				break;
			case 6:
				daySix.add(messyListOfPseudoBooleans.get(i));
				break;
			case 7:
				daySeven.add(messyListOfPseudoBooleans.get(i));
				break;
			case 8:
				dayEight.add(messyListOfPseudoBooleans.get(i));
				break;
			case 9:
				dayNine.add(messyListOfPseudoBooleans.get(i));
				break;
			case 10:
				dayTen.add(messyListOfPseudoBooleans.get(i));
				break;
			case 11:
				dayEleven.add(messyListOfPseudoBooleans.get(i));
				break;
			case 12:
				dayTwelve.add(messyListOfPseudoBooleans.get(i));
				break;
			case 13:
				dayThirteen.add(messyListOfPseudoBooleans.get(i));
				break;
			case 14:
				dayFourteen.add(messyListOfPseudoBooleans.get(i));
				break;
			case 15:
				dayFifteen.add(messyListOfPseudoBooleans.get(i));
				break;
			}

			if (counter == 24) {
				day++;
				loopsCounter++;
				i = loopsCounter - 15;
				counter = 0;
			}
			if (day == 16) {
				break;
			}
		}
		listOfPseudoBooleanInDayOrder.add(dayOne);
		listOfPseudoBooleanInDayOrder.add(dayTwo);
		listOfPseudoBooleanInDayOrder.add(dayThree);
		listOfPseudoBooleanInDayOrder.add(dayFour);
		listOfPseudoBooleanInDayOrder.add(dayFive);
		listOfPseudoBooleanInDayOrder.add(daySix);
		listOfPseudoBooleanInDayOrder.add(daySeven);
		listOfPseudoBooleanInDayOrder.add(dayEight);
		listOfPseudoBooleanInDayOrder.add(dayNine);
		listOfPseudoBooleanInDayOrder.add(dayTen);
		listOfPseudoBooleanInDayOrder.add(dayEleven);
		listOfPseudoBooleanInDayOrder.add(dayTwelve);
		listOfPseudoBooleanInDayOrder.add(dayThirteen);
		listOfPseudoBooleanInDayOrder.add(dayFourteen);
		listOfPseudoBooleanInDayOrder.add(dayFifteen);

		return listOfPseudoBooleanInDayOrder;
	}

	static List<String> getDatesFromRawString(String filePath) throws FileNotFoundException {
		String rawString = getRawString(filePath);
		String[] list = rawString.split(">");
		List<String> listOfDates = new ArrayList<>();
		String firstCondition = "<th class=\"rbcellBDRCOLOR\" align=\"right\" scope=\"col\"";
		String secondCondition = "<th class=\"bcellBDRCOLOR\" align=\"right\" scope=\"col\"";
		for (int i = 0; i < list.length; i++) {
			if (list[i].trim().equals(firstCondition) || list[i].trim().equals(secondCondition)) {
				listOfDates.add(list[i + 1] + " 2017");
			}
		}
		listOfDates.remove(0);
		return listOfDates;
	}

	static List<String> getCleanDateList(String filePath) throws FileNotFoundException {
		List<String> listOfDates = getDatesFromRawString(filePath);
		List<String> newListOfDates = new ArrayList<>();
		String tempElement;
		for (String element : listOfDates) {
			tempElement = element;
			newListOfDates.add(tempElement.substring(0, 2) + " of " + element.substring(8, 11) + " 2017");
		}
		return newListOfDates;
	}

	static List<Integer> getActualSumsForEachDay(String filePath) throws FileNotFoundException {
		List<Integer> listOfSums = new ArrayList<>();
		List<List<String>> booleanLists = getPseudoBooleansInDayOrder(filePath);
		List<List<Integer>> numbersLists = getNumbersInDayOrder(filePath);

		int sum = 0;
		int hour = 0;

		for (int i = 0; i < numbersLists.size(); i++) {
			for (int j = 0; j < numbersLists.get(i).size(); j++) {
				hour++;
				if (booleanLists.get(i).get(j).equals("isActual")) { 
					sum = sum + numbersLists.get(i).get(j);
				} else {
					sum = sum + 0;
				}
					if (hour == 24) { 
						hour = 0;
						listOfSums.add(sum);
						sum = 0;
					}
			}
		}
		return listOfSums;
	}

	static List<Integer> getForecastSumsForEachDay(String filePath) throws FileNotFoundException {
		List<Integer> listOfSums = new ArrayList<>();
		List<List<String>> booleanLists = getPseudoBooleansInDayOrder(filePath);
		List<List<Integer>> numbersLists = getNumbersInDayOrder(filePath);

		int sum = 0;
		int hour = 0;

		for (int i = 0; i < numbersLists.size(); i++) {
			for (int j = 0; j < numbersLists.get(i).size(); j++) {
				hour++;
				if (booleanLists.get(i).get(j).equals("isActual")) { 
					sum = sum + 0;
				} else {
					sum = sum + numbersLists.get(i).get(j);
				}
					if (hour == 24) { 
						hour = 0;
						listOfSums.add(sum);
						sum = 0;
					}
			}
		}
		return listOfSums;
	}

	static List<String> getTranserForEachDay (List<Integer> importSumsList, List<Integer> exportSumsList, String status) { 
		List<String> transferListForEachDay = new ArrayList<>();
		int sum = 0;
		String message = "";
		String export = "Exported: ";
		String equalTransfer = "Daily export and import are equal.";
		String importString = "Imported: ";
		
		if (status.equals("forecast")) { 
			export = "Estimated export: ";
			equalTransfer = "Daily export and import may be equal.";
			importString = "Estimated import: ";
		}
		
		for (int i = 0; i < importSumsList.size(); i++) { 
			sum = exportSumsList.get(i) - importSumsList.get(i);
			if (sum > 0) { 
				message = export + sum; 
			} else if (sum == 0) { 
				message = equalTransfer;
			} else {
				message = importString + (-sum);
			}
			transferListForEachDay.add(message);
		}
		return transferListForEachDay;
	}
}
