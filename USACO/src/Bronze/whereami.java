/*
ID: xarmeetx
LANG: JAVA
TASK: whereami
*/
package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class whereami
{
    public static void main(String[] args) throws Exception
    {

        Scanner scanner = new Scanner(new File("C:\\Users\\Armeet Singh Jatyani\\Documents\\Development\\IdeaProjects\\USACO\\src\\Bronze\\whereami.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Armeet Singh Jatyani\\Documents\\Development\\IdeaProjects\\USACO\\src\\Bronze\\whereami.out"))));

//        Scanner scanner = new Scanner(new File("whereami.in"));
//        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("whereami.out"))));

        //read in string
        String s = scanner.next();
        //generate suffix array
        int[] suffixArray = suffixArray(s);
        //generate LCP array
        int[] LCP = LCP(suffixArray, s);
        printWriter.println(maxValue(LCP)[1] + 1);
        printWriter.close();

    }

    public static int[] maxValue(int[] arr)
    {
        //result[0] = index
        //result[1] = value
        int max = -1;
        int maxIndex = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                maxIndex = i;
            }
        }
        int[] result = new int[2];
        result[0] = maxIndex;
        result[1] = max;
        return result;
    }
    public static int[] suffixArray(String s)
    {
        int n = s.length();
        Suffix[] su = new Suffix[n];

        // Store suffixes and their indexes in
        // an array of classes. The class is needed
        // to sort the suffixes alphabatically and
        // maintain their old indexes while sorting
        for (int i = 0; i < n; i++)
        {
            su[i] = new Suffix(i, s.charAt(i) - '$', 0);
        }
        for (int i = 0; i < n; i++)
            su[i].next = (i + 1 < n ? su[i + 1].rank : -1);

        // Sort the suffixes using the comparison function
        // defined above.
        Arrays.sort(su);

        // At this point, all suffixes are sorted
        // according to first 2 characters.
        // Let us sort suffixes according to first 4
        // characters, then first 8 and so on
        int[] ind = new int[n];

        // This array is needed to get the index in suffixes[]
        // from original index. This mapping is needed to get
        // next suffix.
        for (int length = 4; length < 2 * n; length <<= 1)
        {

            // Assigning rank and index values to first suffix
            int rank = 0, prev = su[0].rank;
            su[0].rank = rank;
            ind[su[0].index] = 0;
            for (int i = 1; i < n; i++)
            {
                // If first rank and next ranks are same as
                // that of previous suffix in array,
                // assign the same new rank to this suffix
                if (su[i].rank == prev &&
                        su[i].next == su[i - 1].next)
                {
                    prev = su[i].rank;
                    su[i].rank = rank;
                }
                else
                {
                    // Otherwise increment rank and assign
                    prev = su[i].rank;
                    su[i].rank = ++rank;
                }
                ind[su[i].index] = i;
            }

            // Assign next rank to every suffix
            for (int i = 0; i < n; i++)
            {
                int nextP = su[i].index + length / 2;
                su[i].next = nextP < n ?
                        su[ind[nextP]].rank : -1;
            }

            // Sort the suffixes according
            // to first k characters
            Arrays.sort(su);
        }

        // Store indexes of all sorted
        // suffixes in the suffix array
        int[] suf = new int[n];

        for (int i = 0; i < n; i++)
            suf[i] = su[i].index;

        // Return the suffix array
        return suf;
    }

    public static int[] LCP(int[] suffixArray, String s)
    {
        int[] LCP = new int[suffixArray.length];
        for (int i = 0; i < suffixArray.length - 1; i++)
        {
            String suffix1 = generateSuffix(s, suffixArray[i]);
            String suffix2 = generateSuffix(s, suffixArray[i + 1]);
            //System.out.println("suffix1: " + suffix1);
            //System.out.println("suffix2: " + suffix2);
            int len1 = suffix1.length();
            int len2 = suffix2.length();
            int minLen = Math.min(len1, len2);
            int count = 0;
            for (int j = 0; j < minLen; j++)
            {
                //System.out.println("comparing " + suffix1.charAt(j) + " and " + suffix2.charAt(j));
                if(Character.toString(suffix1.charAt(j)).equals(Character.toString(suffix2.charAt(j))))
                {
                    //System.out.println("same");
                    count++;
                }else
                    {
                    //System.out.println("diff");
                    break;
                }
            }
            //System.out.println("count: " + count + "\n");
            LCP[i+1] = count;
        }
        return LCP;
    }

    public static String generateSuffix(String s, int index)
    {
        return(s.substring(index, s.length()));
    }

}
class Suffix implements Comparable<Suffix>
{
    int index;
    int rank;
    int next;

    public Suffix(int index, int rank, int next)
    {
        this.index = index;
        this.rank = rank;
        this.next = next;
    }

    public int compareTo(Suffix suffix)
    {
        if (this.rank != suffix.rank)
        {
            return Integer.compare(this.rank, suffix.rank);
        }
        return Integer.compare(this.next, suffix.next);
    }

}