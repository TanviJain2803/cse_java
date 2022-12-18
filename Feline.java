/** 
 * Name: Tanvi Jain
 * Email: t2jain@ucsd.edu
 * PID: A16832726
 * Sources used: Write-up, Piazza, Discord
 * 
 * This file is used to create Feline objects in the simulation
 * and define its behavior
 */
import java.awt.Color;
/**
 * This class contains the constructor for the Feline object
 * and defines its color, movement, eating behavior, win, lose
 * behavior, and attacks.
 * 
 * Instance variables:
 * moveCount - counter for getMove method before random direction
 * eatCount - counter for eating
 * currDir - current direction
 */
public class Feline extends Critter {
    /** Instance variables */
    private int moveCount; //counter for getMove method before random direction
    private int eatCount; //counter for eating
    private Direction currDir; //current direction

    /** Constants (Magic Numbers)  */
    private static final Direction[] PICK_DIRECTION =
    {Direction.NORTH, Direction.SOUTH,Direction.EAST,Direction.WEST};
    private static final String SPECIES_NAME = "Fe";
    private static final int MAX_MOVE_COUNT = 5;
    private static final int MAX_EAT_COUNT = 3;

    /**
     * The constructor initializes moveCount, eatCount, and currDir
     */
    public Feline() {
        super(SPECIES_NAME);
        moveCount = 0;
        eatCount = 0;
        currDir = null;

    }
    /**
     * This method computes the product of firstNum and secondNum
     * using addition.
     * 
     * @return Direction next direction Feline will move in
     */
    @Override
    public Direction getMove() {
        if (moveCount == MAX_MOVE_COUNT || moveCount==0){
            moveCount = 0;
            currDir = PICK_DIRECTION[random.nextInt(PICK_DIRECTION.length)];
            moveCount++;
            return currDir;
        }
        moveCount++;
        return currDir;
    }    
    /**
     * Returns a boolean whether the Feline
     * should eat once prompted. The feline
     * can eat only eat every third time
     * after it has been prompted to eat
     * 
     * @return boolean to eat
     */
    @Override
    public boolean eat() {
        eatCount++;
        if (eatCount == MAX_EAT_COUNT){
            eatCount = 0;
            return true;
        }
        return false;
    }
    /**
     * Returns the POUNCE attack when prompted to
     * attack
     *
     * @return Attack POUNCE
     */
    @Override
    public Attack getAttack(String opponent){
       return Attack.POUNCE;
    }
}