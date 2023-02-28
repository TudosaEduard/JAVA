package homework;

import homework.objects.Location;
import homework.objects.Road;
import homework.types.AirPorts;
import homework.types.Cities;
import homework.types.County;
import homework.types.Express;
import homework.types.GasStations;
import homework.types.Highways;

/**
 * This is the main project for homework
 */

public class Problem {

    private static Location[] locations = new Location[15];
    private static Road[] roads = new Road[15];
    private static int nrL = 0, nrR = 0, twoL = 0, oneR = 0;
    private static boolean findPath = false;

    private static Location[][] twoLocations = new Location[15][2];
    private static Road[] oneRoad = new Road[15];
    private static boolean[] isUsed = new boolean[15];

    /**
     * Create new objects with different parameters, check if the parameters created
     * are valid and
     * determine a path between two locations with a given roads
     */

    public void main() {
        String[] obj1 = { "Palatul Culturii", "Gradina Botanica", "Cinema Victoria" };
        Cities c1 = new Cities("Iasi", 0, 0, 319007, obj1);
        locations[nrL++] = c1;

        String[] obj2 = { "Muzeul viticol", "Casa Ghica" };
        Cities c2 = new Cities("Vaslui", 50.50, 50, 100170, obj2);
        if (c1.validInstance(locations, c2) == false)
            c2 = null;
        else
            locations[nrL++] = c2;

        String[] obj3 = { "Strada Brezoianu" };
        Cities c3 = new Cities("Bucuresti", -122, -462.44, 1716983, obj3);
        if (c1.validInstance(locations, c3) == false)
            c3 = null;
        else
            locations[nrL++] = c3;

        AirPorts a1 = new AirPorts("George Enescu Bacau", 20, 25.55, 400, 5);
        if (c1.validInstance(locations, a1) == false)
            a1 = null;
        else
            locations[nrL++] = a1;

        AirPorts a2 = new AirPorts("Aurel Vlaicu Bucuresti", -120, -27.32, 700, 8);
        if (c1.validInstance(locations, a2) == false)
            a2 = null;
        else
            locations[nrL++] = a2;

        GasStations g1 = new GasStations("Rompetrom", -12, 23.44, 7.5, 20);
        if (c1.validInstance(locations, g1) == false)
            g1 = null;
        else
            locations[nrL++] = g1;

        // System.out.println(c1.toString());

        Highways h1 = new Highways("Autostrada Soarelui", 100, 180, c1, c3, 10);
        roads[nrR++] = h1;

        Highways h2 = new Highways("Autostrada Bacau", 80, 180, c3, a1, 2);
        if (h1.validInstance(roads, h2) == false)
            h2 = null;
        else
            roads[nrR++] = h2;

        Highways h3 = new Highways("Autostrada Vaslui", 120, 120, c2, a1, 10);
        if (h1.validInstance(roads, h3) == false)
            h3 = null;
        else
            roads[nrR++] = h3;

        Express e1 = new Express("Strada Nationala Bucuresti", 30, 70, c3, a2, 1);
        if (h1.validInstance(roads, e1) == false)
            e1 = null;
        else
            roads[nrR++] = e1;

        County cu1 = new County("Bulevard Alexandru", 5, 50, g1, c1, 30);
        if (h1.validInstance(roads, cu1) == false)
            cu1 = null;
        else
            roads[nrR++] = cu1;

        DFS(c1, c2);
        System.out.println(findPath);
        if (findPath == true)
            printPath();
    }

    /**
     * This is the recursive dfs to find the path between two locations
     * 
     * @param l1 Current location for step x
     * @param l2 The final location we want to reach
     */

    private void DFS(Location l1, Location l2) {
        if (l1.equals(l2))
            findPath = true;
        if (findPath == true)
            return;
        else {
            for (int index = 0; index < roads.length; ++index)
                if (!isUsed[index]) {
                    isUsed[index] = true;
                    if (roads[index].getLocationStart().equals(l1)) {
                        DFS(roads[index].getLocationEnd(), l2);
                        if (findPath == true) {
                            twoLocations[twoL][0] = roads[index].getLocationStart();
                            twoLocations[twoL++][1] = roads[index].getLocationEnd();
                            oneRoad[oneR++] = roads[index];
                            return;
                        }
                    } else if (roads[index].getLocationEnd().equals(l1)) {
                        DFS(roads[index].getLocationStart(), l2);
                        if (findPath == true) {
                            twoLocations[twoL][0] = roads[index].getLocationEnd();
                            twoLocations[twoL++][1] = roads[index].getLocationStart();
                            oneRoad[oneR++] = roads[index];
                            return;
                        }
                    }
                    isUsed[index] = false;
                }
        }
    }

    private void printPath() {
        for (int index = oneR - 1; index >= 0; index--)
            System.out.println("Location : " + twoLocations[index][0].getName() + " --> " + "Road : "
                    + oneRoad[index].getName() + " --> " + "Location : " + twoLocations[index][1].getName());
    }
}
