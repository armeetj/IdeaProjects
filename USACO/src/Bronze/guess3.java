package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: guess
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class guess3
{
  public static void main(String[] args) throws Exception
  {
    Scanner scanner = new Scanner(new File("guess.in"));
    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("guess.out"))));
    int n = scanner.nextInt();

    HashMap<String, String[]> animals = new HashMap<>();
    HashMap<String, Integer> characteristicsCount = new HashMap<>();
    ArrayList<String> feasibleSet = new ArrayList<>();

    for (int i = 0; i < n; i++)
    {
      String animal = scanner.next();
      feasibleSet.add(animal);
      int temp = scanner.nextInt();
      String[] characteristicsArray = new String[temp];
      for (int j = 0; j < temp; j++)
      {
        String characteristic = scanner.next();
        characteristicsArray[j] = characteristic;

        if (characteristicsCount.containsKey(characteristic))
        {
          characteristicsCount.replace(characteristic, characteristicsCount.get(characteristic) + 1);
        } else
        {
          characteristicsCount.put(characteristic, 1);
        }
      }

      animals.put(animal, characteristicsArray);
    }

    //now keep asking questions
    int i = 0;
    while(true)
    {
      //sort by number of times the characteristic shows up
      characteristicsCount = fullySort(characteristicsCount);
      //ask question
      String question = (String) characteristicsCount.keySet().toArray()[characteristicsCount.size() - 1];
      characteristicsCount.remove(question);
      //now remove all the animals that don't have this characteristic
      ArrayList<String> feasibleSetCopy = new ArrayList<>();
      for (String s : feasibleSet)
      {
        feasibleSetCopy.add(s);
      }

      for (String animal : feasibleSetCopy)
      {
        if (!contains(animals.get(animal), question))
        {
          feasibleSet.remove(animal);
          for (String animalCharacteristic : animals.get(animal))
          {
            if (characteristicsCount.containsKey(animalCharacteristic))
            {
              characteristicsCount.replace(animalCharacteristic, characteristicsCount.get(animalCharacteristic) - 1);
            }
          }
        }
      }

      i++;
      if (feasibleSet.size() == 1)
      {
        break;
      }
    }

    printWriter.println(i);
    printWriter.close();


//    int i = 0;

  }

  public static HashMap<String, Integer> fullySort (HashMap hmap)
  {
    HashMap<String, Integer> map = sortByValues(hmap);
    return map;
  }

  private static HashMap sortByValues(HashMap map) {
    List list = new LinkedList(map.entrySet());
    // Defined Custom Comparator here
    Collections.sort(list, new Comparator() {
      public int compare(Object o1, Object o2) {
        return ((Comparable) ((Map.Entry) (o1)).getValue())
                .compareTo(((Map.Entry) (o2)).getValue());
      }
    });

    // Here I am copying the sorted list in HashMap
    // using LinkedHashMap to preserve the insertion order
    HashMap sortedHashMap = new LinkedHashMap();
    for (Iterator it = list.iterator(); it.hasNext();) {
      Map.Entry entry = (Map.Entry) it.next();
      sortedHashMap.put(entry.getKey(), entry.getValue());
    }
    return sortedHashMap;
  }

  public static boolean contains(String[] arr, String val)
  {
    for (String temp : arr)
    {
      if (temp.equals(val))
      {
        return true;
      }
    }
    return false;
  }
}