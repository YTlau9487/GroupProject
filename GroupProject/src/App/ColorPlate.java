package App;

public class ColorPlate {
	// Colors ANSI escape code list (set them to be constant)
	public final static String yellow = "\033[33m";
	public final static String blue = "\033[34m";
	public final static String green = "\033[32m";
	public final static String brightBlue = "\033[96m";
	public final static String magenta = "\033[35m";
	public final static String black = "\033[30m";
	public final static String red = "\033[31m";
	public final static String resetColor = "\033[0m";
	

	// Icon of the map elements (set them to be constant)
	// For Monsters
	public final static String monster10 = green + "\uD83D\uDC7E" + resetColor; // monsterPoint: -10
	public final static String monster20 = blue + "\uD83D\uDC7E" + resetColor;// monsterPoint: -20
	public final static String monster30 = magenta + "\uD83D\uDC7E" + resetColor;// monsterPoint: -30
	public final static String monster40 = red + "\uD83D\uDC7E" + resetColor;// monsterPoint: -40

	// For Player
	// Default player icon when the player is not interacting with any entities
	public final static String playerIconDefault = black + "\uD83D\uDC64" + resetColor;
	// Player icon indicating that the player has found a treasure
	public final static String playerIconTreasureFound = brightBlue + "\uD83D\uDC64" + resetColor;
	// Player icon when encountering a monster with a point value of -10
	public final static String playerIconMonsterPointMinus10 = green + "\uD83D\uDC64" + resetColor;
	// Player icon when encountering a monster with a point value of -20
	public final static String playerIconMonsterPointMinus20 = blue + "\uD83D\uDC64" + resetColor;
	// Player icon when encountering a monster with a point value of -30
	public final static String playerIconMonsterPointMinus30 = magenta + "\uD83D\uDC64" + resetColor;
	// Player icon when encountering a monster with a point value of -40
	public final static String playerIconMonsterPointMinus40 = red + "\uD83D\uDC64" + resetColor;

	
	public final static String treasureIcon = brightBlue + "\uD83D\uDC8E" + resetColor; //Treasure: +10
	public final static String grassIcon = yellow + "\uD83C\uDF3E" + resetColor;//Space
}