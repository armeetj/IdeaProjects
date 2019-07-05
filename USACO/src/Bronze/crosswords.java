package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * author: Armeet Singh Jatyani
 * 10-3-18
 * USACO 2014 December Contest, Bronze
 * Problem 2. Crosswords
 */
public class crosswords
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("crosswords.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));

        int y = scanner.nextInt();
        int x = scanner.nextInt();
        //array will hold the crossword
        String[][] array = new String[y][x];

        //read in the input
        for (int i = 0; i < y; i++)
        {
            String temp = scanner.next();
            for (int j = 0; j < x; j++)
            {
                array[i][j] = Character.toString(temp.charAt(j));
            }
        }

        int clues = 0;

        //holds the coordinates of the possible places where there could be a hint/number
        List<Integer> xVals = new LinkedList<Integer>();
        List<Integer> yVals = new LinkedList<Integer>();

        //now for each one, check if it is a starter
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                //check if it is a horizontal clue
                if ((!array[i][j].equals("#")) && (j - 1 < 0 || (j - 1 >= 0 && array[i][j - 1].equals("#"))) && (j + 2 < x && array[i][j + 1].equals(".") && array[i][j + 2].equals(".")))
                {
                    clues++;
                    xVals.add(j+1);
                    yVals.add(i+1);
                }
                //check if it is a vertical clue
                else if ((!array[i][j].equals("#")) && (i - 1 < 0 || (i - 1 >= 0 && array[i - 1][j].equals("#"))) && (i + 2 < y && array[i + 1][j].equals(".") && array[i + 2][j].equals(".")))
                {
                    clues++;
                    xVals.add(j+1);
                    yVals.add(i+1);
                }
            }
        }

        //write to the output file
        printWriter.println(clues);
        for (int i = 0; i < xVals.size(); i++)
        {
            printWriter.print(yVals.get(i) + " ");
            printWriter.println(xVals.get(i));
        }
        printWriter.close();
    }
}
