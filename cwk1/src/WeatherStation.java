import java.util.*;
import java.io.*;

/**
 * Represents a Met Office weather station.
 *
 * @author Ryan Wan
 */

public class WeatherStation
{
  private String name;
  private Location location;
  private WeatherRecord weatherRecord;
  private List<WeatherRecord> wr = new LinkedList<>();
  private int recordCount;
  private String sunniestMonth;
  private double maxTemp;
  int count = -4;

  WeatherStation (String filename) throws FileNotFoundException
  {
    Scanner input = new Scanner(new File(filename));

    name = input.nextLine();

    location = new Location(input.nextLine());

    input.nextLine();

    input.nextLine();

    while (input.hasNextLine())
    {
      wr.add(new WeatherRecord(input.nextLine()));
      //String line = input.nextLine();
      count++;
      //System.out.println(line);

    }

    input.close();
  }


  public String getName()
  {
    return name;
  }

  public Location getLocation()
  {
    return location;
  }

  public int getRecordCount()
  {
    return count;
  }

  public WeatherRecord getRecord(int index)
  {
    return wr.get(index);
  }

  public String findSunniestMonth()
  {
    return sunniestMonth;
  }

  public double meanMaxTemp()
  {
    return maxTemp;
  }
}
