
/*
ID: xarmeetx
LANG: JAVA
TASK: blist
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class backforth
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("backforth.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("backforth.out"))));

        //both sides have 10 buckets, but can hold a max of 11
        List<Integer> side1 = new LinkedList<>();
        List<Integer> side1copy = new LinkedList<>();
        List<Integer> side2 = new LinkedList<>();
        List<Integer> side2copy = new LinkedList<>();

        //store the possible final values of milk in barn1
        List<Integer> possibilites = new LinkedList<>();
        //read in value
        for(int i = 0; i < 10; i++)
        {
            int value = scanner.nextInt();
            side1.add(value);
            side1copy.add(value);
        }
        for(int i = 0; i < 10; i++)
        {
            int value = scanner.nextInt();
            side2.add(value);
            side2copy.add(value);
        }

        //keep track of how much milk is in each large tank on each side (barn)
        int barn1 = 1000, barn2 = 1000;
        int barn1copy = 1000, barn2copy = 1000;

        //simulate all the possibilities

        //tuesday: barn 1 -> barn 2, 10 available buckets
        //wednesday: barn 2 -> barn 1, 11 available buckets
        //thursday: barn 1 -> barn 2, 10 available buckets
        //friday: barn 2 -> barn 1, 11 available buckets
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                for (int k = 0; k < 10; k++)
                {
                    for (int l = 0; l < 11; l++)
                    {
                        //tuesday
                        int temp1 = side1copy.get(i);
                        side1copy.remove(i);
                        side2copy.add(temp1);
                        barn1copy -= temp1;
                        barn2copy += temp1;

                        //wednesday
                        int temp2 = side2copy.get(j);
                        side1copy.add(temp2);
                        side2copy.remove(j);
                        barn1copy += temp2;
                        barn2copy -= temp2;

                        //thursday
                        int temp3 = side1copy.get(k);
                        side1copy.remove(k);
                        side2copy.add(temp3);
                        barn1copy -= temp3;
                        barn2copy += temp3;

                        //friday
                        int temp4 = side2copy.get(l);
                        side1copy.add(temp4);
                        side2copy.remove(l);
                        barn1copy += temp4;
                        barn2copy -= temp4;

                        if (!possibilites.contains(barn1copy))
                        {
                            possibilites.add(barn1copy);
                        }

                        //reset all values
                        barn1copy = barn1;
                        barn2copy = barn2;

                        side1copy = new LinkedList<>();
                        side2copy = new LinkedList<>();

                        for (int m = 0; m < side1.size(); m++)
                        {
                            side1copy.add(side1.get(m));
                            side2copy.add(side2.get(m));
                        }

                    }
                }
            }
        }

        printWriter.println(possibilites.size());
        printWriter.close();
    }

}