//import java.io.*;
//import java.util.Scanner;
//
//public class cowroute_Part2
//{
//    static String answer;
//    static String censor;
//    public static void main(String[] args) throws Exception
//    {
//        Scanner scanner = new Scanner(new File("cowroute.in"));
//        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
//
//        int startLoc = scanner.nextInt();
//        int endLoc = scanner.nextInt();
//        int n = scanner.nextInt();
//
//        int answer = Integer.MAX_VALUE;
//        String[] inputFirstLine = new String[n];
//        String inputSecondLine = new String[n];
//
//        for (int i = 0; i < n; i++)
//        {
//            int price = scanner.nextInt();
//            int j = scanner.nextInt();
//            inputFirstLine[0] = price + " " + j;
//            boolean foundStart = false;
//            boolean foundEnd = false;
//            int count = 0;
//            for (int l = 0; l < j; l++)
//            {
//                int temp = scanner.nextInt();
//                if (temp == startLoc)
//                {
//                    foundStart = true;
//                }
//
//                if (temp == endLoc && foundStart)
//                {
//                    foundEnd = true;
//                }
//
//                if (foundStart && foundEnd && (temp == endLoc))
//                {
//                    int tempAns = price;
//                    if (tempAns < answer)
//                    {
//                        answer = tempAns;
//                    }
//                    String trash = scanner.nextLine();
//                    break;
//                }
//            }
//        }
//
//        //now see if you can find two routest that are cheaper
//
//
//        if (answer == Integer.MAX_VALUE)
//        {
//            answer = -1;
//        }
//
//        printWriter.println(answer);
//        printWriter.close();
//    }
//}
