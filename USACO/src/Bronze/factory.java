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

public class factory
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("factory.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("factory.out"))));

        int n = scanner.nextInt();
        Node[] graph = new Node[n];
        for(int i = 0; i < n; i++)
        {
            graph[i] = new Node(i);
        }
        for(int i = 0; i < n-1; i++)
        {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            graph[a].out.add(b);
            graph[b].in.add(a);
        }

        for (Node currentNode : graph)
        {
            for (int outputNode : currentNode.out)
            {
                graph[outputNode].in.addAll(currentNode.in);
            }
        }
        int ans = -1;
        for(int i = 0; i < n-1; i++)
        {
            if (graph[i].isReachable(n))
            {
                ans = i+1;
                break;
            }
        }
        int trash = 1;
        printWriter.println(ans);
        printWriter.close();

    }

    static class Node
    {
        int name;
        Set<Integer> in = new HashSet<>();
        Set<Integer> out = new HashSet<>();
        public Node(int n)
        {
            this.name = n;
            in.add(n);
            out.add(n);
        }


        public boolean isReachable(int size)
        {
            if (in.size() == size)
            {
                return true;
            }
            return false;
        }
    }
}

