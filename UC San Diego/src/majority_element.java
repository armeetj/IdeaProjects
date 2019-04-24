import java.util.Arrays;
import java.util.Scanner;

public class majority_element
{
    public static void main(String[] args)
    {
        //find the majority element in an array
        //the majority element will be in both halfs of the array if it is majority
        Scanner in = new Scanner(System.in);
        //now read in the input into an array
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i< n;i++)
        {
            array[i] = in.nextInt();
        }
        if (majorityElement(array))
        {
            System.out.println(1);
        }else
        {
            System.out.println(0);
        }
    }

    public static boolean majorityElement(int[] input)
    {
        if (input.length == 3)
        {
            if (input[0] == input[1] || input[0] == input[2] || input[1] == input[2])
            {
                return true;
            }else
            {
                return false;
            }
        }
        else if (input.length == 2)
        {
            return (input[0] == input[1]);
        } else if (input.length == 1)
        {
            return false;
        }else
        {
            int[] array1 = Arrays.copyOfRange(input, 0, input.length / 2);
            int[] array2 = Arrays.copyOfRange(input, input.length / 2, input.length);
                return (majorityElement(array1) || majorityElement(array2));
        }
    }
}
