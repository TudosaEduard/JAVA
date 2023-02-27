package lab2;

import compulsory.Compulsory;

/**
 *
 * @author Tudosa Eduard-Bogdan
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.compulsory();
    }

    void compulsory()
    {
        Compulsory comp = new Compulsory();
        comp.main();
    }
}