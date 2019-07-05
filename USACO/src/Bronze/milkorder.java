package Bronze;

import java.io.*;
import java.util.Scanner;


/*
ID: xarmeetx
LANG: JAVA
TASK: milkorder
*/
public class milkorder
{
    static int[] line;

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(new FileInputStream(new File("milkorder.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));

        //let us read the necessary variables
        //N = numOfCows, M = numOfOrderCows, K = numOfPosCows
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        //make the line array
        line = new int[N + 1];

        line[0] = 0;
        //line[x] will tell you what cow is at pos x in line
        //pos 0 isn't a thing, so pos 0 must be stored as -1 as there is no cow named -1

        //we must store all of the order cows
        int[] order = new int[M];
        for(int i = 0; i < M; i++)
        {
            int temp = sc.nextInt();
            order[i] = temp;
        }

        //now we will take the posCows and put them in the line
        boolean containsOne = false;
        for(int i = 0; i < K;i++)
        {
            int cow = sc.nextInt();
            line[sc.nextInt()] = cow;
        }
        for(int i = 0; i < M; i++)
        {
            if (order[i] == 1)
            {
                containsOne = true;
            }
        }
        printArray(line);

        if (containsOne)
        {
            for (int i = 0; i < M; i++)
            {
                int cow = order[i];
                int containsCow = contains(line, cow);
                if (containsCow < 0)
                {
                    //the cow isn't in the array
                    //put in the first possible area
                    putFirstPossible(cow, 1);
                } else
                {
                    //if it is in the order, put the cow in back of it to the right of it
                    if (i + 1 < order.length)
                    {
                        putFirstPossible(order[i+1],containsCow);
                    }
                }
            }
        }else
        {
            //now we must put the orderCows in
            //start with the last cow in the order
            for (int i = M - 1; i >= 0; i--)
            {
                int cow = order[i];
                int containsCow = contains(line, cow);
                if (containsCow < 0)
                {
                    //the cow isn't in the array
                    //put it in the last position
                    putLastPossible(cow, N);
                } else
                {
                    //if it is in the order, put the cow in front of it to the left of it
                    if (i - 1 >= 0)
                    {
                        putLastPossible(order[i - 1], containsCow);
                    }
                }
            }
        }


        int answer1 = contains(line, 0);
        int answer2 = contains(line, 1);
        System.out.println("answer1: " + answer1);
        System.out.println("answer2: " + answer2);

        if (answer2 != -1)
        {
            pw.print(answer2);
        }else{

            pw.print(answer1);

        }
        printArray(line);
        pw.close();
    }


    public static int contains(int[] a, int b)
    {
        for(int i = 1; i< a.length;i++)
        {
            if (a[i] == b)
            {
                return i;
            }
        }
        return -1;
    }

    //fill to the left of it
    public static void putLastPossible(int cow, int x)
    {
        if (line[x] == 0)
        {
            line[x] = cow;
        }else
        {
            putLastPossible(cow,x-1);
        }
    }

    //fill to the left of x
    public static void putFirstPossible(int cow, int x)
    {
        if (line[x] == 0)
        {
            line[x] = cow;
        }else
        {
            putFirstPossible(cow,x+1);
        }
    }

    public static void printArray(int[] a)
    {
        System.out.print("{ ");

        for (int j : a)
        {
            System.out.print(j+" ");
        }
        System.out.println("}");
    }


}
