import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class outofplace
{

    //the variable: moves will keep track of how many swaps that we have performed
    static int moves = 0;

    public static void main(String[] args) throws Exception
    {
        //input and output files
        Scanner in = new Scanner(new File("outofplace.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

        //find the number of cows in the order
        int numOfCows = in.nextInt();

        //the array line represents the line that the cows are standing in from left to right
        //ultimately we want to swap until the line is inOrder from left to right (least to greatest)
        int[] line = new int[numOfCows];

        //now take in the data
        for(int i = 0; i< numOfCows; i++)
        {
            line[i] = in.nextInt();
        }

        int[] sorted = line.clone();
        Arrays.sort(sorted);

        //the answer will be number of differences between sorted and line-1

        //find the number of differences between line and sorted
        int counter = 0;
        for(int i = 0; i < line.length; i++)
        {
            if (line[i] != sorted[i])
            {
                counter++;
            }
        }

        //if the array is always the same, so we don't want our answer to be -1 not 0
        out.print(Math.max(0, counter-1));
        out.close();
    }
}
