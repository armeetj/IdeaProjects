import java.util.Scanner;

public class sorting
{
    static int[] a;
    static int[] ij;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //n is the number of elements in the unsorted array
        int n = sc.nextInt();
        //a is the array that will hold all of the elements
        a = new int[n];
        ij = new int[2];
        //read all the numbers into the array
        for(int i = 0; i< n; i++)
        {
            a[i] = sc.nextInt();
        }

        //call quicksort on our array
        quicksort(0, n-1);

        //print out the sorted array
        for (int i : a)
        {
            System.out.print(i+ " ");
        }

    }

    public static void quicksort(int low, int high)
    {
        if (low >= high)
        {
            //there is less than one elment in the array
            //simply return the input array because it is already sorted
            return;
        }

        //otherwise make i and j
        int i = 0;
        int j = 0;

        //i and j are the positions of the partitions
        //at first they are 0

        //partition the array a into 3 partitions
        //0 through i are all elements less than the pivot
        //i+1-j-1 are elements equal to the pivot
        //j to r are elements greater than the pivot
        partition(low, high, i, j);

        //now the partition is done, perform quicksort on the the two halfs
        //the first half is from low to i
        quicksort(low, ij[0]);
        //the second half is from j to high
        quicksort(ij[1], high);

    }

    public static void partition(int low, int high, int i, int j)
    {
        //if the array given has only 2 elements...
        if (high - low == 1)
        {
            //now check whether the first one is greater
            if (a[low] > a[high])
            {
                //then just swap the two numbers
                swap(low, high);
                i = low;
                j = high;
                ij[0] = i;
                ij[1] = j;
                //we have sorted the array so just exit
                return;
            }
        }
        //otherwise start by setting mid to low
        //mid is the pointer that will be moving the most
        int mid = low;
        //we must also find the pivot, which we can assume to be the last value in the given array
        int pivot = a[high];

        //as long as mid and high don't cross each other
        while (mid <= high)
        {
            //case 1: mid is < pivot
            if (a[mid] < pivot)
            {
                //just swap low and mid and then increment the pointers low and mid
                swap(low, mid);
                low++;
                mid++;
            }
            //case 2: mid is = pivot
            else if (a[mid] == pivot)
            {
                //simply move on (increment mid by one)
                mid++;
            }
            //case 3: mid is > pivit
            else if (a[mid] > pivot)
            {
                //just swap mid and high
                // and then decrement high by one
                swap(mid, high);
                high--;
            }
        }

        //when we exit out of the while loop, we must change the values of i and j
        i = low-1;
        j = mid;
        ij[0]=i;
        ij[1]=j;
        return;
    }

    public static void swap(int c, int d)
    {
        //if the two indexes are the same then do nothing
        if (c == d)
        {
            return;
        }
        //given two indexes in an array, swap the two items
        //store the value in i
        int tempc = a[c];
        //now change i's value to be j's value
        a[c] = a[d];
        //now change j's value to be tempi (i's old value)
        a[d] = tempc;

        //we are done!
        return;
    }
}