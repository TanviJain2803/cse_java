/** 
 * Name: Tanvi Jain
 * Email: t2jain@ucsd.edu
 * PID: A16832726
 * Sources used: Write-up, Piazza, Discord
 * 
 * This file is used to create Tanvi objects in the simulation
 * and define its behavior
 */
import java.awt.Color;
/**
 * This class contains the constructor for the Tanvi object
 * and defines its color, movement, eating behavior, win, lose
 * behavior, and attacks.
 */
public class Tanvi_t2jain extends Leopard{
    /** Constants (Magic Variables) */
    private static String SPECIES_NAME = "tanussy";
    private static final Direction[] SURROUNDING_CHECK = new Direction[]
    {Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST};
    private static final String RACCOON = "R";
    private static final String BABY_RACCOON = "r";
    private static final String TIRED_RACCOON = "Tired";
    private static final String FOOD = ".";
    private static final Direction[] RANDOM_DIRECTION = 
    {Direction.NORTH, Direction.EAST};

    /**
     * Default constructor - creates critter with name tanussy
     */
    public Tanvi_t2jain(){
        super();
        this.displayName = SPECIES_NAME;
    }

    /**
     * Returns the color of Tanvi objects
     * 
     * @return Color magneta
     */
    @Override 
    public Color getColor() {
        return Color.MAGENTA;
    }

    /**
     * Returns what direction Tanvi
     * should move next
     * 
     * @return Direction of the neighbor if it is food or a 
     * Raccoon. If not a random direction is returned.
     */
    @Override
    public Direction getMove(){
        for (Direction direction: SURROUNDING_CHECK){
            String neighbour = this.info.getNeighbor(direction);
            if (neighbour.equals(FOOD)|| neighbour.equals(RACCOON)||
            neighbour.equals(BABY_RACCOON)|| neighbour.equals(TIRED_RACCOON)){
                return direction;
            }
        }
        Direction randDirection =
        RANDOM_DIRECTION[random.nextInt(RANDOM_DIRECTION.length)];
        return randDirection;
    }
    /**
     * Returns a boolean whether the Tanvi
     * should eat once prompted. Tanvi
     * can eat if the neighbours aren't raccoons
     * 
     * @return boolean to eat
     */
    @Override
    public boolean eat(){
        for (Direction direction: SURROUNDING_CHECK){
            String neighbour = this.info.getNeighbor(direction);
            if (!neighbour.equals(RACCOON)||!neighbour.equals(BABY_RACCOON)){
                return true;
            }
            else{
                return false;
            }
    }
        return true;
    }

    /**
     * Returns the Attack Tanvi will play. If the 
     * opponent is a raccoon it will pounce, if not it
     * will scratch.
     * 
     * @param String opponent's display name
     * @return Attack Tanvi will play next
     */
    @Override
    public Attack getAttack(String opponent){
        if (opponent.equals(RACCOON)||opponent.equals(BABY_RACCOON)||
        opponent.equals(TIRED_RACCOON)){
            return Attack.POUNCE;
        }
        else {
            return Attack.SCRATCH;
        }
    }
}