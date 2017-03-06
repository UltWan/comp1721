import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents the records of a Met Office weather station.
 *
 * @author Ryan Wan
 */
public class WeatherRecord
{
  private static final Pattern PATTERN = Pattern.compile(
      "^\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)"
  );

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

  public WeatherRecord(String line) {
    Matcher matcher = PATTERN.matcher(line);
    if (matcher.matches()) {
      year = Integer.parseInt(matcher.group(1));
      month = Integer.parseInt(matcher.group(2));
      maxTemp = Double.parseDouble(matcher.group(3));
      minTemp = Double.parseDouble(matcher.group(4));
      frostDays = Integer.parseInt(matcher.group(5));
      rainfall = Double.parseDouble(matcher.group(6));
      sunHours = Double.parseDouble(matcher.group(7));
    }
    else {
      throw new InputMismatchException("invalid record format");
    }
  }

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

  public static void main(String[] args)
    {
    WeatherRecord r = new WeatherRecord    ("1930   1    7.6     1.3      11   137.9    36.3");
    System.out.println(r. getMonthName());
    }
}
