package compulsory.objects;

import compulsory.types.RoadType;

public class Road {

    private String name;
    private RoadType type;
    private double x;
    private double y;
    
    public Road() {
        this.name = null;
        this.type = null;
        this.x = 0;
        this.y = 0;
    }

    public Road(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Road(String name, RoadType type, double x, double y) {
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

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
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
        return "Road [name=" + name + ", type=" + type + ", x=" + x + ", y=" + y + "]";
    }

    
}
