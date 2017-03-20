// Use Scanner in java.util package
import java.util.Scanner;
public class Ex4
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    // Prompt user to enter values of a, b and c
    System.out.print("Enter value for a: ");
    double a = input.nextInt();
    System.out.print("Enter value for b: ");
    double b = input.nextInt();
    System.out.print("Enter value for c: ");
    double c = input.nextInt();

    // Quadratic equation formula calculations
    double discriminant = Math.sqrt((b*b)-(4*a*c));
    double positiveRoot = (-b + (discriminant))/(2*a);
    double negativeRoot = (-b - (discriminant))/(2*a);

    // If statement gives root(s) depending on the discriminant being postive, negative or zero
    if (discriminant > 0)
    {
      System.out.println("The roots are: " + positiveRoot + " and " + negativeRoot);
    }
    else if (discriminant == 0)
    {
      System.out.println("The root is: " + positiveRoot);
    }
    else
    {
      System.out.println("The equation has no real roots");
    }
  }
}
