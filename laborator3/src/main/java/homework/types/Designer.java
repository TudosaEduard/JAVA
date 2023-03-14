package homework.types;

import java.time.LocalDate;
import java.util.Date;

import homework.objects.Person;

public class Designer extends Person {

    // Colors Mastered
    private String cm;

    public Designer(String name, int age, LocalDate dob, String cm) {
        super(name, age, dob);
        this.cm = cm;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    
    
}
