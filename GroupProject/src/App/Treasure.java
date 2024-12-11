package App;

import java.util.Random;

public class Treasure {
	
	private Random random = new Random();
	private int treasurePoint = 10; // Set the treasure point to always be 10
	private int treasureX;
	private int treasureY;

	public Treasure(int mapRow, int mapCol) {
		this.treasureX = mapRow -1; //Set the initial position X for treasure
		this.treasureY = mapCol -1; //Set the initial position Y for treasure
	}

	// Set position X
	public int updatePositionX(Map map) {
		// Set position X to random value between 0 - Maximum X boundary of the grid (row -1)
		this.treasureX = random.nextInt(0,map.row); 
		return this.treasureX;
	}

	// Set position Y
	public int updatePositionY(Map map) {
		// Set position Y to random value between 0 - - Maximum Y boundary of the grid (column -1)
		this.treasureY = random.nextInt(map.col); 
		return this.treasureY;
	}

	// update both position
	public void updatePosition(Map map) {
		updatePositionX(map);
		updatePositionY(map);
	}

	// Getting the Treasure
	public int getTreasureX() {
		return this.treasureX;
	}

	public int getTreasureY() {
		return this.treasureY;
	}

	public int getTreasurePoint() {
		return this.treasurePoint; // Always returns 10
	}
}
