import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * author: Armeet Singh Jatyani
 * 10-2-18
 * USACO 2015 December Contest, Bronze
 * Problem 3. Contaminated Milk
 */

public class badmilk
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("badmilk.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));

        //n is the number of people coming to the party
        int n = scanner.nextInt();
        //m is the number of different types of milk
        int m = scanner.nextInt();
        //d is the number of entries in the transcript of the party
        int d = scanner.nextInt();
        //s is the number of cows that get sick
        int s = scanner.nextInt();

        //holds the name of the people
        int[] person = new int[d];
        //holds the milk that the person drank
        int[] milk = new int[d];
        //holds the time that the person drank that particular milk
        int[] time = new int[d];

        //read in the input
        for (int i = 0; i < d; i++)
        {
            person[i] = scanner.nextInt();
            milk[i] = scanner.nextInt();
            time[i] = scanner.nextInt();
        }

        List<Integer> possibleBadMilk = new LinkedList<>();
        boolean isFirst = true;
        //for each cow that was sick, figure out which milks it drank before that instance in time
        //check if there is only 1 milk, and if s > 0
        if (m <= 1 && s > 0)
        {
            printWriter.print(n);
            printWriter.close();
        } else
        {
            for (int i = 0; i < s; i++)
            {
                int currentPerson = scanner.nextInt();
                int currentPersonTime = scanner.nextInt();

                List<Integer> currentMilks = new LinkedList<Integer>();
                for (int j = 0; j < d; j++)
                {
                    if (person[j] == currentPerson && time[j] <= currentPersonTime)
                    {
                        currentMilks.add(milk[j]);
                    }
                }
                if (isFirst)
                {
                    int l = 0;
                    while (l < currentMilks.size())
                    {
                        possibleBadMilk.add(currentMilks.get(l++));
                    }
                    isFirst = false;
                } else
                {
                    possibleBadMilk.retainAll(currentMilks);
                }
                currentMilks.clear();
            }
//        System.out.println(possibleBadMilk);
            possibleBadMilk.retainAll(possibleBadMilk);
            int doses = 0;

            //find the cows that have drinken each of these milks
            int i = 0;
            while (i < possibleBadMilk.size())
            {
                int temp = 0;
                for (int j = 0; j < d; j++)
                {
                    System.out.println();
                    System.out.println("comparing " + milk[j] + " and " + possibleBadMilk.get(i));
                    if (milk[j] == possibleBadMilk.get(i))
                    {
                        System.out.println("temp: " + temp);
                        temp++;
                    }
                }
                doses = Math.max(temp, doses);
                i++;
            }

//        System.out.println(doses);
            printWriter.print(doses);
            printWriter.close();
        }
    }
}
