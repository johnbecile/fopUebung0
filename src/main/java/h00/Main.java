package h00;

import fopbot.Robot;
import fopbot.RobotFamily;
import fopbot.World;

import static fopbot.Direction.LEFT;
import static fopbot.Direction.RIGHT;
import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        // variable representing width/size of world
        final int worldSize = 5;

        // setting world size symmetrical, meaning height = width
        World.setSize(worldSize, worldSize);

        // speed of how fast the world gets refreshed (e.g. how fast the robot(s) act)
        // the lower the number, the faster the refresh
        World.setDelay(300);

        // make it possible to see the world window
        World.setVisible(true);

        // our program/assignment shall be tested/run !
        runExercise();
    }

    /**
     * Runs the exercise.
     */
    public static void runExercise() {
        Robot kaspar = new Robot(0, 0, LEFT, 20, RobotFamily.SQUARE_ORANGE);
        Robot alfred = new Robot(4, 4, RIGHT, 0, RobotFamily.SQUARE_BLUE);

        // -- Kaspars's first act of craziness --
        kaspar.turnLeft();
        kaspar.turnLeft();
        kaspar.putCoin();
        for (int i = 0; i < 4; i++) {
            kaspar.move();
            kaspar.putCoin();
        }
        kaspar.turnLeft();
        for (int i = 0; i < 4; i++) {
            kaspar.move();
            kaspar.putCoin();
        }
        kaspar.turnLeft();
        kaspar.move();

        // -- Alfred's try of heroism --
        while (!alfred.isFacingDown()) {
            alfred.turnLeft();
        }
        while (alfred.isFrontClear()) {
            alfred.pickCoin();
            alfred.move();
        }
        while (!alfred.isFacingLeft()) {
            alfred.turnLeft();
        }
        while (alfred.isFrontClear()) {
            alfred.pickCoin();
            alfred.move();
        }
        while (!alfred.isFacingUp()) {
            alfred.turnLeft();
        }
        alfred.pickCoin();
        alfred.move();
        while (kaspar.hasAnyCoins()) {
            kaspar.putCoin();
            alfred.turnLeft();
        }
    }
}
