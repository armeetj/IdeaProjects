package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class crypt1
{
    public static void main(String[] args) throws Exception
    {
        //USACO 2019 January Contest, Bronze (after contest)
        //Problem 3. Guess the Animal
        Scanner scanner = new Scanner(new File("guess.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("guess.out"))));

        //number of type of animal
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        System.out.println((Integer.toString(x)));
        System.out.println("hi there this is a test ");
    }

}