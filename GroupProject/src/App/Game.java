/*
 * This Game class contains all the game logic:
 * 
 * - generatePositions(): Generates the positions of the treasure and monster also the monster's point.
 * - checkCollision(): Checks for overlaps between the monster and treasure positions.
 * 
 * User input handling for player movement:
 * - playerInputMovement(Scanner input): Gets user input for movement and updates the player's position.
 * 
 * Score calculation when the player is at the same position as the monster or treasure:
 * - checkMonster(): Checks if the player is at the same position as the monster and updates the score accordingly.
 * - checkTreasure(): Checks if the player is at the same position as the treasure and updates the score accordingly.
 * 
 * The main game loop and performance handling:
 * - play(): Manages the game flow, including rounds, player input, and game over conditions.
 */

package App;

import java.awt.AWTException;
import java.util.Scanner;

public class Game {
	Player player;
	Monster monster1;
	Treasure treasure1;
	Map map;
	static int roundCount;
	final static int maxRound = 10; // Set a constant maximum number of rounds for the game

	// Constructor
	public Game(String playerName, int mapRow, int mapCol) {
		player = new Player(playerName); // Create an instance of the Player with the given name
		monster1 = new Monster(); // Create an instance of a Monster
		treasure1 = new Treasure(mapRow, mapCol); // Create an instance of Treasure with specified map dimensions
		map = new Map(mapRow, mapCol); // Create an instance of Map with the specified number of rows and columns
		roundCount = 0; // Initialize the round count to 0

	}

	/**
	 * The method contains the main game logic:
	 * 
	 * 1. It will first create and display the map by calling map.createGrid()
	 * map.printGrid with the current positions of the monster, treasure and player.
	 * 
	 * 2. Then, it will ask the player to enter their movement by calling
	 * playerInputMovement(input).
	 * 
	 * 3. It will call generatePositions(map) to generate the positions of the
	 * monster and treasure, as well as the monster's score.
	 * 
	 * 4. It will call checkCollision() to ensure that the monster's and treasure's
	 * positions do not overlap.
	 * 
	 * 5. It will call CheckMonster() to check if the player is at the same position
	 * as the monster; if so, it will deduct the related score from the player.
	 * 
	 * 6. It will call CheckTreasure() to check if the player is at the same
	 * position as the treasure; if so, it will add the related score to the player.
	 * 
	 * 
	 * The game will loop for a maximum of maxRound times.
	 * 
	 * - If the player's score becomes 0 within this range, it will call
	 * Message.printLoseMsg() and end the game
	 * 
	 * - If the maximum number of rounds is reached and the player's score is not 0,
	 * it will print Message.printWinningMsg() and ask the player if they want to
	 * continue:
	 * 
	 * - If the answer is "no", it will print Message.printFarewellMsg() and end the
	 * game.
	 * 
	 * - If the answer is "yes", it will continue looping the game logic until the
	 * player's score becomes 0, at which point it will print
	 * Message.printDeathMsg().
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void play() throws AWTException, InterruptedException {
		boolean isContinue = true; // Flag to control the main game loop
		// Set the player's starting position at the bottom-left corner of the map
		player.setStartPosition(map.row - 1, 0);
		String askContinue; // Variable to store user input for continuing the game

		Scanner input = new Scanner(System.in);
		// Create grid with the current position of the monster, treasure and player
		String[][] demoGrid = map.createGrid(monster1, treasure1, player, roundCount);

		map.printGrid(demoGrid, roundCount, player);
		roundCount++;
		do {
			int score = player.score; // Get the current score
			// Main game logic
			if (score > 0) {
				// Get player input for movement and update the player's position
				playerInputMovement(input); // Pass the Scanner instance
				KBEvent.clean_console();
				// Update the position of monster & treasure and the monster's points
				generatePositions(map);

				// Check if treasure and monster position overlap
				checkCollision();

				// Check if player and Monster is at the same position
				checkMonster();
				// Check if player and Treasure is at the same position
				checkTreasure();

				// Create and display a demo grid showing the player's initial position
				String[][] grid = map.createGrid(monster1, treasure1, player, roundCount);

				map.printGrid(grid, roundCount, player);
				roundCount++; // Update round of the game
			}

			// Check if the maximum round has been reached
			if (roundCount == maxRound + 1 && score > 0) {
				System.out.println();
				Message.printWinningMsg();
				do {
					// Ask the player if they want to continue
					System.out.println("Do you want to play further? (Y/N)");
					askContinue = input.nextLine().toUpperCase(); // Get answer and convert it to upper case

					// Check user input for continuing the game
					if (askContinue.equals("Y")) {
						System.out.println(
								ColorPlate.magenta + "Great choice! Let's keep playing!" + ColorPlate.resetColor);
						break; // Exit the inner loop to continue the game
					} else if (askContinue.equals("N")) {
						Message.printFarewellMsg();
						isContinue = false; // Set flag to false to exit the outer loop
						break; // Exit the inner loop
					} else {
						// Handle invalid input
						System.out.println(
								ColorPlate.red + "Invalid input. Please enter Y or N." + ColorPlate.resetColor);
					}
				} while (true); // Keep asking until valid input is received
			}

			// Check if the round exceeds the maximum round and if the score is less than or
			// equal to 0
			if (roundCount > maxRound && score <= 0) {
				// Inform the player how many rounds they finished
				Message.printDeathMsg();
				System.out.printf(
						ColorPlate.magenta + "Congratulations! You have completed %d rounds!" + ColorPlate.resetColor,
						roundCount);
				isContinue = false; // Set flag to false to exit the outer loop
				break; // Exit the game
			} else if (roundCount <= maxRound && score <= 0) {
				// Inform the player they lost
				Message.printLoseMsg();
				System.out.printf(ColorPlate.magenta + "You finished with a total of %d rounds" + ColorPlate.resetColor,
						roundCount);
				isContinue = false; // Set flag to false to exit the outer loop
				break; // Exit the game
			}

		} while (isContinue); // Continue the game loop while isContinue is true

		input.close(); // Close the Scanner when done

	}// play Method end

	// generate positions of treasure and monster and the score of monster
	public void generatePositions(Map map) {
//		*****generate treasure position****
		treasure1.updatePosition(map);
//		generate monster position & point
		monster1.update_positionX(map);
		monster1.update_positionY(map);
		monster1.update_point();
	}// generatePositions() end

	// check monster1 and treasure1 positions, if overlap, then update again
	public void checkCollision() {
		// updated until monster1 and treasure1 positions are not equal
		while (monster1.Monster_x == treasure1.getTreasureX() && monster1.Monster_y == treasure1.getTreasureY()) {
			monster1.update_positionX(map); // update monster positionX
			monster1.update_positionY(map); // update monster positionY
		}

	}// checkCollision() end

	/**
	 * Method of checking the position of Player and Monster whether it's same or
	 * not
	 */
	public void checkMonster() {
		if (monster1.Monster_x == player.getPositionX() && monster1.Monster_y == player.getPositionY()) {
			player.updateScore(monster1.Monster_point);
		}
	}// checkMonster() end

