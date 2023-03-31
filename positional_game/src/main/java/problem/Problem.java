package problem;

import problem.game.Game;
import problem.game.Strategy;

public class Problem {
    public void main(){
        Strategy strategy = new Strategy("First Triangle");

        Game game = new Game(6, 1, strategy, "console");
    }
}
