import java.util.*;
import java.io.*;

/**
 * Represents a data from a Met Office weather station.
 *
 * @author Ryan Wan
 */

public class WeatherStation
{
  private String name;
  private Location location;
  private WeatherRecord weatherRecord;
  private List<WeatherRecord> wr = new ArrayList<>();

  /**
   * Reads in data from a weather station via text file,
   * skipping the first four lines of the file
   */
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
    }
    input.close();
  }

  /**
   * @return Name of a weather station
   */
  public String getName()
  {
    return name;
  }

  /**
   * @return Location of a weather station
   */
  public Location getLocation()
  {
    return location;
  }

  /**
   * @return Number of total records of a weather station
   */
  public int getRecordCount()
  {
    return wr.size();
  }

  /**
   * @return A single record of a weather station
   */
  public WeatherRecord getRecord(int index)
  {
    return wr.get(index);
  }

  /**
   * @return Sunniest month of a weather station
   */
  public WeatherRecord findSunniestMonth()
  {
    WeatherRecord sunniestMonth = wr.get(0);
  
    for (int count=1; count < wr.size(); count++)
    {
      if (sunniestMonth.getSunHours() < wr.get(count).getSunHours())
      {
        sunniestMonth = wr.get(count);
      }
    }
    return sunniestMonth;
  }

  /**
   * @return Mean max temp of a given month at a weather station
   */
  public double meanMaxTemp(int month)
  {
    int temp = 0;
    double mean = 0;

    for (int count = 0; count < wr.size(); count++)
      {
      if (wr.get(count).getMonth() == month)
        {
        mean = mean + wr.get(count).getMaxTemp();
        temp = temp + 1;
        }
      }
    double finalMean = mean/temp;
    return finalMean;
  }
}
