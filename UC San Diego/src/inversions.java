import java.util.Scanner;

public class inversions
{
    public static void main(String[] args)
    {
        //input
        Scanner scanner = new Scanner(System.in);
        //number of elements in the array
        int n = scanner.nextInt();
        //the array
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
        {
            //scan the input array into a
            a[i] = scanner.nextInt();
        }

        //call the original merge sort method
        System.out.println(modifiedMergeSort(a));

    }

    public static int modifiedMergeSort(int[] a)
    {
        int[] temp = new int[a.length];
        return modifiedMergeSort(a, temp, 0, a.length - 1);

    }

    public static int modifiedMergeSort(int[] a, int[] temp, int left, int right)
    {
        int inversions = 0;
        int mid = 0;

        if (right > left)
        {
            //calculate mid
            mid = (left + right)/2;
            //sort the first half and add to inversions
            inversions = modifiedMergeSort(a, temp, left, mid);
            //sort the second half and add to inversions
            inversions += modifiedMergeSort(a, temp, mid + 1, right);
            //merge the two arrays and add to inversions
            inversions += merge(a, temp, left, mid+1, right);
        }
        return inversions;
    }

    public static int merge(int[] a, int[] temp, int left, int mid, int right)
    {
        //the index of the start of the left subarray
        int i = left;
        //the index of the start of the right subarray
        int j = mid;
        //the index for the resultant sorted array: temp
        int k = left;
        //set the starting value of inversions to 0
        int inversions = 0;

        while ((i <= mid-1) && (j <= right))
        {
            //while in bounds of array
            if (a[i] <= a[j])
            {
                //if the first number is less, there are no inversions to count
                //simply add the index at i to the final resultant array temp
                temp[k++] = a[i++];
            } else
            {
                //otherwise we add the index at j to the final resultant array temp
                temp[k++] = a[j++];

                //in this case however, there are inversions to count
                inversions = inversions + (mid - i);
            }
        }

        //copy any remaining elements of the left subarray to the final array
        while (i <= mid-1)
        {
            temp[k++] = a[i++];
        }

        //copy any remaining elements of the right subarray to the final array temp
        while (j <= right)
        {
            temp[k++] = a[j++];
        }

        //copy back the temp array into the main array
        for (i=left; i <= right; i++)
        {
            a[i] = temp[i];
        }

        return inversions;

    }
}
