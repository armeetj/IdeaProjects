import java.io.*;

public class censor
{

    static String answer;
    static String censor;
    public static void main(String[] args) throws Exception
    {
        //boiler plate code
        BufferedReader in = new BufferedReader(new FileReader("censor.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("censor.out"));

        String input = in.readLine();
        censor = in.readLine();
        answer = "";

        //build the string one letter at a time
        for(int i = 0; i < input.length(); i++)
        {
            answer += input.charAt(i);
            if (answer.length() > censor.length())
            {
                cut();
            }
        }
        out.write(answer);
        out.close();
    }

    public static void cut()
    {
        String end = answer.substring(answer.length() - censor.length());
        if (end.equals(censor))
        {
            answer = answer.substring(0, (answer.length() - censor.length()));
        }
    }
}
