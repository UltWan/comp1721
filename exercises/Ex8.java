import java.util.Scanner;

public class Ex8
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter ID: ");
    int id = input.nextInt();
    System.out.println("Enter name: ");
    String name = input.next();

    BankAccount bankAccount1 = new BankAccount(id, name, 20000);
    bankAccount1.withdraw(2500);
    bankAccount1.deposit(3000);

    System.out.println("\nThe current balance of the account is: £" + bankAccount1.getBalance());
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

    int getID()
    {
      return id;
    }

    String getName()
    {
      return name;
    }

    int getBalance()
    {
      return balance;
    }

    boolean deposit(int amount)
    {
      if (amount > 0)
      {
        balance = balance + amount;
        return true;
      }
      else
      {
        return false;
      }
    }

    boolean withdraw(int amount)
    {
      if (amount > 0 && amount <= balance)
      {
        balance = balance - amount;
        return true;
      }
      else
      {
        return false;
      }
    }
  }
