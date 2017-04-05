package FourthTask;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		greeting();
		translate();
		System.out.println("\nIf that's all what you had to say, the Chosen One, let it be. Farewell...");
	}

	static Scanner scanner = new Scanner(System.in);

	static StringBuilder letEarthlingSpeak() {
		StringBuilder earthlingCommunicate = new StringBuilder(scanner.nextLine().trim());
		return earthlingCommunicate;
	}

	static String reverseEarthlingCommunicate(StringBuilder earthlingCommunicate) {
		String reversedEarthlingCommunicate = earthlingCommunicate.reverse().toString().toUpperCase();
		return reversedEarthlingCommunicate;
	}

	static void greeting() throws InterruptedException {
		System.out.println("Hello, Earthling.");
		Thread.sleep(1500);
		System.out.print("We're coming from ");
		Thread.sleep(1000);
		System.out.print("outer space ");
		Thread.sleep(1000);
		System.out.print("to communicate");
		Thread.sleep(1000);
		System.out.println(" with your species.");
		Thread.sleep(1000);
		System.out.print("Use our high tech ");
		Thread.sleep(1000);
		System.out.print("translation device so ");
		Thread.sleep(1000);
		System.out.println("we can understand you.");
		Thread.sleep(1500);
		System.out.print("Please, speak to this tiny hole...\n");
	}

	static void translate() throws InterruptedException {
		StringBuilder message = null;
		do {
			message = letEarthlingSpeak();
			System.out.println("Your message is: " + message.toString().toUpperCase());
			String reversedMessage = reverseEarthlingCommunicate(message);
			System.out.println("The translation to the alien language is: " + reversedMessage);
			if (!message.toString().equals("stop")) {
				System.out.println("Please, verbalize something more or say \"POTS\" in your tongue to finish...");
			}
		} while (!message.toString().equals("pots"));
	};
}

