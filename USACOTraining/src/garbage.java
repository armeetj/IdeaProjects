//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class garbage
//{
//
///*
//ID: xarmeet1
//LANG: JAVA
//TASK: crypt1
//*/
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.*;
//
//    /**
//     * author: Armeet Singh Jatyani
//     * 1-4-19
//     * Section 1_4: crypt1
//     */
//
//        public static void main(String[] args) throws Exception
//        {
//            Scanner scanner = new Scanner(new File("crypt1.in"));
//            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
//            int n = scanner.nextInt();
//
//
//            int[] possibleDigits = new int[n];
//            for(int i = 0; i < n; i++)
//            {
//                possibleDigits[i] = scanner.nextInt();
//            }
//
//            int multiplication = 0;
//            int count = 0;
//
//            System.out.println(isSolution(135, 22, multiply(1, 3, 5, 2, 2), possibleDigits));
//
//        }
//
//        public static int multiply(int a, int b, int c, int x, int y)
//        {
//            int num1 = (a * 100) + (b * 10) + c;
//            int num2 = (x * 10) + y;
//            return num1 * num2;
//        }
//
//        public static boolean isSolution(int a, int b, int x, int[] list)
//        {
//
//            if (check(x, list))
//            {
//                int first = Integer.parseInt(Character.toString(Integer.toString(b).charAt(1)));
//                int second = Integer.parseInt(Character.toString(Integer.toString(b).charAt(0)));
//
//                first = a * first;
//                second = a * second;
//                if (Integer.toString(first).length() == 3 && Integer.toString(second).length() == 3)
//                {
//                    int thousandsDigit = Integer.parseInt(Character.toString(Integer.toString(first).charAt(0)));
//                    int hundredsDigit =  Integer.parseInt(Character.toString(Integer.toString(first).charAt(1)));
//                    int tensDigit =  Integer.parseInt(Character.toString(Integer.toString(first).charAt(2)));
//
//                    int tensDigit2 = Integer.parseInt(Character.toString(Integer.toString(second).charAt(0)));
//                    int onesDigit2 = Integer.parseInt(Character.toString(Integer.toString(second).charAt(1)));
//                    if (thousandsDigit == 0 || hundredsDigit == 0 || tensDigit == 0 || tensDigit2 == 0 || onesDigit2 == 0)
//                    {
//                        return false;
//                    }
//                    if(contains(thousandsDigit, list)&& contains(hundredsDigit, list)&& contains(tensDigit, list)&& contains(tensDigit2, list)&& contains(onesDigit2, list))
//                    {
//                        return true;
//                    }
//
//                }
//            }
//            return false;
//        }
//
//        public static boolean check(int x, int[] list)
//        {
//            int thousandsDigit = Integer.parseInt(Character.toString(Integer.toString(x).charAt(0)));
//            int hundredsDigit =  Integer.parseInt(Character.toString(Integer.toString(x).charAt(1)));
//            int tensDigit =  Integer.parseInt(Character.toString(Integer.toString(x).charAt(2)));
//            int onesDigit =  Integer.parseInt(Character.toString(Integer.toString(x).charAt(3)));
//
//            if (thousandsDigit == 0 || hundredsDigit == 0 || tensDigit == 0 || onesDigit == 0)
//            {
//                return false;
//            }
//            //check the length
//            if (Integer.toString(x).length() == 4 && contains(thousandsDigit, list)&& contains(hundredsDigit, list)&& contains(tensDigit, list)&& contains(onesDigit, list))
//            {
//                return true;
//            }
//            return false;
//        }
//
//        public static boolean contains(int x, int[] array)
//        {
//            for(int i = 0; i < array.length; i++)
//            {
//                if (array[i] == x)
//                {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//
//
//}
