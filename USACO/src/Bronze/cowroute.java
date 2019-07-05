package Bronze;

import java.io.*;
import java.util.Scanner;

public class cowroute
{
    static String answer;
    static String censor;
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("cowroute.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));

        int startLoc = scanner.nextInt();
        int endLoc = scanner.nextInt();
        int n = scanner.nextInt();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            int price = scanner.nextInt();
            int j = scanner.nextInt();
            boolean foundStart = false;
            boolean foundEnd = false;
            int count = 0;
            for (int l = 0; l < j; l++)
            {
                int temp = scanner.nextInt();
                if (temp == startLoc)
                {
                    foundStart = true;
                }

                if (temp == endLoc && foundStart)
                {
                    foundEnd = true;
                }

                if (foundStart && foundEnd && (temp == endLoc))
                {
                    int tempAns = price;
                    if (tempAns < answer)
                    {
                        answer = tempAns;
                    }
                    String trash = scanner.nextLine();
                    break;
                }
            }
        }
        if (answer == Integer.MAX_VALUE)
        {
            answer = -1;
        }

        printWriter.println(answer);
        printWriter.close();
    }
}
