import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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


public static void main (String[] args) throws FileNotFoundException
{
  Scanner input = new Scanner(new File(args[0]));

  input.nextLine();

  input.nextLine();

  input.nextLine();

  input.nextLine();

  while (input.hasNextLine()) 
  {
    String line = input.nextLine();
    count++;
    System.out.println(line);
  }

  input.close();
}
}

public String getName
{
  return name;
}

public String getLocation
{
  return Location;
}

public int getRecordCount
{
  return recordCount;
}

public int getRecord
{
  return record;
}

public String findSunniestMonth
{
  return sunniestMonth;
}

public double meanMaxTemp
{
  return maxTemp;
}
