import java.util.Scanner;

public class fibonacci_sum_of_squares
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Long n = in.nextLong();

        if (n < 2)
        {
            System.out.println(n);
        }else
        {
            //the sum of the squares of the fibonacci numbs until n is the multiplication of the nth fib and the n+1 fib

            //find the nth and n +1 fib and multiply them
            System.out.println((fib(n-2)*fib(n-1))%10);
        }



    }

    public static Long fib(Long n)
    {
        n%=60;
        Long t1, t2, s;
        t1 = 0L;
        t2 = 1L;
        s = 0L;
        for(int i = 0; i<=n; i++)
        {
            s = (t1 +t2)%10;
            t1 = t2%10;
            t2 = s%10;
        }
        return s;
    }
}
