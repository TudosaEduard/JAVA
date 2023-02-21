package lab1;

import java.util.Arrays;

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
        
        comp.hello();

        String [] lang = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        comp.setLanguages(lang);
        System.out.println(Arrays.toString(comp.getLanguages()));

        int n = comp.generateNumber();
        System.out.println(n);

        System.out.println(comp.operations(n));

        n = comp.digit(n);
        System.out.println(n);

        comp.message(n);
    }

}
