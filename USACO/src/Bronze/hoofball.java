package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class hoofball
{
    public static void main(String[] args) throws Exception
    {
        //USACO 2018 February Contest, Bronze Problem 2. Hoofball
        Scanner scanner = new Scanner(new File("hoofball.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("hoofball.out"))));
        //n is the number of hay bales in the game that Bessie has designed
        int n = scanner.nextInt();

        int[] cows = new int[1001];
        int[] frequencies = new int[1001];

        int answer = 0;

        //take in input
        for(int i = 1; i <= n; i++)
        {
            cows[scanner.nextInt()] = i;
        }

        //for each cow, see how many cows it passes to
        for(int i = 1; i < 1000; i++)
        {
            if (cows[i] != 0)
            {
                int temp = target(i, cows);
                if (temp != 0)
                {
                    answer++;
                }
                frequencies[temp]++;
            }
        }

        int i = 3;
        System.out.println(answer);
    }

    public static int target(int pos, int[] cows)
    {
        //check
        int index = pos-1;
        int leftNeighbor = Integer.MIN_VALUE;
        int rightNeighbor = Integer.MAX_VALUE;
        while (index > 0)
        {
            if (cows[index] != 0)
            {
                leftNeighbor = index;
                break;
            }
            index--;
        }

        index = pos + 1;
        while (index < cows.length)
        {
            if (cows[index] != 0)
            {
                rightNeighbor = index;
                break;
            }
            index++;
        }

        boolean isLeftN = false;
        if ((Math.abs(leftNeighbor - pos) == Math.abs(rightNeighbor - pos)) || (Math.abs(leftNeighbor - pos) < Math.abs(rightNeighbor - pos)))
        {
            isLeftN = true;
        }

        if (isLeftN)
        {
            return leftNeighbor;
        }
        return rightNeighbor;
    }
}
