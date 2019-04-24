import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for(int x = i; x <= j; x++)
        {
            String initialNumber = Integer.toString(x);
            String finalNumber = "";

            for(int l = initialNumber.length()-1; l >= 0; l--)
            {
                finalNumber+=initialNumber.charAt(l);
            }
            int xFinal = Integer.parseInt(finalNumber);
            if(Math.abs(xFinal-x)%k== 0)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int i = Integer.parseInt(scanner.next());

        int j = Integer.parseInt(scanner.next());
        int k = Integer.parseInt(scanner.next());

        int result = beautifulDays(i, j, k);
        System.out.println(result);

    }
}
