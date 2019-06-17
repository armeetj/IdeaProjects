//Armeet Singh Jatyani
//Introduction
/*
Write a Java program that prints my name, favorite short poem, author, age in years, age in days, and the product
of my favorite number, 123456789, and 9

We also learn how to make new lines using the \n character
 */

public class Introduction
{
    //make a static constant using the final keyword with type integer, all methods in the class can access this variable
    static final int DAYS_IN_YEAR = 365;

    public static void main(String[] args)
    {
        //use the print statement to print something out to standard output
        //the \n at the end creates a new line, or a space after what we are printing
        System.out.println("My name is Armeet Jatyani.\n");

        /*
        I used multiple print statements because instead of having one long line of code that stretches off the screen,
        I prefer multiple lines so all code can be seen
         */
        System.out.println("I shall be telling this with a sigh");
        System.out.println("Somewhere ages and ages hence:");
        System.out.println("Two roads diverged in a wood, and I—");
        System.out.println("I took the one less traveled by,");
        System.out.println("And that has made all the difference.");
        System.out.println("    --Robert Frost");

        //make a new line, using the print command to just print a blank line
        System.out.println();

        //here I store my age in a local integer variable called ageInYears
        int ageInYears = 14;
        //print out the age in years
        System.out.println(ageInYears);

        //print out the result of the yearsToDays function, passing in the age in years as the argument
        System.out.println(yearsToDays(ageInYears));

        //here I store my favorite number in another variable with an integer datatype
        int favNumber = 1;
        System.out.println(12345679 * 9 * favNumber);
    }

    public static int yearsToDays(int years)
    {
        //this function takes in the age in years of a person and returns the age in days
        //it is public and static so it can be accessed from the main method
        return (years * DAYS_IN_YEAR);
    }
}
