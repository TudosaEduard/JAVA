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
    private String input;
    private int nrEdges = 0;

    public Game(int numNodes, double probability, Strategy strategy, String commandType) {
        createNodes(numNodes);
        createEdges(numNodes, probability);
    }

    public void printEdges(){
        for (Edge edge : edges) {
            System.out.println(edge.toString());
        }
    }

    public void createNodes(int numNodes){
        for (int i = 0; i < numNodes; i++) {
            nodes.add(new Node("N" + i));
        }
    }

    public void createEdges(int numNodes, double probability){
        for (int i = 0; i < numNodes; i++) {
            for (int j = i + 1; j < numNodes; j++) {
                if (Math.random() < probability) {
                    Edge edge = new Edge("E" + nrEdges, nodes.get(i), nodes.get(j), "black");
                    edges.add(edge);
                    nrEdges += 1;
                }
            }
        }
    }


    public List<Node> getNodes() {
        return nodes;
    }

    public Node getNodeByName(String name){
        for (Node node : nodes) {
            if(node.getName().equals(name)){
                return node;
            }
        }
        return null;
    }

    public Edge getEdgeByName(String name){
        for (Edge edge : edges) {
            if(edge.getName().equals(name) && edge.getColor().equals("black")){
                return edge;
            }
        }
        return null;
    }

    public List<Node> getNodesByString(String input){
        List<Node> nodes = new ArrayList<Node>();
        String[] nodesString = input.split(" ");
        for (String nodeString : nodesString) {
            nodes.add(getNodeByName(nodeString));
        }
        return nodes;
    }

    public void playRound(Scanner scanner, Boolean playerTurn){
        while(true){
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
        }
    }

    public void playRoundUI(String input, Boolean playerTurn){
        List<Node> dots = getNodesByString(input);
        Edge edge = getEdgeByNodes(dots.get(0), dots.get(1));

        if(edge != null){
            if(!playerTurn){
                player1.addEdge(edge);
                System.out.println("Added for player 1");
            } else {
                player2.addEdge(edge);
                System.out.println("Added for player 2");
            }
        } else {
            System.out.println(input);
            System.out.println(playerTurn);
        }

    }

    public Boolean noEdgesLeft(){
        for (Edge edge : edges) {
            if(edge.getColor().equals("black")){
                return false;
            }
        }
        return true;
    }

    public void printResult(Strategy strategy, Boolean playerTurn, Boolean gameOver){
        if(!gameOver){
            System.out.println("Draw!");
        } else {
            if(strategy.getName().equals("Last Triangle"))
                System.out.println("Player " + (playerTurn ? "2" : "1") + " wins!");
            else
                System.out.println("Player " + (playerTurn ? "1" : "2") + " wins!");
        }
    }

    public Boolean isGameOver(Strategy strategy){
        return strategy.winCondition(player1) || strategy.winCondition(player2);
    }

    public Edge getEdgeByNodes(Node node1, Node node2){
        for (Edge edge : edges) {
            if(edge.getNode1().equals(node1) && edge.getNode2().equals(node2)){
                return edge;
            }
            else if(edge.getNode1().equals(node2) && edge.getNode2().equals(node1)){
                return edge;
            }
        }
        return null;
    }

}
