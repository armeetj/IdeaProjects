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

        if (n % a ==0 && m % a == 0)
        {
            System.out.println((n * m) / (a * a));
        }else
        {
            if(n%a == 0 && m%a != 0)
            {

            }
        }



    }
}
