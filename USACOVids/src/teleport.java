import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class teleport
{
    public static void main(String[] args) throws Exception
    {
        //input file
        Scanner in = new Scanner(new File("teleport.in"));
        //output file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));


        int a = in.nextInt();
        int b = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        //case 1
        int ans1 = Math.abs(a - b);

        //case 2
        int ans2 = Math.abs(a - x) + Math.abs(y - b);

        //case 3
        int ans3 = Math.abs(a - y) + Math.abs(x - b);

        //now we have to find the minimum of these three answers
        out.print(Math.min(Math.min(ans1, ans2),ans3));
        out.close();

    }
}
