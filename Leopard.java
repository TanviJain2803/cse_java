/** 
 * Name: Tanvi Jain
 * Email: t2jain@ucsd.edu
 * PID: A16832726
 * Sources used: Write-up, Piazza, Discord
 * 
 * This file is used to create Leopard objects in the simulation
 * and define its behavior
 */
import java.awt.Color;
/**
 * This class contains the constructor for the leopard object
 * and defines its color, movement, eating behavior, win, lose
 * behavior, and attacks.
 * 
 * Instance variables:
 * confidence - integer for all leopard objects to telepathically
 * keep track of their confidence together
 */
public class Leopard extends Feline {
    /** Instance variables */
    protected static int confidence = 0;

    /** Constants (Magic Numbers)  */
    private static final String SPECIES_NAME = "Lpd";
    private static final Direction[] SURROUNDING_CHECK = new Direction[]
    {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
    private static final Attack[] RANDOM_ATTACK = new Attack[]
    {Attack.POUNCE, Attack.SCRATCH, Attack.ROAR};
    private static final String FOOD = ".";
    private static final String STARFISH = "Patrick";
    private static final String TURTLE = "Tu";
    private static final int HUNDRED = 100;
    private static final int DIVIDE_BY_TEN = 10;
    private static final int MAX_CONFIDENCE= 10;

    /**
     * The constructor creates a leopard object and 
     * changes the display name of the object to "Lpd"
     * instead of its species name from the Feline class
     */
    public Leopard() {
        super();
        this.displayName = SPECIES_NAME;
    }

    /**
     * Returns the color of the Leopard
     * 
     * @return Color red
     */
    @Override 
    public Color getColor() {
        return Color.RED;
    }

    /**
     * This method returns the next direction the leopard will
     * move in. If there is food or a Starfish next to the leopard
     * it will move in that direction. If not, a leopard will
     * move in a random direction.
     * 
     * @return Direction next direction Leopard will move in
     */
    @Override
    public Direction getMove() {
        // TODO
        for (Direction direction: SURROUNDING_CHECK){
            String neighbour = this.info.getNeighbor(direction);
            if (neighbour.equals(FOOD)|| neighbour.equals(STARFISH)){
                return direction;
            }
        }
        Direction randDir = 
        SURROUNDING_CHECK[random.nextInt(SURROUNDING_CHECK.length)];
        return randDir;
    }    

    /**
     * Returns a boolean whether the Leopard
     * should eat once prompted. The Leopard
     * are more likely to eat the higher their
     * confidence is
     * 
     * @return boolean to eat
     */
    @Override
    public boolean eat() {
        int randNum = random.nextInt(HUNDRED)+1;
        if (confidence <= (randNum/DIVIDE_BY_TEN)&& this.confidence>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Increments confidence if it is less than 10
     * once won
     */
    @Override
    public void win(){
        if (this.confidence<MAX_CONFIDENCE){
            confidence++;
        }
    }

    /**
     * reduces confidence if it is more than 0
     */
    @Override
    public void lose(){
        if (this.confidence>0){
            this.confidence = this.confidence-1;
        }
    }

    /**
     * Returns the Attack the Ocelot will play. If the 
     * confidence is greater than 5 or the opponent is a turtle
     * it will pounce, otherwise it will call generateAttack()
     * 
     * @param String opponent's display name
     * @return Attack the Leopard will play next
     */
    @Override
    public Attack getAttack(String opponent){
        if (this.confidence>5){
            return Attack.POUNCE;
        }
        if (opponent.equals(TURTLE)){
            return Attack.POUNCE;
        }
        return generateAttack(opponent);
    }

   /**
     * Called by getAttack(), returns the Attack the Ocelot will play. 
     * If the opponent is a Starfish, the Leopard will forfeit, if not
     * it will play a random attack
     * 
     * @param String opponent's display name
     * @return Attack the Leopard will play next
     */
    protected Attack generateAttack(String opponent){
        if (opponent.equals(STARFISH)){
            return Attack.FORFEIT;
        }
        Attack randAttack = 
        RANDOM_ATTACK[random.nextInt(RANDOM_ATTACK.length)];
        return randAttack;
    }

    /**
     * Resets the confidence of all leopards
     * to 0
     */
    @Override
    public void reset(){
        confidence=0;
    }
}