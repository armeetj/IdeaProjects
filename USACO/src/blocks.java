import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class blocks
{
    public static void main(String[] args) throws Exception
    {
        //USACO 2016 December Contest, Bronze Problem 2. Block Game
        Scanner sc = new Scanner(new File("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        int n = sc.nextInt();
        int[] answer = new int[26];
        ArrayList<String> words = new ArrayList<String>();

        for(int i = 0; i < n; i++)
        {
            String word1 = sc.next();
            String word2 = sc.next();
            int j = 0;
                while (true)
                {
                    try
                    {
                        word2 = word2.replaceFirst(Character.toString(word1.charAt(j)), "");
                        j++;
                    } catch (Exception e)
                    {
                        break;
                    }

                }
                String result = word1 + word2;
                words.add(result);
//            }else
//            {
//                while (true)
//                {
//                    try
//                    {
//                        word1 = word1.replaceFirst(Character.toString(word2.charAt(j)), "");
//                        j++;
//                    } catch (Exception e)
//                    {
//                        break;
//                    }
//
//                }
//                String result = word1 + word2;
//                words.add(result);
//            }

        }
        //convert all the words' letters into the index in the array
        //then increment the letter
        for(int i = 0; i < n; i++)
        {
            String temp = words.get(i);
            for(int j = 0; j < temp.length(); j++)
            {
                char character = temp.charAt(j);
                int index = character-97;
                answer[index]++;
            }
        }

        for(int i = 0; i < 26; i++)
        {
            pw.println(answer[i]);
        }
        pw.close();
    }
}
