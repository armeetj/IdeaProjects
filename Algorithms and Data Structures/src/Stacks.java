
 //making a class called Stacks
public class Stacks
{

    //another class called LinkedLists.Node
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

    // (top) -> (obj) -> (obj)
    //top node, where we will be adding or popping objects
    private Node top;

    //check if the stack is empty
    public boolean isEmpty()
    {
      //if the top is null, the stack is empty
      return top==null;
    }

    //returns the object on the top node
    public int peek()
    {
      //return the input of the top of the stack
      return top.data;
    }

    //to add stuff to the top
    public void push(int data)
    {
      //making the new node with input: input
      Node node = new Node(data);
      //in a stack, the top points to the one below it
      //in this case we make our node point down to top, making it the new top
      node.next = top;
      top = node;
    }

    public boolean containsOne()
    {
        try
        {
            if (top.next == null && top.next.next == null)
            {
                return true;
            }
        } catch (Exception e)
        {
        }
        return false;
    }
    public int pop()
    {
      //to pop, first we store the input of what was in the top node
      int data = top.data;
      //the top becomes the one below it, and so the real top becomes unlinked from the stack and is "popped"
      top = top.next;
      //return to the user what was popped
      return data;

    }

}
