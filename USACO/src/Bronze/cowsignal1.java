package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class cowsignal1
{
    static String[][] logo;
    static String[][] enlargedLogo;
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("cowsignal.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        //M is the number of lines
        int M = scanner.nextInt();
        //N is the num of characters in each line
        int N = scanner.nextInt();
        //K is the enlargement factor
        int K = scanner.nextInt();

        for(int i = 0; i< M; i++)
        {
            String line = scanner.next();
            String enlargedLine = "";
            for (int j = 0; j < N; j++)
            {
                for(int k = 0; k< K; k++)
                {
                    enlargedLine += line.charAt(j);
                }
            }
            for(int k = 0; k< K; k++)
            {
                printWriter.println(enlargedLine);
            }
        }

        printWriter.close();
    }
}
