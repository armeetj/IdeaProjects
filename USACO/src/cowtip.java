import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class cowtip
{
    static int[][] field;
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("cowtip.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));

        int n = scanner.nextInt();
        field = new int[n][n];

        int count = 0;

        //input
        for (int i = 0; i < n; i++)
        {
            String temp = scanner.next();
            for (int j = 0; j < n; j++)
            {
                field[i][j] = Integer.parseInt(Character.toString(temp.charAt(j)));
            }
        }

        //count the answer
        for(int row = n-1; row >=0; row--)
        {
            for(int column = n-1; column >=0; column--)
            {
                int value = field[row][column];
                if (value == 1)
                {
                    toggle(row, column);
                    count++;
                }
            }
        }
        printWriter.print(count);
        printWriter.close();

    }

    public static void toggle(int row, int column)
    {

        for (int i = 0; i <= row; i++)
        {
            for (int j = 0; j <= column; j++)
            {
                if (field[i][j] == 1)
                {
                    field[i][j] = 0;
                } else
                {
                    field[i][j] = 1;
                }
            }
        }
    }
}
