import java.math.BigInteger;
import java.util.Scanner;

public class huge_fibonacci
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        //n is the nth fib number that we would like to get
        long n = in.nextLong();
        long m = in.nextInt();
        BigInteger m2 = new BigInteger(Long.toString(m));
        BigInteger n2 = new BigInteger(Long.toString(n));
        long pisanoPeriod;

        //although instead of fib(n) % m
        //we will do fib(n % pisanoPeriod) % M because this is the same thing
        //however, we will need to find the pisanoPeriod for this

        //but if mod is 1, there is no use finding the pisanoPeriod b/c there isn't one
        //we will just output 0 because everything is divisible by 1
        if (m == 1)
        {
            System.out.println(0);
        }
        else
        {

            //find the pisano period
            long index = 2;
            pisanoPeriod = 0;
            while (true)
            {
                //not found so keep going
                BigInteger zero = new BigInteger("0");
                BigInteger one = new BigInteger("1");
                BigInteger result1 = fibMod(index).mod(m2);
                BigInteger result2 = fibMod(index+1).mod(m2);

                if (result1.equals(zero))
                {
                    if (result2.equals(one)){
                        pisanoPeriod = index;
                        break;
                    }

                }
                index++;
            }
            BigInteger pisanoPeriod2 = new BigInteger(Long.toString(pisanoPeriod));
            //find the answer
            System.out.println(fibMod(n%pisanoPeriod).mod(m2));
        }

    }

    public static BigInteger fibMod(long n)
    {
        //Objective: fib(N) % M
        //N is the nth fib number that we are going to be performing the modulo on
        if (n < 2)
        {
            BigInteger answer = new BigInteger(Long.toString(n));
            return answer;
        }
            BigInteger n1 = new BigInteger("0");
            BigInteger n2 = new BigInteger("1");
            BigInteger s = new BigInteger("0");
            for (long i = 0; i < n - 1; i++)
            {
                s = n1.add(n2);
                n1 = n2;
                n2 = s;
            }
            return s;
    }

}
