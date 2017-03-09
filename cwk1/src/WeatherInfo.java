import java.util.*;
import java.io.*;

/**
 * Represents a Met Office weather station.
 *
 * @author Ryan Wan
 */

public class WeatherInfo
{
  public static void main(String[] args)
  {
    /**
     * @Prints message if there is no file selected
     */
    if (args.length == 0)
    {
      System.out.println("Usage: java WeatherInfo <filename>");
      System.exit(1);
    }

    /**
     * @Attempts to print out the following classes from a file
     */
    try
    {
      WeatherStation ws = new WeatherStation(args[0]);
      System.out.println("Name: " + ws.getName());
      System.out.println("Location: " + ws.getLocation());
      System.out.println(ws.getRecordCount() + " months of data available");
      WeatherRecord wr = ws.findSunniestMonth();
      System.out.println("Sunniest month: " + wr.getYear() + " " + wr.getMonthName() + " (" + wr.getSunHours()+" hours)");
      System.out.printf("Mean max temp in August: %.2f deg C\n", ws.meanMaxTemp(8));
    }

    /**
     * @Prints message if the file type is wrong or the file does not exist
     */
    catch (Exception error)
    {
      System.out.println("Error: cannot access input file");
    }
  }
}
