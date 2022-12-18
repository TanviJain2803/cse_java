/** 
 * Name: Tanvi Jain
 * Email: t2jain@ucsd.edu
 * PID: A16832726
 * Sources used: Write-up, Piazza, Discord
 * 
 * This file is used to create Lion objects in the simulation
 * and define its behavior
 */
import java.awt.Color;
/**
 * This class contains the constructor for the Lion object
 * and defines its color, movement, eating behavior, win, lose
 * behavior, and attacks.
 * 
 * Instance variables:
 * fightCount - int to keep track of the number of fights this Lion wins 
 * until it goes to sleep,
 * eatenAfterFight - boolean to see if it has eaten after winning a fight
 * movePatternIndex - index to track of what direction the Lion is currently
 * in in movePattern
 * moveCount - int to keep track of how many times the Lion has moved in
 * current direction
 */
public class Lion extends Feline {
    /** Instance variables */
    private int fightCount; 
    private boolean eatenAfterFight = false;
    private int movePatternIndex;
    private int moveCount;
    
    /** Constants (Magic Numbers)  */
    private static final Direction[] movePattern = 
    {Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH};
    private static final String SPECIES_NAME = "Lion";
    private static final String SLEEPING_DISPLAY_NAME = "noiL";
    private static final int MAX_MOVE_COUNT = 5;
    private static final int MAX_MOVE_PATTERN_INDEX = 3;

    /**
     * The constructor creates a Lion object and 
     * changes the display name of the object to "Lion"
     * instead of its species name from the Feline class.
     * Also initialises fightCount, movePatternIndex, and
     * moveCount
     */
    public Lion() {
        super();
        this.displayName = SPECIES_NAME;
        fightCount = 0;
        movePatternIndex = 0;
        moveCount = 0;

    }
    /**
     * Returns the color of the Lion
     * 
     * @return Color yellow
     */
    @Override 
    public Color getColor() {
        return Color.YELLOW;
    }
    /**
     * Returns what direction the Lion
     * should move next
     * 
     * @return Direction the next direction the Lion
     * will move
     */
    @Override
    public Direction getMove() {
        // TODO
        if (moveCount>=0 && moveCount<MAX_MOVE_COUNT){
            moveCount++;
            return movePattern[movePatternIndex];
        }
        else{
            moveCount=0;
            if (movePatternIndex!=MAX_MOVE_PATTERN_INDEX){
                movePatternIndex++;
            }
            else {
                movePatternIndex=0;
            }
            moveCount++;
            return movePattern[movePatternIndex];

        }
    }     

    /**
     * Returns a boolean whether the Lion
     * should eat once prompted. The lion
     * can eat after it has at least won
     * one fight
     * 
     * @return boolean to eat
     */
    @Override
    public boolean eat() {
        // TODO
        if (fightCount >= 1 && !eatenAfterFight){
            eatenAfterFight = true;
            return true;
        }
        return false;
    }

    /**
     * Changes display name to "noiL"
     * when it sleeps, and resets count
     * fight
     */
    @Override
    public void sleep(){
        fightCount = 0;
        this.displayName = SLEEPING_DISPLAY_NAME;
        eatenAfterFight = true;

    }
    /**
     * Changes display name back to "Lion"
     * once it wakes up
     */
    @Override
    public void wakeup(){
        this.displayName = SPECIES_NAME;
    }
    /**
     * Increments fight count, and changes
     * eatenAfterFight to false
     */
    @Override
    public void win(){
        fightCount++;
        eatenAfterFight = false;
    }
}