/*
ID: xarmeetx
LANG: JAVA
TASK: word
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class word
{
    public static void main(String[] args) throws Exception
    {

//        Scanner scanner = new Scanner(new File("C:\\Users\\Armeet Singh Jatyani\\Documents\\Development\\IdeaProjects\\USACO\\src\\Bronze\\word.in"));
//        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Armeet Singh Jatyani\\Documents\\Development\\IdeaProjects\\USACO\\src\\Bronze\\word.out"))));

        Scanner scanner = new Scanner(new File("word.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("word.out"))));

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int currentLine = 0;
        String formattedEssay = "";
        for(int i = 0; i < N; i++)
        {
            String word = scanner.next();
            if (currentLine + word.length() < K)
            {
                //add the word and a space
                currentLine += word.length();
                formattedEssay+=(word + " ");
            } else if (currentLine + word.length() == K)
            {
                //add the word and move to the next line
                currentLine = K;
                formattedEssay+=(word + " ");
            } else
            {
                //move to the next line
                currentLine = word.length();
                formattedEssay = formattedEssay.substring(0, formattedEssay.length()-1);
                formattedEssay+=("\n" + word + " ");
            }
        }
        printWriter.println(formattedEssay.substring(0, formattedEssay.length()-1));
        printWriter.close();
    }
}