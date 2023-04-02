package problem.ui;

public class Data {
    private int nrNodes;
    private double prob;

    public Data(int nrNodes, double prob) {
        this.nrNodes = nrNodes;
        this.prob = prob;
    }

    public int getNrNodes() {
        return nrNodes;
    }

    public void setNrNodes(int nrNodes) {
        this.nrNodes = nrNodes;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }
}
