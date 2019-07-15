/*
ID: xarmeetx
LANG: JAVA
TASK: evolution
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class evolution2
{
    public static void main(String[] args) throws Exception
    {

        Scanner scanner = new Scanner(new File("C:\\Users\\singh\\Projects\\IdeaProjects\\USACO\\src\\Bronze\\evolution.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\singh\\Projects\\IdeaProjects\\USACO\\src\\Bronze\\evolution.out"))));

//        Scanner scanner = new Scanner(new File("filename.in"));
//        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("filename.out"))));
        int n = scanner.nextInt();
        ArrayList[] populations = new ArrayList[n];

        for(int i = 0; i < populations.length; i++)
        {
            populations[i] = new ArrayList();
            int numberOfCharacteristics = scanner.nextInt();
            for(int j = 0; j < numberOfCharacteristics; j++)
            {
                populations[i].add(scanner.next());
            }
        }

        System.out.println(overlap("telepathic", "flying", populations));
        System.out.println(overlap("telepathic", "flying", populations));

        int breakpoint = -1;


    }

    public static boolean overlap(String a, String b, ArrayList[] populations)
    {
        boolean aCount = false;
        boolean bCount = false;
        boolean abCount = false;

        ArrayList<Integer> aPops = getPopulations(a, populations);
        ArrayList<Integer> bPops = getPopulations(b, populations);

        for(int i = 0; i < aPops.size(); i++)
        {
            if (bPops.contains(aPops.get(i)))
            {
                abCount = true;
                break;
            } else aCount = true; break;
        }

        for(int i = 0; i < bPops.size(); i++)
        {
            if (aPops.contains(bPops.get(i)))
            {
                abCount = true;
                break;
            } else bCount = true; break;
        }
        return (aCount && bCount && abCount);
    }

    public static ArrayList<Integer> getPopulations(String characteristic, ArrayList[] populations)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < populations.length; i++)
        {
            for (int j = 0; j < populations[i].size(); j++)
            {
                if (populations[i].get(j).equals(characteristic))
                {
                    if (!result.contains(i))
                    {
                        result.add(i);
                    }
                }
            }
        }
        return result;
    }
}