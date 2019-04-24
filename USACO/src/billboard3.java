import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class billboard3
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("billboard.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        //lawnmower billboard (want to cover)
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        //food billboard (want to see)
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        //the answer is originally set to the area of the lawnmower billboard
        int answer = area(x1, y1, x2, y2);

        //if it is perpendicular, return the leftover part to cover
        if (((y3 <= y1) && (y2 >= y4)) || (y3 >= y1) && (y2 <= y4))
        {
            //the lawnmower billboard peeks from the left or the right
            if (x3 < x1)
            {
                //the lawnmower billboard peeks from the right
                answer = area(x2, y2, x1, y1);
            } else if (x3 > x1)
            {
                answer = area(x3, y4, x1, y1);
            }
        } else if ((x1 == x3) && (x2 == x4))
        {
            //the lawnmower billboard peeks from the top or the bottom
            if (y2 > y4)
            {
                answer = area(x3, y2, x4, y4);
            } else if (y2 < y4)
            {
                answer = area(x3, y3, x4, y1);
            }
        }

        //if the second board covers the entire feed board, return 0
        if (x3 <= x1 && y3 <= y1 && x4 >= x2 && y4 >= y2)
        {

            answer = 0;
        }

        printWriter.print(answer);
        printWriter.close();

    }

    public static int area(int x1, int y1, int x2, int y2)
    {
        return ((Math.abs(x1 - x2)) * (Math.abs(y1 - y2)));
    }

}
