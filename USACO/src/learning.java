import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * author: Armeet Singh Jatyani
 * 10-10-18
 * USACO 2014 December Contest, Bronze
 * Problem 4. Learning by Example
 */
public class learning
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("learning.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("learning.out")));

        int n = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        //0: non spotted
        //1: spotted
        ArrayList<Integer> spots = new ArrayList<>();
        ArrayList<Integer> weights  = new ArrayList<>();

        //take in input
        for (int i = 0; i < n; i++)
        {
            String temp = scanner.next();
            int temp2 = scanner.nextInt();

            weights.add(temp2);
            Collections.sort(weights);
            int index = weights.indexOf(temp2);

            if (temp.equals("S"))
            {
                spots.add(index, 1);
            } else
            {
                spots.add(index, 0);
            }
        }


    }
}