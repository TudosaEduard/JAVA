package compulsory;

import java.util.ArrayList;
import java.util.List;

import compulsory.objects.Company;
import compulsory.objects.Person;
import compulsory.types.Specialized;

public class Compulsory {

    private List <Person> person = new ArrayList<>();
    private List <Company> company = new ArrayList<>();
    private List <Object> objects = new ArrayList<>();

    public void main()
    {
        Person p1 = new Person("Radu", 23, Specialized.Designers);
        Person p2 = new Person("Vlad", 37, Specialized.Programmers);
        Person p3 = new Person("Toma", 18);
        Person p4 = new Person("Petru", 43);

        Company c1 = new Company("Continental", 30);
        Company c2 = new Company("Amazor", 37);
        Company c3 = new Company("OLX", 5);

        person.add(p1);
        person.add(p2);
        person.add(p3);
        person.add(p4);

        company.add(c1);
        company.add(c2);
        company.add(c3);

        objects.add(p1);
        objects.add(p2);
        objects.add(p3);
        objects.add(p4);
        objects.add(c1);
        objects.add(c2);
        objects.add(c3);


        System.out.println(objects.toString());
        objects.sort(null);
        System.out.println(objects.toString());
    }

}

