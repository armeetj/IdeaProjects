package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * author: Armeet Singh Jatyani
 * 10-6-18
 * USACO 2014 December Contest, Bronze
 * Problem 3. Cow Jog
 */
public class cowjog
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("cowjog.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));

        //number of cows
        int n = scanner.nextInt();
        int[] speeds = new int[n];
        for(int i = 0; i < n; i++)
        {
            int trash = scanner.nextInt();
            speeds[i] = scanner.nextInt();
        }

        //start from the end of the track, set the slowestCow to the last cow
        int slowestCow = speeds[n - 1];
        int numOfGroups = 0;
        for(int i = n - 1; i >=0; i--)
        {
            //for each cow check if it greater than the slowestCow
            //if it is, it is in the group
            //otherwise it is in its own group and it is the new smallest cow
            if (speeds[i] <= slowestCow)
            {
                //it is in its own group
                numOfGroups++;
                slowestCow = speeds[i];
            }
        }
        printWriter.print(numOfGroups);
        printWriter.close();
    }
}