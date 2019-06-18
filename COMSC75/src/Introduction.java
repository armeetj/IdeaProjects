//Armeet Singh Jatyani
//Introduction
/*
    Write a Java program that prints my name, favorite short poem
    with author, age in years, age in days, and the product
    of my favorite number, 123456789, and 9
    We also learn how to make new lines using the \n character
*/

public class Introduction
{
    public static void main(String[] args)
    {
	//Constants
	final int DAYS_IN_YEAR = 365;
    	final int FAV_NUMBER = 1;

        //print my name
        System.out.println("My name is Armeet Jatyani.\n");

        //print my poem line by line with the author
        System.out.println("I shall be telling this with a sigh");
        System.out.println("Somewhere ages and ages hence:");
        System.out.println("Two roads diverged in a wood, and I—");
        System.out.println("I took the one less traveled by,");
        System.out.println("And that has made all the difference.");
        System.out.println("    --Robert Frost");

        //print a blank line
        System.out.println();

        //store my age in years as a variable
        int ageInYears = 14;
        //print out my age in years
        System.out.println(ageInYears);

        //convert my  ageInYears to ageInDays
        int ageInDays = (ageInYears * DAYS_IN_YEAR);
        //print my age in days
        System.out.println(ageInDays);

        //calculate the product of 12345679, 9 and my favorite number
        //store this in a variable called product
        int product = 12345679 * 9 * FAV_NUMBER;
        //print the product
        System.out.println(product);
    }
}
