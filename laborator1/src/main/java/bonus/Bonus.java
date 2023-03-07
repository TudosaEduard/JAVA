package bonus;

public class Bonus {

    public Bonus() {}

    //Graph is a digraph

    public void cycleGraph(int n)
    {
        int [][] graph = new int [n + 1][n + 1];
        for(int ii = 0 ; ii < n - 1 ; ++ii)
            graph[ii][ii + 1] = 1;
        graph[n - 1][0] = 1;
        
        //print the matrix
        System.out.println("Cycle graph matrix is : ");
        afisareMat(graph, n);

        //copy the matrix
        int [][] graph_2 = new int[n + 1][n + 1];

        //calculate A^2
        for(int ii = 0 ; ii < n ; ++ii)
            for(int jj = 0 ; jj < n ; ++jj)
            {
                for(int k = 0 ; k < n ; ++k)
                    graph_2[ii][jj] += graph[ii][k] * graph[k][jj];
            }
        
        //print the matrix ^ 2
        System.out.println("Cycle graph matrix ^ 2 is : ");
        afisareMat(graph_2, n);
    }
    
    //Graph is a non-directed graph

    public void regularGraph(int n, int[] degree)
    {
        //create the regular graph
        int [][] graph = new int [n + 1][n + 1];
        for(int ii = 0 ; ii < n ; ++ii)
            if(degree[ii] != 0)
            {
                int k = ii + 1;
                while(degree[ii] != 0)
                {
                    graph[ii][k] = graph[k][ii] = 1;
                    degree[ii] --;
                    degree[k] --;
                    k ++;
                }
            }

        //print the matrix for regular graph generated
        System.out.println(("The matrix for regula graph is : "));
        afisareMat(graph, n);
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

}
