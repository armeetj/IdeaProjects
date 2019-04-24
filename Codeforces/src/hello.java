import java.io.File;
import java.util.Scanner;

public class hello
{

    //2018 ACM-ICPC, Syrian Collegiate Programming Contest
    //Problem 1

    public static void main(String[] args) throws Exception
    {
        //input file
        Scanner scanner = new Scanner(new File("hello.in"));
        //output: standard output (System.out.println)

        //there will be t test cases
        int t = scanner.nextInt();

        //each test case has 12 numbers, representing the difficulty of a problem
        //the smaller the number, the lower the difficulty. The higher the number, the higher the difficulty of the that problem
        //the first four problems are in order ascending order of difficulty

        for (int i = 0; i < t; i++)
        {
            boolean order = true;
            boolean answer = true;
            int before = scanner.nextInt();
            int current = -1;
            //for each set
            for (int j = 0; j < 3; j++)
            {
                current = scanner.nextInt();
                if (current < before)
                {
                    order = false;
                }
            }

            if (order)
            {
                //check the rest of the list, and make sure that the first four are the easiest
                for (int j = 0; j < 8; j++)
                {
                    int temp = scanner.nextInt();
                    if (temp < current)
                    {
                        answer = false;
                    }
                }

            } else
            {
                for (int j = 0; j < 8; j++)
                {
                    int temp = scanner.nextInt();
                }
                answer = false;
            }

            if (answer)
            {
                System.out.println("yes");
            } else
            {
                System.out.println("no");
            }

        }


    }
}
