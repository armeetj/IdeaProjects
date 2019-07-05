import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class angry
{
    static int[] order;
    public static void main(String[] args) throws Exception
    {
        //USACO 2016 January Contest, Bronze Problem 2. Angry Cows
//        Scanner in = new Scanner(new File("C:\\Users\\singh\\Projects\\IdeaProjects\\USACO\\src\\Bronze\\angry.in"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\singh\\Projects\\IdeaProjects\\USACO\\src\\Bronze\\angry.out"))));
        Scanner in = new Scanner(new File("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("angry.out"))));

        //n is the number of hay bales in the game that Bessie has designed
        int n = in.nextInt();

        //for each bale of hay, figure out how many bales of hay this one explodes
        //if this result explodes more bales of hay, then make it the best one and store it in answer
        int answer = 0;

        //this array holds the location of the bales of hay
        order = new int[n];
        //read in all the positions of the bales of hay
        for (int i = 0; i < n; i++)
        {
            int temp = in.nextInt();
            order[i] = temp;
        }
        Arrays.sort(order);

        //for each bale, see how many other bales it would explode
        for(int i = 0; i < n; i++)
        {
            //store how many bales that the current bale explodes in total in bales

            int blastLeft = howManyExplode(true, i, 1, 0);
            int blastRight = howManyExplode(false, i, 1,0);
            int bales = blastLeft + blastRight+1;
            if (bales > answer)
            {
                answer = bales;
            }
        }

        //in the end just print out the answer to the output file
        out.print(answer);
        out.close();

    }

    public static int howManyExplode(boolean blastLeft, int index, int radius, int blasted)
    {
        //given the index we are at, check how many cows we can explode to the right or left
        if (blastLeft)
        {
            //we are blasting to the left

            //start at the the index, go to index - i where i is increasing and see if it is reachable by the blast radius
            //find the furthest bale to the right that we can explode

            int[] result = nextBale(true, index, radius, blasted);
            int nextBale = result[0];
            blasted = result[1];

            if (nextBale != -1)
            {
                //if there is a next furthest bale
                return howManyExplode(true, nextBale, radius + 1, blasted);
            }else
            {
                //there is no next bale
                return blasted;
            }

        }else
        {
            //we are blasting to the right
            int[] result = nextBale(false, index, radius, blasted);
            int nextBale = result[0];
            blasted = result[1];

            if (nextBale != -1)
            {
                //if there is a next furthest bale
                return howManyExplode(false, nextBale, radius + 1, blasted);
            }else
            {
                //there is no next bale
                return blasted;
            }
        }
    }

    public static int[] nextBale(boolean goLeft, int index, int radius, int blasted)
    {
        int currentAnswer = index;
        int[] answer = new int[2];
        if (!goLeft)
        {
            if (currentAnswer != order.length - 1)
            {
                currentAnswer++;
            }else
            {
                blasted--;
            }
            //given the index that we are currently find the next furthest bale we can reach
            while (currentAnswer<order.length&&(Math.abs(order[currentAnswer] - order[index]) <= radius))
            {
                //move to the next bale (right)
                blasted++;
                currentAnswer++;
            }
            currentAnswer--;
            //we have found the answer
        }else
        {
            if (currentAnswer != 0)
            {
                currentAnswer--;
            }else
            {
                blasted--;
            }
            //given the index that we are currently find the next furthest bale we can reach
            while (currentAnswer>=0&&Math.abs(order[currentAnswer] - order[index]) <= radius)
            {
                //move to the next bale (left)
                blasted++;
                currentAnswer--;
            }
            currentAnswer++;
        }

        if (currentAnswer == index)
        {
            answer[0] = -1;
            answer[1] = blasted;
            return answer;
        }
        answer[0] = currentAnswer;
        answer[1] = blasted;

        return answer;
    }
}
