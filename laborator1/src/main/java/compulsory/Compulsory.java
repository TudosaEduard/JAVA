package compulsory;

public class Compulsory {

    private String [] languages;

    public Compulsory(){ }

    // Print the Hello World! message

    public void hello()
    {
        System.out.println( "Hello World!" );
    }

    // Define the language array

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getLanguages() {
        return languages;
    }

    // Generate random number

    public int generateNumber(){
        return (int)(Math.random() * 1000000);
    }

    // Performing the operations

    public int operations(int n){
        n = n * 3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;

        return n;
    }

    // Check digit of a number

    public int digit(int n){
        while(n > 9)
        {
            int nn = n, sum = 0;
            while(nn != 0)
            {
                sum += nn % 10;
                nn /= 10;
            }
            n = sum;
        }

        return n;
    }

    // Display the message

    public void message(int n)
    {
        System.out.println("Willy-nilly, this semester I will learn " + languages[n] + ".");
    }
}
