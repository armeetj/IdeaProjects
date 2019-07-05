package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class marathon
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("marathon.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));

        int n = scanner.nextInt();

        //x and y coordinates of checkpoints
        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++)
        {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }

        int leastDistance = Integer.MAX_VALUE;

        int totalDistance = 0;
        //calculate the distance with no skips
        for(int i = 1; i < n; i++)
        {
            totalDistance += distance(x[i], y[i], x[i - 1], y[i - 1]);
        }

        int biggestSkip = 0;
        for(int i = 1; i < n-1; i++)
        {
            int goThroughPoint = Math.abs(x[i+1] - x[i]) + Math.abs(x[i] - x[i-1]) + Math.abs(y[i+1] - y[i]) + Math.abs(y[i] - y[i-1]);
            int skip = Math.abs(x[i+1] - x[i-1]) + Math.abs(y[i+1] - y[i-1]);
            biggestSkip = Math.max(biggestSkip, goThroughPoint - skip);
        }

        //write to the output file
        leastDistance = totalDistance - biggestSkip;
        printWriter.print(leastDistance);
        printWriter.close();

    }



    public static int distance(int x1, int y1, int x2, int y2)
    {
        return ((Math.abs(x1-x2)) + (Math.abs(y1-y2)));
    }
}
