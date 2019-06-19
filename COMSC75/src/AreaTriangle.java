//Armeet Singh Jatyani
//AreaTriangle
/*
	In this program, we prompt the user for 3 coordinate pairs.
	We use the distance between two points formula and Heron's formula
	to find the area of this triangle.
*/

//import the necessary libraries
//import Math to gain access to Math.pow() and Math.sqrt() functions
import java.lang.Math;
//import Scanner to read user input
import java.util.Scanner;

public class AreaTriangle
{
	public static void main(String[] args)
	{
		//make a scanner from which we will read data from user
		Scanner scanner = new Scanner(System.in);

		//prompt the user to enter 3 coordinate pairs
		System.out.println("Enter the coordinates of three points" +
		"seperated by spaces");
		System.out.println("like x1 y1 x2 y2 x3 y3: 1.3 -3.03 4.7 8" +
		"2.5 -8.4 ");

		//store the user's coordinate pairs as variables
		double x1 = scanner.nextDouble();
		double y1 = scanner.nextDouble();
		double x2 = scanner.nextDouble();
		double y2 = scanner.nextDouble();
		double x3 = scanner.nextDouble();
		double y3 = scanner.nextDouble();

		//calculate all the side lengths (distance between vertices)
		double side1 = distance(x1, y1, x2, y2);
		double side2 = distance(x2, y2, x3, y3);
		double side3 = distance(x1, y1, x3, y3);

		//calculate the semiperimeter of the traingle
		double semiPerimeter = (side1 + side2 + side3)/2;

		//calculate area of the rectangle
		double area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) *
		(semiPerimeter - side2) * (semiPerimeter - side3));

		//print out the area to the user
		System.out.printf("The area of the triangle is %.1f ", area);

	}

	public static double distance(double x1,double y1,double x2,double y2)
	{
		//this method/function calculates the distance between two points
		//coordinates are (x1,y1) and (x2,y2)
		return Math.sqrt((Math.pow((x1-x2),2) + (Math.pow((y1-y2), 2))));
	}
}
