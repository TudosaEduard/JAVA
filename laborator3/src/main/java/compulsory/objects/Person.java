package compulsory.objects;

import compulsory.types.Specialized;
import compulsory.utils.Node;

public class Person implements Comparable<Person>, Node {
    private String name;
    private int age;
    private Specialized specialization;


    public Person(String name, int age, Specialized specialization) {
        this.name = name;
        this.age = age;
        this.specialization = specialization;
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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


    public Specialized getSpecialization() {
        return specialization;
    }


    public void setSpecialization(Specialized specialization) {
        this.specialization = specialization;
    }


    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }


    @Override
    public int compareTo(Person other) {
        if (this == other)
            return 0;
        if (other == null)
            return 1;
        return this.name.compareTo(other.name); 
    }


    
}
