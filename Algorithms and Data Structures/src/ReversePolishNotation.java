
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReversePolishNotation
{
    static String input;

    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(new FileReader(new File("ReversePolishNotation.in")));
        input = in.next();
        char[] data = input.toCharArray();
        for (char i : data)
        {
            System.out.println(i);
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(evaluate(data));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    static int evaluate(char[] data)
    {
        Stacks stack = new Stacks();
        for(int i = 0; i< data.length;i++)
        {
            if(data[i]=='*'||data[i]=='/'||data[i]=='+'||data[i]=='-')
            {
                if(data[i]=='*')
                {
                    stack.push(stack.pop() * stack.pop());
                } else if (data[i] == '/')
                {
                    int denominator = stack.pop();
                    int numerator = stack.pop();
                    stack.push(numerator / denominator);
                } else if (data[i] == '+')
                {
                    stack.push(stack.pop() + stack.pop());
                } else
                {
                    stack.push(-1*(stack.pop() - stack.pop()));
                }
            }else
            {
                stack.push(Integer.parseInt(Character.toString(data[i])));
            }

            if (stack.containsOne())
            {
                break;
            }
        }
        return stack.pop();
    }
}
