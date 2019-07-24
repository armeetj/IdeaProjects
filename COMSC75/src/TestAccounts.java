//Armeet Singh Jatyani
//Inheritance and Polymorphism
/*
	In this program, we prompt the user for 3 coordinate pairs.
	We use the distance between two points formula and Heron's formula
	to find the area of this triangle.
*/

import java.text.DecimalFormat;

public class TestAccounts
{
  public static void main(String[] args)
  {
    //make 5 Account_2 Objects (initialize)
    Account_2[] account2s = new Account_2[5];

    //define and initialize the 5 Account_2 objects with values
    Account_2 account21 = new Account_2(1066, 7500);
    Account_2 savingsAccount2 = new SavingsAccount2(30507, 4500, 0.015);
    Account_2 creditCardAccount21 = new CreditCardAccount2(51782737, 7000, .08, 1000);
    Account_2 creditCardAccount22 = new CreditCardAccount2(629553328, 1500, .075, 5000);
    Account_2 creditCardAccount23 = new CreditCardAccount2(4977201043L, -5000, .07, 10000);

    //add values to array
    account2s[0] = account21;
    account2s[1] = savingsAccount2;
    account2s[2] = creditCardAccount21;
    account2s[3] = creditCardAccount22;
    account2s[4] = creditCardAccount23;

    //for each account, make a deposity, withdraw some money,
    // and then print out the status of that account using the toString method
    for (Account_2 account2 : account2s)
    {
      account2.deposit(2134);
      account2.withdraw(4782);
      System.out.println(account2.toString());
    }
  }
}


class Account_2
{
  //private fields
  private long number;
  private double balance;

  //we will use the DecimalFormatter to format our numbers to two decimal places
  DecimalFormat decimalFormat = new DecimalFormat("#0.00");

  //Constructors
  //this is the default constructor that takes no args
  public Account_2()
  {
    //pass to the constructor with 2 args with 0 and 0
    this(0, 0);
  }

  //Constructor: given 2 args: number and balance, set the fields to these values
  public Account_2(long number, double balance)
  {
    this.number = number;
    this.balance = balance;
  }

  //getters and setters
  public long getNumber()
  {
    return number;
  }

  public double getBalance()
  {
    return balance;
  }

  public void setBalance(double balance)
  {
    this.balance = balance;
  }

  //put money into the account
  public void deposit(double amount)
  {
    balance += amount;
  }

  //remove money from the account
  //if the withdraw amount is too large, don't change the balance
  public void withdraw(double amount)
  {
    if (amount <= balance)
    {
      balance -= amount;
    }
  }

  //return a string with the Account_2 # and Balance
  @Override
  public String toString()
  {
    return ("Account_2 #: " + number + "\nBalance: $" + decimalFormat.format(balance) + "\n");
  }
}

class SavingsAccount2 extends Account_2
{
  //private fields
  private double apr;

  //default constructor
  public SavingsAccount2()
  {
    //call 3 arg constructor
    this(0, 0, 0);
  }

  //3 arg constructor that takes in number, balance, and apr
  public SavingsAccount2(long number, double balance, double apr)
  {
    //call the super(parent class's constructor)
    super(number, balance);
    this.apr = apr;
  }

  //getters and setters
  public double getApr()
  {
    return apr;
  }

  public void setApr(double apr)
  {
    if (apr >= 0)
    {
      this.apr = apr;
    }
  }

  //calculate the interest
  public double calculateInterest()
  {
    return apr * getBalance();
  }

  //return a string
  @Override
  public String toString()
  {
    return (super.toString() + "Interest Rate: " + decimalFormat.format(apr * 100.0) + "%\n" + "Annual Interest: $" + decimalFormat.format(calculateInterest()) + "\n");
  }

}

class CreditCardAccount2 extends Account_2
{
  //private fields
  private double apr;
  private double creditLimit;

  //default constructor
  public CreditCardAccount2()
  {
    //call 4 arg constructor
    this(0, 0, 0,0);
  }

  //4 arg constructor that takes in number, balance, apr, and creditLimit
  public CreditCardAccount2(long number, double balance, double apr, double creditLimit)
  {
    //call the super(parent class's constructor)
    super(number, balance);
    this.apr = apr;
    this.creditLimit = creditLimit;
  }

  //override the withdraw function so you can have negative values
  public void withdraw(double amount)
  {
    if (amount <= getBalance() + creditLimit)
    {
      this.setBalance(getBalance() - amount);
    }
  }

  //calculate the monthly payment
  public double calculatePayment()
  {
    if (this.getBalance() >= 0)
    {
      return 0;
    }else
    {
      return (Math.min(20, (apr / 12.0) * (-getBalance())));
    }
  }

  //return a string with balancei, interest rate, annual interest,
  // credit limit, and monthly payment
  @Override
  public String toString()
  {
    return (super.toString() + "Interest Rate: " + decimalFormat.format(apr * 100.0) + "%\n" + "Credit Limit: $" + decimalFormat.format(creditLimit) + "\n" + "Monthly Payment: $" + decimalFormat.format(calculatePayment()) + "\n");
  }

}