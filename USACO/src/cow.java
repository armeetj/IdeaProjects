import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class cow
{
    public static void main(String[] args) throws Exception
    {
        //I/O
        Scanner in = new Scanner(new File("cow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cow.out")));

        //the algorithm works like this
        //scan the string from left to right once
        //the variables c, co, and cow hold the number of times c, co, and cow show up in the input
        //if the next character is...
        //C: c+=1
        //O: co+=c
        //W: cow+=co
        //the final answer will be cow and will hold the number of times cow is in the input string
        long c = 0;
        long co = 0;
        long cow = 0;
        long n = in.nextLong();
        String input = in.next();
        for(int i = 0; i<n;i++)
        {
            if (Character.toString(input.charAt(i)).equals("C"))
            {
                c++;
            }else if(Character.toString(input.charAt(i)).equals("O"))
            {
                co+=c;
            }else
            {
                cow+=co;
            }
        }
        //write to the output file
        out.print(cow);
        out.close();

    }
}
