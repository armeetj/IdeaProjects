package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: factory
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class factory3
{
  public static void main(String[] args) throws Exception
  {
    Scanner scanner = new Scanner(new File("factory.in"));
    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("factory.out"))));

    //store the number of stations
    int n = scanner.nextInt();

    //have an linkedlists of linkedlists
    Set<Integer>[] stations = new HashSet[n+1];

    for(int i = 1; i <= n; i++)
    {
      stations[i] = new HashSet<>();
    }

    //start scanning in data
    for(int i = 0; i < n -1; i++)
    {
      int source = scanner.nextInt();
      int destination = scanner.nextInt();

      //add the source
      stations[destination].add(source);
    }

    boolean found = false;

    //implement our found method to check for each station, if it can be reached by all other stations
    for(int i = 1; i <= n; i++)
    {
      Set<Integer> temp = getAllSources(stations, i);
      if (temp.size() == n - 1)
      {
        printWriter.print(i);
        printWriter.close();
        found = true;
        break;
      }
    }

    if(!found)
    {
      printWriter.print(-1);
      printWriter.close();
    }
  }

  public static Set<Integer> getAllSources(Set<Integer>[] stations, int station)
  {
    //this method will find all of the sources of a certain station recursively
    Set<Integer> set = new HashSet();
    set.addAll(stations[station]);
    for (int source : stations[station])
    {
      //also add all of its sources
      set.addAll(getAllSources(stations, source));
    }

    return set;
  }
}