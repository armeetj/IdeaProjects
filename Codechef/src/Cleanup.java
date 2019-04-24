import java.util.ArrayList;
import java.util.Scanner;

class Cleanup
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //number of test cases
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++)
        {
            //total number of jobs
            int n = scanner.nextInt();
            //number of jobs already completed
            int m = scanner.nextInt();
            ArrayList<Integer> jobs = new ArrayList<>();
            ArrayList<Integer> chefJobs = new ArrayList<>();
            ArrayList<Integer> assistantJobs = new ArrayList<>();
            for (int j = 1; j <= n; j++)
            {
                jobs.add(j);
            }
            for (int j = 0; j < m; j++)
            {
                jobs.remove(jobs.indexOf(scanner.nextInt()));
            }

            for (int j = 0; j < jobs.size(); j++)
            {
                if (j % 2 == 1)
                {
                    assistantJobs.add(jobs.get(j));
                } else
                {
                    chefJobs.add(jobs.get(j));
                }
            }

            //print both arrays now
            printArrayList(chefJobs);
            printArrayList(assistantJobs);

        }



    }

    public static void printArrayList(ArrayList<Integer> arrayList)
    {
        for(int i = 0; i < arrayList.size(); i++)
        {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println("");
    }
}
