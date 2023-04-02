package problem;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import problem.game.Game;
import problem.game.Strategy;
import problem.game.objects.Edge;
import problem.ui.DrawingPanel;
import problem.ui.MainFrame;

public class Problem {

    private Scanner scanner;
    private final String commandType = "gui";
    private Boolean playerTurn = false;
    private Boolean gameOver = false;
    private DrawingPanel canvas;
    private Game game;
    MainFrame mf;

    public void main(){

        Strategy strategy = new Strategy("First Triangle");

        if(commandType.equals("console")){

            scanner = new Scanner(System.in);
            game = new Game(6, 1, strategy, "console");

        }
        else if(commandType.equals("gui")){
            game = new Game(6, 1, strategy, "console");
            mf = new MainFrame(game.getNodes());
            mf.setVisible(true);
            //TODO .... mainframe game

        } else {

            System.out.println("Invalid command type");
            return;

        }

        while (!gameOver) {
            if(commandType.equals("console")){
                System.out.println("Player " + (playerTurn ? "2" : "1") + "'s turn");

                game.printEdges();

                System.out.println("Enter an edge to color:");

                game.playRound(scanner, playerTurn);
                playerTurn = !playerTurn;
                
            } else if(commandType.equals("gui")){
                //TODO
                
                canvas = mf.getCanvas();
                canvas.setPlayerTurn(playerTurn);
    
                if(canvas.getEdge() != null){
                    String edge = canvas.getEdge();
                    game.playRoundUI(edge, playerTurn);
                    playerTurn = !playerTurn;
                    System.out.println(canvas.getEdge());
                    game.printEdges();
                    canvas.setEdge(null);
                }
            }

            gameOver = game.isGameOver(strategy);

            if(game.noEdgesLeft()){
                break;
            }
        }

        game.printResult(strategy, playerTurn, gameOver);

        if(commandType.equals("console")){
            scanner.close();
        }
        else{
            canvas.winPlayer();
        }

    }
}
