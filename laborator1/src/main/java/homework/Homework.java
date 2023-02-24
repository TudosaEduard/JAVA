package homework;
import java.util.Scanner;

public class Homework {
    
    public Homework() {}

    // Read the input and check if is integer or not
    public int input()
    {
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt())
        {
            System.out.println("Number is not valid!");
            sc.close();
            return -1;
        }

        int n = sc.nextInt();
        if(n < 0)
        {
            System.out.println("Number is not valid!");
            sc.close();
            return -1;
        }

        sc.close();
        return n;
    }

    // Create and print the Latin Square with 1...n symbols
    public int[][] latinSquare(int n)
    {
        int [][] mat = new int [n + 1][n + 1];

        for(int jj = 0 ; jj < n ; ++jj)
            mat[0][jj] = jj + 1;
        for(int ii = 1 ; ii < n ; ++ii)
        {
            for(int jj = 1 ; jj < n ; ++jj)
                mat[ii][jj] = mat[ii - 1][jj - 1];
            mat[ii][0] = mat[ii - 1][n - 1];
        }

        return mat;
    }

    public void afisareMat(int mat[][], int n)
    {
        for(int ii = 0 ; ii < n ; ++ii)
        {
            for(int jj = 0 ; jj < n ; ++jj)
                System.out.print(mat[ii][jj] + " ");
            System.out.println();
        }
    }

    public void displayString(int [][] mat, int n)
    {
        System.out.println("Concatenate lines: ");
        for(int ii = 0 ; ii < n ; ++ii)
        {
            String line = "";
            for(int jj = 0 ; jj < n ; ++jj)
                line = line + mat[ii][jj];
            System.out.println("Line " + (ii + 1) + " is : " + line);
        }

        System.out.println("Concatenate columns: ");
        for(int jj = 0 ; jj < n ; ++jj)
        {
            String column = "";
            for(int ii = 0 ; ii < n ; ++ii)
                column = column + mat[ii][jj];
            System.out.println("Column " + (jj + 1) + " is : " + column);
        }
    }

    //  java -XX:+PrintFlagsFinal -version | findstr HeapSize --> pentru a vedea memoria heap initiala, minima, maxima ... din JVM
    //  
}
