import java.util.Scanner;

public class Steps
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("enter a number of steps: ");
            String input = sc.next();
            if (input.equals("x"))
            {
                break;
            }
            System.out.println(numOfWays(Integer.parseInt(input)));
        }

    }

    static int numOfWays(int x)
    {
        if(x<=2)
        {
            return x;
        }
        return (numOfWays(x - 1) + numOfWays(x - 2));
    }
}
