//Armeet Singh Jatyani
//MergeTestezzzzzzsw3ww
/*
  In this program we prompt the user to enter in two sorted lists.
  We then print out both lists. Finally we print out the two lists merged
  into one large sorted list. We use arrays and for loops in this program.
*/

//import the scanner
import java.util.Scanner;

public class MergeTest
{
  public static void main(String[] args)
  {
    //initialize the scanner to read input
    Scanner scanner = new Scanner(System.in);

    //prompt the user for the first list
    System.out.print("Enter the size for the list: ");
    int list1Size = scanner.nextInt();
    System.out.print("Enter the items in the list: ");
    int[] list1 = new int[list1Size];
    for(int i = 0; i < list1Size; i++)
    {
      //store the first list in an array
      list1[i] = scanner.nextInt();
    }

    //prompt the user for the second list
    System.out.print("Enter the size for the list: ");
    int list2Size = scanner.nextInt();
    System.out.print("Enter the items in the list: ");
    int[] list2 = new int[list2Size];
    for(int i = 0; i < list2Size; i++)
    {
      //store the second list in an array
      list2[i] = scanner.nextInt();
    }

    //print both lists
    System.out.print("list1 is ");
    for (int item : list1)
    {
      System.out.print(item + " ");
    }
    System.out.println();
    System.out.print("list2 is ");
    for (int item : list2)
    {
      System.out.print(item + " ");
    }
    System.out.println();

    //define the merged list to be the result of the merge function
    int[] mergedList = merge(list1, list2);
    //print the merged array
    System.out.print("The merged list is ");
    for (int item : mergedList)
    {
      System.out.print(item + " ");
    }
    System.out.println();


  }

  /*
  The merge function takes two sorted lists(arrays) and returns a larger
  sorted list(array) after we merge the two lists.
  */
  public static int[] merge(int[] list1, int[] list2)
  {
    int[] mergedArr = new int[list1.length + list2.length];

    //initialize the pointers
    int list1Pointer = 0;
    int list2Pointer = 0;
    int mergedArrPointer = 0;

    //while we can still add to the mergedArr
    while (mergedArrPointer <= mergedArr.length-1 )
    {
      //if we have added all of list1, just add all of list2
      if (list1Pointer > list1.length - 1)
      {
        for (list2Pointer = list2Pointer; list2Pointer < list2.length; list2Pointer++)
        {
          mergedArr[mergedArrPointer++] = list2[list2Pointer];
        }
      }
      //if we have added all of list2, just add all of list1
      else if (list2Pointer > list2.length - 1)
      {
        for (list1Pointer = list1Pointer; list1Pointer < list1.length; list1Pointer++)
        {
          mergedArr[mergedArrPointer++] = list1[list1Pointer];
        }
      } else
      {
        //if the item in the first list is less, we should add this to our mergedArr
        //then we should increment mergedArrPointer by 1
        //we should also increment list1Pointer by 1
        if (list1[list1Pointer] < list2[list2Pointer])
        {
          mergedArr[mergedArrPointer++] = list1[list1Pointer++];
        }
        //if the item in the second list is less, we should add this to our mergedArr
        //then we should increment mergedArrPointer by 1
        //we should also increment list2Pointer by 1
        else
        {
          mergedArr[mergedArrPointer++] = list2[list2Pointer++];
        }
      }
    }

    //return the mergedArr
    return mergedArr;
  }
}
