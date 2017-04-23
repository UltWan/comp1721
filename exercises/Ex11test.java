import java.util.*;
import java.io.*;

public class Ex11test
{
  private double numbers;

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    Scanner scan = new Scanner("data.txt");
    while(scan.hasNextLine()){
      list.add(scan.nextLine());
    }
    scan.close();
}

  public double getNumbers();
  {
    return numbers;
  }

  public double mean()
  {
    double mean = 0;

    for (int count = 0; count < list.size(); count++)
      {
      mean += list.get(count).getNumbers();
      }
    double finalMean = mean/list.size;
    return finalMean;
  }
}
