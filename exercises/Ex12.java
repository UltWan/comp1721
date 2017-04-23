import java.util.HashMap;
import java.util.Map;

public class Ex12 {
	
  public static void main(String[] args) {
  Map<String, String> phoneNumbers = new HashMap<>();
		
  // Add some phone numbers.
  phoneNumbers.put("Jim", "07769055150");
  phoneNumbers.put("Kevin", "07783566123");
  phoneNumbers.put("Stanley", "07773457994");
  phoneNumbers.put("Pam", "07851022169");
		
  System.out.println("Total phone numbers: " + phoneNumbers.size());
		
  // Iterate over all phone numbers, using the keySet method.
  for(String key: phoneNumbers.keySet())
  {
    String value = phoneNumbers.get(key);
    System.out.printf("%s: %s", key, value, "\n");
  }
		
  String searchKey = "quit";
  if(phoneNumbers.containsKey(searchKey))
  {
    System.exit(0);
  }
		
  // Clear all values.
  phoneNumbers.clear();
}
}
