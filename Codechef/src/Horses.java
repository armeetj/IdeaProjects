import java.util.Arrays;
import java.util.Scanner;

class Horses
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //number of test cases
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++)
        {
            // n is the number of horses in this test case
            int n = scanner.nextInt();
            int[] horses = new int[n];
            for (int j = 0; j < n; j++)
            {
                //read in the input
                horses[j] = scanner.nextInt();
            }
            System.out.println(minDif(horses));
        }
    }

    public static int minDif(int[] arr)
    {
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length-1; i++)
        {
            int diff = arr[i + 1] - arr[i];
            ans = Math.min(diff, ans);
        }
        return ans;
    }
}
