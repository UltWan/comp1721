public class Ex7
{
  public static void main(String[] args)
  {
    BankAccount bankaccount1 = new BankAccount(4, 40);
    System.out.println("Rectangle 1:");
    System.out.println("The width of the rectangle is: " + rectangle1.getWidth());
    System.out.println("The height of the rectangle is: " + rectangle1.getHeight());
    System.out.println("The area of the rectangle is: " + rectangle1.getArea());
    System.out.println("The perimeter of the rectangle is: " + rectangle1.getPerimeter());
    System.out.println("");

    BankAccount bankaccount2 = new BankAccount(3.5, 35.9);
    System.out.println("Rectangle 2:");
    System.out.println("The width of the rectangle is: " + rectangle2.getWidth());
    System.out.println("The height of the rectangle is: " + rectangle2.getHeight());
    System.out.println("The area of the rectangle is: " + rectangle2.getArea());
    System.out.println("The perimeter of the rectangle is: " + rectangle2.getPerimeter());
  }
}

  class BankAccount
  {
    int id;
    String name;
    int balance;

    BankAccount(int i, String n)
    {
      balance = 0;
    }

    BankAccount(int i, String n, int b)
    {
      id = i;
      name = n;
      balance = b;
    }

    int getId()
    {
      return id;
    }

    String getName()
    {
      return String;
    }

    int getBalance()
    {
      return width * height;
    }

    boolean deposit(int amount)
    {
      return;
    }

    boolean withdraw(int amount)
    {
      return;
    }
}
