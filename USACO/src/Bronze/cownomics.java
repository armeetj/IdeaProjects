package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: cownomics
*/

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class cownomics
{
    //USACO 2017 US Open Contest Bronze Level Problem 1: The Lost Cow
    public static void main(String [] args) throws IOException
    {
        //to read the input file
        Scanner in = new Scanner(new File("cownomics.in"));
        //to write to the output file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        //N is the number of spotty cows
        //N is also the number of unspotted cows
        int N = in.nextInt();
        //M is the length of each of the cows genome
        int M = in.nextInt();
        System.out.println("N: " + N);
        System.out.println("M: " + M);

        //make an array that stores the cow's genome
        //the first N lines will be the spotty cows
        //the final N lines will be the unspotted cows
        String[][] genomes = new String[2 * N][M];
        for (int y = 0; y < 2 * N; y++)
        {
            String temp = in.next();

            for (int x = 0; x < M; x++)
            {
                String var = Character.toString(temp.charAt(x));
                genomes[y][x] = var;
            }
        }
        printGenomes(genomes);

        //if something is found in the spotty cows and plain cows, it can't cause "spottyness"
        //to keep track of the number of locations that there may be a possible cause of spottyness
        int numOfLocations = 0;

        //{A, T, C, G}
        Set spottyBooleans = new HashSet<Character>();
        Set plainBooleans = new HashSet<Character>();

        for (int y = 0; y < M; y++)
        {
            for (int x = 0; x < N; x++)
            {
                spottyBooleans.add(genomes[x][y]);
                plainBooleans.add(genomes[x+N][y]);
            }

            //
            spottyBooleans.retainAll(plainBooleans);
            if(spottyBooleans.isEmpty()) {
                System.out.println("Found a path at "+y);

                numOfLocations++;
            }
            spottyBooleans.clear();
            plainBooleans.clear();

        }
        out.print(numOfLocations);
        out.close();
    }
    public static void printGenomes(String[][]genomes)
    {
        for (String[] a : genomes)
        {//for array a in the double dimension array genomes...
            for (String b : a)
            {
                //for string b inside of the array a
                System.out.print(b + " ");
                //print out b and then a space after it
            }
            //then make a new line
            System.out.println();
            //thanks for watching :)
        }

    }

}
