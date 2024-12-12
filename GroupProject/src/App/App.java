/*
 * This is the class where the main method is located. 
 * You will run the game through this class.
 */

package App;

import java.util.Scanner;

public class App {

	public static void main(String[] args) throws InterruptedException {
		int choice;
		Scanner intScanner = new Scanner(System.in);
		Scanner nameScanner = new Scanner(System.in);
		Message.displayDifficultyMenu();
		do {
			System.out.print(ColorPlate.magenta + ColorPlate.bold+"Your choice: " + ColorPlate.resetColor);
			choice = intScanner.nextInt();
			System.out.println();

			switch (choice) {
			case 1:
//				 Welcome message
				Message.welcomeMessage();
//				 ask player's name
				Message.print_letter_by_letter(
						"\nPlease enter your character's name, and get ready to face the challenge!\n", 25);
				Thread.sleep(500);
				Message.print_letter_by_letter("Your character's name is: ", 25);
				Thread.sleep(500);
				String playerName = nameScanner.nextLine();
				System.out.println();
				Message.print_letter_by_letter("Good luck, " + playerName + "! Your adventure is about to begin. ", 25);
				Thread.sleep(500);
				System.out.println();

				// play the game
				Game game = new Game(playerName, 3, 3);
				game.play();

				intScanner.close();
				nameScanner.close();
				System.exit(0);
				break; // Exit the switch after handling choice 1
			case 2:

				System.out.println(
						ColorPlate.red + "You have selected Normal Mode. This feature is still under development."
								+ ColorPlate.resetColor);
				intScanner.close();
				nameScanner.close();
				System.exit(0);
				break; // Exit the switch after handling choice 2
			case 3:

				System.out.println(
						ColorPlate.red + "You have selected Extreme Mode. This feature is still under development."
								+ ColorPlate.resetColor);
				intScanner.close();
				nameScanner.close();
				System.exit(0);
				break; // Exit the switch after handling choice 3
			default:
				// Invalid choice message
				System.out.println(ColorPlate.red + "Invalid choice. Please enter 1, 2, or 3." + ColorPlate.resetColor);
				break; // Exit the switch for invalid input
			}
		} while (choice < 1 || choice > 3); // Continue until a valid choice is made

	}
}