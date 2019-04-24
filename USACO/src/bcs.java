import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bcs
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(new File("bcs.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("bcs.out"))));
        //n is the number of cows
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        //try every single combination because at most there are 10 choose 2 * (4 ways to fit: top, bottom, left, right)


    }

}