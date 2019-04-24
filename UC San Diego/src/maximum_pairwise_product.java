import java.util.Arrays;
import java.util.Scanner;

public class maximum_pairwise_product
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int numOfVals = in.nextInt();

        //we will store the values in this array
        long[] vals = new long[numOfVals];
        long largestVal = -1;
        long largestIndex = -1;
        long largestVal2 = -1;

        for (int i = 0; i < numOfVals; i++)
        {
            //go through and find the largest val while still putting items into the array for the second search
            long temp = in.nextInt();

            if (temp >= largestVal)
            {
                largestVal = temp;
                largestIndex = i;
            }

            vals[i] = temp;
        }

        // now that we have found the largest term we will find the second largest
        //we will skip over the index that the largest term was at
        for (int i = 0; i < numOfVals; i++)
        {
            //now we will go through but we will be looking for the second largest term, skipping over the index of the largest term
            long temp = vals[i];
            if (i == largestIndex)
            {

            } else if (temp >= largestVal2)
            {
                largestVal2 = temp;
            }

        }

        //now that we have the two values we return the multiplacation

        System.out.println(largestVal * largestVal2);
    }
}
