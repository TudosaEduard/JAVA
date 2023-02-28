package compulsory;

import java.math.BigDecimal;
import java.math.RoundingMode;

import compulsory.objects.Location;
import compulsory.objects.Road;
import compulsory.types.LocationType;
import compulsory.types.RoadType;

/**
 * This is the main project for compulsory
 */

public class Compulsory {

    /**
     * Create new objects with different parameters and constructors and print them
     */
    public void main() {
        Location l1 = new Location();
        l1.setName("Iasi");
        l1.setType(LocationType.CITIES);
        l1.setX(0.0);
        l1.setY(0.0);

        Location l2 = new Location("Vaslui", 10.0, 20.0);
        l2.setType(LocationType.CITIES);

        Location l3 = new Location("Rompetrol Bucuresti", LocationType.GAS_STATIONS, -15.20, 22.02);

        Location l4 = new Location("Aurel Vlaicu", LocationType.AIRPORTS, -10, 0.10);

        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());
        System.out.println(l4.toString());

        System.out.println();

        Road r1 = new Road();
        r1.setName("Autostrada Soarelui");
        r1.setType(RoadType.HIGHWAYS);
        r1.setLength(euclidianDistance(l1.getX(), l1.getY(), l2.getX(), l2.getY()));
        r1.setSpeed(120);
        r1.setLocationStart(l1);
        r1.setLocationEnd(l2);

        Road r2 = new Road("Autostrada A10", euclidianDistance(l1.getX(), l1.getY(), l3.getX(), l3.getY()), 180);
        r2.setType(RoadType.HIGHWAYS);
        r1.setLocationStart(l1);
        r1.setLocationEnd(l3);

        Road r3 = new Road("Brasovia", RoadType.EXPRESS, euclidianDistance(l2.getX(), l2.getY(), l4.getX(), l4.getY()),
                70, l2, l4);

        Road r4 = new Road("Bulevard Dacia", RoadType.COUNTY,
                euclidianDistance(l4.getX(), l4.getY(), l3.getX(), l3.getY()), 50, l4, l3);

        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        System.out.println(r4.toString());
    }

    // Euclidian distance for determine the length roads
    public double euclidianDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
        BigDecimal bd = new BigDecimal(Double.toString(distance));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
