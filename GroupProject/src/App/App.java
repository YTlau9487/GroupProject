package App;

import java.awt.AWTException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws AWTException, InterruptedException {
		Scanner scanner = new Scanner(System.in);
		print_letter_by_letter("Please enter user name: ", 25);
		String playerName = scanner.nextLine();
		print_letter_by_letter("Welcome, " + playerName + "!", 25);
		System.out.println();
		print_letter_by_letter("This terrible 5x5 map, you will take on the role of a brave adventurer.", 25);
		System.out.println();
		print_letter_by_letter("Your mission is to:", 25);
		Thread.sleep(500);
		System.out.println();
		print_letter_by_letter("----Collect treasures to earn points.", 25);
		Thread.sleep(500);
		System.out.println();
		print_letter_by_letter("----Avoid encounters with monsters, as your score will decrease.", 25);
		Thread.sleep(500);
		System.out.println();
		print_letter_by_letter("----Survive through ten actions to successfully complete your adventure!", 25);
		Thread.sleep(500);
		System.out.println();

		int treasure = 10;
		int score = 100;

		int result = add(treasure, score);
		System.out.println("Your total points after adding treasure: " + result);

		scanner.close();
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static void print_letter_by_letter(String S, int speed) throws InterruptedException {
		for (int i = 0; i < S.length(); i++) {
			System.out.print(S.charAt(i));
			Thread.sleep(speed);
		}

	}
}