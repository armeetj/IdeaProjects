package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class lifeguards
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(new File("lifeguards.in"));
        //to write to the output file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        //number of cows that farmer john hired
        int numOfCows = in.nextInt();

        //needs to fire one, but still maximize the time that the pool is being "covered"

        //the cows array will take care of the start and end times of all cows
        int[][] cows = new int[numOfCows][2];

        //assigning the start and end times
        for (int i = 0; i < numOfCows; i++)
        {
            cows[i][0] = in.nextInt();
            cows[i][1] = in.nextInt();
        }

        //the variable that will keep the original value
        int coveredCopy = 0;
        //the variable that we will be changing
        int covered = 0;
        int answer = 0;

        //make an array of size 1000 (because that is the length of a day) which will represent the times
        //we will call this timeline which will be changing
        int[] timeline = new int[1001];
        //timeline is a temp variable that will hold the value of timeline
        int[] timelineCopy;

        //now we will pretend that none of the cows were fired and increment timeline[i] if a cow is covering that time
        //if there is one cow supervising at the time, the entry in the array will be 1
        //if there are two cows that are supervising at the same time, the entry in the array will be 2
        for (int i = 0; i < numOfCows; i++)
        {
            //for each cow add one to the time spots that it covers
            //for example if a cow covers from time 3-5...
            //the array timeline will be incremented (+1) on indexes 3, 4, and 5

            for (int j = cows[i][0]; j <= cows[i][1] - 1; j++)
            {
                //only if before adding the time, the entry is 0, we will be covering one more square
                if (timeline[j] == 0)
                {
                    covered++;
                }
                //add one to each time interval of one
                timeline[j]++;
            }
        }
        //keep the value of the cows stored in covered
        //we will keep changing coveredCopy and then change it back to covered, which holds the original value
        coveredCopy = covered;
        timelineCopy = timeline.clone();

        //steps:
        //remove cow i
        //then decrement all the entries in the timelineCopy that were in the time range of the cow
        //and keep track of the covered time
        //if this time is larger than the answer than make answer equal this time
        //then make timelineCopy back to the original timeLine
        //timelineCopy is holding the original value
        for (int i = 0; i < numOfCows; i++)
        {
            //for each cow, decrement all the entries of the timelineCopy that were in the time range of the cow
            for (int j = cows[i][0]; j <= cows[i][1] - 1; j++)
            {
                //decrement by 1
                timeline[j]--;
                if (timeline[j] == 0)
                {
                    covered--;
                }
            }
            //update our new answer
            if (covered >= answer)
            {
                answer = covered;
            }
            //now reset the timelineCopy to the timeline
            timeline = timelineCopy.clone();
            //also reset the coveredCopy to the saved covered
            covered = coveredCopy;
        }
        out.print(answer);
        out.close();
    }

    public static void printArray(int[][] array)
    {
        for (int[] i : array)
        {
            for (int j : i)
            {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] array)
    {
        for (int i : array)
        {
            System.out.print(i+ " ");
        }
    }
}
