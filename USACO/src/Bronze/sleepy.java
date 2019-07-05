package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: shell
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class sleepy
{

    public static void main(String[] args) throws Exception
    {
        //USACO 2019 January Contest, Bronze
        //Problem 2. Sleepy Cow Sorting
        Scanner scanner = new Scanner(new File("sleepy.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("sleepy.out"))));

        int n = scanner.nextInt();
        LinkedList<Integer> line = new LinkedList<>();



        for(int i = 0; i < n; i++)
        {
            int temp = scanner.nextInt();
            line.add(temp);
        }

        if (isSorted(line))
        {
            printWriter.println(0);
            printWriter.close();
        }else
        {
            int count = 0;
            while (true)
            {
                count++;

                    //otherwise, swap until you find the fit
                for (int i = 1; i < line.size(); i++)
                {
                    if (line.get(0) < line.get(i))
                    {
                        line.add(line.size(), line.get(0));
                        line.remove(0);
                        break;
                    } else
                    {
                        line.add(i + 1, line.get(0));
                        line.remove(0);
                        break;
                    }
                }

                    if (isSorted(line))
                    {
                        printWriter.println(count);
                        printWriter.close();
                        break;
                    }

                }



        }

    }

//    public static int[] move(int[] line, int n)
//    {
//        for(int i = 0; i < n-1; i++)
//        {
//
//            swap(i, i + 1, line);
//        }
//        return line;
//    }


//    public static int[] move(int[] line, int n)
//    {
//        int[] arr = new int[line.length];
//        if (n == line.length)
//        {
//            for(int i = 0; i < line.length-1; i++)
//            {
//                arr[i] = line[i + 1];
//            }
//            arr[line.length - 1] = line[0];
//        }else
//        {
//            for(int i = 0; i < n-1; i++)
//            {
//                arr[i] = line[i + 1];
//            }
//            arr[n-1] = line[0];
//            for(int i = n; i < line.length; i++)
//            {
//                arr[i] = line[i];
//            }
//        }
//
//        return arr;
//
//    }

    public static int[] swap(int index1, int index2, int[] arr)
    {
        int val1 = arr[index1];
        int val2 = arr[index2];
        arr[index1] = val2;
        arr[index2] = val1;
        return arr;
    }

    public static boolean isSorted(LinkedList<Integer> list)
    {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i))
            {
                return false;
            }
        }
        return true;

    }
}