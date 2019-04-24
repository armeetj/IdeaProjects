
import java.util.Scanner;

public class binary_search
{
    static int array[];

    public static void main(String[] args)
    {
        //start with a sorted array
        //store the array
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++)
        {
            array[i] = in.nextInt();
        }

        //now take all of the inputs
        int j = in.nextInt();
        int[] queries = new int[j];
        //there are j queries
        //find the input's key
        for (int i = 0; i < j; i++)
        {
            queries[i] = in.nextInt();
        }
        for (int i = 0; i < j; i++)
        {
            int answer = contains(0, n - 1, queries[i]);
            System.out.print(answer+" ");

        }



    }

    public static int contains(int start, int end, int key)
    {
        //if the key is smaller than the smallest or greater than the greatest then return -1.

        while (true)
        {
            if (key < array[start] || key > array[end] || end < start)
            {
                return -1;

            }
            //this is the index of the middle
            int middle =  start + (end - start) / 2;

            if (key == array[middle])
            {
                //if the key is the middle
                return middle;
            }
            else if (key < array[middle])
            {
                //search lower half
                end = middle-1;
            } else
            {
                //search the upper half
                start = middle+1;
            }
        }
        //if the key isn't found in the array
//        return -1;
    }
}
