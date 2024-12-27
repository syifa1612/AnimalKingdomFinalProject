import java.awt.*;

/**
 * Represents a NinjaCat critter in the simulation.
 * NinjaCats are highly customizable with their own unique behavior.
 */

public class NinjaCat extends Critter {
      /**
     * Returns the color of the NinjaCat.
     * Always returns pink.
     * @return the color of the NinjaCat.
     */

    @Override
    public Color getColor() {
        return Color.PINK;
    }

    /**
     * Returns the string representation of the NinjaCat.
     * @return "NC" as the NinjaCat's representation.
     */

    @Override
    public String toString() {
        return "NC";
    }

     /**
     * Determines the NinjaCat's next action.
     * Custom behavior based on its surroundings.
     * @param info information about the NinjaCat's surroundings.
     * @return the action the NinjaCat will take.
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
