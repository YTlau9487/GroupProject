/*
 * This is the class where the main method is located. 
 * You will run the game through this class.
 */

package App;

import java.awt.AWTException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws InterruptedException, AWTException {
		String choice;// Variable to store users's choice
		Scanner choiceScanner = new Scanner(System.in);// Scanner to read the user's choice
		Scanner nameScanner = new Scanner(System.in); // Scanner to get player's name
		boolean developChoice = false; // Flag to indicate if the player's choice is still in development mode
		String playerName; // Variable to store player's name

		Message.displayDifficultyMenu();// Display the difficulty menu
		do {
			// Prompt the user for their choice
			System.out.print(ColorPlate.magenta + ColorPlate.bold + "Your choice: " + ColorPlate.resetColor);
			choice = choiceScanner.nextLine();// Read the player's choice
			System.out.println();

			// Process the user's choice
			switch (choice) {
			case "1":
				// Clear the difficulty menu from the console
				KBEvent.clean_console();

				// Display a welcome message
				Message.welcomeMessage();

				// Prompt the player to enter their name
				Message.print_letter_by_letter(
						"\nPlease enter your character's name, and get ready to face the challenge!\n", 25);
				Thread.sleep(500);

				// Ensure the player enters a valid name
				do {

					Message.print_letter_by_letter("Your character's name is: ", 25);
					Thread.sleep(500);
					playerName = nameScanner.nextLine();
					System.out.println();
				} while (playerName.length() <= 0);

				// Display a good luck message
				Message.print_letter_by_letter("Good luck, " + playerName + "! Your adventure is about to begin. ", 25);
				Thread.sleep(500);
				System.out.println();

				// Start the game
				Game game = new Game(playerName, 3, 3);
				game.play();

				// Close scanners and exit the program
				choiceScanner.close();
				nameScanner.close();
				System.exit(0);
				break; // Exit the switch after handling choice 1

			// Normal mode
			case "2":
				// Notify the user that Normal Mode is under development
				System.out.println(
						ColorPlate.red + "You have selected Normal Mode. This feature is still under development."
								+ ColorPlate.resetColor);

				developChoice = true;// Prompt the user to input again
				break; // Exit the switch after handling choice 2

			// Extreme mode
			case "3":
				// Notify the user that Extreme Mode is under development
				System.out.println(
						ColorPlate.red + "You have selected Extreme Mode. This feature is still under development."
								+ ColorPlate.resetColor);

				developChoice = true;// Prompt the user to input again
				break; // Exit the switch after handling choice 3
			default:
				// Display an error message for invalid input
				System.out.println(ColorPlate.red + "Invalid choice. Please enter 1, 2, or 3." + ColorPlate.resetColor);
				break; // Exit the switch for invalid input
			}
		} while (choice != "1" || choice != "2" || choice != "3" || developChoice == true); // // Repeat until the
																							// player makes a valid
																							// choice

	}
}