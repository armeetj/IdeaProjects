package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
ID: xarmeetx
LANG: JAVA
TASK: cownomics
 */
public class cownomics1
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(new File("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        //N is the first number in the line of input
        //M is the second

        int numOfPaths = 0;
        int N = in.nextInt();
        int M = in.nextInt();
        System.out.println("N: " + N);
        System.out.println("M: " + M);

        //first index is row number
        //second index is the column number
        String[][] genomes = new String[2 * N][M];
        for (int x = 0; x < 2 * N; x++)
        {
            String temp = in.next();

            for (int y = 0; y < M; y++)
            {
                String var = Character.toString(temp.charAt(y));
                genomes[x][y] = var;
            }
        }
        printGenomes(genomes, M, N);

        Set spottedCows = new HashSet<String>();
        Set plainCows = new HashSet<String>();
        for(int y =0; y<M; y++)
        {
            for (int x = 0; x < N; x++)
            {
                spottedCows.add(genomes[x][y]);
                plainCows.add(genomes[x+N][y]);

            }

            spottedCows.retainAll(plainCows);
            if (spottedCows.isEmpty())
            {
                numOfPaths++;
            }
            spottedCows.clear();
            plainCows.clear();
        }
        out.print(numOfPaths);
        out.close();
    }

    public static void printGenomes(String[][] genomes, int M, int N)
    {
        for (int x = 0; x < 2*N; x++)
        {
            for(int y = 0; y<M;y++)
            {
                System.out.print(genomes[x][y]+" ");
            }
            System.out.println("");
        }
    }
}
