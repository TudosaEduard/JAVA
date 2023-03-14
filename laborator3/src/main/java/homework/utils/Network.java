package homework.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Network{
    private List<Node> nodes = new ArrayList<>();

    public Network() {}

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Network [nodes=" + nodes + "]";
    }

    public void sortList()
    {
        for(int ii = 0 ; ii < nodes.size() - 1 ; ii ++)
            for(int jj = ii + 1 ; jj < nodes.size() ; jj ++)
                if(nodes.get(ii).getNrConn() < nodes.get(jj).getNrConn())
                    Collections.swap(nodes, ii, jj);
    }
       
}
