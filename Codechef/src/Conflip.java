import java.util.Arrays;
import java.util.Scanner;

class Conflip
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        //number of test cases
        int t = scanner.nextInt();

        for (int z = 0; z < t; z++)
        {
            //the elephant plays g games
            int g = scanner.nextInt();
            for (int j = 0; j < g; j++)
            {
                //i is the starting position of all the n coins
                // i = 1 means head
                // i = 2 means tail
                int i = scanner.nextInt();
                //n is the number of coins in the game
                int n = scanner.nextInt();
                //q is the coin that the elephant is guessing at the end of the game
                //if q is 1, we are counting heads
                //if q is 2, we are counting tails
                int q = scanner.nextInt();
                System.out.println(playGame(i, n, q));
            }
        }
    }

    public static int playGame(int i, int n, int q)
    {
        int[] coins = new int[n];
        Arrays.fill(coins, i);
        //n rounds
        for (int j = 1; j <= n; j++)
        {
            for (int k = 0; k < j; k++)
            {
                toggle(coins, k);
            }
        }

        int count = 0;
        for(int j = 0; j < coins.length; j++)
        {
            if (coins[j] == q)
            {
                count++;
            }
        }
        return count;
    }
    public static void toggle(int[] coins, int index)
    {
        if(coins[index] == 1)
        {
            coins[index] = 2;
        }else
        {
            coins[index] = 1;
        }
    }
}
