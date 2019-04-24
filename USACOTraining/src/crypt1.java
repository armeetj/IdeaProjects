
/*
ID: xarmeet1
LANG: JAVA
TASK: crypt1
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * author: Armeet Singh Jatyani
 * 1-4-19
 * Section 1_4: crypt1
 */

// ID: xarmeet1
// LANG: JAVA
// TASK: crypt1

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class crypt1 {

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("crypt1.in"));
        PrintWriter printWriter = new PrintWriter(new FileWriter(("crypt1.out")));

        int n = scanner.nextInt();
        List<Integer> possibleDigits = new LinkedList<>();
        Set<Integer> answerSet = new HashSet<>();
        for(int i = 0; i < n; i++)
        {
            possibleDigits.add(scanner.nextInt());
        }

        int ans = 0;

        for(int a = 0; a < n; a++)
        {
            if (possibleDigits.get(a) == 0) continue;
            for (int b = 0; b < n; b++)
            {
                for (int c = 0; c < n; c++)
                {
                    for (int d = 0; d < n; d++)
                    {
                        if (possibleDigits.get(d) == 0) continue;
                        for (int e = 0; e < n; e++)
                        {
                            int product = multiply(possibleDigits.get(a), possibleDigits.get(b), possibleDigits.get(c), possibleDigits.get(d), possibleDigits.get(e), possibleDigits);
                            if (product != -1)
                            {
                                if (answerSet.add(product))
                                {
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }
        printWriter.println(ans);
        printWriter.close();

    }

    public static int multiply(int a, int b, int c, int d, int e, List<Integer> digits)
    {

        int subProduct1 = ((a *100) +(b * 10) + c) * (e);
        int subProduct2 = ((a *100) +(b * 10) + c) * (d);
        int product = (((a *100) +(b * 10) + c) * ((10 * d)+e));
        boolean noSuccess = true;

        //checking subproduct1

        if (a == 0 || d == 0 || Integer.toString(subProduct1).length() != 3 || Integer.toString(subProduct2).length() != 3)
        {
            System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product+ "length subproduct or leading zero");

            noSuccess=false;
        }

        for (int i = 0; i < 3; i++) {
            int digit = Integer.parseInt(Character.toString(Integer.toString(subProduct1).charAt(i)));
            if (i==0 && digit == 0)
            {
                System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product+ "failed leading zero");

                noSuccess=false;
            }
            if (!digits.contains(digit)) {
                System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product+ " failed no digit"+digit);

                noSuccess=false;
            }
        }

        //checking subproduct2
        for (int i = 0; i < 2; i++) {
            int digit = Integer.parseInt(Character.toString(Integer.toString(subProduct2).charAt(i)));
            if (i==0 && digit == 0)
            {
                System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product+ "failed leading zero"+subProduct2);

                noSuccess=false;
            }
            if (!digits.contains(digit)) {
                System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product+ "failed "+digit);

                noSuccess=false;
            }
        }



        //checking product
        if (Integer.toString(product).length() != 4) {
            System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product+ "failed length");

            noSuccess=false;
        }

        for (int i = 0; i < 4; i++) {
            int digit = Integer.parseInt(Character.toString(Integer.toString(product).charAt(i)));
            if (!digits.contains(digit)) {
                System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product+ "failed "+digit);
                noSuccess=false;
            }
        }

        if(!noSuccess)

            ;
            //System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product);
        else
        {
            //System.out.println(a +""+ b+"" + ""+c+ " * " + d +""+ e+"" +" = " + subProduct1 + " + " + subProduct2+"0" + " = " + product);
        }
        return noSuccess ? product:-1;

    }
}

