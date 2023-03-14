package homework.objects;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import homework.utils.Node;

public abstract class Person implements Comparable<Node>, Node {
    private String name;
    private int age;
    private LocalDate dob;
    private Map<Node, String> relationships = new HashMap<>();
    private int nrConn;

    public Person(String name, int age, LocalDate dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.nrConn = 0;
    }

    @Override
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", nrConn=" + nrConn + "]";
    }

    public LocalDate getDob() {
        return dob;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
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

    public void addRelathionship(Node node, String rel)
    {
        this.relationships.put(node, rel);
        nrConn += 1;
        node.addConn();
    }
    
}
