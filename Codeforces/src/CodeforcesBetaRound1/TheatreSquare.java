package CodeforcesBetaRound1;

import java.util.Scanner;

public class TheatreSquare
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextInt();
        long m = scanner.nextInt();
        long a = scanner.nextInt();

        long ans = (m/a) * (n/a);

        if (a > m && a > n)
        {
            System.out.println(1);
            return;
        } else if (n % a == 0 && m % a == 0)
        {
            System.out.println(ans);
            return;
        } else
        {
            if (n % a == 0 && m % a != 0)
            {
                ans += (n-(n%a))/a;
                System.out.println(ans);
                return;
            }
            if (n % a != 0 && m % a == 0)
            {
                ans += (n-(n%a))/a;
                System.out.println(ans);
                return;
            }
            if (n % a != 0 && m % a != 0)
            {
                ans += (n-(n%a))/a + (m-(m%a))/a + 1;
                System.out.println(ans);
                return;
            }
        }



    }
}
