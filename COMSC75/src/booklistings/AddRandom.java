//Armeet Singh Jatyani
//AddRandom
/*
  This program prompts the user with two numbers to add.
  Takes the input and checks if the user is correct.
  Displays true if they are correct, and false if they
  are incorrect. Loops infinitely until the user gets
  a question wrong. There is also a built in score.
*/


//import Scanner explicitly
import java.util.Scanner;
public class AddRandom
{

    public static void main(String[] args)
    
   	 //initialize the Scanner
   	 Scanner scanner = new Scanner(System.in);

   	 long score = 0;
   	 //prompt the user with the choice to practice + - / *
   	 System.out.println("Would you like to add, subtract, multiply or divide?: ");
   	 String choice = scanner.next();
   	 if(choice.equals("+") || choice.equals("add"))
   	 {
   		 while(true)
   		 {
   			 //find the first number
   			 long num1 = Math.round(Math.random() * 10);
   			 long num2 = Math.round(Math.random() * 10);

   			 //prompt the user to add the two numbers
   			 System.out.println("Add " + num1 + " and " + num2 + ":");
   			 //store the result that the user gave
   			 long result = scanner.nextInt();
   			 long answer = num1 + num2;

   			 //check if the user is correct
   			 if(result == answer)
   			 {
   				 System.out.println("C O R R E C T !   	 :)");
   				 System.out.println("score:" + (++score) + ("\n"));

   			 }else
   			 {
   				 System.out.println("Incorrect -> G A M E  O V E R   	 :(");
   				 System.out.println("score: " + score);
   				 break;
   			 }
   		 }
   	 } else if(choice.equals("-") || choice.equals("minus") || choice.equals("sub")|| choice.equals("subtract"))
   	 {
   		 while(true)
   		 {
   			 //find the first number
   			 long num1 = Math.round(Math.random() * 10);
   			 long num2 = Math.round(Math.random() * 10);

   			 //prompt the user to add the two numbers
   			 System.out.println("Subtract " + num1 + " and " + num2 + ":");
   			 //store the result that the user gave
   			 long result = scanner.nextInt();
   			 long answer = num1 - num2;

   			 //check if the user is correct
   			 if(result == answer)
   			 {
   				 System.out.println("C O R R E C T !   	 :)");
   				 System.out.println("score:" + (++score) + ("\n"));

   			 }else
   			 {
   				 System.out.println("Incorrect -> G A M E  O V E R   	 :(");
   				 System.out.println("score: " + score);
   				 break;
   			 }
   		 }
   	 }else if(choice.equals("/") || choice.equals("div") || choice.equals("divide"))
   	 {
   		 while(true)
   					 {
   						 //find the first number
   						 long num1 = Math.round(Math.random() * 10);
   						 long num2 = Math.round(Math.random() * 10);

   						 //prompt the user to add the two numbers
   						 System.out.println("Subtract " + num1 + " and " + num2 + ":");
   						 //store the result that the user gave
   						 double result = scanner.nextDouble();
   						 double answer = num1 / num2;

   						 //check if the user is correct
   						 if(result == answer)
   						 {
   							 System.out.println("C O R R E C T !   	 :)");
   							 System.out.println("score:" + (++score) + ("\n"));

   						 }else
   						 {
   							 System.out.println("Incorrect -> G A M E  O V E R   	 :(");
   							 System.out.println("score: " + score);
   							 break;
   						 }
   		 }
   	 }else if(choice.equals("*") || choice.equals("Divide") || choice.equals("mult"))
   	 {
   		 while(true)
   					 {
   						 //find the first number
   						 long num1 = Math.round(Math.random() * 10);
   						 long num2 = Math.round(Math.random() * 10);

   						 //prompt the user to add the two numbers
   						 System.out.println("Multiply " + num1 + " and " + num2 + ":");
   						 //store the result that the user gave
   						 long result = scanner.nextLong();
   						 long answer = num1 * num2;

   						 //check if the user is correct
   						 if(result == answer)
   						 {
   							 System.out.println("C O R R E C T !   	 :)");
   							 System.out.println("score:" + (++score) + ("\n"));

   						 }else
   						 {
   							 System.out.println("Incorrect -> G A M E  O V E R   	 :(");
   							 System.out.println("score: " + score);
   							 break;
   						 }
   		 }
   	 }
    
}
