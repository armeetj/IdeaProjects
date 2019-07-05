package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: factory
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class factory2
{
    static Node[] graph;
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("factory.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("factory.out"))));

        int n = scanner.nextInt();
        graph = new Node[n];
        for(int i = 0; i < n; i++)
        {
            graph[i] = new Node(i);
        }
        for(int i = 0; i < n-1; i++)
        {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            graph[a].out.add(b);
        }
        Set<Integer> possibleSolutions = new HashSet<>();
        for (Node node : graph)
        {
            for (int index: node.out)
            {
                node.out.addAll(graph[index].out);
            }
        }

        for(int i = 0; i < n; i++)
        {
            possibleSolutions.add(i);
        }
        for (Node node : graph)
        {
            possibleSolutions.retainAll(node.out);
        }
        System.out.println(possibleSolutions);
        int ans = Integer.MAX_VALUE;
        if (possibleSolutions.size() == 0)
        {
            ans = -1;
        }else
        {
            for (int a : possibleSolutions)
            {
                ans = Math.min(ans, a);
            }
            ans++;
        }
        int trash = 1;
        printWriter.println(ans);
        printWriter.close();

    }

    static class Node
    {
        int name;
        Set<Integer> out = new HashSet<>();
        public Node(int n)
        {
            this.name = n;
            out.add(n);
        }

        public void addOut(int name)
        {
            out.add(name);

            for (int output : graph[name].out)
            {
                out.addAll(graph[output].out);
            }
        }

    }
}

