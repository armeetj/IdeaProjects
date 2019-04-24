
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class binary_search1
{
    static int array[];

    public static void main(String[] args) throws Exception
    {
        //start with a sorted array
        //store the array
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        Scanner in = new Scanner(System.in);
        String temp = in.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        int k = 0;

        int n = Integer.parseInt(st.nextToken(" "));
        array = new int[n];
        while (st.hasMoreTokens())
        {
            array[k++] = Integer.parseInt(st.nextToken(" "));
        }
        temp = in.readLine();
        st = new StringTokenizer(temp);
        //now take all of the inputs
        int j = Integer.parseInt(st.nextToken(" "));

        int[] queries = new int[j];
        k =0;
        while (st.hasMoreTokens())
        {
            queries[k++] = Integer.parseInt(st.nextToken(" "));

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
