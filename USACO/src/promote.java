import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class promote
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(new File("promote.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("promote.out"))));

        int[] before = new int[4];
        int[] after = new int[4];
        for(int i = 0; i < 4; i++)
        {
            before[i] = scanner.nextInt();
            after[i] = scanner.nextInt();
        }
        printWriter.println(after[1]-before[1]+after[2]-before[2]+after[3]-before[3]);
        printWriter.println(after[2]-before[2]+after[3]-before[3]);
        printWriter.println(after[3]-before[3]);
        printWriter.close();
    }

}
