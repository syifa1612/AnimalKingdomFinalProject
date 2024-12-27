import java.awt.*;
/**
 * Represents a Bear critter in the simulation.
 * The Bear alternates between `/` and `\` as its string representation
 * and behaves based on its surroundings.
 */
public class Bear extends Critter {
    private boolean polar; // True if the bear is polar, false otherwise
    private boolean slash = true; // Alternates between / and \


    /**
     * Constructs a Bear object.
     * 
     * @param polar true if the bear is polar, false otherwise
     */
    public Bear(boolean polar) {
        this.polar = polar;
    }

    /**
     * Returns the color of the bear.
     * 
     * @return Color.WHITE if polar, otherwise Color.BLACK
     */

    @Override
    public Color getColor() {
        return polar ? Color.WHITE : Color.BLACK;
    }


     /**
     * Returns the string representation of the bear, alternating between `/` and `\\`.
     * 
     * @return `/` or `\\` based on the current state
     */

    @Override
    public String toString() {
        String result = slash ? "/" : "\\";
        slash = !slash;
        return result;
    }

    /**
     * Defines the bear's movement behavior.
     * 
     * @param info provides information about the bear's surroundings
     * @return the action the bear should take (INFECT, HOP, or LEFT)
     */
    
    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}
