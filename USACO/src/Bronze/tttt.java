package Bronze;

import java.io.*;
import java.util.*;

public class tttt
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(new FileInputStream(new File("tttt.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

        int individual = 0;
        int teams = 0;
        //first store the input into a 2d array
        String[][] grid = new String[3][3];
        String input;
        for (int i = 0; i < 3; i++)
        {
            input = sc.next();
            for (int j = 0; j < 3; j++)
            {
                grid[i][j] = Character.toString(input.charAt(j));
            }
        }
        Set<String> individualWinners = new HashSet<String>();
        Set<Set<String>> teamWinners = new HashSet<>();
        Set<String> set = new HashSet<String>();

        //check the horizontal wins
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                set.add(grid[i][j]);
            }

            if (set.size() == 1)
            {

                if(!individualWinners.contains(set.iterator().next()))
                {
                    //this means that all of the symbols are the same and there is another individual winner
                    individual++;
                }
                individualWinners.add(set.iterator().next());


            } else if (set.size() == 2)
            {
                if (!teamWinners.contains(set))
                {
                    //this means that all of the symbols are the same and there is another individual winner
                    teams++;
                }
                teamWinners.add(set);

                //if the size is two it means that there are only two letters in the row
                //this means that if the cows were a team, there is another team win
            }

            //clear the set for the next row
            set.clear();
        }

        //check the vertical wins
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                set.add(grid[j][i]);
            }
            if (set.size() == 1)
            {

                if(!individualWinners.contains(set.iterator().next()))
                {
                    //this means that all of the symbols are the same and there is another individual winner
                    individual++;
                }
                individualWinners.add(set.iterator().next());

            } else if (set.size() == 2)
            {

                if (!teamWinners.contains(set))
                {
                    //this means that all of the symbols are the same and there is another individual winner
                    teams++;
                }
                teamWinners.add(set);

            }

            //clear the set for the next row
            set.clear();
        }

        //check diagonal 1 wins
        for(int i = 0; i < 3; i++)
        {
            set.add(grid[i][i]);
        }
        if (set.size() == 1)
        {

            if(!individualWinners.contains(set.iterator().next()))
            {
                //this means that all of the symbols are the same and there is another individual winner
                individual++;
            }
            individualWinners.add(set.iterator().next());

        } else if (set.size() == 2)
        {

            if (!teamWinners.contains(set))
            {
                //this means that all of the symbols are the same and there is another individual winner
                teams++;
            }
            teamWinners.add(set);

        }
        //clear the set for the next check
        set.clear();
        int i, j;
        //check diagonal 2 wins
        for(i = 0, j = 2; i<3; i++, j--)
        {

            if (set.size() == 1)
            {

                if(!individualWinners.contains(set.iterator().next()))
                {
                    //this means that all of the symbols are the same and there is another individual winner
                    individual++;
                }
                individualWinners.add(set.iterator().next());

            } else if (set.size() == 2)
            {

                if (!teamWinners.contains(set))
                {
                    //this means that all of the symbols are the same and there is another individual winner
                    teams++;
                }
                teamWinners.add(set);

            }

            //clear the set for the next row
            set.clear();
        }

        pw.println(individual);
        pw.println(teams);
        pw.close();

    }

}