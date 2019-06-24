//Armeet Singh Jatyani
//Selection Structures
/*
  In this program, we prompt the user to give us the weight of
  a package and then return the cost of shipping. If the weight
  is negative or equal to 0 or it is greater than 20 pounds, we
  say that we can't ship the package.
 */

//explicit imports
import java.util.Scanner;

public class Shipping
{
  public static void main(String[] args)
  {
    //initialize the scanner to read input
    Scanner scanner = new Scanner(System.in);

    //prompt the user for input
    System.out.print("Enter the weight of the package in pounds: ");
    //store the weight entered by the user
    double userWeight = scanner.nextDouble();

    //find the weight group and print the price
    if (userWeight > 20)
    {
      System.out.println("The package cannot be shipped.");
    } else if (userWeight > 10)
    {
      System.out.println("Cost: $10.50");
    }  else if (userWeight > 3)
    {
      System.out.println("Cost: $8.50");
    } else if (userWeight > 1)
    {
      System.out.println("Cost: $5.50");
    } else if (userWeight > 0)
    {
      System.out.println("Cost: $3.50");
    } else if (userWeight < 0)
    {
      System.out.println("Invalid Input");
    }
  }
}
