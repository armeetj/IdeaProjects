import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class cowsignal
{
    static String[][] logo;
    static String[][] enlargedLogo;
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("cowsignal.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        //M is the number of lines
        int M = scanner.nextInt();
        //N is the num of characters in each line
        int N = scanner.nextInt();
        //K is the enlargement factor
        int K = scanner.nextInt();

        //make an array with the dimensions
        logo = new String[M][N];


        for(int i = 0; i< M; i++)
        {
            String temp = scanner.next();
            for(int j = 0; j< N; j++)
            {
                logo[i][j]= ""+temp.charAt(j);
            }
        }

        printArray(logo);

        //now we can start building the enlarged array
        //the enlarged array will have enlarged dimensions

        enlargedLogo = new String[M * K][N * K];
        //now we build the array from scratch\
        String temp="";
        for(int i = 0; i< M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                temp = logo[i][j];
                for(int l = 0; l < K; l++)
                {
                    fillNextSpot(temp,M, N, K);

                }
            }
        }
        System.out.println();
        printArray(enlargedLogo);

        for(int i = 0; i< M * K; i++)
        {
            for(int j = 0; j< N* K; j++)
            {
                printWriter.print(enlargedLogo[i][j]);
            }
            printWriter.println();
        }

        printWriter.close();
    }

    public static void printArray(String[][] logo)
    {
        for (String[] array : logo)
        {
            for (String a : array)
            {
                System.out.print(a);
            }
            System.out.println();
        }

    }

    public static void fillNextSpot(String data,int M, int N, int K)
    {
        for(int i = 0; i< M * K; i++)
        {
            for(int j = 0; j < N * K; j++)
            {
                if (enlargedLogo[i][j]==null)
                {
                    enlargedLogo[i][j] = data;
                    return;
                }

            }
        }

    }

    public static boolean goingToNextLine(int n, int M)
    {
        for(int i = 0; i< M; i++)
        {
            if (enlargedLogo[n][i] == null)
            {
                return false;
            }
        }
        return true;
    }

}
