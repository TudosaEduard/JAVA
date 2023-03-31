package app;

import problem.Problem;

/**
 * @
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.problem();
    }

    void problem(){
        Problem pb = new Problem();
        pb.main();
    }
}
