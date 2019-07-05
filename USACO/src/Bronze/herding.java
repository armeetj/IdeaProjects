package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: task name here
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class herding
{
  public static void main(String[] args) throws Exception
  {
    Scanner scanner = new Scanner(new File("herding.in"));
    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("herding.out"))));

    ArrayList<Long> numberLine = new ArrayList<>();
    numberLine.add(scanner.nextLong());
    numberLine.add(scanner.nextLong());
    numberLine.add(scanner.nextLong());
    Collections.sort(numberLine);

    long leastMoves = -1;
    long mostMoves = -1;

    if (numberLine.get(0) + 1 == numberLine.get(1) && numberLine.get(1) + 1 == numberLine.get(2))
    {
      //already in line
      leastMoves = 0;
      mostMoves = 0;
    } else if (numberLine.get(0) + 2 == numberLine.get(1) ^ numberLine.get(1) + 2 == numberLine.get(2))
    {
      //single space only on one side
      leastMoves = 1;
      mostMoves = (numberLine.get(2) - numberLine.get(0) - 3);
    }  else if (numberLine.get(0) + 2 == numberLine.get(1) && numberLine.get(1) + 2 == numberLine.get(2))
    {
      //single space on both sides
      leastMoves = 1;
      mostMoves = 1;
    }else
    {
      //otherwise
      leastMoves = 2;
      if (numberLine.get(1) - numberLine.get(0) >= numberLine.get(2) - numberLine.get(1))
      {
        mostMoves = (numberLine.get(1) - numberLine.get(0) - 1);
      }else
      {
        mostMoves = (numberLine.get(2) - numberLine.get(1) - 1);
      }
    }

    //write to ouptut file
    printWriter.println(leastMoves);
    printWriter.println(mostMoves);
    printWriter.close();

  }
}