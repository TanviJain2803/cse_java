/** 
 * Name: Tanvi Jain
 * Email: t2jain@ucsd.edu
 * PID: A16832726
 * Sources used: Write-up, Piazza, Discord
 * 
 * This file is used to create Turtle objects in the simulation
 * and define its behavior
 */
import java.awt.Color;

/**
 * This class contains the constructor for the Turtle object
 * and defines its color, movement, eating behavior and attacks.
 */
public class Turtle extends Critter {
    /** Instance variables */
    private static final String SPECIES_NAME = "Tu";
    private static final Direction[] SURROUNDING_CHECK =
    {Direction.NORTH, Direction.WEST, Direction.SOUTH, Direction.EAST};
    private static final Attack[] RANDOM_ATTACK =
    {Attack.ROAR, Attack.FORFEIT};
    private static final String EMPTY_SPACE = " ";
    private static final String FOOD = ".";

    /**
     * Default constructor - creates critter with name Tu
     */
    public Turtle() {
        super(SPECIES_NAME);
    }

    /**
     * Returns what direction the Turtle
     * should move next
     * 
     * @return Direction West
     */
    @Override
    public Direction getMove() {
        return Direction.WEST;
    }

    /**
     * Returns the color of the Turtle
     * 
     * @return Color green
     */
    @Override 
    public Color getColor() {
        return Color.GREEN;
    }
    /**
     * Returns a boolean whether the Turtle
     * should eat once prompted. The turtle
     * can eat if it safe to eat (no hostile neighbours)
     * 
     * @return boolean to eat
     */
    @Override
    public boolean eat(){
        boolean isSafeToEat = false;
        for (Direction i: SURROUNDING_CHECK){
            String neighbourAnimal = this.info.getNeighbor(i);
            if ((!neighbourAnimal.equals(SPECIES_NAME))&&
            (!neighbourAnimal.equals(EMPTY_SPACE))&&
            (!neighbourAnimal.equals(FOOD))){
                return isSafeToEat;
            }
        }
        isSafeToEat = true;
        return isSafeToEat;
    }
    /**
     * Returns an Attack that the Turtle will play selected
     * randomly from either Roar or Forfeit
     *
     * @return Attack the next move the Turtle will play
     */
    @Override
    public Attack getAttack(String opponent){
        Attack randomElement =
        RANDOM_ATTACK[random.nextInt(RANDOM_ATTACK.length)];
        return randomElement;
    }

}