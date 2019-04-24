import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
/*
ID: xarmeetx
LANG: JAVA
TASK: diamond
 */
public class diamond
{
    static int[] diamonds;
    public static void main(String[] args) throws Exception
    {
        //to read the input file
        Scanner in = new Scanner(new File("diamond.in"));
        //to write to the output file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));

        //n is the number of diamonds that Bessie has
        int n = in.nextInt();
        //k is the maximum difference between the greatest and least components
        int k = in.nextInt();
        //make the array to store the diamonds with their sizes
        diamonds = new int[n];
        //put values into the array
        for (int i = 0; i < n; i++)
        {
            diamonds[i] = in.nextInt();
        }

        //this is where we will store the answer to print to the output file
        int answer = 0;

        //i will be the index of the assumed smallest diamond
        for(int i = 0; i < n; i++)
        {
            //assume diamonds[i] is the smallest diamond in the case
            //this is counting the number of diamonds that can fit in the box with the diamond
            int diamondsInBox = 0;
            for(int j = 0; j<n;j++)
            {
                //if the diamond we are comparing is bigger than the smallest and is less than k more than i
                if (diamonds[j] >= diamonds[i] && diamonds[j] <= diamonds[i] + k)
                {
                    diamondsInBox++;
                }
            }
            if (diamondsInBox > answer)
            {
                answer = diamondsInBox;
            }
        }

        out.print(answer);
        out.close();

    }
}
