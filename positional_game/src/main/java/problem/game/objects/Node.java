package problem.game.objects;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List <Node> neighbors = new ArrayList<Node>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return name;
    }
}
