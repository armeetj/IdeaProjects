import java.io.File;
import java.util.Scanner;

public class hamming
{
    //2018 ACM-ICPC, Syrian Collegiate Programming Contest
    //Problem 2

    public static void main(String[] args) throws Exception
    {
        //input file
        Scanner scanner = new Scanner(new File("hamming.in"));
        //output: standard output (System.out.println)

        //there will be t test cases
        int t = scanner.nextInt();

        //each test case has 12 numbers, representing the difficulty of a problem
        //the smaller the number, the lower the difficulty. The higher the number, the higher the difficulty of the that problem
        //the first four problems are in order ascending order of difficulty

        for (int i = 0; i < t; i++)
        {
            //n is the length of the string
            int n = scanner.nextInt();
            String str = scanner.next();
            int ones1 = 0;
            int zeros1 = 0;
            for (int j = 0; j < n; j++)
            {
                if (Character.toString(str.charAt(j)).equals("0"))
                {
                    ones1++;
                }else
                {
                    zeros1++;
                }
            }

            String str2 = scanner.next();
            int ones2 = 0;
            int zeros2 = 0;

            for (int j = 0; j < n; j++)
            {
                if (Character.toString(str2.charAt(j)).equals("1"))
                {
                    ones2++;
                } else
                {
                    zeros2++;
                }
            }

            int answer = 0;

            while (zeros1 > 0 && zeros2 > 0)
            {
                zeros1--;
                zeros2--;
                answer++;
            }
            while (ones1 > 0 && ones2 > 0)
            {
                ones1--;
                ones2--;
                answer++;
            }
            System.out.println(answer);
        }
    }


}
