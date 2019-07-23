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
    //make 5 Account Objects (initialize)
    Account[] accounts = new Account[5];

    //define and initialize the 5 Account objects with values
    Account account1 = new Account(1066, 7500);
    Account savingsAccount = new SavingsAccount(30507, 4500, 0.015);
    Account creditCardAccount1 = new CreditCardAccount(51782737, 7000, .08, 1000);
    Account creditCardAccount2 = new CreditCardAccount(629553328, 1500, .075, 5000);
    Account creditCardAccount3 = new CreditCardAccount(4977201043L, -5000, .07, 10000);

    //add values to array
    accounts[0] = account1;
    accounts[1] = savingsAccount;
    accounts[2] = creditCardAccount1;
    accounts[3] = creditCardAccount2;
    accounts[4] = creditCardAccount3;

    //for each account, make a deposity, withdraw some money,
    // and then print out the status of that account using the toString method
    for (Account account : accounts)
    {
      account.deposit(2134);
      account.withdraw(4782);
      System.out.println(account.toString());
    }
  }
}


class Account
{
  //private fields
  private long number;
  private double balance;

  //we will use the DecimalFormatter to format our numbers to two decimal places
  DecimalFormat decimalFormat = new DecimalFormat("#0.00");

  //Constructors
  //this is the default constructor that takes no args
  public Account()
  {
    //pass to the constructor with 2 args with 0 and 0
    this(0, 0);
  }

  //Constructor: given 2 args: number and balance, set the fields to these values
  public Account(long number, double balance)
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

  //return a string with the Account # and Balance
  @Override
  public String toString()
  {
    return ("Account #: " + number + "\nBalance: $" + decimalFormat.format(balance) + "\n");
  }
}

class SavingsAccount extends Account
{
  //private fields
  private double apr;

  //default constructor
  public SavingsAccount()
  {
    //call 3 arg constructor
    this(0, 0, 0);
  }

  //3 arg constructor that takes in number, balance, and apr
  public SavingsAccount(long number, double balance, double apr)
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

class CreditCardAccount extends Account
{
  //private fields
  private double apr;
  private double creditLimit;

  //default constructor
  public CreditCardAccount()
  {
    //call 4 arg constructor
    this(0, 0, 0,0);
  }

  //4 arg constructor that takes in number, balance, apr, and creditLimit
  public CreditCardAccount(long number, double balance, double apr, double creditLimit)
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