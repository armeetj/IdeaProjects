
/*
ID: xarmeet1
LANG: JAVA
TASK: palsquare
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * author: Armeet Singh Jatyani
 * 1-4-19
 * Section 1_3: palsquare
 */
public class palsquare
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("palsquare.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        int base = scanner.nextInt();

        for(long n = 1; n <=300; n++)
        {
            //try all the n's
            long nSquared = n * n;
            if (isPalindrome((convertBase(nSquared, base))))
            {
                //convert to the given base
                printWriter.println(convertBase(n, base) + " " + convertBase(nSquared, base));
            }
        }
        printWriter.close();
    }

    public static boolean isPalindrome(String y)
    {
            //i is the left point, j is the right pointer
            int i = 0, j = y.length()-1;
            while (i<j)
            {
                if(!Character.toString(y.charAt(i)).equals(Character.toString(y.charAt(j)))||(Character.toString(y.charAt(i)).equals(Character.toString(y.charAt(j)).equals("0"))))
                {
                    return false;
                }

                i++;
                j--;
            }
            return true;
    }

    public static String convertBase(long n, int base)
    {
        String answer = Long.toString(n, base);
        String build  = "";
        //change the loweercase a's b's c's... to uppercase letters
        for (int i = 0; i < answer.length(); i++)
        {
            char x = answer.charAt(i);
            int value = x;
            if (value >= 97 && value <= 122)
            {
                x = Character.toUpperCase(x);
            }
            build+=x;
        }
        return build;
    }

}