public class Date
{
  private int day;
  private Month month;
  private int year;

  class Date(int d, Month m, int y)
  {
    this(d, m, y);
  }

  int getDay()
  {
    return day;
  }

  Month getMonth()
  {
    return month;
  }

  int getYear()
  {
    return year;
  }

  @Override
  public String toString
  {
    return "Date: " + getDay() + " " + getMonth() + " " + getYear();
  }
}
