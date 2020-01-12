//kruskal
package lab8;
import java.util.*;
class Main
{
    int parent[] = new int[10];
    int find(int m)
    {
        int p;
        p=m;
        while(parent[p]!=0)
            p=parent[p];
        return p;
    }
    void union(int i, int j)
    {
        if(i<j)
            parent[i]=j;
        else
            parent[j]=i;
    }

    void krul(int a[][], int n)
    {
        int min,u=0,v=0,sum=0,i,j,k=0;
        while(k<n-1) {
            min=99;
            for(i=1;i<=n;i++)
                for(j=1;j<=n;j++)
                    if(a[i][j]<min && i!=j)
                    {
                        min=a[i][j];
                        u=i;
                        v=j;
                    }
            i=find(u);
            j=find(v);
            if(i!=j)
            {
                union(i,j);
                System.out.println("("+u+","+v+")"+"="+a[u][v]);
                sum=sum+a[u][v];
                k++;
            }
            a[u][v]=a[v][u]=99;
        }
        System.out.println("The cost is = "+sum);
    }
    public static void main(String[] args)
    {
        int a[][]= new int[10][10];
        int n,i,j;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the n size");
        n=in.nextInt();
        System.out.println("enter matrix = ");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                a[i][j]=in.nextInt();
        Main k = new Main();
        k.krul(a, n);
        in.close();
    }
}