// Filename: Welcome.java
import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for first name
        System.out.print("Enter your First Name: ");
        String firstName = input.nextLine();

        // Prompt the user for last name
        System.out.print("Enter your Last Name: ");
        String lastName = input.nextLine();

        // Display the welcome message
        System.out.println("Welcome to the Second Year " + firstName + " " + lastName + "!");

        input.close();
    }
}