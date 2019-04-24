import java.util.Scanner;

public class lcm
{
    static long c;
    public static void main(String[] args)
    {
        //we are given two numbers: a and b
        //we must find their least common multiple
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();

        lcm(a, b);
    }

    public static void lcm(long a, long b)
    {
        //the lcm of a and b is defined by the following formula
        // |a * b| / gcd(a, b)

        long numerator = Math.abs(a * b);
        gcd(a, b);
        System.out.println(numerator/c);
    }

    public static void gcd(long a, long b)
    {
        //we must find the greatest common divisor of a and b
        //key fact: the greatest common divisor of a and b is the greatest common divisor of b and a'
        //a' is a%b
        if (b == 0)
        {
            c = a;
        }else
        {
            //otherwise we must simplify this further
            //aPrime is a%b
            long aPrime = a % b;
            gcd(b,aPrime);
        }
    }
}
