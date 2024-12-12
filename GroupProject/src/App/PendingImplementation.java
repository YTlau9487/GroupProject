/* 
 * This class contains methods that are currently under development for Scrum2. 
 * The methods have not been tested and are intended for future implementation.
 */
package App;

import java.util.ArrayList;
import java.util.Random;

public class PendingImplementation {
	/**
	 * Method to automatically create multiple monsters. For example, if
	 * numOfMonster is 3, it will create 3 monsters.
	 * 
	 * @param numOfMonster The number of monsters to create.
	 * 
	 * @return A list of created Monster objects.
	 */
	public ArrayList<Monster> createMonster(int numOfMonster) {
		// List to store monster objects
		ArrayList<Monster> monsterList = new ArrayList<Monster>();

		// Create monster objects based on the number specified by the user
		for (int i = 0; i < numOfMonster; i++) {
			Monster monster = new Monster(); // Create monster object
			monsterList.add(monster); // Add monster to monsterList
		}
		return monsterList; // Return the list of monsters
	}// createMonster end

	/**
	 * Method to automatically create multiple treasures. For example, if
	 * numOfTreasure is 3, it will create 3 treasures.
	 * 
	 * @param numOfTreasure The number of treasures to create.
	 * 
	 * @return A list of created Treasure objects.
	 */
	public ArrayList<Treasure> createTreasure(int numOfTreasure, Map map) {
		Random random = new Random();
		// List to store treasure objects
		ArrayList<Treasure> treasuresList = new ArrayList<Treasure>();

		// Create treasure objects based on the number specified by the user
		for (int i = 0; i < numOfTreasure; i++) {
			// Generate random coordinates within the bounds of the map
			int treasureX = random.nextInt(map.row); // Assuming map.row is the height of the map
			int treasureY = random.nextInt(map.col); // Assuming map.col is the width of the map

			Treasure treasure = new Treasure(treasureX, treasureY); // Create treasure object
			treasuresList.add(treasure); // Add treasure to treasuresList
		}
		return treasuresList; // Return the list of treasures
	}// createTreasure end

	/**
	 * Checking for collisions: 1. Between different monsters 2. Between different
	 * treasures 3. Between monsters and treasures
	 */
	boolean checkCollision(ArrayList<Monster> MonsterList, ArrayList<Treasure> TreasureList) {
		boolean result = false; // define result for return the boolean result

		/*
		 * Loop for determine whether the monster location is same as another monster
		 * location
		 */
		for (int i = 0; i < MonsterList.size(); i++) {
			int MonsterX = MonsterList.get(i).Monster_x;
			int MonsterY = MonsterList.get(i).Monster_y;

			for (int j = 0; j < MonsterList.size(); j++) {
				if (j != i) { // Ensures that a monster does not compare itself to itself
					if (MonsterX == MonsterList.get(j).Monster_x && MonsterY == MonsterList.get(j).Monster_y) {
						result = true;
					}
				}
			}
		}

		/*
		 * Loop for determine whether the treasure location is same as another treasure
		 * location
		 */
		for (int i = 0; i < TreasureList.size(); i++) {
			int TreasureX = TreasureList.get(i).getTreasureX();
			int TreasureY = TreasureList.get(i).getTreasureY();

			for (int j = 0; j < TreasureList.size(); j++) {
				if (j != i) { // Ensures that a treasure does not compare itself to itself
					if (TreasureX == TreasureList.get(j).getTreasureX()
							&& TreasureY == TreasureList.get(j).getTreasureY()) {
						result = true;
					}
				}
			}
		}

		/*
		 * Loop for determine whether the monster location is same as the treasure
		 * location
		 */
		for (int i = 0; i < TreasureList.size(); i++) {
			int TreasureX = TreasureList.get(i).getTreasureX();
			int TreasureY = TreasureList.get(i).getTreasureY();

			for (int j = 0; j < MonsterList.size(); j++) {
				if (TreasureX == MonsterList.get(j).Monster_x && TreasureY == MonsterList.get(j).Monster_y) {
					result = true;
				}
			}
		}

		return result;
	}// checkCollision end

	/*
	 * Note: The main purpose of the code is using probability to generating
	 * monsters and treasures
	 */
	public void generatePositions(Map map) {
		// Note: 40% nothing, 35% monster, 20% treasure (modified if want)

		Random random = new Random();
		ArrayList<Monster> monster_entities = new ArrayList<Monster>();
		ArrayList<Treasure> treasure_entities = new ArrayList<Treasure>();

		int random_PositionX = random.nextInt(map.row); // Random x-axis for generate
		int random_PositionY = random.nextInt(map.col); // Random y-axis for generate

		boolean collision = false; // determine whether the collision occur during the gerneration of monster and
									// treasure

		/*
		 * Generating monster and treasure (if collision occur generate again until no
		 * collision happen)
		 */
		do {
			/* Loop for generating monster in the map */
			for (int i = 0; i < map.grid.length; i++) {
				for (int j = 0; j < map.grid[i].length; j++) {
					int percentage = random.nextInt(100);
					if (percentage >= 65) {
						Monster monster = new Monster();
						monster.Monster_x = i;
						monster.Monster_y = j;
						monster_entities.add(monster);
					}
				}
			}

			/* Loop for generation treasure in the map */
			for (int i = 0; i < map.grid.length; i++) {
				for (int j = 0; j < map.grid[i].length; j++) {
					int percentage = random.nextInt(100);
					if (percentage >= 80) {
						Treasure treasure = new Treasure(i, j);
						treasure_entities.add(treasure);
					}
				}
			}

			collision = checkCollision(monster_entities, treasure_entities);

		} while (collision == true);

	}// generatePositions end

}// PendingImplementation
