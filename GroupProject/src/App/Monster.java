/* 
 * The Monster class represents a monster in the game. 
 * It creates instances of monsters with specific positions and point values. 
 * The class includes methods to update the monster's position and point value.
 */
package App;

import java.util.Random;

public class Monster {

	Random random = new Random();
	// Array of possible point values for the monster, with lower values appearing more frequently
	int[] points = { -10, -10, -10, -10, -20, -20, -20, -30, -30, -40 };
	int Monster_point;
	int Monster_x;
	int Monster_y;

	public Monster() { // create Monster.(object)
		this.Monster_x = 1;//Set the initial position X for monster
		this.Monster_y = 0;//Set the initial position Y for monster
		this.Monster_point = -10;//Set the initial monster point for monster
	}

	// set positionX
	public int update_positionX(Map map) { // u can call (object).update_positionX
		// set positionX to random 0 - Maximum X boundary of the grid (row -1)
		this.Monster_x = random.nextInt(0,map.row ); 
		return this.Monster_x;
	}

	// set positionY
	public int update_positionY(Map map) { // u can call (object).update_positionY
		// set positionY random 0 - Maximum Y boundary of the grid (column -1)
		this.Monster_y = random.nextInt(0,map.col ); 
		return this.Monster_y;
	}

	// set point
	public int update_point() { // call (object).update_point
		this.Monster_point = points[random.nextInt(points.length)]; // set point random 10 - 40
		return this.Monster_point;
	}
}