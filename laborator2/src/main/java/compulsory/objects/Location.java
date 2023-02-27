package compulsory.objects;

import compulsory.types.LocationType;

public class Location {
    
    private String name;
    private LocationType type;
    private double x;
    private double y;
    
    public Location() {
        this.name = null;
        this.type = null;
        this.x = 0;
        this.y = 0;
    };

    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

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
