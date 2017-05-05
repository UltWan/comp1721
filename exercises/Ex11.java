import java.util.*;
import java.io.*;

public class Ex11
{
  public static void main(String[] args) throws FileNotFoundException
  {
    if (args.length == 0)
    {
      System.out.println("Error: No file specified");
      System.exit(1);
    }

    double total = 0;
    ArrayList<Double> dataList = new ArrayList<>();

    Scanner input = new Scanner(new File(args[0]));

    while (input.hasNext())
    {
      double value = input.nextDouble();
      total = total + value;
      dataList.add(value);
    }
    System.out.printf("The number of values = %d%n", dataList.size());
    System.out.printf("The sum of all values = %.3f%n", total);
    System.out.printf("The mean = %.3f%n", total/dataList.size());
  }
}
