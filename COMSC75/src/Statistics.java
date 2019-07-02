//Armeet Singh Jatyani
//Statistics
/*
  In this program we prompt the user for prices.
  We keep prompting for prices until they enter -1.
  We then tell them how many items they entered,
  the mean of the prices, and the standard deviation
  of the prices.
 */

//import statements
import java.util.*;

public class Statistics
{
  public static void main(String[] args)
  {
    //initialize our scanner so that we can read input from the user
    Scanner scanner = new Scanner(System.in);
    //initialize a linked list which we will use to store all of our prices
    LinkedList<Double> list = new LinkedList<>();

    int i = 0;
    //this loop will always run until it hits a break statement
    while (true)
    {
      //for the first try we want to ask for the first price
      if (i == 0)
      {
        System.out.print("Enter first price, or -1 to quit: $");
      }
      //for all other times we want to ask for the next price
      else
      {
        System.out.print("Enter next price, or -1 to quit: $");
      }
      //store user input
      double input = scanner.nextDouble();
      //if the user wants to stop break the loop
      if (input == -1)
      {
        break;
      }
      //otherwise add the price to the list
      list.add(input);
      //increment i
      i++;
    }

    //count is the number of prices entered
    int count = i;

    double sum = 0;
    //for every price in the list, add it to sum
    for (double temp : list)
    {
      sum += temp;
    }

    //calculate the average(mean)
    double mean = sum / count;


    double sumSquared = 0;
   	 /*
   	   for every price in the list, find the (difference)^2
   	   and add to differenceSum
   	  */
    for (double temp : list)
    {
      sumSquared += temp * temp;
    }

    //calculate the standard deviation
    double standardDev = Math.sqrt(Math.abs(((count * sumSquared) - (sum * sum)) / ((count - 1) *  (count))));

    System.out.println("Number of items: " + count);

    //if there is no data, we can't calculate statistics
    //if there is only 1 data, we can't calculate statistics
    //otherwise print the # of items, average, and standard deviation
    if (count == 0)
    {
      System.out.println("No data entered. Cannot calculate"
              + " statistics");
    } else if (count == 1)
    {
      System.out.println("Cannot calculate standard deviation"
              + "for one item.");
    } else
    {
      System.out.println("Average price: $" + (Math.round(mean * 100.0)
              / 100.0));
      System.out.println("Standard deviation of prices is: $" + (Math.round
              (standardDev * 100.0) / 100.0));

      //print a blank line
      System.out.println("\n");
    }
  }

}
