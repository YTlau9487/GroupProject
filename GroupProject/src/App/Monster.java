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
		this.Monster_x = 0;//Set the initial position X for monster
		this.Monster_y = 0;//Set the initial position Y for monster
	}

	// set positionX
	public int update_positionX() { // u can call (object).update_positionX
		this.Monster_x = random.nextInt(5); // set positionX to random 0 - 4
		return this.Monster_x;
	}

	// set positionY
	public int update_positionY() { // u can call (object).update_positionY
		this.Monster_y = random.nextInt(5); // set positionY random 0 - 4
		return this.Monster_y;
	}

	// set point
	public int update_point() { // call (object).update_point
		this.Monster_point = points[random.nextInt(points.length)]; // set point random 10 - 40
		return this.Monster_point;
	}
}