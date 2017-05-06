import java.util.*;

public class Ex15
{
  public static void main(String[] args)
  {
    List<Date> dates = new ArrayList<>();

    dates.add(new Date(13, Month.MARCH, 2017));
    dates.add(new Date(29, Month.SEPTEMBER, 2017));
    dates.add(new Date(28, Month.MAY, 2017));
    dates.add(new Date(11, Month.NOVEMBER, 2017));
    dates.add(new Date(05, Month.JUNE, 2017));

    System.out.println("List of dates: ");

    for (Date d: dates)
    {
      System.out.println(d);
    }

    Collections.sort(dates);

    System.out.println("\nSorted list of dates: ");

    for (Date d: dates)
    {
      System.out.println(d);
    }
  }
}
