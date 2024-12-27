import java.awt.*;

/**
 * Represents a WhiteTiger critter in the simulation.
 * WhiteTigers start as lowercase "tgr" and switch to uppercase "TGR" after infecting another critter.
 */

public class WhiteTiger extends Tiger {
    private boolean hasInfected = false;


    /**
     * Returns the color of the WhiteTiger.
     * Always returns white.
     * @return the color of the WhiteTiger.
     */

    @Override
    public Color getColor() {
        return Color.WHITE;
    }


    /**
     * Returns the string representation of the WhiteTiger.
     * Starts as "tgr" and becomes "TGR" after infecting.
     * @return the string representation of the WhiteTiger.
     */

    @Override
    public String toString() {
        return hasInfected ? "TGR" : "tgr";
    }

     /**
     * Determines the WhiteTiger's next action.
     * Tracks whether it has infected another critter.
     * @param info information about the WhiteTiger's surroundings.
     * @return the action the WhiteTiger will take.
     */
    
    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            hasInfected = true;
            return Action.INFECT;
        }
        return super.getMove(info);
    }
}
