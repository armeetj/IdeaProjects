
/*
ID: xarmeet1
LANG: JAVA
TASK: barn1
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * author: Armeet Singh Jatyani
 * 1-4-19
 * Section 1_4: barn1
 */
public class barn1
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("barn1.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        int maxNumOfBoardsToBuy = scanner.nextInt();
        int numOfStalls = scanner.nextInt();
        int numOfCows = scanner.nextInt();

        List<Blank> blanks = new LinkedList<Blank>();
        List<Board> boards = new LinkedList<Board>();

        int[] stalls = new int[numOfStalls+1];
        int maxIndex = -1;
        int leastIndex = Integer.MAX_VALUE;
        for(int i = 0; i < numOfCows; i++)
        {
            //fill in with a 1 if it is full
            int index = scanner.nextInt();
            if (index > maxIndex)
            {
                maxIndex = index;
            }

            if (index < leastIndex)
            {
                leastIndex = index;
            }
            stalls[index] = 1;
        }

        //find all the blanks
        int current = leastIndex;
        while (current < maxIndex)
        {
            int start = current;
            int end = start;
            if(stalls[current] == 0)
            {
                int count = 0;
                for(int i = current; i < maxIndex; i++)
                {
                    if (stalls[i] == 0)
                    {
                        count++;
                    }else
                    {
                        break;
                    }
                    end = start + count - 1;

                }
                blanks.add(new Blank(start, end));
                current = end + 1;
            }else
            {
                current ++;
            }


        }
        Collections.sort(blanks);

        boards.add(new Board(leastIndex, maxIndex));

        while (boards.size() < maxNumOfBoardsToBuy && blanks.size()!=0)
        {
            Blank temp = blanks.get(blanks.size() - 1);
            blanks.remove(blanks.size()-1);
            for(int i = 0; i < boards.size(); i ++)
            {
                if ((temp.start >= boards.get(i).start) && (temp.end <= boards.get(i).end))
                {
                    int tempStart = boards.get(i).start;
                    int tempEnd = boards.get(i).end;
                    boards.remove(i);
                    boards.add(new Board(tempStart, temp.start-1));
                    boards.add(new Board(temp.end + 1, tempEnd));
                }
            }
        }


        int count = 0;
        for(int i = 0; i < boards.size(); i++)
        {
            count += boards.get(i).length;
        }
        printWriter.println(count);
        printWriter.close();

    }



}

class Blank implements Comparable<Blank>
{
    int start;
    int end;
    int length;

    public Blank(int start, int end)
    {
        this.start = start;
        this.end = end;
        this.length = Math.abs(start - end) + 1;
    }

    public int compareTo(Blank otherBlank) {
        int result = 0;
        if (length != otherBlank.length) {
            result = length < otherBlank.length ? -1 : 1;
        }
        return result;
    }
}

class Board implements Comparable<Board>
{
    int start, end, length;
    public Board(int start, int end)
    {
        this.start = start;
        this.end = end;
        this.length = Math.abs(start - end) + 1;
    }

    public int compareTo(Board otherBoard) {
        int result = 0;
        if (length != otherBoard.length) {
            result = length < otherBoard.length ? -1 : 1;
        }
        return result;
    }
}