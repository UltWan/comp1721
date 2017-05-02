public class Date
{
  private int day;
  private Month month;
  private int year;

  Date(int day, Month month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
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
  public String toString()
  {
    return "Date: " + getDay() + " " + getMonth() + " " + getYear();
  }
}
