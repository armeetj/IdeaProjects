package ZCO_PracticeContest;

import java.util.Arrays;
import java.util.Scanner;

class ZCO14003
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        long ans = -1;
        for(int i = n-1; i >=0; i--)
        {
            ans = Math.max(revenue(arr, arr[i]),ans);
        }
        System.out.println(ans);
    }


    public static long revenue(long[] arr, long budget)
    {
        int ans = 0;
        for (int i = arr.length-1; i >= 0; i--)
        {
            if (budget <= arr[i])
            {
                ans += budget;
            } else
            {
                break;
            }
        }
        return ans;
    }
}
