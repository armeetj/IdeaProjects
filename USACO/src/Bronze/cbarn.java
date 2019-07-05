package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class cbarn
{
    static int rooms[];
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("cbarn.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int n = scanner.nextInt();

        rooms = new int[n];
        for(int i = 0; i < n; i++)
        {
            rooms[i] = scanner.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            //start at room i and find the distance
            int tempDistance = 0;
            int multiplier = 1;
            int currentIndex = i;
            for (int j = 0; j < n-1; j++)
            {
                int nextRoom = nextIndexCW(currentIndex);
                tempDistance += (rooms[nextRoom]) * (multiplier);
                multiplier++;
                currentIndex=nextRoom;
            }
            if (tempDistance < answer)
            {
                answer = tempDistance;
            }
        }
        printWriter.print(answer);
        printWriter.close();

    }

    public static int nextIndexCW(int currentIndex)
    {
        if (currentIndex + 1 >= rooms.length)
        {
            return 0;
        }else
        {
            return currentIndex+1;
        }
    }
}
