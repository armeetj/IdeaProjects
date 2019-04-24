import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class trapped
{
    static ArrayList<Integer> road;
    //hold the positions of the haybales
    static int[] size;
    static int[] positions;
    static int leftMost;
    static int rightMost;
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("trapped.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));

        //number of hay bales
        int n = scanner.nextInt();
        //the road
        //road[i] is 0 if it is empty there and holds a value if there is a hay bale there, the value will be the size of the bale

        //hold the positions of the haybales
        size = new int[n];
        positions = new int[n];

        leftMost = Integer.MAX_VALUE;
        rightMost = -1;
       //read in the input
        road = new ArrayList<>(1000000000);
        for(int i = 0; i < n; i++)
        {
            size[i] = scanner.nextInt();
            positions[i] = scanner.nextInt();
            road.add(positions[i], size[i]);
            if (positions[i] < leftMost)
            {
                leftMost = positions[i];
            } else if (positions[i] > rightMost)
            {
                rightMost = positions[i];
            }
        }

        int area = 0;
        for(int i = 0; i < rightMost; i++)
        {
            if (road.get(i) != 0)
            {
                //if there is a bale, find the next bale
                int j = i + 1;
                while (true)
                {
                    if (road.get(j) != 0)
                    {
                        break;
                    }
                    j++;
                }
                //check if the cow can escape between both
                if (canEscape(i, j))
                {
                    area += Math.abs(i - j);
                }
            }
        }
    }

    public static boolean canEscape(int l, int r)
    {
        int lSize = size[l];
        int rSize = size[r];
        //try going left
        int d = Math.abs(l - r);
        if (d > lSize)
        {
            if (l <= leftMost)
            {
                return true;
            }
            int j = l - 1;
            while (true)
            {
                if (road.get(j) != 0)
                {
                    break;
                }
                j--;
            }
            return canEscape(j, l);
        } else if (d > rSize)
        {
            //try going right

            if (r >= rightMost)
            {
                return true;
            }
            int j = l + 1;
            while (true)
            {
                if (road.get(j) != 0)
                {
                    break;
                }
                j++;
            }
            return canEscape(r, j);
        }
        return false;
    }

}
