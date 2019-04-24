
/*
ID: xarmeet1
LANG: JAVA
TASK: milk
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * author: Armeet Singh Jatyani
 * 1-4-19
 * Section 1_4: milk
 */
public class milk
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("milk.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        int quantity = scanner.nextInt();
        int numOfFarmers = scanner.nextInt();

        //input format: price / milk, max quantity available
        //make an array of Farmers
        Farmer[] farmers = new Farmer[numOfFarmers];
        for(int i = 0; i < numOfFarmers; i++)
        {
            farmers[i] = new Farmer(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(farmers);

        //now go through and calculate
        int milkBought = 0;
        int farmer = 0;
        int moneySpent = 0;
        while (milkBought < quantity && farmer < farmers.length)
        {
            int price = farmers[farmer].price;
            int amount = farmers[farmer].quantity;

            //buy only how much we have
            int howMuchToBuy = quantity - milkBought;

            if (howMuchToBuy > amount)
            {
                //buy all of the farmers milk
                moneySpent += (price * amount);
                milkBought += amount;
                farmer++;
            } else if (howMuchToBuy <= amount)
            {
                //buy only how much you need
                moneySpent += (howMuchToBuy * price);
                milkBought += howMuchToBuy;
                break;
            }
        }

        printWriter.println(moneySpent);
        printWriter.close();
        int i = 0;
    }

}

class Farmer implements Comparable<Farmer>
{
    int price, quantity;
    public Farmer(int price, int quantity)
    {
        this.price = price;
        this.quantity = quantity;
    }

    public int compareTo(Farmer otherFarmer) {
        int result = 0;
        if (price != otherFarmer.price) {
            result = price < otherFarmer.price ? -1 : 1;
        }
        return result;
    }

}