package problem.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import problem.game.Game;
import problem.game.Player;
import problem.game.Strategy;
import problem.game.objects.Edge;
import problem.game.objects.Node;
import problem.ui.MainFrame;

public class Test {
    public Test() {
        //Test for game
        List <Node> nodes = testNodes();

        List <Edge> edges = testEdge(nodes);

        List<Player> players = testPlayer(edges);

        Strategy strategy = testStrategy(players.get(0));

        testGame(6, 1, strategy);

        //Test for UI
        testUI(nodes, edges);
    }

    public static void main(String[] args) {
        new Test();
    }

    public List<Node> testNodes(){

        System.out.println("\nTest Node\n");

        List <Node> nodes = new ArrayList <Node>();
        for(int i = 0; i < 10; i++){
            nodes.add(new Node("N" + i));
        }
        System.out.println(nodes.get(3).toString());
        nodes.get(3).setName("Nume schimbat!");
        System.out.println(nodes.get(3).toString());

        return nodes;
    }

    public List<Edge> testEdge(List <Node> nodes){

        System.out.println("\nTest Edge\n");

        List <Edge> edges = new ArrayList <Edge>();
        int nrEdges = 0;

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (Math.random() < 0.5 || nrEdges < 5) {
                    Edge edge = new Edge("E" + nrEdges, nodes.get(i), nodes.get(j), "black");
                    edges.add(edge);
                    nrEdges += 1;
                }
            }
        }

        System.out.println(edges.get(3).toString());
        edges.get(3).setColor("Culoare schimbata!");
        edges.get(3).setNode1(nodes.get(0));
        System.out.println(edges.get(3).toString());

        return edges;
    }

    public List<Player> testPlayer(List <Edge> edges){

        System.out.println("\nTest Player\n");

        Player player1 = new Player("Player 1", "red");
        Player player2 = new Player("Player 2", "blue");

        System.out.println(player1.toString());
        player1.addEdge(edges.get(3));
        player1.setName("Nume schimbat!");
        System.out.println(player1.toString());

        System.out.println(player2.toString());
        player2.addEdge(edges.get(1));
        player2.addEdge(edges.get(2));
        player2.setName("Tony!");
        System.out.println(player2.toString());

        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        return players;
    }

    public Strategy testStrategy(Player player){
        Strategy strategy = new Strategy("First Triangle");
        System.out.println("\nTest Strategy\n");

        List <Node> nodes = new ArrayList <Node>();
        for(int i = 0 ; i < 3 ; i++){
            nodes.add(new Node("T" + i));
        }

        System.out.println(strategy.winCondition(player) + " " + player.toString());

        player.addEdge(new Edge("T1", nodes.get(0), nodes.get(1), "black"));
        player.addEdge(new Edge("T2", nodes.get(1), nodes.get(2), "black"));
        player.addEdge(new Edge("T3", nodes.get(2), nodes.get(0), "black"));

        System.out.println(strategy.winCondition(player) + " " + player.toString());

        strategy.setName("Last Triangle");

        System.out.println(strategy.winCondition(player) + " " + player.toString());

        return strategy;
    }

    public void testGame(int nrNodes, int probability, Strategy strategy){
        System.out.println("\nTest Game\n");

        Game game = new Game(nrNodes, probability, strategy);

        System.out.println(game.getNodeByName("N1"));
        System.out.println(game.getEdgeByName("E1"));

        game.printEdges();
        Scanner scanner = new Scanner(System.in);
        game.playRound(scanner, false);

        game.printEdges();
        game.playRound(scanner, false);

        System.out.println(game.isGameOver(strategy));
        game.printResult(strategy, true, false);

        game.printResult(strategy, true, true);

    }

    public void testUI(List <Node> nodes, List <Edge> edges){
        System.out.println("\nTest UI\n");

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);

        mainFrame.getCanvas().setNodes(nodes);
        mainFrame.getCanvas().setEdges(edges);
        mainFrame.getCanvas().setPlayerTurn(false);
    }
}
