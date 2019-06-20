//Armeet Singh Jatyani
//Circumference
/*
In this program we ask input from the user
about the circle, and then find the circumference
of that circle. We learn to use Math.PI, Scanner,
as well as if and else statements in this program.
*/

//import statements
import java.util.Scanner;
import java.lang.Math;

public class CirclePerimeterArea
{

	//main method
	public static void main(String[] args)
	{
		//inilitize the scanner to read in input
		Scanner scanner = new Scanner(System.in);

		//ask for circumference or area
		System.out.println("Would you like to calculate area(a)" +
						   "or perimeter(p)?");
		//store their choice
		String choice = scanner.next();

		//prompt the user and store their input in radius
		System.out.println("Enter the radius of the circle: ");
		double radius = scanner.nextDouble();

		//if and else statements
		if(choice.equals("circumference") || choice.equals("c"))
		{
			//print out the circumference using P = 2pi * r
			System.out.print("The circumference of this circle is ");
			System.out.printf("%.2f", 2 * Math.PI * radius);
		}else if(choice.equals("area") || choice.equals("a"))
		{
			//print out the circumference using P = 2pi * r
			System.out.print("The area  of this circle is ");
			System.out.printf("%.2f", Math.PI * Math.pow(radius, 2));

		}else
		{
			//print out the circumference using P = 2pi * r
			System.out.print("The circumference of this circle is ");
			System.out.printf("%.2f", 2 * Math.PI * radius);

			//print a blank line
			System.out.println();

			//print out the area using A = pi * r^2
			System.out.print("The area  of this circle is ");
			System.out.printf("%.2f", Math.PI * Math.pow(radius, 2));
		}

	}

}
