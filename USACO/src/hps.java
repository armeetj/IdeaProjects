import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class hps
{
    static int[][] games;
    static int hoof, paper, scissors;
    static int answer;
    public static void main(String[] args) throws Exception
    {
        //to read the input file
        Scanner scanner = new Scanner(new File("hps.in"));
        //to write to the output file
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        //there are n games between the two cows
        int n = scanner.nextInt();
        games = new int[n][2];
        answer = 0;

        for(int i = 0; i < n; i++)
        {
            games[i][0] = scanner.nextInt();
            games[i][1] = scanner.nextInt();
            System.out.print(games[i][0]+ " ");
            System.out.println(games[i][1]);
        }

        //run all 6 combinations
        //hoof   paper   scissors
        // 1       2        3
        // 1       3        2
        // 2       1        3
        // 2       3        1
        // 3       1        2
        // 3       2        1

        firstCowWins(1, 2, 3);
        firstCowWins(1, 3, 2);
        firstCowWins(2, 1, 3);
        firstCowWins(2, 3, 1);
        firstCowWins(3, 1, 2);
        firstCowWins(3, 2, 1);

        printWriter.print(answer);
        printWriter.close();

    }

    public static void firstCowWins(int hoofValue, int paperValue, int scissorsValue)
    {
        hoof = hoofValue;
        paper = paperValue;
        scissors = scissorsValue;
        int tempAnswer = 0;

        for (int i = 0; i < games.length; i++)
        {
            int result = winner(i);
            if (result == 0)
            {
                tempAnswer++;
            }
        }
        if (tempAnswer > answer)
        {
            answer = tempAnswer;
        }
    }

    public static int winner(int game)
    {
        //we are looking at game number: game
        int firstCow = games[game][0];
        int secondCow = games[game][1];

        if (firstCow == hoof)
        {
            if (secondCow == hoof)
            {
                return -1;
            } else if (secondCow == paper)
            {
                return 1;
            } else if (secondCow == scissors)
            {
                return 0;
            }
        } else if (firstCow == paper)
        {
            if (secondCow == hoof)
            {
                return 0;
            } else if (secondCow == paper)
            {
                return -1;
            } else if (secondCow == scissors)
            {
                return 1;
            }
        } else if (firstCow == scissors)
        {
            if (secondCow == hoof)
            {
                return 1;
            } else if (secondCow == paper)
            {
                return 0;
            } else if (secondCow == scissors)
            {
                return -1;
            }
        }
        return -2;
    }
}
