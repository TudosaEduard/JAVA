package homework.objects;

public abstract class Location {
    protected String name;
    protected double x;
    protected double y;
    
    public Location() {};

    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Location [name=" + name + ", x=" + x + ", y=" + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x) && (Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y)))
            return true;
        return true;
    }

    public boolean validInstance(Location [] locations, Location newLocation)
    {
        for (Location location : locations) {
            if(newLocation.equals(location))
                return false;
        }
        return true;
    }

}
