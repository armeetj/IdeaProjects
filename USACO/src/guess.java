//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.*;
//
//public class guess
//{
//    public static void main(String[] args) throws Exception
//    {
//        //USACO 2019 January Contest, Bronze (after contest)
//        //Problem 3. Guess the Animal
//        Scanner scanner = new Scanner(new File("guess.in"));
//        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("guess.out"))));
//
//        //number of type of animal
//        int n = scanner.nextInt();
//
//        List<Characteristic> charactersCopy = new LinkedList<>();
//        List<Animal> animalsCopy = new LinkedList<>();
//
//        for (int i = 0; i < n; i++)
//        {
//            animalsCopy.add(new Animal());
//            animalsCopy.get(i).id = scanner.next();
//            String[] temp = new String[scanner.nextInt()];
//            for (int j = 0; j < temp.length; j++)
//            {
//                temp[j] = scanner.next();
//                if (contains(charactersCopy, temp[j])<0)
//                {
//                    charactersCopy.add(new Characteristic(temp[j], 1));
//
//                } else
//                {
//                    charactersCopy.get(contains(charactersCopy,temp[j])).increment(1);
//                }
//            }
//            animalsCopy.get(i).characteristics = temp;
//        }
//
//        Collections.sort(charactersCopy);
//
//        int count = 0;
//        while(animalsCopy.size()!=1)
//        {
//            count++;
//            //ask a question to which the answer is yes, and eliminate the animals that aren't possible
//            String question = charactersCopy.get(charactersCopy.size() - 1).id;
//            for(int i = 0; i < animalsCopy.size(); i++)
//            {
//                if (!animalsCopy.get(i).contains(question))
//                {
//
//                    String[] temp = animalsCopy.get(i).characteristics;
//                    animalsCopy.remove(i);
//                    for(int j = 0; j < temp.length; j++)
//                    {
//                        int index = contains(charactersCopy, temp[j]);
//                        if (index != -1)
//                        {
//                            charactersCopy.get(index).magnitude--;
//                        }
//                    }
//                }
//            }
//            charactersCopy.remove(charactersCopy.size() - 1);
//            Collections.sort(charactersCopy);
//        }
//        printWriter.println(count);
//        printWriter.close();
//    }
//    public static int contains(List<Characteristic> list, String str)
//    {
//        for (int i = 0; i < list.size(); i++)
//        {
//            if (list.get(i).id.equals(str))
//            {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//
//
//}
////class Characteristic implements Comparable<Characteristic>
////{
////    String id;
////    int magnitude;
////    Characteristic(String id, int magnitude)
////    {
////        this.id = id;
////        this.magnitude = magnitude;
////    }
////
////    public int compareTo(Characteristic other)
////    {
////        int result = 0;
////        if (magnitude != other.magnitude) {
////            result = magnitude < other.magnitude ? -1 : 1;
////        }
////        return result;
////    }
////
////    public void increment(int increment)
////    {
////        magnitude += increment;
////    }
////}
//
//
////class Animal
////{
////    String id;
////    String[] characteristics;
////
////    public boolean contains(String string)
////    {
////        for(int i = 0; i < characteristics.length; i++)
////        {
////            if (characteristics[i].equals(string))
////            {
////                return true;
////            }
////        }
////        return false;
////    }
////    public Animal(String id, String[] characteristics)
////    {
////        this.id = id;
////        this.characteristics = characteristics;
////    }
////    public Animal()
////    {
////    }
////}
