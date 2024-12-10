/*This map class is the */
package App;

public class Map {
	String[][] grid; //2D array of the game grid
	int row; //Number of row of the grid
	int col; // Number of column of the grid
	


//	Constructor to initialize the grid size
	public Map(int row, int col) {
		this.row = row;
		this.col = col;

		// Initialize the grid with the specified size
		this.grid = new String[row][col];
	}

//	Method to create the grid 
	public String[][] createGrid(Monster monster1, Treasure treasure1,Player player, int roundCount) {
		int monsterX= monster1.Monster_x; // X-coordinate of the monster
		int monsterY= monster1.Monster_y; // Y-coordinate of the monster
		int monsterType = monster1.Monster_point; // Type of the monster (score value)

		int treasureX = treasure1.getTreasureX(); // X-coordinate of the treasure
		int treasureY = treasure1.getTreasureY(); // Y-coordinate of the treasure
		
		int playerX = player.getPositionX(); // X-coordinate of the player
		int playerY = player.getPositionY(); // Y-coordinate of the player
		String playerName = player.getPlayerName(); // Name of the player
		int playerScore = player.score; //Current score of the player
		
		int round = roundCount;
		
		// Fill the grid with grass icon initially
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				this.grid[i][j] = ColorPlate.grassIcon; // Fill the grid with grassIcon
			}
		}
		
		// Place the monster on the grid based on its type
		if (monsterType == -10) {
			this.grid[monsterX][monsterY] = ColorPlate.monster10; // Monster -10 score

		} else if (monsterType == -20) {
			this.grid[monsterX][monsterY] = ColorPlate.monster20; // Monster -20 score

		} else if (monsterType == -30) {
			this.grid[monsterX][monsterY] = ColorPlate.monster30; // Monster -30 score

		} else if (monsterType == -40) {
			this.grid[monsterX][monsterY] = ColorPlate.monster40; // Monster -40 score

		}
		
		// Place the treasure on the grid
		this.grid[treasureX][treasureY] = ColorPlate.treasureIcon; // Treasure +10 score

		// Place player on the grid
		// Check if the player is on the same position as the monster
		if (monsterX == playerX && monsterY == playerY) {
			// Update player's icon based on the monster type
			if (monsterType == -10) {
				this.grid[playerX][playerY] = ColorPlate.playerIconMonsterPointMinus10;

			} else if (monsterType == -20) {
				this.grid[playerX][playerY] = ColorPlate.playerIconMonsterPointMinus20;
				
			} else if (monsterType == -30) {
				this.grid[playerX][playerY] = ColorPlate.playerIconMonsterPointMinus30;

			} else if (monsterType == -40) {
				this.grid[playerX][playerY] = ColorPlate.playerIconMonsterPointMinus40;
			}
			
		} 
		// Check if the player is on the same position as the treasure
		else if (treasureX == playerX && treasureY == playerY) {

			this.grid[playerX][playerY] = ColorPlate.playerIconTreasureFound; // Player found the treasure

		} else {

			this.grid[playerX][playerY] = ColorPlate.playerIconDefault; // Default player icon

		}



//=====================Print the grid and information=====================================

		// Display round number with underline
		System.out.printf("%50s %5s\n", "\u001B[4m" + "Round", round + "\u001B[0m");
		
		System.out.println(
				"================================================================================================");
		
		// Display the icons and their meanings
		System.out.printf("%15s: Player %s: +10 score %s: -10 score %s: -20 score %s: -30 score %s: -40 score\n",
				ColorPlate.playerIconDefault, ColorPlate.treasureIcon, ColorPlate.monster10, ColorPlate.monster20, ColorPlate.monster30, ColorPlate.monster40);
		System.out.println(
				"================================================================================================");
		System.out.println();
		
		// Display player information (name and score)
		System.out.printf("%22s %-30s %15s %d\n", "Player:", playerName, "Score:", playerScore);
//        System.out.println();
		
		// Print the grid
		for (String[] row : grid) {
			System.out.printf("%27s", ""); //Space for alignment
			for (String ele : row) {
				System.out.printf("%15s", ele); // Print each element of the row
			}
			System.out.println(); //Move to next line after printing a row
		}
		

		return grid; //return the grid (may be no need)
	}



}
