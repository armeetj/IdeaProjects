
import java.util.Scanner;

public class moneyChange
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        //take in the input (the amount of change to return)
        int moneyLeft = in.nextInt();

        //counter keeps track of the answer (numbers of coins used to make the change)
        int counter = 0;

        //we know that to use the least amount of coins, we should use the largest value coins first
        //this way we are finding the lowest number of coins to use to make the amount of change

        //start by using 10 cent coins (the largest coin available)
        while (true)
        {
            if (moneyLeft>=10)
            {
                moneyLeft -= 10;
                counter++;
            }else
            {
                break;
            }
        }

        //now use 5 cent coins (next largest coin available)
        while (true)
        {
            if (moneyLeft>=5)
            {
                moneyLeft -= 5;
                counter++;
            }else
            {
                break;
            }
        }

        //now use 1 cent coins (smallest coin available)
        while (true)
        {
            if (moneyLeft>=1)
            {
                moneyLeft -= 1;
                counter++;
            }else
            {
                break;
            }
        }

        //print out the final answer
        System.out.println(counter);

    }
}
