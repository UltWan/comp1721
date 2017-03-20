import java.util.ArrayList;

public class Ex11
{
  private double numbers;
  private List<data> d = new ArrayList<>();

  public static void main (String[] args) throws FileNotFoundException
  {
    Scanner input = new Scanner(new File(args[0]));

    while (input.hasNextLine())
    {
      d.add(new data(input.nextLine()));
    }
    input.close();
  }

  public double getNumbers();
  {
    return numbers;
  }

  public double mean()
  {
    double mean = 0;

    for (int count = 0; count < d.size(); count++)
      {
      mean += d.get(count).getNumbers();
      }
    double finalMean = mean/d.size;
    return finalMean;
  }
}
