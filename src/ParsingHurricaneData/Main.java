package ThirdTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String sourceFilePath = "data.txt";
		int desiredYear = 0; 
		
		System.out.println("Please enter the year you're interested in (for example -> \"2009\"). The range is 1949 - 2015.");
		desiredYear = Integer.parseInt(getUserInput());
		System.out.println("Thank you. The file with data is quite big, so it may take around two minutes to process it.");
		System.out.println("Please be patient - it's 0.1 version :)");
		System.out.println("");
		printAllDataOfDesiredYear(desiredYear, sourceFilePath);

	}
	static Scanner sc = new Scanner(System.in);
	
	public static String getUserInput() {
		return sc.nextLine().trim();
	}

	static String textToStringReaderFromFile(String path) throws FileNotFoundException {
		String rawStringInput = "";
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			rawStringInput = rawStringInput + scanner.nextLine();
		}
		scanner.close();
		return rawStringInput;
	}

	static List<String> listCyclonNumbers(String rawStringInput) {
		String[] tableOfValues = rawStringInput.split(",");
		List<String> listOfCyclonNumber = new ArrayList<>();
		for (String element : tableOfValues) {
			if (element.contains("EP") || element.contains("CP")) {
				listOfCyclonNumber.add(element);
			}
		}
		return listOfCyclonNumber;
	}

	static List<String> listCyclonYears(String rawStringInput) {
		String[] tableOfValues = rawStringInput.split(",");
		List<String> listOfCyclonYears = new ArrayList<>();
		String tempElement = null;
		for (String element : tableOfValues) {
			if (element.contains("EP") || element.contains("CP")) {
				tempElement = element.substring(4, 8);
				listOfCyclonYears.add(tempElement);
			}
		}
		return listOfCyclonYears;
	}

	static List<String> listCyclonNames(String rawStringInput) {
		String[] tableOfValues = rawStringInput.split(",");
		List<String> listOfCyclonNames = new ArrayList<>();
		for (int i = 0; i < tableOfValues.length; i++) {
			if (tableOfValues[i].contains("EP") || tableOfValues[i].contains("CP")) {
				listOfCyclonNames.add(tableOfValues[i + 1].trim());
			}
		}
		return listOfCyclonNames;
	}

	static List<ArrayList<String>> listTheListsOfCyclonSpeeds(String rawStringInput) {
		String[] tableOfValues = rawStringInput.split(",");
		List<ArrayList<String>> listOfListsContainingCyclonWindSpeeds = new ArrayList<ArrayList<String>>();
		try {
			for (int i = 0; i < tableOfValues.length; i++) {
				ArrayList<String> temporaryList = new ArrayList<>();
				if (tableOfValues[i].startsWith("EP") || tableOfValues[i].startsWith("CP")) {
					int iteration = i + 9;
					temporaryList.add(tableOfValues[iteration]);
					while (iteration + 20 < tableOfValues.length) {
						if (tableOfValues[iteration + 14].startsWith("EP") || tableOfValues[iteration + 14].startsWith("CP")) {
							break;
						}
						iteration = iteration + 20;
						temporaryList.add(tableOfValues[iteration]);
					}
					listOfListsContainingCyclonWindSpeeds.add((ArrayList<String>) temporaryList);
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}
		return listOfListsContainingCyclonWindSpeeds;
	}

	static int getMaximumCyclonSpeed (List<String> listOfSpeeds) { 
		int maximumCyclonSpeed = 0;
		List<Integer> listOfSpeedsInt = new ArrayList<>();
		for (String element : listOfSpeeds) { 
			listOfSpeedsInt.add(Integer.parseInt(element.trim()));
		}
		Collections.sort(listOfSpeedsInt);
		maximumCyclonSpeed = listOfSpeedsInt.get(listOfSpeedsInt.size() - 1);
		return maximumCyclonSpeed;
	}
	
	static void printAllDataOfDesiredYear(int desiredYear, String sourceFilePath) throws FileNotFoundException {
		String rawStringInput = Main.textToStringReaderFromFile(sourceFilePath);
		List<String> listOfCyclonNumbers = listCyclonNumbers(rawStringInput);
		List<String> listCyclonYears = listCyclonYears(rawStringInput);
		List<String> listCyclonNames = listCyclonNames(rawStringInput);
		List<ArrayList<String>> listOfMaximumSpeeds = listTheListsOfCyclonSpeeds(rawStringInput);

		for (int i = 0; i < listCyclonYears.size(); i++) {
			if (Integer.parseInt(listCyclonYears.get(i)) == desiredYear) { 
			System.out.println("Year: " + listCyclonYears.get(i));
			System.out.println("Cyclon #: " + listOfCyclonNumbers.get(i));
			System.out.println("Cyclon Name: " + listCyclonNames.get(i));
			System.out.println("Cyclon maximum speed: " + getMaximumCyclonSpeed(listOfMaximumSpeeds.get(i)));
			System.out.println("\n****\n");
			}
		}
	}
}
