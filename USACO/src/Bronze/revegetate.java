package Bronze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class revegetate
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("revegetate.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("revegetate.out"))));

        //n = number of pastures, m = number of cows
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        LinkedList<Node> graph = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            graph.add(new Node(i));
        }

        for(int i = 0; i < m; i++)
        {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            graph.get(a).connections.add(b);
            graph.get(b).connections.add(a);
        }
        int x = 3;

        //for each pasture, find the seed
        for (int i = 0; i < n; i++)
        {
            int seed = -1;
            for (int j : graph.get(i).connections)
            {
                seed = Math.max(graph.get(j).seed, seed);
            }
            if (seed == -1)
            {
                graph.get(i).seed = 1;
            } else
            {
                graph.get(i).seed = seed + 1;
            }
        }

        for (Node node : graph)
        {
            printWriter.print(node.seed);
        }
        printWriter.close();
    }

}

class Node
{
    int pasture;
    int seed;
    LinkedList<Integer> connections = new LinkedList<>();

    public Node(int pasture)
    {
        this.pasture = pasture;
        seed = -1;
    }

    public void addConnection(int x)
    {
        connections.add(x);
    }

}