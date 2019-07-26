//Armeet Singh Jatyani
//Files and Exceptions
/*
  In this program we have some accounts with initial conditions found in
  accounts.dat. We then prompt the user to enter in their ATM number so they
  can withdraw and deposit amounts. This program will also be able to throw/
  handle errors.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer
{
  //initialize the scanner, accounts ArrayList, and formatter
  static Scanner scanner;
  static ArrayList<Account> accounts;
  static DecimalFormat formatter = new DecimalFormat("#0.00");

  public static void main(String[] args) throws IOException
  {
    try
    {
      //declare scanner to read input from accounts.dat
      scanner = new Scanner(new File("C:\\Users\\singh\\" +
              "Projects\\IdeaProjects\\COMSC75\\src\\accounts.dat"));

      //make the arraylist that holds the valid accounts
      accounts = new ArrayList<>();

      //read the input
      while(scanner.hasNext())
      {
        String rawString = scanner.nextLine();
        String[] parsedString = rawString.split(":");

        //make an account and add the account to our arraylist
        Account newAccount = new Account(Integer.parseInt(parsedString[0]),
                parsedString[1], Double.parseDouble(parsedString[2]));
        accounts.add(newAccount);
      }

      //now change the scanner so we can read input from the user
      scanner = new Scanner(System.in);

      //prompt user for id
      while (true)
      {
        int accountNumber = promptAccountNumber();

        if (accountNumber == -3)
        {
          break;
        }

        //if the number is invalid or isn't a number ask again
        if (accountNumber < 0)
        {
          continue;
        }else
        {
          //otherwise prompt further
          System.out.println("Hello, " + accounts.get(accountNumber).getName());
          showBalance(accountNumber);
          promptChoice(accountNumber);
        }
      }

      //now copy the new information into the file
      //declare printWriter so that we can update the .dat file after user finishes
      PrintWriter printWriter = new PrintWriter(new File("C:\\Users\\singh\\" +
              "Projects\\IdeaProjects\\COMSC75\\src\\accounts.dat"));
      //write data
      for(int i = 0; i < accounts.size(); i++)
      {
        printWriter.println(accounts.get(i).toString());
      }
      //close the file
      printWriter.close();
    } catch (FileNotFoundException exception)
    {
      //return the appropriate reason an error was thrown
      //in this case the file wasn't found
      System.out.println("File \"accounts.dat\" not found...");
    }
  }

  //this method will find the index of an account in the list
  public static int findIndex(ArrayList<Account> accountList,
                              int accountNumber)
  {
    for (int i = 0; i < accountList.size(); i++)
    {
      //if we found the account index, return it
      if (accountList.get(i).getAcctNumber() == accountNumber)
      {
        return i;
      }
    }
    //if the number is never found, return -1
    //this means the account number is invalid
    return -1;
  }

  //-1 not a number
  //-2 unknown acct number
  //-3 want to stop the program
  //x index of the account
  public static int promptAccountNumber()
  {
    System.out.print("Enter your account number: ");
    String accountNumber = scanner.nextLine();

    int index = -1;
    //user wants to stop
    if (accountNumber.equals("stop"))
    {
      return -3;
    }

    //check if the input is a valid number
    if (isNumeric(accountNumber))
    {
      index = findIndex(accounts, Integer.parseInt(accountNumber));
      if (index == -1)
      {
        System.out.println("Unknown account number");
        return -2;
      }
    } else
    {
      System.out.println(accountNumber + " is not a number");
      return -1;
    }
    return index;
  }

  //this method will go prompt the user to deposit and will handle all errors
  public static void promptDeposit(int index)
  {
    System.out.print("Enter amount to deposit: $");
    String amount = scanner.nextLine();

    //not a number
    if (!isNumeric(amount))
    {
      System.out.println(amount + " is not a number");
    } else if (Double.parseDouble(amount) < 0)
    {
      //can't deposit neg amounts
      System.out.println("You cannot deposit a negative amount");
    } else
    {
      //otherwise make the deposit and show the balance for the account
      accounts.get(index).deposit(Double.parseDouble(amount));
      showBalance(index);
    }
  }

  //-1 not a number
  //-2 negative
  //-3 too big withdrawal
  //0 successful withdraw
  public static void promptWithdraw(int index)
  {
    System.out.print("Enter amount to withdraw: $");
    String amount = scanner.nextLine();

    if (!isNumeric(amount))
    {
      //not a number
      System.out.println(amount + " is not a number");
    } else if (Double.parseDouble(amount) < 0)
    {
      //can't withdraw neg #
      System.out.println("You cannot withdraw a negative amount");
    } else if (Double.parseDouble(amount) > accounts.get(index).getBalance())
    {
      //can't withdraw more that what you have in the bank
      System.out.println("You can't withdraw more than you have");
    }else
    {
      accounts.get(index).withdraw(Double.parseDouble(amount));
      showBalance(index);
    }
  }

  public static void promptChoice(int index)
  {
    //goes through and asks the user if they would like to
    //deposit, withdraw, or finish
    while(true)
    {
      System.out.print("D)eposit, W)ithdraw, or F)inish? ");
      String inputString = scanner.nextLine();
      char input = inputString.charAt(0);
      int choice = -1;

      if (input == 68 || input == 100)
      {
        //user wants to deposit
        promptDeposit(index);
      } else if (input == 87 || input == 119)
      {
        //user wants to withdraw
        promptWithdraw(index);
      } else if (input == 70 || input == 102)
      {
        //user wants to finish
        System.out.println("Goodbye, " + accounts.get(index).getName() + "\n");
        break;
      }
    }
  }

  //prints the balance of the account given index
  public static void showBalance(int index)
  {
    System.out.println("Your current balance is $" + formatter.format(accounts.get(index).getBalance()));
  }

  //this method will return if a string is numeric or not
  public static boolean isNumeric(String input)
  {
    try
    {
      //if this throws an error, it will go to the catch block and return false
      Double.parseDouble(input);
      return true;
    } catch (Exception e)
    {
      return false;
    }
  }
}

class Account
{
  //private fields(attributes)
  private int acctNumber;
  private String name;
  private double balance;

  //getters and setters for the private fields
  public int getAcctNumber()
  {
    return acctNumber;
  }

  public String getName()
  {
    return name;
  }

  public double getBalance()
  {
    return balance;
  }

  public void setBalance(double balance)
  {
    this.balance = balance;
  }

  //constructor with 3 arguments
  public Account(int acctNumber, String name, double balance)
  {
    this.acctNumber = acctNumber;
    this.name = name;
    this.balance = balance;
  }

  //return a string with the account ID, name, and balance
  @Override
  public String toString()
  {
    return (acctNumber + ":" + name + ":" + balance);
  }

  //deposit money into the account
  public void deposit(double amount)
  {
    if (amount >= 0)
    {
      balance += amount;
    }
  }

  //withdraw money from the account
  public void withdraw(double amount)
  {
    if (amount >= 0 && amount <= balance)
    {
      balance -= amount;
    }
  }
}
