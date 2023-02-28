package homework.types;

import java.util.Arrays;

import homework.objects.Location;

public class Cities extends Location {

    private int numberPeople;
    private String[] touristicObjectives;

    /**
     * 
     * @param name                Name of the location created
     * @param x                   The x coordinate for location positioning
     * @param y                   The y coordinate for location positioning
     * @param numberPeople        The population number
     * @param touristicObjectives The best tourist attractions
     */

    public Cities(String name, double x, double y, int numberPeople, String[] touristicObjectives) {
        super(name, x, y);
        this.numberPeople = numberPeople;
        this.touristicObjectives = touristicObjectives;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String[] getTouristicObjectives() {
        return touristicObjectives;
    }

    public void setTouristicObjectives(String[] touristicObjectives) {
        this.touristicObjectives = touristicObjectives;
    }

    @Override
    public String toString() {
        return "Cities [numberPeople=" + numberPeople + ", touristicObjectives=" + Arrays.toString(touristicObjectives)
                + "]";
    }

}
