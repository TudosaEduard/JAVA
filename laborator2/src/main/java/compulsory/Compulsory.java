package compulsory;

import compulsory.objects.Location;
import compulsory.objects.Road;
import compulsory.types.LocationType;
import compulsory.types.RoadType;

public class Compulsory {
    public void main()
    {
        Location l1 = new Location();
        l1.setName("Iasi");
        l1.setType(LocationType.CITIES);
        l1.setX(0.0);
        l1.setY(0.0);
        
        Location l2 = new Location("Vaslui", 10.0, 20.0);
        l2.setType(LocationType.CITIES);

        Location l3 = new Location("Rompetrol", LocationType.GAS_STATIONS, -15.20, 22.02);

        Location l4 = new Location("Aurel Vlaicu", LocationType.AIRPORTS, -10, 0.10);

        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());
        System.out.println(l4.toString());

        System.out.println();

        Road r1 = new Road();
        r1.setName("Autostrada Soarelui");
        r1.setType(RoadType.HIGHWAYS);
        r1.setX(0.0);
        r1.setY(0.0);
        
        Road r2 = new Road("Autostrada A10", 10.0, 20.0);
        r2.setType(RoadType.HIGHWAYS);

        Road r3 = new Road("Brasovia", RoadType.EXPRESS, -15.20, 22.02);

        Road r4 = new Road("Bulevard Dacia", RoadType.COUNTY, -10, 0.10);

        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        System.out.println(r4.toString());
    }
}
