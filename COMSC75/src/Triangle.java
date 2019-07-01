//Armeet Singh Jatyani
//Selection Structures
/*
  In this program we ask the user for three side lengths of a triangle.
  If the triangle is valid we return the perimeter.
  If the triangle is not valid we let the user know that the triangle is invalid
*/

//explicit imports
import java.util.Scanner;

public class Triangle
{
  public static void main(String[] args)
  {
    //initialize the scanner to read input
    Scanner scanner = new Scanner(System.in);

    //prompt the user to enter in 3 side lengths
    System.out.print("Enter lengths of sides of the triangle: ");
    //store the side lengths entered by the user
    double side1 = scanner.nextDouble();
    double side2 = scanner.nextDouble();
    double side3 = scanner.nextDouble();

    //if side1 + side2 < side3 the triangle is invalid
    if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1)
    {
      //the triangle isn't valid
      System.out.println("These sides do not specify a valid triangle. \n");
    } else
    {
      //the triangle is valid so display the perimeter of the triangle
      double perimeter = side1 + side2 + side3;
      System.out.println("The perimeter of the triangle is "
                         + perimeter + "\n");
    }
  }
}
