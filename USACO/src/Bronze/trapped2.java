package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class trapped2
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("trapped.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));

        //number of hay bales
        int n = scanner.nextInt();

        ArrayList<Long> size = new ArrayList<>();
        ArrayList<Long> pos = new ArrayList<>();

        //read the input
        for(int i = 0; i < n; i++)
        {
            long tempsize = scanner.nextLong();
            long tempPos = scanner.nextLong();
            pos.add(tempPos);
            Collections.sort(pos);
            size.add(pos.indexOf(tempPos), tempsize);
        }

        //area: the answer, holds the area from which Bessie can't escape from
        int area = 0;

        //for each interval, run the simulation, and see if Bessie is able to get out
        int l = 0;
        int r = 1;
        while (r < n)
        {
            if(!canEscape(size, pos, l, r))
            {
                //the cow can't escape, add to the area from which the cow can't escape
                area += Math.abs(pos.get(l) - pos.get(r));
            }
            l = r;
            r++;
        }

        printWriter.print(area);
        printWriter.close();
    }

    public static boolean canEscape(ArrayList<Long> size, ArrayList<Long> pos, int l, int r)
    {
        //given the index of the two bales the cow is between, figure out if it can escape
        //return true if it can escape, and false if it can't

        //if the cow can break through either the leftmost or rightmost bale she is free: return true
        int leftMostBale = 0;
        int rightMostBale = size.size()-1;

        //can Bessie break the left bale?
        if (size.get(l) < Math.abs(pos.get(l) - pos.get(r)))
        {
            if (l == leftMostBale)
            {
                //we are free
                return true;
            }
            return canEscape(size, pos, l - 1, r);
        }
        //can Bessie break the right bale?
        else if (size.get(r) < Math.abs(pos.get(l) - pos.get(r)))
        {
            if (r == rightMostBale)
            {
                //cow is free
                return true;
            }
            return canEscape(size, pos, l, r + 1);
        }
        //otherwise, the cow can't break out
        return false;
    }
}
