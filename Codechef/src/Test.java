import java.util.Scanner;

class Test
{
    public static void main(String[] args)
    {
        //initialize our scanner
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            //read in our input
            int input = scanner.nextInt();

            //perform our check
            if (input == 42)
            {
                //stop the program
                break;
            }else
            {
                //prints the input out
                System.out.println(input);
            }
        }
    }
}