	/**
	 * Method of checking the position of Player and Treasure whether it's same or
	 * not
	 */
	public void checkTreasure() {
		if (treasure1.getTreasureX() == player.getPositionX() && treasure1.getTreasureY() == player.getPositionY()) {
			player.updateScore(treasure1.getTreasurePoint());
		}
	}// checkTreasure() end

	/**
	 * This method gets user input (W, A, S, D) to control the movement of the
	 * player, and (E) to exit the game. It will continue to prompt the user until a
	 * valid input is received.
	 * 
	 * @param input A Scanner object passed from the play method to collect user
	 *              movement input.
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void playerInputMovement(Scanner input) throws AWTException, InterruptedException { // Accept Scanner as a
																								// parameter
		int playerPositionX = player.getPositionX(); // Initial X position of the player from player class
		int playerPositionY = player.getPositionY(); // Initial Y position of the player from player class
		int mapMaxX = map.row; // Maximum X boundary of the grid (row -1)
		int mapMaxY = map.col; // Maximum Y boundary of the grid (column -1)
		String movement; // Variable to store user movement input

		boolean isValidMove = false; // Flag to check if the move is valid

		do {
			// Prompt the user for movement input
			System.out.println("Ready to move? Use " + ColorPlate.red + "W" + ColorPlate.resetColor + "(up), "
					+ ColorPlate.red + "A" + ColorPlate.resetColor + "(left), " + ColorPlate.red + "S"
					+ ColorPlate.resetColor + "(down), or " + ColorPlate.red + "D" + ColorPlate.resetColor
					+ "(right) to choose your next step, or " + ColorPlate.red + "E" + ColorPlate.resetColor
					+ " to exit the game!");
			System.out.print("What is your choice? ");

			movement = input.nextLine().toUpperCase(); // Convert input to upper-case (case insensitive)

			int playerNextX = playerPositionX; // Start with current position
			int playerNextY = playerPositionY; // Start with current position

			// Check if the player wants to exit the game
			if (movement.equals("E")) {
				Message.printFarewellMsg();
				System.out.println(
						ColorPlate.magenta + "Exiting the game. Thank you for playing!" + ColorPlate.resetColor);
				System.exit(0); // Exit the program
			}

			// Check if the movement is valid, update the X and Y position variables
			switch (movement) {
			case "W":
				playerNextX = playerPositionX - 1; // Move up
				break;

			case "A":
				playerNextY = playerPositionY - 1; // Move left
				break;

			case "S":
				playerNextX = playerPositionX + 1; // Move down
				break;

			case "D":
				playerNextY = playerPositionY + 1; // Move right
				break;

			default:
				System.out.println(ColorPlate.red + "Invalid input, please try again" + ColorPlate.resetColor);
				continue; // Ask for input again
			}
			// Check if the new position is valid
			if (playerNextX < 0 || playerNextX >= mapMaxX || playerNextY < 0 || playerNextY >= mapMaxY) {
				System.out.println(
						ColorPlate.red + "Invalid move! Out of bounds. Please try again." + ColorPlate.resetColor);
				continue; // Ask for input again
			} else {
				// Update the player's position

				player.move(playerNextX, playerNextY);

				// For testing: printing the current X,Y of player
//				System.out.printf("\nThe new x,y is: (%d,%d)\n", player.getPositionX(), player.getPositionY());

				isValidMove = true; // Set the flag to true to exit the loop
			}
		} while (!isValidMove); // Continue until a valid move is made

	}// playerInputMovement() end

}
