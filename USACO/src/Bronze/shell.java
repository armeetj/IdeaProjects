package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: shell
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class shell
{

    public static void main(String[] args) throws Exception
    {
        //USACO 2019 January Contest, Bronze
        //Problem 1. Shell Game
        Scanner scanner = new Scanner(new File("shell.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("shell.out"))));

        int numberOfSwaps = scanner.nextInt();
        int[][] directions = new int[numberOfSwaps][3];
        int answer = -1;

        for (int i = 0; i < numberOfSwaps; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                directions[i][j] = scanner.nextInt()-1;
            }
        }
        for(int i = 0; i < 3; i++)
        {
            answer = Math.max(answer, countWins(i, directions));
        }
        printWriter.println(answer);
        printWriter.close();

    }

    public static int countWins(int startIndex, int[][] directions)
    {
        int count = 0;
        int[] shells = new int[3];
        shells[startIndex] = 1;
        for (int lineNumber = 0; lineNumber < directions.length; lineNumber++)
        {
            int shell1 = directions[lineNumber][0];
            int shell2 = directions[lineNumber][1];
            swap(shell1, shell2, shells);
            int guess = directions[lineNumber][2];
            if (shells[guess] == 1)
            {
                count++;
            }
        }
        return count;
    }

    public static int[] swap(int index1, int index2, int[] arr)
    {
        int val1 = arr[index1];
        int val2 = arr[index2];
        arr[index1] = val2;
        arr[index2] = val1;
        return arr;
    }
}
