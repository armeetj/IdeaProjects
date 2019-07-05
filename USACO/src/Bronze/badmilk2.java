package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class badmilk2
{
    public static void main(String[] args) throws Exception
    {
        //input/output
        Scanner scanner = new Scanner(new File("badmilk.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));

        //n is the number of people tasting the milk at the party
        int n = scanner.nextInt();
        //m is the number of different types of milk
        int m = scanner.nextInt();
        //d is the number of entries in the transcript of the party
        int d = scanner.nextInt();
        //s is the number of people that get sick
        int s = scanner.nextInt();

        //these are the logs of the party:
        //holds the name of the people
        int[] drinkPerson = new int[d];
        //holds the milk that the person drank
        int[] drinkMilk = new int[d];
        //holds the time that the person drank that particular milk
        int[] drinkTime = new int[d];

        //read in the input
        for (int i = 0; i < d; i++)
        {
            drinkPerson[i] = scanner.nextInt();
            drinkMilk[i] = scanner.nextInt();
            drinkTime[i] = scanner.nextInt();
        }

        //the last segment of the log: the sick people
        //holds the name of the person that got sick
        int[] sickPerson = new int[s];
        //the time that that person became sick
        int[] sickTime = new int[s];

        //read input
        for (int i = 0; i < s; i++)
        {
            sickPerson[i] = scanner.nextInt();
            sickTime[i] = scanner.nextInt();
        }

        //for each sick person, figure out which milks it drank before getting sick
        //list will hold the name of the milks that the person drank
        //Ex:
        //list[0] will hold the milks that the first sick person drank before getting sick
        //list[1] will hold the milks that the second sick person drank before they got sick
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //list of all the milks that could have potentially gone wrong (whoever drank got sick)
        ArrayList<Integer> badMilks = new ArrayList<>();

        for (int i = 0; i < s; i++)
        {
            //name of the sick person
            int person = sickPerson[i];
            //figure out at what time they got sick
            int time = sickTime[i];
            //find all milks that this person drank before getting sick
            //we will store all the milks the person drank in temp
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < d; j++)
            {
                //go through the whole log
                if (drinkTime[j] < time && drinkPerson[j] == person)
                {
                    //if the drin
                    int tempMilk = drinkMilk[j];
                    if (!temp.contains(tempMilk))
                    {
                        temp.add(tempMilk);
                    }
                }
            }
            list.add(temp);
            for (int k = 0; k < temp.size(); k++)
            {
                if (!badMilks.contains(temp.get(k)))
                {
                    badMilks.add(temp.get(k));
                }
            }
        }

        //now we have all the possible bad milks, just find which people drank those milks
        //for each milk, find the people that drank it
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        for(int milk = 0; milk < m; milk++)
        {
            ArrayList<Integer> temp2 = new ArrayList<>();
            for(int i = 0; i < d; i++)
            {
                if (drinkMilk[i] == milk + 1)
                {
                    int tempPerson = drinkPerson[i];
                    if (!temp2.contains(tempPerson))
                    {
                        temp2.add(drinkPerson[i]);
                    }
                }
            }
            list2.add(temp2);
        }
        int answer = 0;
        //for each milk in bad milk, see how many people drank it, that is the number of doses
        for(int i = 0; i < badMilks.size(); i++)
        {
            int tempBadMilk = badMilks.get(i);
            int temp = list2.get(tempBadMilk - 1).size();
            if (temp > answer)
            {
                answer = temp;
            }
        }
        printWriter.println(answer);
        printWriter.close();

    }

}
