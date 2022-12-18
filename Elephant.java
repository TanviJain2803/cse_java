/** 
 * Name: Tanvi Jain
 * Email: t2jain@ucsd.edu
 * PID: A16832726
 * Sources used: Write-up, Piazza, Discord
 * 
 * This file is used to create Elephant objects in the simulation
 * and define its behavior
 */
import java.awt.Color;
/**
 * This class contains the constructor for the Lion object
 * and defines its color, movement, eating behavior, win, lose
 * behavior, and attacks.
 * 
 * Instance variables:
 * goalX - the common X coordinate all elephant objects will move towards
 * goalY - the common Y coordinate all elephants objects will move towards
 */
public class Elephant extends Critter {
    /** Constants (Magic Numbers) */
    private static final String SPECIES_NAME = "El";

    /** Instance Variables */
    protected static int goalX;
    protected static int goalY;

    /**
     * The constructor initialises goalX and goalY
     */
    public Elephant(){
       super(SPECIES_NAME);
        goalX = 0;
        goalY = 0;
    }

    /**
     * Returns the color of the Elephant
     * 
     * @return Color gray
     */
    @Override 
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * Returns what direction the Elephant
     * should move next. If one of the elephants 
     * reaches the goal coordinates the goal coordinates
     * will randomly be changed.
     * 
     * @return Direction the next direction the Elephant
     * will move
     */
    @Override
    public Direction getMove(){
        int currX = this.info.getX();
        int currY = this.info.getY();
         if (currX==goalX && currY == goalY){
            goalY = (int) (Math.random() * this.info.getY());
            goalX = (int) (Math.random()* this.info.getX());
        }
        int xDistance = goalX - currX;
        int yDistance = goalY - currY;
       
        if (Math.abs(xDistance) < Math.abs(yDistance)){
            if (yDistance >0){
                return Direction.SOUTH;
            }
            else if (yDistance<0){
                return Direction.NORTH;
            }
            else {
                return Direction.CENTER;
            }
        }
        else {
            if (xDistance > 0){
                return Direction.EAST;
            }
            else if (xDistance < 0){
                return Direction.WEST;
            }
            else {
                return Direction.CENTER;
            }
        }
    }

    /**
     * Returns a boolean whether the Elephant
     * should eat once prompted. 
     * 
     * @return boolean to eat is true always
     */
    @Override
    public boolean eat(){
        return true;
    }

    /**
     * increments the level of the Elephant
     */
    @Override
    public void mate(){
        this.incrementLevel(2);
    }
    /**
     * Sets the goal coordinates to 0,0
     */
    @Override
    public void reset(){
        goalX = 0;
        goalY = 0;
    }
}