public class Ex14
{
  public static void main(String[] args)
  {
    Date date1 = new Date(13, Month.MARCH, 2017);
    System.out.println("The date is: " + date1.getDay() + " " + date1.getMonth() + " " + date1.getYear());
    System.out.printf("As a string: %s%n", date1);
  }
}
