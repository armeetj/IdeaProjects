import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class speeding2
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner=new Scanner(new File("speeding.in"));
        PrintWriter printWriter=new PrintWriter(new BufferedWriter(new FileWriter(new File("speeding.out"))));
        int n=scanner.nextInt();
        int m=scanner.nextInt();

        int[] speedlimits = new int[100];
        int[] speedsBessie = new int[100];

        int start = 0;
        for (int i = 0; i < n; i++)
        {
            int distance = scanner.nextInt();
            int speed = scanner.nextInt();

            for (int j = start; j < start + distance; j++)
            {
                speedlimits[j] = speed;
            }
            start += distance;

        }

        //fill in Bessie's speeds
        start = 0;
        for (int i = 0; i < m; i++)
        {
            int distance = scanner.nextInt();
            int speed = scanner.nextInt();

            for (int j = start; j < start + distance; j++)
            {
                speedsBessie[j] = speed;
            }
            start += distance;

        }
    }
}
