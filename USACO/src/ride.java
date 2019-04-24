/*
ID: xarmeet1
LANG: JAVA
TASK: ride
*/
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class ride
{

    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(new File("ride.in"));
        FileWriter out = new FileWriter(new File("ride.out"));

        //the first line is the comet name
        String comet = in.next();
        //the second line is the group name
        String group = in.next();

        int cometCode = getCode(comet);
        int groupCode = getCode(group);
        if (cometCode == groupCode)
        {
            out.write("GO");
            out.write("\n");
        }else
        {
            out.write("STAY");
            out.write("\n");
        }
        out.close();

    }

    //the method getCode will convert the name of comet/group into a number
    //than that number will be divided by 47 and the remainder will be returned to the main method
    public static int getCode(String s)
    {
        char[] charArray = s.toCharArray();
        int product = 1;
        int index = 0;
        for(char c : charArray)
        {
            index = ((int) c) - 64;
            product*=index;
        }
        return product%47;
    }

}
