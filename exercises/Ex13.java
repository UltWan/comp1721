import java.util.*;

public class Ex13
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
    System.out.printf("As a string: %s%n", bankAccount1);

    OverdraftAccount overdraftAccount1 = new OverdraftAccount(id, name, 2000);
    overdraftAccount1.setOverdraftLimit(500);
    overdraftAccount1.withdraw(2500);
    System.out.println("\nThe current balance of the account is: £" + overdraftAccount1.getBalance());
    System.out.printf("As a string: %s%n", overdraftAccount1);

    SavingsAccount savingsAccount1 = new SavingsAccount(id, name, 2000);
    savingsAccount1.setInterestRate(5);
    savingsAccount1.applyInterest();
    System.out.println("\nThe current balance of the account is: £" + savingsAccount1.getBalance());
    System.out.printf("As a string: %s%n", savingsAccount1);
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

    BankAccount(int i, String n, int bal)
    {
      id = i;
      name = n;
      balance = bal;
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

    void deposit(int amount)
    {
      if (amount <= 0)
      {
        throw new IllegalArgumentException("Invalid amount");
      }
      else
      {
        balance = balance + amount;
      }
    }

    void withdraw(int amount)
    {
      if (amount < 0 || amount > balance)
      {
        throw new IllegalArgumentException("Invalid amount");
      }
      else
      {
        balance = balance - amount;
      }
    }

    @Override
    public String toString()
    {
      return getClass().getName() + ", ID: " + getID() + ", Name: " + getName() + ", Balance: £" + getBalance();
    }
  }

  class OverdraftAccount extends BankAccount
  {
    int overdraftLimit = 300;

    OverdraftAccount(int id, String name, int bal)
    {
      super (id, name, bal);
    }

    int getOverdraftLimit()
    {
      return overdraftLimit;
    }


    void setOverdraftLimit(int limit)
    {
      if (limit < 0)
      {
        throw new IllegalArgumentException("Invalid overdraft limit");
      }
      else
      {
        overdraftLimit = limit;
      }
    }

    @Override
    void withdraw(int amount)
    {
      if (amount > (balance + overdraftLimit))
      {
        throw new IllegalArgumentException("Invalid withdrawal, exceeds overdraft");
      }
      else
      {
        balance = balance - amount;
      }
    }

    @Override
    public String toString()
    {
      return String.format("%s, %s %s%d", super.toString(), "Overdraft Limit:", "£", getOverdraftLimit());
    }
  }

  class SavingsAccount extends BankAccount
  {
    double interestRate = 1.0;

    SavingsAccount(int id, String name, int bal)
    {
      super (id, name, bal);
    }

    double getInterestRate()
    {
      return interestRate;
    }

    void setInterestRate(double rate)
    {
      if (rate < 0)
      {
        throw new IllegalArgumentException("Invalid interest rate");
      }
      else
      {
        interestRate = rate;
      }
    }

    void applyInterest()
    {
      balance = (int) (balance + balance *(interestRate/100));
    }

    @Override
    public String toString()
    {
      return String.format("%s, %s %.2f%s", super.toString(), "Interest Rate:", getInterestRate(), "%");
    }
  }
