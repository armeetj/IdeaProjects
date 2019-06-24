// Armeet Singh Jatyani
// Selection Structures
/*
   In this program we first prompt the user for two earlier times
   and two later times. We then
*/

//import
import java.util.Scanner;

public class Intervals
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    //prompt the user for input
    System.out.println("Enter earlier start and end time as two" +
                       " 24-hour format times: ");
    //read in the times
    String earlyStart = scanner.next();
    String earlyEnd = scanner.next();

    System.out.println("Enter later start and end time as two " +
                       " 24-hour format times: ");
    //read in the times
    String lateStart = scanner.next();
    String lateEnd = scanner.next();

    int earlyStartHr = Integer.parseInt(earlyStart.substring(0, 2));
    int earlyEndHr = Integer.parseInt(earlyEnd.substring(0, 2));
    int earlyStartMin = Integer.parseInt(earlyStart.substring(2, 4));
    int earlyEndMin= Integer.parseInt(earlyEnd.substring(2, 4));
    int lateStartHr = Integer.parseInt(lateStart.substring(0, 2));
    int lateEndHr = Integer.parseInt(lateEnd.substring(0, 2));
    int lateStartMin = Integer.parseInt(lateStart.substring(2, 4));
    int lateEndMin = Integer.parseInt(lateEnd.substring(2, 4));

    //parse the strings into integers
    int earlyHrs = Math.abs(earlyStartHr - earlyEndHr);
    int earlyMinutes = Math.abs(earlyStartMin - earlyEndMin);
    int lateHrs = Math.abs(lateStartHr - lateEndHr);
    int lateMinutes = Math.abs(lateStartMin - lateEndMin);

    //calculate the total interval times in minutes
    int earlyIntervalMinutes = ((earlyHrs * 60) + earlyMinutes);
    int lateIntervalMinutes = ((lateHrs * 60) + lateMinutes);

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
    } else {
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

    if (((earlyStartHr * 60 + earlyStartMin) > lateEndHr * 60 + lateEndMin)
      || ((lateEndHr * 60 + lateEndMin) < (earlyStartHr * 60 + earlyStartMin)))
    {
      System.out.println("The intervals don't overlap");

    }else
    {
      System.out.println("The intervals overlap");

    }
  }


}
