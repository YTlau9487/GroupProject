/*
 * About: This Message class is responsible for displaying various messages 
 * to the player during the game, including the difficulty selection screen, welcome, 
 * win, lose, game over, and farewell messages. It also includes functions for printing 
 * messages character by character to create a typing effect and for printing text 
 * centered in the console.
 */

package App;


public class Message {
	
	/**
	 * Displays the welcome message for the game "Path of Hero".
	 * This message introduces the player to the game and outlines their mission.
	 * 
	 * @throws InterruptedException If the thread is interrupted while sleeping.
	 */
	public static void welcomeMessage() throws  InterruptedException {
		print_letter_by_letter("Welcome to \"Path of Hero\"!\n", 25);
		Thread.sleep(1500);
		System.out.println();
		print_letter_by_letter("In this mysterious map, you will take on the role of a brave adventurer,",25);
		Thread.sleep(1000);
		System.out.println();
		print_letter_by_letter ("exploring uncharted territories in search of hidden treasures,",25);
		Thread.sleep(400);
		System.out.println();
		print_letter_by_letter ("all while being cautious of the monsters lurking in the shadows.", 25);
		System.out.println();
		Thread.sleep(800);
		print_letter_by_letter("\nYour mission is to:", 25);
		Thread.sleep(500);
		System.out.println();
		print_letter_by_letter("- Collect treasures to earn points.", 25);
		Thread.sleep(500);
		System.out.println();
		print_letter_by_letter("- Avoid encounters with monsters, as your score will decrease, and you may even face the danger of game over.", 25);	
		Thread.sleep(500);
		System.out.println();
		print_letter_by_letter("- Survive through ten actions to successfully complete your adventure!", 25);
		Thread.sleep(500);
		System.out.println();
	}
	
	
	/**
	 * Displays the difficulty selection menu at the start of the game.
	 * This menu presents the player with options to choose the difficulty level 
	 * of the game, including Easy, Normal, and Extreme
	 */
	public static void displayDifficultyMenu() {
	    String gameName = " █▀▄ ▄▀▄ ▀█▀ █▄█   ▄▀▄ █▀   █▄█ ██▀ █▀▄ ▄▀▄\r\n"
	                    + " █▀  █▀█  █  █ █   ▀▄▀ █▀   █ █ █▄▄ █▀▄ ▀▄▀\r\n";

	    
	    String[] lines = gameName.split("\r\n"); //Split the ASCII art into array of string by \r\n

	    System.out.println();
	    // Print line by line
	    for (String line : lines) {
	        printCentered(line);
	    }
	    System.out.println();

	    printCentered(ColorPlate.bold+"        Choose difficulty"+ColorPlate.resetColor);
	    printCentered("+-----------------+");
	    printCentered("|1. Easy Mode     |");
	    printCentered("|-----------------|");
	    printCentered("|2. Normal Mode   |");
	    printCentered("|-----------------|");

	    printCentered("|3. Extreme Mode  |");
	    printCentered("+-----------------+");
//	   System.out.printf("%58s\n","|   2. Normal Mode  |");
//	   System.out.printf("%59s\n","3. Extreme Mode");
	}

	/**
	 * Displays the winning message to the user when they successfully complete the game.
	 */
    public static void printWinningMsg() {
        String win_message = "██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗██╗\r\n" + //
                        	 "╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║██║\r\n" + //
                        	 " ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║██║\r\n" + //
                        	 "  ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║╚═╝\r\n" + //
                        	 "   ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║██╗\r\n" + //
                        	 "   ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝\r\n" + //
                        	 "";

	    String[] lines = win_message.split("\r\n"); //Split the ASCII art into array of string by \r\n

	    // Print line by line
	    for (String line : lines) {
	        printCentered(line);
	    }
	    System.out.println();
    }
    
    /**
     *Displays the losing message to the user when they fail to complete the game 
     */
    public static void printLoseMsg() {
        String lose_message = "██╗   ██╗ ██████╗ ██╗   ██╗    ██╗      ██████╗ ███████╗███████╗         \r\n" + //
                        	  "╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║     ██╔═══██╗██╔════╝██╔════╝         \r\n" + //
                        	  " ╚████╔╝ ██║   ██║██║   ██║    ██║     ██║   ██║███████╗█████╗           \r\n" + //
                        	  "  ╚██╔╝  ██║   ██║██║   ██║    ██║     ██║   ██║╚════██║██╔══╝           \r\n" + //
                        	  "   ██║   ╚██████╔╝╚██████╔╝    ███████╗╚██████╔╝███████║███████╗██╗██╗██╗\r\n" + //
                        	  "   ╚═╝    ╚═════╝  ╚═════╝     ╚══════╝ ╚═════╝ ╚══════╝╚══════╝╚═╝╚═╝╚═╝\r\n" + //
                        	  "";

	    String[] lines = lose_message.split("\r\n"); //Split the ASCII art into array of string by \r\n

	    // Print line by line
	    for (String line : lines) {
	        printCentered(line);
	    }
	    System.out.println();
    }

