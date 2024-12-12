/* 
 * The Player class represents a player in the game. 
 * It creates an instance of a player with a specific position, 
 * a player name input by the user, and the player's score, which is initialized to 100. 
 * The class includes methods to get the player's name, get the position, update the position, 
 * and update the score.
 */

package App;

public class Player {
    
    public int score;    // Create score attribute that is the score in game
    private String PlayerName = "";        // Create Player attribute for storing Player name
    private int positionX;        // Create positionX attribute for storing x-axis of the Player
    private int positionY;        // Create positionY attribute for storing y-axis of the Player

    /* Constructor for initial Player's score and name (name by user) */
    public Player(String name) {
        this.PlayerName = name;
        this.score = 100;
    }
    
    /* Method of getting the name from the Player */
    public String getPlayerName() {
        return this.PlayerName;
    }
    
    /* Method for initial Player's x-axis and y-axis */
    public void setStartPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }
    
    /* Method for getting x-axis from the Player*/
    public int getPositionX(){
        return this.positionX;
    }
    
    /* Method for getting y-axis from the Player*/
    public int getPositionY(){
        return this.positionY;
    }
    
    /* Method for moving Player's x-axis and y-axis */
    public void move(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }
    
    
    /* Method for updating Player's score */
    public void updateScore(int score) {
        this.score += score;
    }
}