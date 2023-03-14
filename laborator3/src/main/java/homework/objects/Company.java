package homework.objects;

import homework.utils.Node;

public class Company implements Comparable<Node>, Node {
    private String name;
    private int networth;
    private int nrConn;


    public Company(String name, int networth) {
        this.name = name;
        this.networth = networth;
        this.nrConn = 0;
    }


    @Override
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getNetworth() {
        return networth;
    }


    public void setNetworth(int networth) {
        this.networth = networth;
    }


    @Override
    public String toString() {
        return "Company [name=" + name + ", networth=" + networth + ", nrConn=" + nrConn + "]";
    }


    @Override
    public int compareTo(Node other) {
        if (this == other)
            return 0;
        if (other == null)
            return 1;
            
        Integer nrC = Integer.valueOf(this.nrConn);
        Integer nrO = Integer.valueOf(other.getNrConn());
        return nrC.compareTo(nrO); 
    }

    @Override
    public int getNrConn() {
        return nrConn;
    }

    public void setNrConn(int nrConn) {
        this.nrConn = nrConn;
    }

    @Override
    public void addConn(){
        nrConn += 1;
    }
    
}
