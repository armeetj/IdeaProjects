package Bronze;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
ID: xarmeet1
LANG: JAVA
TASK: gift1
*/
public class gift1
{
    public static void main(String[] args) throws Exception
    {
        //the scanner is to scan input from the input file
        Scanner in = new Scanner(new File("gift1.in"));
        //to write the solution out to the output file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        //we need a StringTokenizer
        StringTokenizer st;

        //first we make a Hashmap with all the people and the values set at a default of  0
        //the first line tells us how many friends there are
        int numOfFriends = in.nextInt();
        System.out.println("number of friends:  " + numOfFriends);
        //make the Hashmap
        HashMap<String, Integer> friends = new HashMap<String,Integer>();
        //for loop to put the values into the Hashmap
        for(int i = 0; i < numOfFriends; i++)
        {
            friends.put(in.next(), 0);
        }
        System.out.println("HashMap of friends: " + friends);

        while (in.hasNext())
        {
            //now we read the next line, which gives us the name of the giver, although this needs to be in a while loop that checks if there is a nextline
            String giver = in.next();
            System.out.println("giver:  " + giver);
            int giveHowMuch = in.nextInt();
            int giveToHowMany = in.nextInt();
            System.out.println("givehowmuch:    " + giveHowMuch);
            System.out.println("givetohowmany:  "+ giveToHowMany);
            System.out.println();

            int giveToEach;
            int keep;
            if (giveToHowMany == 0)
            {
                keep = 0;
                giveToEach = 0;
            }
            //figure out if giver keeps anything or gives everything
            else if(giveHowMuch % giveToHowMany == 0)
            {
                //giver gives everything
                giveToEach = giveHowMuch / giveToHowMany;
                keep = 0;
            }else
            {
                keep = giveHowMuch % giveToHowMany;
                giveToEach = giveHowMuch/giveToHowMany;
            }
            int currentGiver = friends.get(giver);
            //update the giver's account
            friends.put(giver, currentGiver - giveHowMuch + keep);
            //read the recievers names and then add what they receive into the accounts
            for (int i = 0; i < giveToHowMany; i ++)
            {
                String tempReceiver = in.next();
                System.out.println("reciever:   " + tempReceiver);
                int current = friends.get(tempReceiver);
                friends.put(tempReceiver, current + giveToEach);
                System.out.println();
            }
            System.out.println(friends);
        }

        Scanner in2 = new Scanner(new File("gift1.in"));
        int trash = in2.nextInt();

        for(int i = 0; i<numOfFriends; i++)
        {
            String temporary = in2.next();
            out.write(temporary + " " + friends.get(temporary));
            out.write("\n");
        }
        out.close();
    }
}
