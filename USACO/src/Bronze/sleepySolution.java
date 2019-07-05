package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: shell
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class sleepySolution
{

    public static void main(String[] args) throws Exception
    {
        //USACO 2019 January Contest, Bronze (Solution, after competition
        //Problem 2. Sleepy Cow Sorting
        Scanner scanner = new Scanner(new File("sleepy.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("sleepy.out"))));

        int n = scanner.nextInt();
        int[] line = new int[n];

        for(int i = 0; i < n; i++)
        {
            line[i] = scanner.nextInt();
        }

        boolean printed = false;
        for (int i = n - 1; i > 0; i--)
        {
            if (line[i - 1] > line[i])
            {
                printWriter.println(i);
                printWriter.close();
                printed = true;
                break;
            }
        }

        if (!printed)
        {
            printWriter.println(0);
            printWriter.close();
        }
    }
}