//hamiltonian
package lab12;
public class Main
{
    final int V = 5;
    int path[];

    boolean isSafe(int v, int graph[][], int path[], int pos)
    {
        if(graph[path[pos-1]][v]==0)
            return false;
        for(int i=0;i<pos;i++)
            if(path[i]==v)
                return false;
        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], int pos)
    {
        if(pos==V)
        {
            if(graph[path[pos-1]][path[0]]==1)
                return true;
            else
                return false;
        }
        for(int v=1;v<V;v++)
        {
            if(isSafe(v,graph,path,pos))
            {
                path[pos]=v;
                if(hamCycleUtil(graph,path,pos+1)==true)
                    return true;
                path[pos]=-1;
            }
        }
        return false;
    }
    int hamCycle(int graph[][])
    {
        path = new int[V];
        for(int i=0;i<V;i++)
            path[i]=-1;
        path[0]=0;
        if(hamCycleUtil(graph,path,1)==false)
        {
            return 0;
        }
        printSolution(path);
        return 1;
    }

    void printSolution(int path[])
    {
        System.out.println("Solution exists: following "+"is one hamiltonin cycle");
        for(int i=0;i<V;i++)
            System.out.println(" "+path[i]+" ");
        System.out.println(" "+path[0]+" ");
    }

    public static void main(String [] args)
    {
        Main ham = new Main();
        int graph1[][]= {{0,1,0,1,0},
                {1,0,1,1,1},
                {0,1,0,0,1},
                {1,1,0,0,1},
                {0,1,1,1,0},
        };

        ham.hamCycle(graph1);
        int graph2[][]= {{0,1,0,1,0},
                {1,0,1,1,1},
                {0,1,0,0,1},
                {1,1,0,0,0},
                {0,1,1,0,0},
        };
        ham.hamCycle(graph2);
    }
}

/*\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


        package lol;
        import java.util.Scanner;
public class Main
{
    static int x[] = new int[10];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,j,x1, x2, edges, n;
        int g[][] = new int[10][10];
        System.out.print("Enter No. of Vertices: ");
        n = sc.nextInt();
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                g[i][j] = 0;
                x[i]=0;
            }
        }

        System.out.print("Enter No. of Edges: ");
        edges = sc.nextInt();
        for(i=1;i<=edges;i++)
        {
            System.out.println("Enter the Edge"+i+": ");
            x1 = sc.nextInt();
            x2 = sc.nextInt();
            g[x1][x2] = 1;
            g[x2][x1] = 1;
        }
        x[1] = 1;
        System.out.println("\nHamiltonian Cycle");
        hcycle(g,n,2);
    }

    public static void nextvalue(int g[][],int n,int k)
    {
        int j;
        while(true)
        {
            x[k] = (x[k] + 1) % (n+1);
            if(x[k] == 0)
                return;
            if(g[x[k-1]][x[k]] == 1)
            {
                for(j=1;j<=k-1;j++)
                {
                    if(x[j] == x[k] )
                        break;
                }
                if(j ==  k)
                {
                    if((k<n) || ((k==n) && (g[x[n]][x[1]] == 1)))
                        return;
                }
            }
        }
    }

    public static void hcycle(int g[][],int n, int k)
    {
        int i;
        while(true)
        {
            nextvalue(g,n,k);
            if(x[k]== 0)
                return;
            if(k==n)
            {
                for(i=1;i<=n;i++)
                    System.out.print(x[i]+"-->");
                System.out.println(x[1]+"\n");
            }
            else
                hcycle(g,n,k+1);
        }
    }
}*/