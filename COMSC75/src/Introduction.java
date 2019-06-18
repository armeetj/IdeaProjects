//Armeet Singh Jatyani
//Introduction
/*
    Write a Java program that prints my name, favorite short poem
    , author, age in years, age in days, and the product
    of my favorite number, 123456789, and 9
    We also learn how to make new lines using the \n character
*/

public class Introduction
{
    //Constants
    static final int DAYS_IN_YEAR = 365;
    static final int favNumber = 1;

    public static void main(String[] args)
    {
        //display my name
        System.out.println("My name is Armeet Jatyani.\n");

        //print my poem line by line to keep my code neat
        System.out.println("I shall be telling this with a sigh");
        System.out.println("Somewhere ages and ages hence:");
        System.out.println("Two roads diverged in a wood, and I—");
        System.out.println("I took the one less traveled by,");
        System.out.println("And that has made all the difference.");
        System.out.println("    --Robert Frost");

        //just print a blank line
        System.out.println();

        //store my age in years as a variable
        int ageInYears = 14;
        //print out my age
        System.out.println(ageInYears);

        //convert the ageInYears to ageInDays
        int ageInDays = (ageInYears);
        //print my age in days
        System.out.println(ageInDays);

        //here I store my favorite number in another variable with an integer datatype
        System.out.println(12345679 * 9 * favNumber);
    }
}
