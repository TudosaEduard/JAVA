package homework;

import java.time.LocalDate;
import java.util.List;

import homework.objects.Company;
import homework.types.Designer;
import homework.types.Programmer;
import homework.utils.Network;
import homework.utils.Node;

public class Homework {

    public void main()
    {
        Programmer p1 = new Programmer("Florin", 25, LocalDate.parse("2020-07-27"), "Java");
        Programmer p2 = new Programmer("Marin", 35, LocalDate.parse("2020-07-27"), "Python");
        Programmer p3 = new Programmer("Alin", 15, LocalDate.parse("2020-07-27"), "C#");

        Designer d1 = new Designer("Magdalena", 17, LocalDate.parse("2020-07-27"), "albastru");
        Designer d2 = new Designer("Marlena", 23, LocalDate.parse("2020-07-27"), "rosu");
        Designer d3 = new Designer("Gicu", 35, LocalDate.parse("2020-07-27"), "galben");

        Company c1 = new Company("Microsoft", 17);
        Company c2 = new Company("Certus", 15);

        d3.addRelathionship(d1, "iubire");
        p1.addRelathionship(p3, "prietenie");
        p1.addRelathionship(d1, "iubire");
        p1.addRelathionship(d3, "dusmanie");
        p1.addRelathionship(c2, "boss");
        p2.addRelathionship(c1, "angajat");
        d2.addRelathionship(d1, "bff");
        d1.addRelathionship(c2, "angajat");
        d3.addRelathionship(c1, "angajat");
        p1.addRelathionship(d2, "frati");

        Network net = new Network();
        net.addNode(p1);
        net.addNode(p2);
        net.addNode(p3);
        net.addNode(d1);
        net.addNode(d2);
        net.addNode(d3);
        net.addNode(c1);
        net.addNode(c2);

        net.sortList();

        System.out.println(net.toString());
    }
    
}
