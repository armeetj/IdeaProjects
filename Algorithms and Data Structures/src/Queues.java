//making a class to learn about queues
public class Queues
{

  //queues are FIFO: "first in - first out"
  //more like lines, stacks are more like a stack of plates

  //another class called Node
  private static class Node
  {

      //input being passed
      private int data;

      //pointer to the next node
      private Node next;

      //constructor setting input
      private Node(int data)
      {
        this.data = data;
      }

  }

    // (head) -> (obj) -> (obj) -> (tail)
    //always remove from head
    private Node head;
    //always add on tail
    private Node tail;

    //check if the queue is empty
    public boolean isEmpty()
    {
      //if head is null, the queue is empty
      return head == null;
    }

    //returns first element which in this case is the head
    public int peek()
    {
      return head.data;
    }

    //to add stuff to the top
    public void push(int data)
    {
      Node node = new Node(data);
      node = tail.next;
      tail = node;
    }

    public int pop()
    {
      //head is the first to be popped
      //store the input of the head
      int data = head.data;
      //head is no longer connected to anything
      head.next = null;
      return data;
    }

}
