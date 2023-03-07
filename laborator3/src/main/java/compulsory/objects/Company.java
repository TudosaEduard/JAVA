package compulsory.objects;

import compulsory.utils.Node;

public class Company implements Comparable<Company>, Node{
    private String name;
    private int networth;


    public Company(String name, int networth) {
        this.name = name;
        this.networth = networth;
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
        return "Company [name=" + name + ", networth=" + networth + "]";
    }


    @Override
    public int compareTo(Company other) {
        if (this == other)
            return 0;
        if (other == null)
            return 1;
        return this.name.compareTo(other.name); 
    }

}
