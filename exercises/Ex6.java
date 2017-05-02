import java.util.Scanner;

public class Ex6
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter text: ");
    String inputString = input.nextLine();

    if (inputString.length() < 10 )
    {
      System.out.println("String is too short: Less 10 characters");
      System.exit(0);
    }

    int charCount = inputString.length();
    System.out.println("\nThere are " + charCount + " characters in the string");
    int i;
    int countA = 0;
    int countE = 0;
    int countI = 0;
    int countO = 0;
    int countU = 0;

    for(i=0; i <= (charCount-1); ++i)
    {
      if (inputString.charAt(i) == 'a' || inputString.charAt(i) == 'A')
      {
        countA++;
      }
      if (inputString.charAt(i) == 'e' || inputString.charAt(i) == 'E')
      {
        countE++;
      }
      if (inputString.charAt(i) == 'i' || inputString.charAt(i) == 'I')
      {
        countI++;
      }
      if (inputString.charAt(i) == 'o'|| inputString.charAt(i) == 'O')
      {
        countO++;
      }
      if (inputString.charAt(i) == 'u' || inputString.charAt(i) == 'U')
      {
        countU++;
      }
    }

    System.out.println("Number of A's: " + countA);
    System.out.println("Number of E's: " + countE);
    System.out.println("Number of I's: " + countI);
    System.out.println("Number of O's: " + countO);
    System.out.println("Number of U's: " + countU);

    int total = countA + countE + countI + countO + countU;
    System.out.println("Total number of vowels: " + total);
  }
}
