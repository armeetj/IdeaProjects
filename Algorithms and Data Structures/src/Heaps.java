public class Heaps
{
    //in min heap, the nodes at the top are smaller
    //going down the heap, the nodes are larger
    //you insert at the bottom of the heap (which looks like a tree), from the left to the right

    //adding a node to somewhere above the bottom of the heap
    /*
    1) add the small node to the bottom of the tree
    2) compare the node to the parent
    3) if it is smaller than the parent, switch parent and the small node
    4) repeat until the node is in the desired spot
     */

    //removing the top element
    /*
    1) make the top node empty
    2) assign the value of the top node to be the largest value in the heap (bottom rightmost)
    3) compare the present top node(largest) with the left and right child
    4) swap with the smallest child
    5) continue until the large node has found its spot and the smallest node is at the top
     */

}
