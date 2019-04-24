import java.util.*;

public class dot_product
{
    public static void main(String[] args)
    {
        //algorithm:

        //if all elements are positive:
        //find the max from array1 and array2
        //take the product and add it to the answer
        //remove both elements from their respective arrays
        //repeat until there are no elements left

        //if there are some negative elements in both arrays:
        //find the maxpos elements from array1 and array2
        //find the leastneg elements from array1 and array2
        //compare the product of both maxpos elements and leastneg elements
        //add the greater product to the answer and then remove the elements from their respective arrays

        //read the input
        Scanner in = new Scanner(System.in);
        //read in the number of ads
        int n = in.nextInt();
        //create the arrays to store the numbers
        List<Long> array1 = new ArrayList<Long>();
        List<Long> array2 = new ArrayList<Long>();
        long answer = 0;
        //fill the arrays
        for(int i = 0; i < n; i++)
        {
            array1.add(in.nextLong());
        }
        for(int i = 0; i< n; i++)
        {
            array2.add(in.nextLong());
        }

        //if n = 1, this means that there is only 1 ad and 1 slot, so the answer is just the product of these two
        if (n == 1)
        {
            System.out.println(array1.get(0) * array2.get(0));
        }else
        {
            //otherwise we do the following

            //sort the array
            Collections.sort(array1);
            Collections.sort(array2);
            for (int i = 0; i < n; i++)
            {
                long product = array1.get(i) * array2.get(i);

                answer += product;
            }
            System.out.println(answer);

        }
    }

}
