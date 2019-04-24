import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci_last_digit
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if (n < 2)
        {
            System.out.println(n);
        }else
        {
            n+=2;
            //use the previous problem to find the last digit of the n + 2 number
            long m = 10;
            BigInteger m2 = new BigInteger(Long.toString(m));
            BigInteger n2 = new BigInteger(Long.toString(n));
            BigInteger one = new BigInteger("1");
            BigInteger negOne = new BigInteger("-1");
            long pisanoPeriod = 60;
            BigInteger pisanoPeriod2 = new BigInteger(Long.toString(pisanoPeriod));
            //find the answer

            BigInteger answer = new BigInteger("0");
            answer = fibMod(n%pisanoPeriod).mod(m2);

            if (answer.subtract(one).equals(negOne))
            {
                System.out.println(9);
            }else
            {
                System.out.println(answer.subtract(one));
            }
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
