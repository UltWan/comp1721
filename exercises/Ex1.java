// Use Scanner in java.util package
import java.util.Scanner;
public class Ex1
{
	public static void main(String[] args)
	{
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt user to enter a number
		System.out.print("Enter number of miles: ");

		// Declare variables
		double miles = input.nextDouble();
		double kilometres = miles * 1.6;

		// Display converted kilometres
		System.out.println("Number of kilometeres is: " + kilometres);
	}
}
