import java.util.*;
import java.io.*;

public class Ex11
{
  private double numbers;

  public static void main (String[] args) throws FileNotFoundException
  {
    ArrayList<Double> list = new ArrayList<Double>();

    Scanner input = new Scanner(new File(args[0]));

    while (input.hasNext())
    {
      list.add(new ArrayList(input.next()));
    }
    input.close();
  }

  double getNumbers();
  {
    return numbers;
  }

  double mean()
  {
    double mean = 0;

    for (double count = 0; count < list.size(); count++)
      {
        mean += list.get(count).getNumbers();
      }
    double finalMean = mean/list.size();
    return finalMean;
  }
}
