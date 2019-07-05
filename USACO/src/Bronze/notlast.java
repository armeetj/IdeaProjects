package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

/*
ID: xarmeetx
LANG: JAVA
TASK: notlast
 */
public class notlast
{
    public static void main(String[] args) throws Exception
    {
        //to read the input file
        Scanner in = new Scanner(new File("notlast.in"));
        //to write to the output file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

        //N will be the number of entries in Farmer's log
        int N = in.nextInt();
        System.out.println("N: " + N);
        //loop N times
        Map<String,Integer> cows = new HashMap<String,Integer>();
        cows.put("Bessie",0);
        cows.put("Elsie",0);
        cows.put("Daisy",0);
        cows.put("Gertie",0);
        cows.put("Annabelle",0);
        cows.put("Maggie", 0);
        cows.put("Henrietta", 0);
        System.out.println(cows);

        for(int i = 0;i<N;i++)
        {
            String cowName = in.next();
            System.out.print("cowname: " + cowName);
            int milk = Integer.parseInt(in.next());
            System.out.println(", adding milk: "+ milk);
            int temp = cows.get(cowName)+milk;
            cows.put(cowName, temp);
        }
        //sort the cows from least to greatest
        //first put the cows into an array, which will later be sorted
        int[] cowsInt = new int[7];
        cowsInt[0] = cows.get("Gertie");
        cowsInt[1] = cows.get("Elsie");
        cowsInt[2] = cows.get("Henrietta");
        cowsInt[3] = cows.get("Daisy");
        cowsInt[4] = cows.get("Bessie");
        cowsInt[5] = cows.get("Annabelle");
        cowsInt[6] = cows.get("Maggie");

        Arrays.sort(cowsInt);
        int answerMilk = -1;
        //check if the least milk makers are all the same
        //check position 0 and x
        for(int x = 1;x<7;x++)
        {
            if (cowsInt[0] != cowsInt[x])
            //7, 7, 7, 7, 9
            {
                answerMilk = cowsInt[x];
                break;
            }
            else
            {
                answerMilk = cowsInt[0];
            }
        }
        String answer = null;
        if (cows.get("Gertie")==answerMilk)
        {
            answer = "Gertie";
        }
        if ( cows.get("Elsie")==answerMilk)
        {
            if (answer != null)
            {
                answer = "Tie";
            } else
            {
                answer = "Elsie";
            }
        }
        if (cows.get("Henrietta")==answerMilk)
        {
            if (answer != null)
            {
                answer = "Tie";
            } else
            {
                answer = "Henrietta";
            }
        }
        if ( cows.get("Daisy")==answerMilk)
        {
            if (answer != null)
            {
                answer = "Tie";
            } else
            {
                answer = "Daisy";
            }
        }
        if ( cows.get("Bessie")==answerMilk)
        {
            if (answer != null)
            {
                answer = "Tie";
            } else
            {
                answer = "Bessie";
            }
        }
        if ( cows.get("Annabelle")==answerMilk)
        {
            if (answer != null)
            {
                answer = "Tie";
            } else
            {
                answer = "Annabelle";
            }
        }
        if (cows.get("Maggie")==answerMilk)
        {
            if (answer != null)
            {
                answer = "Tie";
            } else
            {
                answer = "Maggie";
            }
        }




        System.out.println(cows);
        System.out.println(answer);
        out.print(answer);
        out.close();
    }

}
