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
      "^^\\yyyy\\mm\\tmax\\tmin\\af\\rain\\sun"
  );

  private int year;
  private int month;
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
  public int getMonthName()
    {
    return month;
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
}