    /**
     *Displays the death message to the user when their character dies in the game 
     */
    public static void printDeathMsg() {
        String death_message = " ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ \r\n" + //
                        	   "██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗\r\n" + //
                        	   "██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝\r\n" + //
                        	   "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗\r\n" + //
                        	   "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║\r\n" + //
                        	   " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝\r\n" + //
                        	   "";

	    String[] lines = death_message.split("\r\n"); //Split the ASCII art into array of string by \r\n

	    // Print line by line
	    for (String line : lines) {
	        printCentered(line);
	    }
	    System.out.println();
    }

    /** 
     * Displays a farewell message to the user when they exit the game 
     */
    public static void printFarewellMsg() {
        String farewell_message = "███████╗███████╗███████╗    ██╗   ██╗ ██████╗ ██╗   ██╗    ███╗   ██╗███████╗██╗  ██╗████████╗    ████████╗██╗███╗   ███╗███████╗\r\n" + //
                        		  "██╔════╝██╔════╝██╔════╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║    ████╗  ██║██╔════╝╚██╗██╔╝╚══██╔══╝    ╚══██╔══╝██║████╗ ████║██╔════╝\r\n" + //
                        		  "███████╗█████╗  █████╗       ╚████╔╝ ██║   ██║██║   ██║    ██╔██╗ ██║█████╗   ╚███╔╝    ██║          ██║   ██║██╔████╔██║█████╗  \r\n" + //
                        		  "╚════██║██╔══╝  ██╔══╝        ╚██╔╝  ██║   ██║██║   ██║    ██║╚██╗██║██╔══╝   ██╔██╗    ██║          ██║   ██║██║╚██╔╝██║██╔══╝  \r\n" + //
                        		  "███████║███████╗███████╗       ██║   ╚██████╔╝╚██████╔╝    ██║ ╚████║███████╗██╔╝ ██╗   ██║          ██║   ██║██║ ╚═╝ ██║███████╗\r\n" + //
                        		  "╚══════╝╚══════╝╚══════╝       ╚═╝    ╚═════╝  ╚═════╝     ╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝   ╚═╝          ╚═╝   ╚═╝╚═╝     ╚═╝╚══════╝\r\n" + //
                        		  "";

	    String[] lines = farewell_message.split("\r\n"); //Split the ASCII art into array of string by \r\n

	    // Print line by line
	    for (String line : lines) {
	        printCentered(line);
	    }
	    System.out.println();
    }
    
    
	/**
	 * This method prints a String at the center of the console.
	 * 
	 * @param text The string you want to print.
	 * @param consoleWidth The width of the console in characters.
	 */
	public static void printCentered(String text, int consoleWidth) {
	    // Get the length of the text you want to print 
	    int textLength = text.length();
	    
	    // Calculate the number of spaces needed for centering
	    int padding = (consoleWidth - textLength) / 2;

	    // Ensure padding is non-negative
	    if (padding < 0) {
	        padding = 0; // If text is longer than console width, no padding
	    }
	    
	    // Create spaces until it meets the padding, combined with the text you want to print
	    String centeredText = " ".repeat(padding) + text;

	    // Print the centered text
	    System.out.println(centeredText);
	}

	/**
	 * This method prints a String at the center of the console with a fixed width.
	 * 
	 * @param text The string you want to print.
	 * This method uses a console width of 101 characters.
	 */
	public static void printCentered(String text) {
	    // Get the length of the text you want to print 
	    int textLength = text.length();
	    int consoleWidth = 101; // Fixed console width

	    // Calculate the number of spaces needed for centering
	    int padding = (consoleWidth - textLength) / 2;

	    // Ensure padding is non-negative
	    if (padding < 0) {
	        padding = 0; // If text is longer than console width, no padding
	    }
	    
	    // Create spaces until it meets the padding, combined with the text you want to print
	    String centeredText = " ".repeat(padding) + text;

	    // Print the centered text
	    System.out.println(centeredText);
	}

	/**
	 * This method prints the string character by character.
	 * 
	 * @param S The string you want to print.
	 * @param speed The delay (in milliseconds) between each character being printed.
	 * @throws InterruptedException If the thread is interrupted while sleeping.
	 */
	public static void print_letter_by_letter(String S, int speed) throws InterruptedException {
		for (int i = 0; i < S.length(); i++) {
			System.out.print(S.charAt(i));
			Thread.sleep(speed);
		}

	}
}// Message class

