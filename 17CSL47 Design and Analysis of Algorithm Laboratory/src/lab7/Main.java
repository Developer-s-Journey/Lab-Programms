//dijkstra
package lab7;
import java.util.*;
public class Main
{
    public int distance[] = new int[10];
    public int cost[][] = new int[10][10];
    public void calc(int n, int s)
    {
        int flag[] = new int[10];
        int minpos=1,k,c,minimum,i;
        for(i=1;i<=n;i++) {
            flag[i]=0;
            this.distance[i] = this.cost[i][s];
        }
        c=2;
        while(c<=n)
        {
            minimum=99;
            for(k=1;k<=n;k++) {
                if(this.distance[k]<minimum && flag[k]!=1)
                {
                    minimum=distance[k];
                    minpos=k;
                }
            }
            flag[minpos]=1;
            c++;
            for(k=1;k<=n;k++)
            {
                if(this.distance[minpos]+this.cost[minpos][k]< this.distance[k] && flag[k]!=1)
                    this.distance[k]=this.distance[minpos]+this.cost[minpos][k];
            }
        }
    }

    public static void main(String [] args)
    {
        int nodes,source,i,j;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter nodes = ");
        nodes = in.nextInt();
        Main d = new Main();
        System.out.println("cost matrix =  ");
        for(i=1;i<=nodes;i++)
            for(j=1;j<=nodes;j++) {
                d.cost[i][j] = in.nextInt();
                if(d.cost[i][j]==0)
                    d.cost[i][j]=999;
            }
        System.out.println("Enter source vertex = ");
        source = in.nextInt();
        d.calc(nodes, source);
        System.out.println("The shortest path from source"+source+"to all other vertices ");
        for(i=1;i<=nodes;i++)
            if(i!=source)
                System.out.println("source:"+source+"destinaiton"+i+"min cost"+d.distance[i]);
    }
}