/*
ID: xarmeetx
LANG: JAVA
TASK: photo
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Scanner;

public class photo2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("photo.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("photo.out"))));

        int N = scanner.nextInt();

        int[] cows = new int[N - 1];
        for(int i = 0; i < cows.length; i++)
        {
            cows[i] = scanner.nextInt();
        }

        int[] b = new int[N];
        LinkedList<String> sequences = new LinkedList<>();

        for (int i = 1; i <= 9; i++)
        {
            b[0] = i;
            String seq = "";
            for (int j = 0; j < N-1; j++)
            {
                if (cows[j] - b[j] < 0)
                {
                    continue;
                }
                b[j + 1] = cows[j] - b[j];
            }
            for (int temp : b)
            {

                    seq += Integer.toString(temp);

            if (hasDistinctDigits(temp))
            {
                sequences.add(seq);
            }}
        }

        int trash = 10;
    }
    private static boolean hasDistinctDigits(int number) {
        int numMask = 0;
        int numDigits = (int) Math.ceil(Math.log10(number+1));
        for (int digitIdx = 0; digitIdx < numDigits; digitIdx++) {
            int curDigit = (int)(number / Math.pow(10,digitIdx)) % 10;
            int digitMask = (int)Math.pow(2, curDigit);
            if ((numMask & digitMask) > 0) return false;
            numMask = numMask | digitMask;
        }
        return true;
    }
}
