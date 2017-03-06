import java.util.InputMismatchException;


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
   * Creates a Location object from the data supplied in a Met Office
   * weather station dataset.
   *
   * <p>An example of the required format is shown here:</p>
   * <pre>
   * Location 433900E 387200N, Lat 53.381 Lon -1.490, 131 metres amsl
   * </pre>
   *
   * @param line Line of text containing location data
   */


  /**
   * @return Year of the WeatherRecord
   */
  public int getYear()
    {
    return year;
    }

  /**
   * @return Month of the WeatherRecord
   */
  public int getMonth()
    {
    return month;
    }

  /**
   * @return Month of the WeatherRecord
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
    return monthName;
    }

  /**
   * @return MaxTemp of the WeatherRecord in deg C
   */
  public double getMaxTemp()
    {
    return maxTemp;
    }

  /**
   * @return MinTemp of the WeatherRecord in deg C
   */
  public double getMinTemp()
    {
    return minTemp;
    }

  /**
   * @return FrostDays of the WeatherRecord in days
   */
  public int getFrostDays()
    {
    return frostDays;
    }

  /**
   * @return Rainfall of the WeatherRecord in mm
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

  public WeatherRecord(String input) {

  String line [] = input.trim().split("\\s+");

    if (line.length != 7) {
      throw new InputMismatchException("invalid record format");
}
      year = Integer.parseInt(line[0]);
      month = Integer.parseInt(line[1]);
      maxTemp = Double.parseDouble(line[2]);
      minTemp = Double.parseDouble(line[3]);
      frostDays = Integer.parseInt(line[4]);
      rainfall = Double.parseDouble(line[5]);
      sunHours = Double.parseDouble(line[6]);




    
  }
  public static void main(String[] args)
    {
    WeatherRecord r = new WeatherRecord    ("1930   1    7.6     1.3      11   137.9    36.3");
    System.out.println(r.getMonthName());
    }
}
