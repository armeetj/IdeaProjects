package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: buckets
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class buckets2
{
  public static void main(String[] args) throws Exception
  {
    Scanner scanner = new Scanner(new File("buckets.in"));
    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("buckets.out"))));

    //find the coordinates of the barn and the lake
    int barnX = -1;
    int barnY = -1;
    int lakeX = -1;
    int lakeY = -1;
    int rockX = -1;
    int rockY = -1;

    for(int i = 0; i < 10; i++)
    {
      String input = scanner.next();
      for(int j = 0; j < 10; j++)
      {

        if (input.charAt(j) == 'B')
        {
          //store the x and y value of the barn
          barnX = i;
          barnY = j;
        } else if (input.charAt(j) == 'L')
        {
          lakeX = i;
          lakeY = j;
        } else if (input.charAt(j) == 'R')
        {
          rockX = i;
          rockY = j;
        }
      }
    }

    int answer = -1;
    //check if the rock is in the way collinear with B and L
    if (((rockX == barnX && rockX == lakeX) || rockY == barnY && lakeY == rockY) && distance(rockX, rockY, barnX, barnY) < distance(lakeX, lakeY, barnX, barnY))
    {
      //now return the least number of cows needed for a brigade
      answer = Math.abs(lakeX - barnX) + Math.abs(lakeY - barnY) + 1;
    } else
    {
      //now return the least number of cows needed for a brigade
      answer = Math.abs(lakeX - barnX) + Math.abs(lakeY - barnY) - 1;
    }

    //write to output file
    printWriter.print(answer);
    printWriter.close();
  }

  public static int distance(int x1, int y1, int x2, int y2)
  {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}