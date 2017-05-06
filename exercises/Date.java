public class Date implements Comparable<Date>
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
    return getDay() + " " + getMonth() + " " + getYear();
  }

  public int compareTo(Date other)
  {
    int comp = Integer.compare(year, other.year);
    if (comp == 0)
    {
      comp = Integer.compare(month.ordinal(), other.month.ordinal());
      if (comp == 0)
      {
        comp = Integer.compare(day, other.day);
      }
    }
    return comp;
  }
}
