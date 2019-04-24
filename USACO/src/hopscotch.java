import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class hopscotch
{
    static String[][] grid;
    static int r;
    static int c;
    public static void main(String[] args) throws Exception
    {
        //I/O
        Scanner in = new Scanner(new File("hopscotch.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));

        //read in the input
        r = in.nextInt();
        c = in.nextInt();

        //create the grid array and then read the input into it
        grid = new String[r][c];
        for(int i = 0; i < r; i++)
        {
            String temp = in.next();
            for(int j = 0; j < c; j++)
            {
                grid[i][j] = Character.toString(temp.charAt(j));
            }
        }

        //now use the recursive solution to find the output
        //print it to the output file
        out.print(routes(0, 0));
        //close the file
        out.close();
    }

    public static int routes(int x, int y)
    {
        //base case (exit case)
        //if the current position is already the bottom right, just return one
        if (x == r - 1 && y == c - 1)
        {
            return 1;
        }


        //otherwise
        //find the color of our current spot and the next one that we will jump onto
        String currentColor, nextColor;
        if (grid[x][y].equals("R"))
        {
            currentColor = "R";
            nextColor = "B";
        }else
        {
            currentColor = "B";
            nextColor = "R";
        }

        int routes = 0;
        //now find the next square to go to
        for (int i = x + 1; i < r; i++)
        {
            for (int j = y + 1; j < c; j++)
            {
                if (grid[i][j].equals(nextColor))
                {
                    routes += routes(i, j);
                }
            }
        }
        return routes;

    }
}