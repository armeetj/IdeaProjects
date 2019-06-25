// Armeet Singh Jatyani
// Selection Structures
/*
   In this program we first prompt the user for two earlier times
   and two later times that form two intervals. We then print out
   the duration in minutes of both the earlier and later intervals.
   Then print out which interval is longer and if the intervals are
   overlapping.
*/

//imports
import java.util.Scanner;

public class Intervals
{
  public static void main(String[] args)
  {
    //constants
    
    //create scanner to read input
    Scanner scanner = new Scanner(System.in);
    //prompt the user for the earlier interval
    System.out.println("Enter earlier start and end time as two" +
                       " 24-hour format times: ");
    //read in the times
    String earlyStart = scanner.next();
    String earlyEnd = scanner.next();
    //prompt the user for the later interval
    System.out.println("Enter later start and end time as two " +
                       " 24-hour format times: ");
    //read in the times
    String lateStart = scanner.next();
    String lateEnd = scanner.next();

    //find the start and end hr and min for both the early and late interval
    // and store it in variables
    int earlyStartHr = Integer.parseInt(earlyStart.substring(0, 2));
    int earlyEndHr = Integer.parseInt(earlyEnd.substring(0, 2));
    int earlyStartMin = Integer.parseInt(earlyStart.substring(2, 4));
    int earlyEndMin= Integer.parseInt(earlyEnd.substring(2, 4));
    int lateStartHr = Integer.parseInt(lateStart.substring(0, 2));
    int lateEndHr = Integer.parseInt(lateEnd.substring(0, 2));
    int lateStartMin = Integer.parseInt(lateStart.substring(2, 4));
    int lateEndMin = Integer.parseInt(lateEnd.substring(2, 4));

    //parse the strings into integers
    //use Math.abs in case the user entered in the ending time first
    int earlyHrs = Math.abs(earlyStartHr - earlyEndHr);
    int earlyMinutes = Math.abs(earlyStartMin - earlyEndMin);
    int lateHrs = Math.abs(lateStartHr - lateEndHr);
    int lateMinutes = Math.abs(lateStartMin - lateEndMin);

    //calculate the total interval times in minutes
    int earlyIntervalMinutes = ((earlyHrs * 60) + earlyMinutes);
    int lateIntervalMinutes = ((lateHrs * 60) + lateMinutes);

    //if the user entered the input correctly (start time, end time) for the intervals...
    if (Integer.parseInt(earlyStart.substring(0,2)) < Integer.parseInt(
            lateStart.substring(0,2)))
    {
      System.out.println("The earlier interval is " + earlyIntervalMinutes +
              " minutes long.");
      System.out.println("The later interval is " + lateIntervalMinutes +
              " minutes long.");
      if(earlyIntervalMinutes == lateIntervalMinutes)
      {
        System.out.println("Both intervals are the same length.");
      }else
      {
        System.out.println((earlyIntervalMinutes > lateIntervalMinutes) ?
                "The earlier interval is longer." :
                "The later interval is longer.");
      }
      //check if the two intervals don't overlap
      if (((earlyEndHr * 60 + earlyEndMin) > lateStartHr * 60 + lateStartHr))
      {
        System.out.println("The intervals don't overlap");
        //otherwise they must overlap
      }else
      {
        System.out.println("The intervals overlap");
      }

    }
    //otherwise if the user gave the input incorrectly (end time, start time)
    //we will swap the earlier and later times
    else {
      System.out.println("The earlier interval is " +
              lateIntervalMinutes + " minutes long.");
      System.out.println("The later interval is " +
              earlyIntervalMinutes + " minutes long.");
      if(earlyIntervalMinutes == lateIntervalMinutes)
      {
        System.out.println("Both intervals are the same length.");
      }else
      {
        System.out.println((earlyIntervalMinutes > lateIntervalMinutes) ?
                "The later interval is longer." :
                "The earlier interval is longer.");
      }
    }
//check if the two intervals don't overlap
    if (    (lateEndHr * 60 + lateEndMin) > (earlyStartHr * 60 + earlyStartMin))
    {
      System.out.println("The intervals don't overlap");
    //otherwise they must overlap
    }else
    {
      System.out.println("The intervals overlap");
    }
  }
}
