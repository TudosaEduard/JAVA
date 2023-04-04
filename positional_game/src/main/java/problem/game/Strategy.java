package problem.game;

import java.io.Serializable;

import problem.game.objects.Edge;

public class Strategy implements Serializable{
    private String name;

    public Strategy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean winCondition(Player player) {
        if(player.getEdges().size() < 3)
            return false;
        Edge startEdge = player.getEdges().get(player.getEdges().size() - 1);
        for(Edge edge : player.getEdges()) 
            if(startEdge.getNode1().equals(edge.getNode1()) || startEdge.getNode1().equals(edge.getNode2()) || 
                startEdge.getNode2().equals(edge.getNode1()) || startEdge.getNode2().equals(edge.getNode2()))
                if(!edge.equals(startEdge))
                    for(Edge edge2 : player.getEdges())
                        if(edge.getNode1().equals(edge2.getNode1()) || edge.getNode1().equals(edge2.getNode2()) 
                        || edge.getNode2().equals(edge2.getNode1()) || edge.getNode2().equals(edge2.getNode2()))
                            if(!edge2.equals(edge) && !edge2.equals(startEdge))
                                if(edge2.getNode1().equals(startEdge.getNode1()) || edge2.getNode1().equals(startEdge.getNode2()) 
                                || edge2.getNode2().equals(startEdge.getNode1()) || edge2.getNode2().equals(startEdge.getNode2()))
                                    return true;
        return false;
    }
}
