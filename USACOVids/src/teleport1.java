import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class teleport1
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(new File("teleport.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));

        int a = in.nextInt();
        int b = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        //case 1:
        int answer1 = Math.abs(a-b);

        //case 2:
        int answer2 = Math.abs(a-x) + Math.abs(b-y);

        //case 3:
        int answer3 = Math.abs(a-y) + Math.abs(b-x);

        out.print(Math.min(Math.min(answer1, answer2), answer3));
        out.close();
    }
}
