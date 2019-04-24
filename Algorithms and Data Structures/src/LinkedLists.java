public class LinkedLists
{
    private class Node
    {

        //pointer to the next
        Node next;

        //input
        int data;

        //constructor
        public Node(int data)
        {
            this.data = data;
        }

    }

    //head is the first element in the LinkedList
    Node head;

    //add to the end of the LinkedList
    public void append(int data)
    {
        //if there is no head and the list is empty, just make the object you are adding the head with the input: input
        if (head == null)
        {
            head = new Node(data);
            return;
        }

        //otherwise we do this
        //current position starts at head
        Node current = head;
        //going through the list until we reach an object that points to nothing
        while (current.next != null)
        {
            //current becomes the next position every time
            current = current.next;
        }

        //when we reach the end of the list add the LinkedLists.Node with input: input which is an integer in the method arguments above
        current.next = new Node(data);
    }

    //add to the head of the linked list
    public void prepend(int data)
    {
        //make a new head
        Node newHead = new Node(data);
        //make your new head point to the old head
        newHead.next = head;
        //make newHead your head
        head = newHead;
    }

    //pass a value, search the list for that value, when found "delete" it
    public void deleteWithValue(int data)
    {
        //if the list is empty, do nothing
        if (head == null)
        {
            return;
        }

        //if the input that you are deleting is the head, you need to make head.next the new head
        if (head.data == data)
        {
            head = head.next;
        }

        //start at the head
        Node current = head;
        //cycling through the list until we see that the next obj is the one we want to delete
        while (current != null)
        {
            //if current.next is what we want to delete excecute the following:
            if (current.next.data == data)
            {
                //make current point to current.next.next, essentially skipping over current.next, removing it from the list
                current.next = current.next.next;
                return;
            }
            //otherwise, move on:
            //your current position becomes the next position
            current = current.next;

        }
    }

    //print all the elements of the LinkedList starting with head and ending at the end
    public void printAllElements()
    {
        //current position starts at the start, which is head
        Node current = head;

        //if the list is empty print "The LinkedList is empty"
        if (head == null)
        {
            System.out.println("\"The LinkedList is empty   :(\"");
        }
        //loop until you reach the end
        while (current.next != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    //print all the elements until the next one is the argument: input
    public void printAllElementsUntilObj(int data)
    {
        //if the list is empty print "The LinkedList is empty"
        if (head == null)
        {
            System.out.println("\"The LinkedList is empty   :(\"");
            return;
        }

        //if the input is head, just print the head
        if (head.data == data)
        {
            System.out.println("head: "+head.data);
            return;
        }

        //start at the head
        Node current = head;

        //loop until the end
        while (current.next != null)
        {
            //first print out the obj
            System.out.println(current.data);

            //if the next obj has input: input, stop printing out
            if (current.next.data == data)
            {
                return;
            }

            current = current.next;
        }

    }

}

