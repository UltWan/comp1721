// Use Scanner in java.util package
import java.util.Scanner;
public class Ex5
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    System.out.println("Celcius	Fahrenheit");

    // Celcius to Fahrenheit conversion
    for (int celcius = 0; celcius <= 100; celcius +=2)
    {
      double fahrenheit= (1.8*celcius)+32;
      System.out.println(celcius + "	");
      System.out.printf(fahrenheit%.2f);
    }
  }
}
