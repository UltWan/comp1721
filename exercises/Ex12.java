import java.util.*;

public class Ex12
{	
  public static void main(String[] args)
  {
    Map<String, String> phoneNumbers = new HashMap<>();
		
    // Add some phone numbers.
    phoneNumbers.put("Jim", "07769055150");
    phoneNumbers.put("Daryl", "07783566123");
    phoneNumbers.put("Stanley", "07773457994");
    phoneNumbers.put("Pam", "07851022169");
		
    System.out.println("Total phone numbers: " + phoneNumbers.size());

    // Iterate over all phone numbers, using the keySet method.
    for(String key: phoneNumbers.keySet())
    {
      String value = phoneNumbers.get(key);
    }

    while(true)
    {
      Scanner input = new Scanner(System.in);

      System.out.printf("\nEnter name: ");
      String name = input.next();

      if(name.equals("quit"))
      {
          System.out.println("Exiting phonebook");
          phoneNumbers.clear();
          System.exit(0);
      }

      if(phoneNumbers.get(name) == null) 
      {
        System.out.println("Error: Name " + name + " not found");
      }

      else 
      {
        System.out.println(name + ": " + phoneNumbers.get(name));
      }
    }
  }
}
