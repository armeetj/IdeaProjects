package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class palpath
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("cownomics.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        //length and width of the field
        int n = scanner.nextInt();

        String[][] field = new String[n][n];

        //read in the input
        for (int i = 0; i < n; i++)
        {
            String temp = scanner.next();
            for (int j = 0; j < n; j++)
            {
                field[i][j] = Character.toString(temp.charAt(j));
            }
        }

        int answer = count(field,0,0,field[0][0]);
        printWriter.println(answer);
        printWriter.close();
    }

    public static int count(String[][] array, int r, int c, String str)
    {
        int count = 0;
        while (true)
        {
            //can we go down
            if (r + 1 < array.length && (((array[r+1][c]).equals(array[array.length-1][array.length-2]))||((array[r+1][c]).equals(array[array.length-2][array.length-1]))))
            {
                str+=(array[r+1][c]);
                continue;
            }
            //can we go right
            if (r + 1 < array.length && (((array[r+1][c]).equals(array[array.length-1][array.length-2]))||((array[r+1][c]).equals(array[array.length-2][array.length-1]))))
            {
                str+=(array[r+1][c]);
                continue;
            }
        }

    }
}

