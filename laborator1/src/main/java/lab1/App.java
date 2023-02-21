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
        
        System.out.print("First message is: ");
        comp.hello();

        System.out.print("Available languages is: ");
        String [] lang = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        comp.setLanguages(lang);
        System.out.println(Arrays.toString(comp.getLanguages()));

        System.out.print("The generated number is: ");
        int n = comp.generateNumber();
        System.out.println(n);

        System.out.print("The number after operations is: ");
        System.out.println(comp.operations(n));

        System.out.print("The digit is: ");
        n = comp.digit(n);
        System.out.println(n);

        System.out.print("Last message is: ");
        comp.message(n);
    }

}
