import java.util.Scanner;

class Fctrl
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        for(int i = 0; i < t; i++)
        {
            System.out.println(Z(scanner.nextLong()));
        }
    }

    public static int Z(long n)
    {
        int count = 0;

        for (int i = 5; n / i >= 1; i *= 5)
        {
            count += n / i;
        }
        return count;
    }
}
