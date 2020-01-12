package lab2b;
import java.util.*;
import java.util.StringTokenizer;

public class Main
{
    public String readCustomer()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name and DOB =");
        String str = scanner.next();
        if(!str.startsWith("<")||!str.endsWith(">"))
        {
            System.out.println("Please enter it in proper format ");
            System.exit(0);
        }
        return str;
    }

    public void displayCustomer(String data)
    {
        String st = data.substring(0,data.length());
        StringTokenizer token = new StringTokenizer(st,"<,/>");
        String finalString = null;
        while(token.hasMoreTokens())
        {
            if(finalString == null)
            {
                finalString = token.nextToken();
            }else {
                finalString = finalString + "," + token.nextToken();
            }
        }
        System.out.println("The resultant string is = "+"<"+finalString+">");
    }
    public static void main(String args[]) {
        Main c = new Main();
        String data = c.readCustomer();
        c.displayCustomer(data);
    }
}