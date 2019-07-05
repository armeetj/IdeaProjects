package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class billboard4
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("billboard.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        int tarpArea = -1;

        //the coordinates of the billboard we would like to cover (lawnmower ad)
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        //coordinates of the billboard that we like (food = yummy = yay!)s
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        //3 main cases
        //case 1: the entire lawnmower billboard is covered by the food billboard
        //case 2: one corner of the food billboard is covered by the lawnmower billboard
        //case 3: the lawnmower billboard overlaps perpendicularly
        //case 4: the boards don't overlap

        //case 1
        if (x1 >= x3 && x2 <= x4 && y1 >= y3 && y2 <= y4)
        {
            //there is no need to cover
            tarpArea = 0;
        }
        //case 3: right
        else if (x1 >= x3 && x2 > x4 && y1 >= y3 && y2 <= y4)
        {
            tarpArea = rectArea(x4, y1, x2, y2);
        }
        //case 3: left
        else if (x1 < x3 && x2 <= x4 && y1 >= y3 && y2 <= y4)
        {
            tarpArea = rectArea(x1, y1, x3, y2);
        }
        //case 3: top
        else if (y1 >= y3 && y2 > y4 && x1 >= x3 && x2 <= x4)
        {
            tarpArea = rectArea(x1, y4, x2, y2);
        }
        //case 3: bottom
        else if (y2 <= y4 && y1 < y3 && x1 >= x3 && x2 <= x4)
        {
            tarpArea = rectArea(x1, y1, x2, y3);
        }
        //case 2 and 4
        else {
            tarpArea = rectArea(x1, y1, x2, y2);
        }

        printWriter.print(tarpArea);
        printWriter.close();

    }

    public static int rectArea(int x1, int y1, int x2, int y2)
    {
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        int area = x * y;
        return area;
    }
}