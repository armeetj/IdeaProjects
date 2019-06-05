import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int ans[] = new int[alice.length];

        int rank = 1;

        int prev = scores[0];

        Entry[] leaderBoard = new Entry[scores.length];
        for(int i = 0; i < scores.length; i++)
        {
            if(prev != scores[i])
            {
                rank++;
            }
            leaderBoard[i] = new Entry(scores[i], rank);

            prev = scores[i];
        }

        int j = 0;
        for(int i = scores.length-1; i >= 0; i--)
        {
            if(alice[j] < leaderBoard[i].val)
            {
                ans[j++] = leaderBoard[i].rank + 1;
            }else if(alice[j] > leaderBoard[0].val)
            {
                ans[j] = 1;
                break;
            }

            if(j > alice.length-1)
            {
                break;
            }
        }
        if(alice[alice.length-1] > leaderBoard[0].val)
        {
            ans[j] = 1;
        }

        return ans;
    }



    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        int scoresCount = scanner.nextInt();

        int[] scores = new int[scoresCount];


        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = scanner.nextInt();
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();

        int[] alice = new int[aliceCount];

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = scanner.nextInt();
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
            }
        }

        scanner.close();
    }
}

class Entry
{
    int val, rank;

    public Entry(int val, int rank)
    {
        this.val = val;
        this.rank = rank;
    }
}