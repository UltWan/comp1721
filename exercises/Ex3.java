// Use Scanner in java.util package
import java.util.Scanner;

public class Ex3
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    // Prompt user to enter points
    System.out.println("Enter first x coordinate: ");
    double x1 = input.nextDouble();
    System.out.println("Enter first y coordinate: ");
    double y1 = input.nextDouble();
    System.out.println("Enter next x coordinate: ");
    double x2 = input.nextDouble();
    System.out.println("Enter next y coordinate: ");
    double y2 = input.nextDouble();

    double xTotal = (x2-x1)*(x2-x1);
    double yTotal = (y2-y1)*(y2-y1);
    double overallTotal = xTotal + yTotal;
    double distance = Math.sqrt(overallTotal);

    // Display converted distance
    System.out.println("The distance is: " + distance);
  }
}
