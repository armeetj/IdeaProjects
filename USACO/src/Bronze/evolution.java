package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: evolution
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class evolution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("evolution.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("evolution.out"))));

        Node[] levels = new Node[25];
        Node[] levels2 = new Node[25];
        for(int i = 0; i < levels.length; i++)
        {
            levels[i] = new Node();
            levels2[i] = new Node();
        }

        int n = scanner.nextInt();
        int max = -1;
        for (int i = 0; i < n; i++)
        {
            int depth = scanner.nextInt();
            max = Math.max(max, depth);
            HashSet<String> characteristics = new HashSet<>();
            for (int j = 0; j < depth; j++)
            {
                characteristics.add(scanner.next());
            }
//            LinkedList<HashSet> abc = levels[depth].properties;
//            abc.add(characteristics);

        }
        boolean ok = true;
        for (int i = 0; i <= max; i++)
        {

            if (levels[i].properties.size() == 0)
            {
                levels2[i] = levels[i];
            } else
            {
                //validate here
//                ok = validate(levels2[i - 1], levels2[i]);
            }
        }
        String ans = "yes";
        printWriter.println(ans);
        printWriter.close();

        int x = 2;
    }

    public boolean validate(LinkedList<HashSet<String>> first, LinkedList<HashSet<String>> second)
    {
        for (HashSet<String> set1 : second)
        {
            for (String property : set1)
            {
                for (HashSet<String> set2 : first)
                {
                    if (set2!=null &&(set2.size() == 0))
                    {
                       return true;
                    }else if(set2.contains(property))
                    {

                    }
                }
            }
        }
        return false;
    }

    static class Node
    {
        LinkedList<HashSet<String>> properties;

        public Node()
        {
            this.properties = new LinkedList<>();
        }
    }
}