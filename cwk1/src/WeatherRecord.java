import java.util.*;
import java.io.*;

/**
 * Represents the records of a Met Office weather station.
 *
 * @author Ryan Wan
 */
public class WeatherRecord
{
  private int year;
  private int month;
  private String monthName;
  private double maxTemp;
  private double minTemp;
  private int frostDays;
  private double rainfall;
  private double sunHours;

  /**
   * @return Year of a weather record
   */
  public int getYear()
  {
    return year;
  }

  /**
   * @return Month of a weather record
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * @return Month name of a weather record
   */
  public String getMonthName()
  {
    if (month == 1)
        {
        monthName = ("January");
        }

    if (month == 2)
        {
        monthName = ("February");
        }

    if (month == 3)
        {
        monthName = ("March");
        }

    if (month == 4)
        {
        monthName = ("April");
        }

    if (month == 5)
        {
        monthName = ("May");
        }

    if (month == 6)
        {
        monthName = ("June");
        }

    if (month == 7)
        {
        monthName = ("July");
        }

    if (month == 8)
        {
        monthName = ("August");
        }

    if (month == 9)
        {
        monthName = ("September");
        }

    if (month == 10)
        {
        monthName = ("October");
        }

    if (month == 11)
        {
        monthName = ("November");
        }

    if (month == 12)
        {
        monthName = ("December");
        }
    if (month > 12)
        {
        monthName = ("Integer does not correspond to a month");
        }
    return monthName;
  }

  /**
   * @return MaxTemp of a weather record in deg C
   */
  public double getMaxTemp()
  {
    return maxTemp;
  }

  /**
   * @return MinTemp of a weather record in deg C
   */
  public double getMinTemp()
  {
    return minTemp;
  }

  /**
   * @return FrostDays of a weather record in days
   */
  public int getFrostDays()
  {
    return frostDays;
  }

  /**
   * @return Rainfall of the weather record in mm
   */
  public double getRainfall()
  {
    return rainfall;
  }

  /**
   * @return SunHours of the WeatherRecord in hours
   */
  public double getSunHours()
  {
    return sunHours;
  }

  /**
   * Checks to make sure that the data being read in is in 
   * the correct order and format.
   *
   * <p>An example of the required format is shown here:</p>
   * <pre>
   *    1930   1    8.1     2.4       6   120.5    54.2
   * </pre>
   *
   * @param line Line of text containing location data
   */
  public WeatherRecord(String input)
  {
    String line [] = input.trim().split("\\s+");

    if (line.length != 7) 
    {
      throw new InputMismatchException("Invalid record format");
    }

    year = Integer.parseInt(line[0]);
    month = Integer.parseInt(line[1]);
    maxTemp = Double.parseDouble(line[2]);
    minTemp = Double.parseDouble(line[3]);
    frostDays = Integer.parseInt(line[4]);
    rainfall = Double.parseDouble(line[5]);
    sunHours = Double.parseDouble(line[6]);
  }
}
