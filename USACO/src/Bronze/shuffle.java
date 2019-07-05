package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class shuffle
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("shuffle.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        //n is the number of people coming to the party
        int n = scanner.nextInt();

        //int order
        int[] order = new int[n];
        for(int i = 0; i < n; i++)
        {
            order[i] = scanner.nextInt()-1;
        }

        int[] finalOrder = new int[n];
        for(int i = 0; i < n; i++)
        {
            finalOrder[i] = scanner.nextInt();
        }
        int[] previousCopy = new int[n];
        for(int i = 0; i< n; i++)
        {
            previousCopy[i] = finalOrder[i];

        }
        int[] answer = new int[n];
        for(int i = 0; i < n ; i++)
        {
            answer[i] = previousCopy[i];
        }
        //3 times
        for (int j = 0; j < 3; j++)
        {
            for (int i = 0; i < n; i++)
            {
                int index = i;
                int value = previousCopy[order[i]];
                answer[index] = value;
            }
            for (int i = 0; i < n; i++)
            {
                previousCopy[i] = answer[i];
            }
        }


        for(int i = 0; i < n ; i++)
        {
            printWriter.println(answer[i]);
        }
        printWriter.close();

    }

}
