package lab1;

import java.util.Arrays;

import compulsory.Compulsory;
import homework.Homework;

/**
*
* @author Tudosa Eduard-Bogdan
*/


public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        //app.compulsory();
        app.homework();
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
        n = comp.operations(n);
        System.out.println(comp.operations(n));

        System.out.print("The digit is: ");
        n = comp.digit(n);
        System.out.println(n);

        System.out.print("Last message is: ");
        comp.message(n);
    }

    void homework()
    {
        Homework hw = new Homework();

        System.out.print("The input number is : ");
        int n = hw.input();

        System.out.println("The Latin Square is :");
        int [][] matrix = hw.latinSquare(n);

        if(n <= 500)
            hw.displayStringSmall(matrix, n);
    }

}
