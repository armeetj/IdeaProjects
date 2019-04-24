import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci_partial_sum
{
    public static void main(String[] args)
    {
        //https://stackoverflow.com/questions/42944323/i-am-trying-to-find-the-last-digit-of-partial-sum-of-fibonacci-series

        Scanner in = new Scanner(System.in);

        //n is the nth fib number that we would like to get
        Long m2 = in.nextLong();
        Long n2 = in.nextLong();

        //we know that the last digit of a fibonacci number always repeats every 60 numbers
        //therefore we can just store the first 60 fibonacci number's and then just find the sum of those last digits

        //first find the first 60 fibonacci numbers
        int[] fibs = new int[60];
        fibs[0] = 0;
        fibs[1] = 1;

        for(int i = 2; i< fibs.length; i++)
        {
            fibs[i] = (fibs[i - 1] + fibs[i - 2])%10;
        }


        int nn2 = (int) (n2 % 60);
        int mm2 = (int) (m2 % 60);



        if (mm2==nn2)
        {
            //then just find the last digit of nth fibonacci number
            System.out.println(fibs[nn2]);

        }else
        {
            //now take m and n and take mod60 to find the interval that we will be using in our solution


            long sum = 0;
            //now find the sum from m to n in the array

            for(int i = mm2; i <= nn2; i++)
            {
                sum += fibs[i];
            }

            System.out.println(sum%10);
        }


    }


}
