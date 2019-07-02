//Armeet Singh Jatyani
//Temperature (Exam 1)
/*
  In this program, we will read in a Celsius degree in
  a double value from the user. We will then convert
  this into degrees Fahrenheit and then tell the user
  to either bring a coat, swimsuit, or that the weather
  is perfect based on the temperature in degrees
  Fahrenheit.
*/

//explicitly import the Scanner to read input
import java.util.Scanner;

public class Temperature
{
  public static void main(String[] args)
  {
    //initialize scanner so that we can read input from the console (user)
    Scanner scanner = new Scanner(System.in);

    //prompt the user to enter in the degrees C
    System.out.print("Enter a degree in Celsius: ");
    //store this value
    double degreesCelsius = scanner.nextDouble();
    //store the converted value
    double degreesFahrenheit = celsiusToDegrees(degreesCelsius);

    //now output the conversion
    //use printf("%.nf", message); to format to n decimal places
    System.out.printf("%.1f", degreesCelsius);
    System.out.print(" Celsius is ");
    System.out.printf("%.2f", degreesFahrenheit);
    System.out.println(" Fahrenheit");

    //now tell the user what they should bring based on degreesFahrenheit
    if (degreesFahrenheit > 75)
    {
      System.out.println("Please bring a swimsuit.\n");
    }
    /*
      if the statement reaches this point,
      we already know degreesFahrenheit <=75
      We just have to check if degreesFahrenheit >=65
    */
    else if (degreesFahrenheit >= 65)
    {
      System.out.println("It is perfect weather.\n");
    }
    /*
      if the statement reaches this point we know that degreesFahrenheit
      is less than 65, so we tell the user to wear a coat
     */
    else
    {
      System.out.println("Please wear a coat.\n");
    }

  }

  //this method will take the degrees celsius as a double
  //it will then convert this to degrees and return it as a double
  public static double celsiusToDegrees (double degreesCelsius)
  {
    //this formula is given in the problem statement
    //we use 9.0/5.0 so that we get a double result
    return ((9.0 / 5.0) * degreesCelsius + 32);
  }
}
