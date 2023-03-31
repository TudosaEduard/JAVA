package problem.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import problem.game.objects.Edge;
import problem.game.objects.Node;

public class Game {
    private List<Node> nodes = new ArrayList<Node>();
    private List<Edge> edges = new ArrayList<Edge>();
    private Player player1 = new Player("Player 1", "red");
    private Player player2 = new Player("Player 2", "blue");
    private Boolean playerTurn = false;
    private Boolean gameOver = false;
    private String input;
    private int nrEdges = 0;

    public Game(int numNodes, double probability, Strategy strategy, String commandType) {
        createNodes(numNodes);
        createEdges(numNodes, probability);

        while (!gameOver) {
            if(commandType.equals("console")){
                System.out.println("Player " + (playerTurn ? "2" : "1") + "'s turn");

                for (Edge edge : edges) {
                    System.out.println(edge.toString());
                }

                System.out.println("Enter an edge to color:");

                playRound();
                
            } else if(commandType.equals("gui")){
                //TODO
            }

            gameOver = strategy.winCondition(player1) || strategy.winCondition(player2);

            if(noEdgesLeft()){
                break;
            }
        }

        if(!gameOver){
            System.out.println("Draw!");
        } else {
            if(strategy.getName().equals("Last Triangle"))
                System.out.println("Player " + (playerTurn ? "2" : "1") + " wins!");
            else
                System.out.println("Player " + (playerTurn ? "1" : "2") + " wins!");
        }
    }

    public void createNodes(int numNodes){
        for (int i = 0; i < numNodes; i++) {
            nodes.add(new Node("N " + i));
        }
    }

    public void createEdges(int numNodes, double probability){
        for (int i = 0; i < numNodes; i++) {
            for (int j = i + 1; j < numNodes; j++) {
                if (Math.random() < probability) {
                    Edge edge = new Edge("E " + nrEdges, nodes.get(i), nodes.get(j), "black");
                    edges.add(edge);
                    nodes.get(i).addNeighbor(nodes.get(j));
                    nodes.get(j).addNeighbor(nodes.get(i));
                    nrEdges += 1;
                }
            }
        }
    }

    public Edge getEdgeByName(String name){
        for (Edge edge : edges) {
            if(edge.getName().equals(name) && edge.getColor().equals("black")){
                return edge;
            }
        }
        return null;
    }

    public void playRound(){
        while(true){
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            
            Edge edge = getEdgeByName(input);

            if(edge != null){
                if(!playerTurn){
                    player1.addEdge(edge);
                } else {
                    player2.addEdge(edge);
                }
                break;
            } else {
                System.out.println("Invalid edge. Try again.");
            }

            scanner.close();
        }

        playerTurn = !playerTurn;
    }

    public Boolean noEdgesLeft(){
        for (Edge edge : edges) {
            if(edge.getColor().equals("black")){
                return false;
            }
        }
        return true;
    }
}
