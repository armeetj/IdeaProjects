//Armeet Singh Jatyani
//Phoneword
/*
  In this program, we prompt the user for 7 letters
  which represent numbers. We convert the letters to
  a phone number and return it.
*/

//explicit imports
import java.util.Scanner;

public class Phoneword
{
	public static void main(String[] args)
	{
		//inilitiaze the scanner to read input
		Scanner scanner = new Scanner(System.in);

		//loop infinetely always asking for user input
		while(true)
		{
			//prompt the user for the 7 letter word
			System.out.println("Please enter in a 7 letter word: ");
			//read the input
			String input = scanner.nextLine();

			//we will store our number here
			String number = "";

			//uppercase the whole string
			input = input.toUpperCase();
			input = input.replaceAll("\\s+","");

			if(input.length() < 7)
			{
				System.out.println("Your phone word is not long enough" +
				                   "for a phone number.");
		    }else
		    {
				//for each character is
				for(int i = 0; i < 7; i++)
				{
					if(i == 3)
					{
						number += "-";
					}
					number += Integer.toString(charToNumber(input.charAt(i)));
				}

				//print out the number to the user
				System.out.println("Your number is " + number
								 + "\n");
			}
		}
	}

	//this method takes a character, and then converts it to a number (code)
	public static int charToNumber(char character)
	{
		//find the ASCII value
		int characterValue = (int) character;

		//check if the character is a number
		if(characterValue >= 48 && characterValue <=57)
		{
			return Integer.parseInt(Character.toString(character));
		}

		//otherwise the character is a letter of the alphabet
		switch(characterValue)
		{
			case 65: case 66: case 67:
				return 2;
			case 68: case 69: case 70:
				return 3;
			case 71: case 72: case 73:
				return 4;
			case 74: case 75: case 76:
				return 5;
			case 77: case 78: case 79:
				return 6;
			case 80: case 81: case 82: case 83:
				return 7;
			case 84: case 85: case 86:
				return 8;
			case 87: case 88: case 89: case 90:
				return 9;
		}
		return -1;
	}
}
