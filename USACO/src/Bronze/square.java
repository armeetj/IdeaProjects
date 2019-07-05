package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class square
{
    public static void main(String[] args) throws Exception
    {
		Scanner scanner = new Scanner(new File("square.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        //bottom corner 1
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        //top corner 1
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        //bottom corner 2
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        //top corner 2
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        //of the bottom corners, find the min x and min y
        int minx = min(x1, x3);
        int miny = min(y1, y3);

        //of the top corners, find the max x and max y
        int maxx = max(x2, x4);
        int maxy = max(y2, y4);

        System.out.println("minx: " + minx);
        System.out.println("miny: " + miny);
        System.out.println("maxx: " + maxx);
        System.out.println("maxy: " + maxy);

        //now find the x and y length of these coordinates
        int xlen = maxx-minx;
        int ylen = maxy-miny;
        System.out.println("xlen: " + xlen);
        System.out.println("ylen: " + ylen);

        int zlen = max(xlen, ylen);
        System.out.println("zlen: " + zlen);
        int answer = zlen * zlen;

        System.out.println(answer);
        printWriter.print(answer);
        printWriter.close();
    }

    public static int min(int a, int b)
    {
        if (a < b)
        {
            return a;
        }else
        {
            return b;
        }
    }
    public static int max(int a, int b)
    {
        if (a > b)
        {
            return a;
        }else
        {
            return b;
        }
    }
}
