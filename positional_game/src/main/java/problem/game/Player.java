package problem.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import problem.game.objects.Edge;

public class Player implements Serializable{
    private String name;
    private String color;
    private List <Edge> edges = new ArrayList<Edge>();

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
        edge.setColor(color);
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", color=" + color + ", edges=" + edges + "]";
    }

}
