import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Ex10
{
  public static void main(String[] args) throws IOException
  {
    FileReader reader = new FileReader("integers.txt");

    int[] values = new int[11];
    int i = 0;

    System.out.println("Array: " + Arrays.toString(values));

    try
    {
      Scanner input = new Scanner(reader);

      while(input.hasNextInt())
      {
        values[i] = input.nextInt();
        i++;
      }
      input.close();
    }

    catch(Exception error)
    {
      error.printStackTrace();
    }

    System.out.println("Textfile values: " + Arrays.toString(values));

    Arrays.sort(values);
    System.out.println("Sorted values: " + Arrays.toString(values));
  }
}
