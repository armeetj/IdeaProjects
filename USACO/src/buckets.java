/*
ID: xarmeetx
LANG: JAVA
TASK: buckets
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class buckets
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("buckets.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("buckets.out"))));

        char[][] farm = new char[10][10];

        int Bx = -1;
        int By = -1;

        int Rx = -1;
        int Ry = -1;

        int Lx = -1;
        int Ly = -1;

        for (int i = 0; i < 10; i++)
        {
            String str = scanner.next();
            for (int j = 0; j < 10; j++)
            {
                farm[i][j] = str.charAt(j);
                if (farm[i][j] == 'B')
                {
                    Bx = j;
                    By = i;
                }else if (farm[i][j] == 'R')
                {
                    Rx = j;
                    Ry = i;
                }else  if (farm[i][j] == 'L')
                {
                    Lx = j;
                    Ly = i;
                }
            }
        }

        if ((((Bx == Rx && Lx == Rx)  || (By == Ry && Ly == Ry))) && (distance(Bx, By, Lx, Ly) > distance(Bx, By ,Rx ,Ry)))
        {
            printWriter.println(distance(Bx, By, Lx, Ly) + 1);
        }else
        {
            printWriter.println(distance(Bx, By, Lx, Ly) - 1);
        }
        printWriter.close();
    }

    public static int distance(int x1, int y1, int x2, int y2)
    {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}