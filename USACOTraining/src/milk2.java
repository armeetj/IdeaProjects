
/*
ID: xarmeet1
LANG: JAVA
TASK: milk2
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * author: Armeet Singh Jatyani
 * 1-2-19 (back from thailand)
 * Section 1_3: milk2
 */
public class milk2
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("milk2.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        //number of cows and farmers
        int n = scanner.nextInt();

        //time will hold the number of cows being milked at that time, it will be the max length of time given: 1 million
        //start at time 1 to time 1000000
        int[] time = new int[1000001];
        Arrays.fill(time, 0);
        List<Integer> temp = new LinkedList<>();

        //start incrementing
        for(int i = 0; i < n; i++)
        {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            // get the min and max
            temp.add(start);
            temp.add(end);
            fillArray(start, end, 1, time);
        }
        Collections.sort(temp);

        int preMaxUsed = 0;
        int curMaxUsed = 0;
        int preMaxIdle = 0;
        int curMaxIdle = 0;

        //now count the intervals
        int prevValue = 0;
        boolean isIdle = true;
        for (int i = temp.get(0)+1; i <= temp.get(temp.size() - 1); i++)
        {
            int nextVal = time[i];

            //if continuous
            if(nextVal == prevValue)
            {
                if(isIdle)
                    curMaxIdle = curMaxIdle+1;
                else
                    curMaxUsed = curMaxUsed+1;
            }
            else
            {
                //idle to used transition
                if (isIdle)
                {
                    if (preMaxIdle < curMaxIdle)
                    {
                        preMaxIdle = curMaxIdle;
                    }
                    isIdle = false;
                    curMaxUsed = 1;
                    curMaxIdle = 0;
                }
                else
                // used to idle transition
                {
                    if(preMaxUsed < curMaxUsed)
                    {
                        preMaxUsed = curMaxUsed ;
                    }
                    isIdle = true;
                    curMaxUsed = 0;
                    curMaxIdle = 1;
                }
            }
            prevValue = nextVal;

        }
        if(preMaxUsed < curMaxUsed)
        {
            preMaxUsed = curMaxUsed;
        }
        if (preMaxIdle < curMaxIdle)
        {
            preMaxIdle = curMaxIdle;
        }
        printWriter.println(preMaxUsed + " " + preMaxIdle);
        printWriter.close();
    }

    public static void fillArray(int start, int end, int increment, int[] array)
    {
        for (int i = start+1; i <= end; i++)
        {
            array[i] = 1;
        }
    }

}