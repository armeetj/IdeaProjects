public class Introduction
{
    public static void main(String[] args)
    {
        //use the System.out.println(); statement to print something out to standard output
        //the \n at the end creates a new line, or a space after what we are printing
        //alternatively we could type in System.out.println(); after this line of code to make a new line after writing our name
        System.out.println("My name is Armeet Jatyani.\n");


        //this is one of my favorite poems, by Robert Frost, called "The Road Not Taken"
        /*
        Instead of using one print statement and using the \n new line character,
        I chose to use multiple print statements right after each other to clean up the code
        (Instead of having one long line of code that stretches off the screen, I prefer multiple lines so all code can
        be seen
         */
        System.out.println("I shall be telling this with a sigh");
        System.out.println("Somewhere ages and ages hence:");
        System.out.println("Two roads diverged in a wood, and I—");
        System.out.println("I took the one less traveled by,");
        System.out.println("And that has made all the difference.");
        System.out.println("    --Robert Frost");

        //make a new line, using the System.out.println(); command to just print/skip a line
        System.out.println();

        //here I store my age in a local variable called age of type integer
        int age = 14;
        //print out the age that is stored in the local variable
        System.out.println(age);
        //print out the result of the yearsToDays function, passing in the age in years as the argument
        System.out.println(yearsToDays(age));

        //here I store my favorite number in another variable with an integer datatype
        int favNumber = 1;
        System.out.println(12345679 * 9 *  favNumber);
    }

    public static int yearsToDays(int years)
    {
        //this function takes in the age in years of a person
        //it is public and static so it can be accessed from the main method
        //it returns an integer
        //return years * 365 because there are 365 days per year
        return (years * 365);
    }
}
