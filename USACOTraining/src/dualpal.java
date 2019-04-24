
/*
ID: xarmeet1
LANG: JAVA
TASK: dualpal
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * author: Armeet Singh Jatyani
 * 1-4-19
 * Section 1_3: dualpal
 */
public class dualpal
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("dualpal.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int count = 0;

        ArrayList<Long> palindromes = new ArrayList<>();
        //find the next N numbers > S such that they are palindromes when written in 2 bases (2-10 inclusive)
        for (long i = ++s; count < n; i++)
        {
            //try all the combinations
            for (int j = 2; j <= 10; j++)
            {
                for (int k = 2; k <= 10; k++)
                {
                    if (j!=k&&isPalindrome(convertBase(i, j)) && isPalindrome(convertBase(i, k)))
                    {
                        if (!palindromes.contains(i))
                        {
                            //this is a number
                            printWriter.println(i);
                            palindromes.add(i);
                            count++;
                        }
                    }
                }
            }
        }

        printWriter.close();
    }

    public static boolean isPalindrome (String y)
    {
        //i is the left point, j is the right pointer
        int i = 0, j = y.length() - 1;
        while (i < j)
        {
            if (!Character.toString(y.charAt(i)).equals(Character.toString(y.charAt(j))) || (Character.toString(y.charAt(i)).equals(Character.toString(y.charAt(j)).equals("0"))))
            {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public static String convertBase (long n, int base)
    {
        String answer = Long.toString(n, base);
        String build = "";
        //change the loweercase a's b's c's... to uppercase letters
        for (int i = 0; i < answer.length(); i++)
        {
            char x = answer.charAt(i);
            int value = x;
            if (value >= 97 && value <= 122)
            {
                x = Character.toUpperCase(x);
            }
            build += x;
        }
        return build;
    }
}