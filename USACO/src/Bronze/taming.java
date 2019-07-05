package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class taming
{
    static int s = 0;
    static int e = 0;
    //USACO 2018 February Contest, Bronze Problem 3. Taming the Herd
    public static void main(String[] args) throws Exception
    {
        //to read the input file
        Scanner scanner = new Scanner(new File("taming.in"));
        //to write to the output file
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));

        //take in the input
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++)
        {
            //scan to array
            input[i] = scanner.nextInt();
        }

        //now pass this array to the min numOfBreakouts array
        int answer = numOfBreakouts(input, n);
        if (answer == -1)
        {
            printWriter.print(-1);
            printWriter.close();
        } else if (answer == 0)
        {

            printWriter.print(s+ " ");
            printWriter.print(s + e);
            printWriter.close();
        }else
        {
            printWriter.print("ERROR");
            printWriter.close();
        }

    }

    public static int numOfBreakouts(int[] array, int n)
    {
        //first check if the first element is a non-negative number that is not 0
        //if it is, then we just output 1 to the outfput file
        if (array[0] > 0)
        {
            return -1;
        }

        //otherwise...
        //make the starting element of the array 0 because we are given the fact that there was a breakout on day 1
        array[0] = 0;


        //t is a variable that will hold the value that we expect in the next element (left 1)
        //starts at -1
        int t = -1;

        //start from the end of the array all the way to the beginning
        for (int i = n - 1; i >= 0; i--)
        {
            //check if there is an inconsistency or not
            if (t != -1 && array[i] != -1 && array[i] != t)
            {
                //if i is some expected number
                //and the array has some value
                //and the expected value doesn't match what is already in the array
                //this means that we have an inconsistency
                return -1;
            }
            //otherwise do the following...
            //if t is -1 this means that there is no expected value
            if (t == -1)
            {
                //then we assign t to the value at i, if it is some num > -1, then we will be decrementing this later on
                //when we decrement t, we will get the expected value for the object 1 to the left of i
                t = array[i];
            }

            //if a[i] is -1, then we set it to t, the expected value
            if (array[i] == -1)
            {
                array[i] = t;
            }

            //if a[i] is 0, this means that a streak has ended, so we must increment the number of streaks
            if (array[i] == 0)
            {
                s++;
            }

            //if a[i] is still -1, then it means that we need to increment e
            if (array[i] == -1)
            {
                e++;
            }

            //lastly if t > -1 then we will decrement t; this will give the value that the object one to the right of i should be
            if (t > -1)
            {
                t--;
            }
        }
        return 0;
    }
}
