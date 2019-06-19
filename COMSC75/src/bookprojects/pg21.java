package bookprojects;

import java.util.Scanner;

public class pg21
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the degrees in Celcius: ");
        double degreesCelcius = scanner.nextDouble();
        System.out.print("Faranheit: ");
        System.out.println(((9.0/5.0)*degreesCelcius) + 32);
        //if you use line 15 the program will give a semantic error
        System.out.println(((9/5)*degreesCelcius) + 32);
    }
}
