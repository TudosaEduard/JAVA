package homework.objects;

public abstract class Road {
    protected String name;
    protected double length;
    protected double speed;
    protected Location locationStart, locationEnd;
    
    public Road() {}

    public Road(String name, double length, double speed) {
        this.name = name;
        this.length = length;
        this.speed = speed;
    }

    public Road(String name, double length, double speed, Location locationStart, Location locationEnd) {
        this.name = name;
        this.length = length;
        this.speed = speed;
        this.locationStart = locationStart;
        this.locationEnd = locationEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Road [name=" + name + ", length=" + length + ", speed=" + speed + ", locationStart="
                + locationStart + ", locationEnd=" + locationEnd + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Road other = (Road) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length) && (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed)))
            return true;
        return true;
    }

    public boolean validInstance(Road [] roads, Road newRoad)
    {
        for (Road road : roads) {
            if(newRoad.equals(road))
                return false;
        }
        return true;
    }
}
