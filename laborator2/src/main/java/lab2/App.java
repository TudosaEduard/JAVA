package lab2;

import compulsory.Compulsory;
import homework.Problem;

/**
 *
 * @author Tudosa Eduard-Bogdan
 */
public class App 
{
    /**
     * Main function of project for laboratory 2
     * @param args
     */
    public static void main( String[] args )
    {
        App app = new App();
        app.compulsory();
        app.homework();
    }

    void compulsory()
    {
        Compulsory comp = new Compulsory();
        comp.main();
    }

    void homework()
    {
        Problem pb = new Problem();
        pb.main();
    }
}