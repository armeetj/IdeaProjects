//package Section1_2;

/*
ID: xarmeet1
LANG: JAVA
TASK: beads
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * author: Armeet Singh Jatyani
 * 10-10-18
 * Section 1_2: beads
 */
public class beads
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("beads.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = scanner.nextInt();
        String beads = scanner.next();

        //split at a location, and then count
        //split at x means that that the necklace will be split after charAt(x)
        int max = 0;
        for(int i = 0; i < n-1; i++)
        {
            //split at i and count
            //if the count is greater than max, then update max
            max = Math.max(max, count(i, beads));
        }

        printWriter.println(max);
        printWriter.close();
    }

    public static int count(int splitIndex, String beads)
    {
        int leftCount = 0;
        int rightCount = 0;

        //the necklace will split right after charAt(splitIndex)

        //count the number of beads on the left
        int i = splitIndex;
        char leftCharacter = beads.charAt(i);
        while (true)
        {
            if (leftCount >= beads.length())
            {
                return beads.length();
            }
            String nextBead = Character.toString(beads.charAt(nextIndex(i, beads, true)));
            String currentBead = Character.toString(beads.charAt(i));
            if (Character.toString(leftCharacter).equals("w"))
            {
                //it is white
                //check if the next one isn't white
                leftCount++;
                if (!nextBead.equals("w"))
                {
                    leftCharacter = nextBead.charAt(0);
                }
            } else if (currentBead.equals(Character.toString(leftCharacter)) || currentBead.equals("w"))
            {
                leftCount++;
            } else
            {
                break;
            }
            //increment i
            i = nextIndex(i, beads, true);
        }

        i = nextIndex(splitIndex, beads, false);
        char rightCharacter = beads.charAt(i);
        while (true)
        {
            if (rightCount >= beads.length())
            {
                return beads.length();
            }
            String nextBead = Character.toString(beads.charAt(nextIndex(i, beads, false)));
            String currentBead = Character.toString(beads.charAt(i));
            if (Character.toString(rightCharacter).equals("w"))
            {
                //it is white
                //check if the next one isn't white
                rightCount++;
                if (!nextBead.equals("w"))
                {
                    rightCharacter = nextBead.charAt(0);
                }
            } else if (currentBead.equals(Character.toString(rightCharacter)) || currentBead.equals("w"))
            {
                rightCount++;
            } else
            {
                break;
            }
            //increment i
            i = nextIndex(i, beads, false);
        }
        return leftCount + rightCount;
    }

    public static int nextIndex(int currentIndex, String string, boolean goLeft)
    {
        //given whether we are going left or right
        //find the next index

        //if we are going left
        if (goLeft)
        {
            //check if we aren't going off the string
            if (currentIndex - 1 != -1)
            {
                return currentIndex - 1;
            }else
            {
                //otherwise we are going off of the string, next should be the last
                return string.length()-1;
            }
        }else
        {
            //we are going to the right

            //check if we aren't going off the string
            if (currentIndex + 1 < string.length())
            {
                return currentIndex + 1;
            }else
            {
                //otherwise we are going off the string, next should be the first element in the thing
                return 0;
            }
        }
    }
}
