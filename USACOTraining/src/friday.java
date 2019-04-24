//package Section1_2;

/*
ID: xarmeet1
LANG: JAVA
TASK: friday
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * author: Armeet Singh Jatyani
 * 1-1-19 (New Year!, just got back from Thailand!)
 * Section 1_2: friday
 */
public class friday
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("friday.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        //n years interval
        int n = scanner.nextInt();

        //normal months
        int[] months = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapmonths = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //frequencies[n] is the number of times the 13th of each month happens on that day
        //frequencies[0] is the number of times the 13th of each month lands on a Monday
        //1 -> Tuesday, 2 -> Wednesday...
        int[] frequencies = new int[7];

        //the total number of days from the start of the year
        int totalDays = 0;
        //start year and end years
        int start , end = 1900+n-1;

        //run through all the years
        for (start = 1900; start <= end; start++)
        {
            //run through all the months
            for (int month = 0; month < 12; month++)
            {
                int day = (totalDays + 12) % 7;
                frequencies[day]++;

                if (isLeap(start))
                {
                    totalDays += leapmonths[month];
                } else
                {
                    totalDays += months[month];
                }
            }
        }

        printWriter.print(frequencies[5]);
        printWriter.print(' ');
        printWriter.print(frequencies[6]);
        printWriter.print(' ');
        printWriter.print(frequencies[0]);
        printWriter.print(' ');
        printWriter.print(frequencies[1]);
        printWriter.print(' ');
        printWriter.print(frequencies[2]);
        printWriter.print(' ');
        printWriter.print(frequencies[3]);
        printWriter.print(' ');
        printWriter.println(frequencies[4]);
        printWriter.close();

    }

    //checks if the given year is a leap year
    public static boolean isLeap(int year)
    {
        if (year % 100 == 0)
        {
            //check if it is a century
            if (year % 400 == 0)
            {
                return true;
            }else
            {
                return false;
            }
        }else
        {
            if (year % 4 == 0)
            {
                return true;
            }else
            {
                return false;
            }
        }
    }

}
