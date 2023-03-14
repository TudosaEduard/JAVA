package lab3;

import java.time.LocalDate;

import compulsory.Compulsory;
import homework.Homework;

/**
 * @
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.compulsory();
        app.homework();
    }

    void compulsory()
    {
        //Compulsory comp = new Compulsory();
        //comp.main();
    }

    void homework()
    {
        Homework hw = new Homework();
        hw.main();
    }
}
