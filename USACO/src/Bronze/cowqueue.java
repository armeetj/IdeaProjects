package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class cowqueue
{
    public static void main(String[] args) throws Exception
    {
        //enter time
        int[] enter = new int[100];

        //how long it takes to process a cow
        int[] duration = new int[100];

        //a boolean that marks if a cow has been processed or not
        boolean[] processed = new boolean[100];

        //the variable where we store the answer, totalTime
        int totalTime = 0;

        //take input
        Scanner scanner = new Scanner(new File("cowqueue.in"));
        //write output
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

        //store numOfCows
        int numOfCows = scanner.nextInt();
        //loop over the cows
        for(int i = 0; i<numOfCows;i++)
        {
            //make the array entry at i to be the nth cow's cows enter time
            enter[i] = scanner.nextInt();

            //make the array entry at i to be the nth cow's duration
            duration[i] = scanner.nextInt();
        }

        int nextAvailableTime = 0;
        int nextToEnter;
        for(int j = 0;j<numOfCows;j++)
        {
            nextToEnter = -1;
            for (int k = 0; k < numOfCows; k++)
            {
                if (!processed[k] && (nextToEnter == -1 || enter[k] < enter[nextToEnter]))
                {
                    nextToEnter = k;
                }
            }

            //process the cow and mark it to be processed
            processed[nextToEnter]= true;
            if (enter[nextToEnter] > nextAvailableTime)
            {
                nextAvailableTime = enter[nextToEnter] + duration[nextToEnter];
            }else
            {
                nextAvailableTime = nextAvailableTime + duration[nextToEnter];

            }
        }
        totalTime = nextAvailableTime;
        writer.write(Integer.toString(totalTime));
        writer.close();

    }
}
