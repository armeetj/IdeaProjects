import java.util.Scanner;

public class fibonacci
{
    public static void main(String[] args)
    {
        //make an array of size N which will hold the fib numbers
        Scanner in = new Scanner(System.in);
        int N = in.nextInt()+1;
        if(N-1 == 0|| N-1==1)
        {
            System.out.println(N-1);
        }else
        {
            long[] fibs = new long[(N)];

            //first two numbers are defined
            fibs[0] = 0;
            fibs[1] = 1;

            //now we will fill in all the fibonacci numbs into fibs
            for (int i = 2; i < N; i++)
            {
                fibs[i] = fibs[i - 1] + fibs[i - 2];
            }

            System.out.println(NthFib(fibs, N-1));
        }
    }

    public static long NthFib(long[] fibs, int N)
    {
        return fibs[N];
    }

}
