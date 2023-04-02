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
    private Boolean gameStarted = false;

    private int nrNodes = 0;
    private double probability = 0;

    public void main(){

        Strategy strategy = new Strategy("First Triangle");

        if(commandType.equals("console")){

            scanner = new Scanner(System.in);
            game = new Game(6, 1, strategy);

        }
        else if(commandType.equals("gui")){

            mf = new MainFrame();
            mf.setVisible(true);

            nrNodes = (Integer) mf.getConfigPanel().getDotsSpinner().getValue();
            probability = (Double) mf.getConfigPanel().getLinesCombo().getSelectedItem();

            game = new Game(nrNodes, probability, strategy);

            mf.getCanvas().setNodes(game.getNodes());
            mf.getCanvas().setEdges(game.getEdges());

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

                if(canvas.getNewGameStarted() == true){
                    gameStarted = true;

                    canvas.setNewGameStarted(false);
                    nrNodes = (Integer) mf.getConfigPanel().getDotsSpinner().getValue();
                    probability = (Double) mf.getConfigPanel().getLinesCombo().getSelectedItem();

                    System.out.println("New game started with " + nrNodes + " nodes and " + probability + " probability");

                    game = new Game(nrNodes, probability, strategy);

                    System.out.println(game.getEdges());
                    
                    mf.getCanvas().setNodes(game.getNodes());
                    mf.getCanvas().setEdges(game.getEdges());
                    
                    playerTurn = false;
                    canvas.setPlayerTurn(playerTurn);

                    gameOver = false;
                    continue;
                }
    
                if(canvas.getEdge() != null){
                    String edge = canvas.getEdge();
                    game.playRoundUI(edge, playerTurn);
                    playerTurn = !playerTurn;
                    //System.out.println(canvas.getEdge());
                    game.printEdges();
                    canvas.setEdge(null);
                }
            }

            if(gameStarted == false){
                continue;
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
            canvas.setPlayerTurn(playerTurn);
            canvas.winPlayer();
        }

    }
}
