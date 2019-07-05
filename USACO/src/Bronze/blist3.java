package Bronze;
/*
ID: xarmeetx
LANG: JAVA
TASK: blist
*/

//after the contest solution: 10/10 passed all cases (1-2-19)
/*
http://www.usaco.org/current/data/sol_blist_bronze_dec18.html
Nathan Pinsker: The key to this problem is realizing that the IDs of the buckets aren't
relevant to solving it. Every bucket is interchangeable with every bucket,
because the only thing we want to know is the maximum number of buckets that will be in use at some time.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class blist3
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("blist.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("blist.out"))));

        int n = scanner.nextInt();

        //array[1] holds the number of buckets being used at that time
        //the largest amount of buckets being used at one time is the amount of buckets that Farmer john needs
        int[] array = new int[1001];
        //fill in the buckets
        for(int i = 0; i < n; i++)
        {
            //pass the start, end, increment value, and the array that is keeping track of the frequencies
            fillArray(scanner.nextInt(), scanner.nextInt(),scanner.nextInt(), array);
        }

        //linear search through the entire array for the greatest number, which is the answer
        int answer = -1;
        for(int i = 1; i < array.length; i++)
        {
            if (array[i] > answer)
            {
                answer = array[i];
            }
        }

        printWriter.println(answer);
        printWriter.close();

    }

    public static void fillArray(int start, int end, int increment, int[] array)
    {
        for(int i = start; i <= end; i++)
        {
            array[i]+=increment;
        }
    }

}