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

        //Get the jvm heap size.
        long heapSize = Runtime.getRuntime().totalMemory();

        //Print the jvm heap size.
        System.out.println("Heap Size = " + heapSize);

        App app = new App();
        //app.compulsory();
        app.homework(args);
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

    void homework(String[] args)
    {
        Homework hw = new Homework();
        int n;

        if(args.length > 0)
        {
            System.out.print("The input number is : " + args[0]);
            n = Integer.parseInt(args[0]);
        }
        else
        {
            System.out.print("The input number is : ");
            n = hw.input();
        }

        if(n <= 30000)
        {
            System.out.println("The Latin Square is :");
            int [][] matrix = hw.latinSquare(n);
            hw.afisareMat(matrix, n);
            
            hw.displayString(matrix, n);
        }
        else
        {
            long startTime = System.nanoTime();
            
            int [][] matrix = hw.latinSquare(n);
            
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("The time in nanoseconds for application is : " + totalTime);
        }
    }

}
