import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class billboard
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(new File("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        //rect 1 is the first yummy ad!
        //rect 1 coords: (x1, y1) is bottom left ocrner (x2, y2) is top right corner
        int x1, y1, x2, y2;
        x1 = in.nextInt();
        y1 = in.nextInt();
        x2 = in.nextInt();
        y2 = in.nextInt();
        //calculate the area of this rectangle
        int rect1Area = Math.abs(x1 - x2) * Math.abs(y1 - y2);

        //rect 2 is the second yummy billboard
        //rect 2 coords: (a1,b1) is bottom left corner (a2,b2) is the top right corner
        int a1, b1, a2, b2;
        a1 = in.nextInt();
        b1 = in.nextInt();
        a2 = in.nextInt();
        b2 = in.nextInt();
        int rect2Area = Math.abs(a1 - a2) * Math.abs(b1 - b2);
        //cases:
        // 1. feed billboard doesn't block the lawnmower billboard
        // 2. feed billboard covers only corners
        // 3. feed billboard covers entire lawnmower billboard
        // 4: feed billboard covers perpendicularly


        //case 2: feed billboard covers only corners
        //top left corner covered


        //case 3 and 2: feed billboard covers entire lawnmower billboard
        if (a2 >= x2 && b2 >= y2 && a1 <= x1 && b1 <= y1)
        {
            System.out.println("writing case 3 or 2");

            out.print(0);
            out.close();
        }

        //case 4: feed billboard covers perpendicularly
        else if((b2 >= y2 && b1 <= y1 && a2 < x2 && a2 > x1)||(b2 >= y2 && b1 <= y1 && a1 > x1 && a1 < x2)||(a2 >= x2 && a1 <= x1 && b1 < y2 && b1 > y1&&b2>y2)||(a2 >= x2 && a1 <= x1 && b2 < y2 && b2 > y1 && b1< y1))
        {
            //perpendicularly left
            if (b2 >= y2 && b1 <= y1 && a2 < x2 && a2 > x1)
            {
                //calculate area to cover

                int height = Math.abs(y2 - y1);
                int width = Math.abs(x2 - a2);

                int area = height * width;
                out.print(area);
                System.out.println("writing case 4 left");

                out.close();
            }

            //perpendicularly right
            else if (b2 >= y2 && b1 <= y1 && a1 > x1 && a1 < x2)
            {
                int height = Math.abs(y2 - y1);
                int width = Math.abs(x1 - a1);

                int area = height * width;
                out.print(area);
                System.out.println("writing case 4 right");

                out.close();
            }

            //perpendicularly up
            else if (a2 >= x2 && a1 <= x1 && b1 < y2 && b1 > y1&&b2>y2)
            {
                int height = Math.abs(x2 - x1);
                int width = Math.abs(y1 - b1);

                int area = height * width;
                out.print(area);
                System.out.println("writing case 4 up");

                out.close();
            }

            //perpendicularly down
            else if (a2 >= x2 && a1 <= x1 && b2 < y2 && b2 > y1 && b1< y1)
            {
                int height = Math.abs(x2 - x1);
                int width = Math.abs(y2 - b2);

                int area = height * width;
                out.print(area);
                System.out.println("writing case 4 down");
                out.close();
            }
        }

        //case 1: rect1 doesn't even cover rect2 (all other cases fail)
        else
        {
            System.out.println("writing case 1");
            out.println(rect1Area);
            out.close();
        }
    }
}
