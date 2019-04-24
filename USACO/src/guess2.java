import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class guess2
{
    public static void main(String[] args) throws Exception
    {
        //USACO 2019 January Contest, Bronze (after contest)
        //Problem 3. Guess the Animal
        Scanner scanner = new Scanner(new File("guess.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("guess.out"))));

        //number of type of animal
        int n = scanner.nextInt();

        List<Characteristic> charactersCopy = new LinkedList<>();

        List<Animal> animals = new LinkedList<>();
        List<Animal> animalsCopy = new LinkedList<>();

        for (int i = 0; i < n; i++)
        {
            animalsCopy.add(new Animal());
            animalsCopy.get(i).id = scanner.next();
            LinkedList<String> temp = new LinkedList<>();
            for (int j = 0; j < temp.size(); j++)
            {
                temp.add(scanner.next());
                if (contains(charactersCopy, temp.get(j))<0)
                {
                    charactersCopy.add(new Characteristic(temp.get(j), 1));

                } else
                {
                    charactersCopy.get(contains(charactersCopy,temp.get(j))).increment(1);
                }
            }
            animalsCopy.get(i).characteristics = temp;
        }

        Collections.sort(charactersCopy);
        for (int z = 0; z < animalsCopy.size(); z++)
        {
            animals.add(animalsCopy.get(z));
        }
        int ans = -1;
        for(int i = 0; i < animalsCopy.size()-1; i++)
        {
            for (int l = 0; l < animalsCopy.size() - 1; l++)
            {
                if (i == l)
                {
                    continue;
                }
                animalsCopy.get(i).characteristics.retainAll(animalsCopy.get(l).characteristics);
                int count = animalsCopy.size();
                ans = Math.max(count, ans);
                animalsCopy.clear();
                for (int z = 0; z < animals.size(); z++)
                {
                    animalsCopy.add(animals.get(z));
                }
            }
        }
        printWriter.println(--ans);
        printWriter.close();
    }

    public static int contains(List<Characteristic> list, String str)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).id.equals(str))
            {
                return i;
            }
        }
        return -1;
    }
}

class Characteristic implements Comparable<Characteristic>
{
    String id;
    int magnitude;
    Characteristic(String id, int magnitude)
    {
        this.id = id;
        this.magnitude = magnitude;
    }

    public int compareTo(Characteristic other)
    {
        int result = 0;

        if (magnitude != other.magnitude) {
            result = magnitude < other.magnitude ? -1 : 1;
        }
        return result;
    }

    public void increment(int increment)
    {
        magnitude += increment;
    }
}

class Animal
{
    String id;
    LinkedList<String> characteristics;

    public boolean contains(String string)
    {
        for(int i = 0; i < characteristics.size(); i++)
        {
            if (characteristics.get(i).equals(string))
            {
                return true;
            }
        }
        return false;
    }
    public Animal(String id, LinkedList<String> characteristics)
    {
        this.id = id;
        this.characteristics = characteristics;
    }
    public Animal()
    {
    }
}
