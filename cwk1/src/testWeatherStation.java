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


public WeatherStation (String[] args) throws FileNotFoundException
{

  Scanner input = new Scanner(new File(args[0]));

  name=input.nextLine();

  location = new Location(input.nextLine());

  input.nextLine();

  input.nextLine();

  while (input.hasNextLine()) 
  {
    String line = input.nextLine();
    System.out.println(line);
  }

  input.close();
}
}
