package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import problem.Problem;
import problem.game.Game;

/**
 * @
 *
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.problem();
    }

    void problem() {
        Problem pb = new Problem();
        pb.main();

        Game game = null;

        try (FileInputStream fileIn = new FileInputStream("E:/Java/Teme/JAVA/positional_game/src/main/java/problem/results/game.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            game = (Game) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (game != null) {
            game.printEdges();
        }
    }
}
