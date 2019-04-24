import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: xarmeetx
LANG: JAVA
TASK: crossroad
*/
//problem: farmer John has 10 cows
//he observes them crossing
//side 0 is one side of the road
//side 1 is the other side of the road
//the input has how many observations there are
//the format of the input is
// 1rst line: # of observations
// next line: cow # side of road (0 or 1)
//count how many times a cow crosses the road
public class crossroad
{
    public static void main(String[] args) throws Exception
    {
        //to read the input file
        Scanner in = new Scanner(new File("crossroad.in"));
        //to write to the output file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));

        //var to store how many times a cow crossed
        int crossed = 0;

        //numOfObs is the number of observations that Farmer John made
        int N = in.nextInt();
        System.out.println("N: " + N);
        System.out.println();


        //array that stores the name of Farmer John's ten cows and the side of the road they are on
        int [][] cows = new int[10][2];
        for(int i = 0; i<10; i++)
        {
                cows[i][0] = i+1;
                cows[i][1] = 2;
        }
        printArray(cows);

        //runs N times for all N observations
        for(int i = 0; i<N; i++)
        {
            //cowNum will be the id of the cow
            int cowNum = in.nextInt();
            System.out.print("cowNum: " +cowNum);
            //roadSide will be the side of the road that the cow is on
            int roadSide = in.nextInt();
            System.out.print(", roadSide: " + roadSide);
            System.out.println();

            //figure out if this is the first visit
            // if the value of the second row is 2 it is the first visit
            if (cows[cowNum - 1][1] == 2)
            {
                //this is what happens if this is the first time we observe the cow
                cows[cowNum - 1][1] = roadSide;
            }
            else
            {
                //if roadSide is the same is the previous value, do nothing
                //if roadSide differs from the previous value, crossed++

                if (cows[cowNum - 1][1] != roadSide)
                {
                    //if the cow moved/crossed the road
                    crossed++;
                    cows[cowNum - 1][1] = roadSide;
                }
            }

        }

        out.write(Integer.toString(crossed));
        out.close();
        System.out.println();
        System.out.println("writing "+ crossed + " to crossroad.out");
    }

    public static void printArray(int[][] cows)
    {
        System.out.println("Cows array: ");
        for (int c[] : cows)
        {
            for(int d : c)
            {
                System.out.print(d + " ");

            }
            System.out.println("");
        }
    }
}
