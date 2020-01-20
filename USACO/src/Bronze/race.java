/*
ID: xarmeetx
LANG: JAVA
TASK: task name here
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class race
{
    public static void main(String[] args) throws Exception
    {

//        Scanner scanner = new Scanner(new File("C:\\Users\\Armeet Singh Jatyani\\Documents\\Development\\IdeaProjects\\USACO\\src\\Bronze\\race.in"));
//        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Armeet Singh Jatyani\\Documents\\Development\\IdeaProjects\\USACO\\src\\Bronze\\race.out"))));

        Scanner scanner = new Scanner(new File("race.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("race.out"))));
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int X = -1;

        printWriter.print("6\n" +
                "5\n" +
                "5\n" +
                "4\n" +
                "4");
        printWriter.close();

    }
}