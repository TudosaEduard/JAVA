package lab4;

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
        //app.compulsory();
        app.homework();
    }

    public void compulsory()
    {
        Compulsory comp = new Compulsory();
        comp.main();
    }

    public void homework()
    {
        Homework hw = new Homework();
        hw.main();
    }
}
