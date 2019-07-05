package Bronze;

import java.io.*;
import java.util.Scanner;

public class measurement
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("measurement.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        //start by taking in the input
        //int n is the number of entries
        int n = scanner.nextInt();
        //we will split the input into 3 arrays
        //each line has a day number, cow name, and change in milk
        //the first array is the day number
        int[] day = new int[n];
        //the second array is the name of the cow
        String[] cow = new String[n];
        //the third array is the change in the milk
        int[] change = new int[n];

        //read in the input
        for(int i = 0; i < n; i++)
        {
            day[i] = scanner.nextInt();
            cow[i] = scanner.next();
            change[i] = scanner.nextInt();
        }

        //the current amount of milk that each cow has
        int bessieMilk, elsieMilk, mildredMilk;
        bessieMilk = 7;
        elsieMilk = 7;
        mildredMilk = 7;

        //a cow's value is true if it is winning
        boolean bessieWin, elsieWin, mildredWin;
        bessieWin = true;
        elsieWin = true;
        mildredWin = true;

        int answer = 0;

        //start from day 1 to 100
        for (int currentDay = 1; currentDay <= 100; currentDay++)
        {
            for (int i = 0; i < n; i++)
            {
                if (day[i] == currentDay)
                {
                    //a change was made on this day
                    //increment this cow's stuff
                    if(cow[i].equals("Bessie"))
                    {
                        bessieMilk += change[i];
                    }else if(cow[i].equals("Elsie"))
                    {
                        elsieMilk += change[i];
                    }else if(cow[i].equals("Mildred"))
                    {
                        mildredMilk += change[i];
                    }
                }
            }

            //now that all the cows on that day are incremented
            //figure out if there was any leaderboard Change
            //figure out the max amount of milk produced
            int maxMilkProduced = Math.max(bessieMilk, Math.max(elsieMilk, mildredMilk));
            boolean bessieWinNext = (bessieMilk == maxMilkProduced);
            boolean elsieWinNext = (elsieMilk == maxMilkProduced);
            boolean mildredWinNext = (mildredMilk == maxMilkProduced);

            if (bessieWin != bessieWinNext || elsieWin != elsieWinNext || mildredWin != mildredWinNext)
            {
                //there has been a change in the leaderboard
                answer++;
            }

            //update the variables that designate the winning cows
            bessieWin = bessieWinNext;
            elsieWin = elsieWinNext;
            mildredWin = mildredWinNext;

        }

        printWriter.print(answer);
        printWriter.close();

    }

}
