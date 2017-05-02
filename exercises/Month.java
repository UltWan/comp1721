public enum Month
{
  JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPETEMBER, OCTOBER, NOVEMBER, DECEMBER;

  @Override
  public String toString()
  {
    return name().substring(0, 1)
         + name().substring(1).toLowerCase();
  }
}
