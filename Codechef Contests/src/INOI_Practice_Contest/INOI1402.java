//package INOI_Practice_Contest;
//
//import sun.awt.image.ImageWatched;
//
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//class INOI1402
//{
//    public static void main(String[] args) throws Exception
//    {
//        Scanner scanner = new Scanner(System.in);
//        int F = scanner.nextInt();
//        int C = scanner.nextInt();
//
//        Node[] graph = new Node[F];
//
//        for(int i = 0; i < F; i++)
//        {
//            graph[i] = new Node(i);
//        }
//
//        for(int i = 0; i < C; i++)
//        {
//            int id1 = scanner.nextInt()-1;
//            int id2 = scanner.nextInt()-1;
//            int price = scanner.nextInt();
//
//            graph[id1].price.add(price);
//            graph[id2].price.add(price);
//
//            if (!graph[id1].contains(id2))
//            {
//                graph[id1].connections.add(id2);
//            }
//            if (!graph[id2].contains(id1))
//            {
//                graph[id2].connections.add(id1);
//            }
//        }
//
//        for (int i = 0; i < F; i++)
//        {
//            for (int j = 0; j < F; j++)
//            {
//                if (i == j)
//                {
//                    continue;
//                }
//                int price = graph[i].totalPrice(i, j);
//            }
//        }
//
//    }
//
//}
//
//class Node
//{
//    int id;
//    LinkedList<Integer> connections = new LinkedList<>();
//    LinkedList<Integer> price = new LinkedList<>();
//
//    public Node(int id)
//    {
//        this.id = id;
//    }
//
//    public boolean contains(int x)
//    {
//        for(int i = 0; i < this.connections.size(); i++)
//        {
//            if (this.connections.get(i) == x)
//            {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int totalPrice(int start, int end)
//    {
//        int answer = 0;
//        LinkedList<Integer> connectionsCopy = new LinkedList<>();
//        for(int i = 0)
//
//        int next =
//        answer += totalPrice(start, end);
//
//        return answer;
//    }
//}
