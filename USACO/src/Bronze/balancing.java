package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class balancing
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("balancing.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));

        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] farm = new int[b+1][b+1];
        int xCount = 0;
        int yCount = 0;

        List<Integer> xCoords = new LinkedList<Integer>();
        List<Integer> yCoords = new LinkedList<Integer>();

        for(int i = 0; i < n; i++)
        {
            int xcoord = scanner.nextInt();
            if (!xCoords.contains(xcoord))
            {
                xCount++;
                xCoords.add(xcoord);
            }
            int ycoord = scanner.nextInt();
            if (!yCoords.contains(ycoord))
            {
                yCount++;
                yCoords.add(ycoord);
            }
            farm[xcoord][ycoord] = 1;
        }
        boolean xOdd = false;
        boolean yOdd = false;
        if (xCount % 2 == 0)
        {
            xCount /= 2;
        }else
        {
            xOdd = true;
        }

        if (yCount % 2 == 0)
        {
            yCount /= 2;
        }else
        {
            yOdd = true;
        }

        int count = 0;
        int x = 1;
        int y = 1;
        //find the vertical line
        while (count < xCount)
        {
            if (farm[x][y]==1)
            {
                x++;
                y = 1;
                count++;
            } else if (x < b && y < b)
            {
                y++;
            }else
            {
                x++;
                y = 1;
            }
        }
        int verticalLine = x;

        count = 0;
        x = 1;
        y = 1;
        //find the horizontal line
        while (count < yCount)
        {
            if (farm[x][y]==1)
            {
                y++;
                x = 1;
                count++;
            } else if (x < b && y < b)
            {
                x++;
            }else
            {
                y++;
                x = 1;
            }
        }
        int horizontalLine = y;

        printWriter.println(count(farm, verticalLine, horizontalLine));
        printWriter.close();

    }

    public static int count(int[][] farm, int verticalLine, int horizontalLine)
    {
        int topLeft = 0;
        int topRight = 0;
        int bottomLeft = 0;
        int bottomRight = 0;

        //topLeft
        for(int x = 1; x < verticalLine; x++)
        {
            for(int y = farm.length-1; y > horizontalLine; y--)
            {
                if (farm[x][y]==1)
                {
                    topLeft++;
                }
            }
        }
        //topRight
        for(int x = farm.length-1; x > verticalLine; x--)
        {
            for(int y = farm.length-1; y > horizontalLine; y--)
            {
                if (farm[x][y]==1)
                {
                    topRight++;
                }
            }
        }
        //bottomLeft
        for(int x = 1; x < verticalLine; x++)
        {
            for(int y = 1; y < horizontalLine; y++)
            {
                if (farm[x][y]==1)
                {
                    bottomLeft++;
                }
            }
        }
        //bottomRight
        for(int x = farm.length-1; x > verticalLine; x--)
        {
            for(int y = 1; y < horizontalLine; y++)
            {
                if (farm[x][y]==1)
                {
                    bottomRight++;
                }
            }
        }

        return Math.max(topLeft, Math.max(topRight, Math.max(bottomLeft, bottomRight)));
    }
}

