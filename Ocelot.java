/** 
 * Name: Tanvi Jain
 * Email: t2jain@ucsd.edu
 * PID: A16832726
 * Sources used: Write-up, Piazza, Discord
 * 
 * This file is used to create Ocelot objects in the simulation
 * and define its behavior
 */
import java.awt.Color;
/**
 * This class contains the constructor for the Ocelot object
 * and defines its color, movement, eating behavior, win, lose
 * behavior, and attacks.
 * 
 */
public class Ocelot extends Leopard {
    /** Instance variables */
    private static final String SPECIES_NAME = "Oce";
    private static final String LION_NAME = "Lion";
    private static final  String NOIL_NAME = "noiL";
    private static final String FELINE_NAME = "Fe";
    private static final String LEOPARD_NAME = "Lpd";
    
    /**
     * The constructor creates an Ocelot object and 
     * changes the display name of the object to "Oce"
     * instead of its species name from the Leopard class.
     */
    public Ocelot(){
        super();
        this.displayName = SPECIES_NAME;
    }

    /**
     * Returns the color of the Ocelot
     * 
     * @return Color light gray
     */
    @Override 
    public Color getColor() {
        return Color.LIGHT_GRAY;
    }

    /**
     * Returns the Attack the Ocelot will play. If the 
     * opponent is a Lion, Feline, or a Leopard, the Ocelot
     * will scratch, if not it will pounce
     * 
     * @param String opponent's display name
     * @return Attack the Ocelot will play next
     */
    @Override
    protected Attack generateAttack(String opponent){
        if (opponent.equals(LION_NAME)||opponent.equals(NOIL_NAME)||
        opponent.equals(FELINE_NAME)||opponent.equals(LEOPARD_NAME)){
            return Attack.SCRATCH;
        }
        else{
            return Attack.POUNCE;
        }
    }
}