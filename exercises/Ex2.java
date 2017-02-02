// Use Scanner in java.util package
import java.util.Scanner;
public class Ex2
{
    public static void main(String[] args)
    {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.print("Enter number of minutes: ");

        // Declare variables
        int minutes = input.nextInt();
        int days = minutes / 1440;
        int years = minutes / 525600;

        // Display years and days
        System.out.println("The number of years and days are: " + years + " year(s) or " + days + " day(s).");
    }
}
