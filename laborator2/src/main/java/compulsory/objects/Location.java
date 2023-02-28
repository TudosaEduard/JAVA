package compulsory.objects;

import compulsory.types.LocationType;

/**
 * Locations objects class
 */

public class Location {

    private String name;
    private LocationType type;
    private double x;
    private double y;

    public Location() {
    };

    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @param name Name of the location created
     * @param type Type of the location, among those existing in the enum
     *             LocationType
     * @param x    The x coordinate for location positioning
     * @param y    The y coordinate for location positioning
     */
    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * Getters and setters for Location parameters
     * 
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Locations [name=" + name + ", type=" + type + ", x=" + x + ", y=" + y + "]";
    }

}
