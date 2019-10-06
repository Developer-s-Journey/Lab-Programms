/** Create a Java class called Studentwith the following details as variables within it.
(i) USN
(ii) Name
(iii) Branch
(iv) Phone
Write a Java program to create nStudent objects and print the USN, Name,
Branch, and Phoneof these objects with suitable headings. */

package student;
import java.util.*;
public class Student {
    String USN;
    String name;
    String phone;
    String branch;

    void getDetails() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the student USN:\t");
        USN = in.nextLine();
        System.out.println("Enter student name:\t");
        name = in.nextLine();
        System.out.println("Enter the branch:\t");
        branch = in.nextLine();
        System.out.println("Enter the phone no.:\t");
        phone = in.nextLine();
    }

    void putDetails() {
        System.out.println("\nUSN:\t" + USN + "\nName:\t" + name + "\nBranch:\t" + branch + "\nPhone no.:\t" + phone);
    }
    public static void main(String[] args) {
        System.out.println("\nEnter no. of students:\t");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Student a[] = new Student[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Student();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i+1));
            a[i].getDetails();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("\nThe details of student" + (i+1) + ":\t");
            a[i].putDetails();
        }
    }
}
