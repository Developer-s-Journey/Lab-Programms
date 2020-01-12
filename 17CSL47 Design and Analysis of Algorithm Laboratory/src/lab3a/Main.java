package lab3a;
import java.util.*;
class Main
{
    public static void main(String [] args) {
        int a,b,d;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a and b = ");
        a=in.nextInt();
        b=in.nextInt();
        try
        {
            d=a/b;
            System.out.println("Result = " +d);
        }catch(ArithmeticException ae)
        {
            System.out.println("Divide by zero");
        }
    }
}