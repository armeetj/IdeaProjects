import java.io.*;
import java.util.Scanner;

public class milkorder1
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new FileInputStream(new File("milkorder.in")));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));

        //let us read the necessary variables
        int n = scanner.nextInt();
        int numOrderCows = scanner.nextInt();
        int numPosCows = scanner.nextInt();

        int[] orderCows = new int[n];
        for(int i = 0; i < numOrderCows; i++)
        {
            orderCows[i] = scanner.nextInt();
        }

        //now get all the cows positions
    }
}
