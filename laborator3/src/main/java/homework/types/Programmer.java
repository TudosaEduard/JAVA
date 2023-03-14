package homework.types;

import java.time.LocalDate;
import java.util.Date;

import homework.objects.Person;

public class Programmer extends Person {

    // Programming languages
    private String pl;

    public Programmer(String name, int age, LocalDate dob, String pl) {
        super(name, age, dob);
        this.pl = pl;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    
    
}
