package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: xarmeetx
LANG: JAVA
TASK: mixmilk
*/

public class mixmilk
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("mixmilk.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("mixmilk.out"))));

        long[] state = new long[3];
        final long[] capacity = new long[3];

        //read in the input
        for(int i = 0; i < 3; i++)
        {
            capacity[i] = scanner.nextInt();
            state[i] = scanner.nextInt();
        }

        int milk1 = 0;
        int milk2 = 1;
        //pour hundred times
        for(int i = 0; i < 100; i++)
        {
            state = pour(state, capacity, milk1, milk2);
            if (milk1 == 0)
            {
                milk1 = 1;
                milk2 = 2;
            } else if (milk1 == 1)
            {
                milk1 = 2;
                milk2 = 0;
            } else if (milk1 == 2)
            {
                milk1 = 0;
                milk2 = 1;
            }
        }

        //output
        for(int i = 0; i < 3; i++)
        {
            printWriter.println(Long.toString(state[i]));
        }
        printWriter.close();
    }

    public static long[] pour(long[] state, long[] capacity, int milk1, int milk2)
    {
        long[] ans = new long[3];
        for(int i = 0; i < 3; i++)
        {
            ans[i] = state[i];
        }
        long milk1State = state[milk1];
        long milk2State = state[milk2];
        long milk1Capacity = capacity[milk1];
        long milk2Capacity = capacity[milk2];
        long milk2Space = milk2Capacity - milk2State;

        //if milk1 is too much
        if (milk2Space < milk1State)
        {
            //only add how much you can
            milk1State -= milk2Space;
            milk2State += milk2Space;
        }
        //if  milk1 is too less
        else if (milk2Space >= milk1State)
        {
            milk2State += milk1State;
            milk1State = 0;
        }
        ans[milk1] = milk1State;
        ans[milk2] = milk2State;
        return ans;
    }

}
