package compulsory.objects;

import compulsory.types.RoadType;

public class Road {

    private String name;
    private RoadType type;
    private double length;
    private double speed;
    Location locationStart, locationEnd;

    public Road() {
    }

    public Road(String name, double length, double speed) {
        this.name = name;
        this.length = length;
        this.speed = speed;
    }

    public Road(String name, RoadType type, double length, double speed) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.speed = speed;
    }

    /**
     * 
     * @param name          Name of the Road created
     * @param type          Type of the location, among those existing in the enum
     *                      RoadType
     * @param length        The length of the road calculated with euclidian
     *                      distance
     * @param speed         The spped limit
     * @param locationStart The location from which the road starts
     * @param locationEnd   The location from which the road ends
     */

    public Road(String name, RoadType type, double length, double speed, Location locationStart, Location locationEnd) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.speed = speed;
        this.locationStart = locationStart;
        this.locationEnd = locationEnd;
    }

    // Getters and setters for Road parameters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Location getLocationStart() {
        return locationStart;
    }

    public void setLocationStart(Location locationStart) {
        this.locationStart = locationStart;
    }

    public Location getLocationEnd() {
        return locationEnd;
    }

    public void setLocationEnd(Location locationEnd) {
        this.locationEnd = locationEnd;
    }

    @Override
    public String toString() {
        return "Road [name=" + name + ", type=" + type + ", length=" + length + ", speed=" + speed + ", locationStart="
                + locationStart + ", locationEnd=" + locationEnd + "]";
    }

}
