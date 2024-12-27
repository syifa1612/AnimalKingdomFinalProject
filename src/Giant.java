import java.awt.*;

/**
 * Represents a Giant critter in the simulation.
 * Giants cycle through the phrases "fee", "fie", "foe", and "fum" every six moves.
 */

public class Giant extends Critter {
    private String[] phrases = {"fee", "fie", "foe", "fum"};
    private int steps = 0;


    /**
     * Returns the color of the Giant.
     * Always returns gray.
     * @return the color of the Giant.
     */

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * Returns the string representation of the Giant.
     * Cycles through phrases every six moves.
     * @return the string representation of the Giant.
     */ 

    @Override
    public String toString() {
        return phrases[(steps / 6) % phrases.length];
    }

    /**
     * Determines the Giant's next action.
     * @param info information about the Giant's surroundings.
     * @return the action the Giant will take.
     */
    
    @Override
    public Action getMove(CritterInfo info) {
        steps++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}
