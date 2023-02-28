package homework.types;

import homework.objects.Location;
import homework.objects.Road;

public class Express extends Road {

    private int oldAge;

    public Express(String name, double length, double speed, Location locationStart, Location locationEnd, int oldAge) {
        super(name, length, speed, locationStart, locationEnd);
        this.oldAge = oldAge;
    }

    public int getOldAge() {
        return oldAge;
    }

    public void setOldAge(int oldAge) {
        this.oldAge = oldAge;
    }

    @Override
    public String toString() {
        return "Express [oldAge=" + oldAge + "]";
    }

    
}
