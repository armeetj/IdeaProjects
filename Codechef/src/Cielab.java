import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

class Cielab
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long difference = a - b;
        String differenceString = Long.toString(difference);
        String ans = "";

        boolean changed = false;

        for (int i = 0; i < differenceString.length(); i++)
        {
            String temp = Character.toString(differenceString.charAt(i));
            if (!temp.equals(0) && !changed)
            {
                for (int j = 1; j < 10; j++)
                {
                    if (!temp.equals(Integer.toString(j)))
                    {
                        ans += j;
                        changed = true;
                        break;
                    }
                }
            } else
            {
                ans += temp;
            }
        }

        System.out.println(ans);
    }
}
