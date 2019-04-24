import java.util.Scanner;

public class gcd
{
    public static void main(String[] args)
    {
        //we are given two numbers a and b
        Scanner in = new Scanner(System.in);

        long a = in.nextLong();
        long b = in.nextLong();


        gcd(a, b);
    }

    public static void gcd(long a, long b)
    {
        //we must find the greatest common divisor of a and b
        //key fact: the greatest common divisor of a and b is the greatest common divisor of b and a'
        //a' is a%b
        if (b == 0)
        {
            System.out.println(a);
        }else
        {
            //otherwise we must simplify this further
            //aPrime is a%b
            long aPrime = a % b;
            gcd(b,aPrime);
        }
    }
}
