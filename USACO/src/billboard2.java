import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * author: Armeet Singh Jatyani
 * 10-1-18
 * USACO 2017 December Contest, Bronze
 * Problem 1. Blocked Billboard
 */
public class billboard2
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("billboard.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        //first billboard
        //(x1, y1) lower left corner
        //(x2, y2) upper right corner
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        //second billboard
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        //truck
        int x5 = scanner.nextInt();
        int y5 = scanner.nextInt();
        int x6 = scanner.nextInt();
        int y6 = scanner.nextInt();

        //the answer
        int totalArea = 0;

        //calculate the final area of the overlap between the first billboard and the truck
        totalArea += overlapArea(x1, y1, x2, y2, x5, y5, x6, y6);

        //calculate the final area of the overlap between the second billboard and the truck
        totalArea += overlapArea(x3, y3, x4, y4, x5, y5, x6, y6);

        printWriter.print(totalArea);
        printWriter.close();

    }

    public static int rectArea(int x1, int y1, int x2, int y2)
    {
        //compute the area: base times height
        return (Math.abs(x1 - x2) * Math.abs(y1 - y2));
    }

    public static int overlapArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
    {

        //find the area of the billboard neglecting the truck
        int areaRect = rectArea(x1, y1, x2, y2);
        int finalArea = areaRect;
        //find the area where the truck and the billboard overlap
        int bottomLeftX = Math.max(x1, x3);
        int bottomLeftY = Math.max(y1, y3);
        int topRightX = Math.min(x2, x4);
        int topRightY = Math.min(y2, y4);

        //check if this overlap is even "real"
        if ((bottomLeftX < topRightX) && (bottomLeftY < topRightY))
        {
            //it exists
            int overlapArea = rectArea(bottomLeftX, bottomLeftY, topRightX, topRightY);

            finalArea = areaRect - overlapArea;
        }

        return finalArea;
    }
}
