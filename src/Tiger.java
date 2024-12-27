import java.awt.*;
import java.util.Random;


/**
 * Represents a Tiger critter in the simulation.
 * Tigers randomly change their color every three moves.
 */

public class Tiger extends Critter {
    private Color color;
    private int moves = 0;


     /**
     * Creates a Tiger object.
     * Initializes the Tiger with a random color.
     */

    public Tiger() {
        color = getRandomColor();
    }

    /**
     * Generates a random color for the Tiger.
     * @return a random color (red, green, or blue).
     */

    private Color getRandomColor() {
        Random random = new Random();
        int choice = random.nextInt(3);
        return switch (choice) {
            case 0 -> Color.RED;
            case 1 -> Color.GREEN;
            default -> Color.BLUE;
        };
    }

     /**
     * Returns the current color of the Tiger.
     * Changes color every three moves.
     * @return the current color of the Tiger.
     */

    @Override
    public Color getColor() {
        if (moves % 3 == 0) {
            color = getRandomColor();
        }
        return color;
    }

    /**
     * Returns the string representation of the Tiger.
     * @return "TGR" as the Tiger's representation.
     */

    @Override
    public String toString() {
        return "TGR";
    }


    /**
     * Determines the Tiger's next action based on its surroundings.
     * - Infects if an enemy is in front.
     * - Turns left at walls or if another critter of the same type is in front.
     * - Hops otherwise.
     * @param info information about the Tiger's surroundings.
     * @return the action the Tiger will take.
     */

     
    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}
