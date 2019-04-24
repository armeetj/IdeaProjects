import java.util.Scanner;

public class fractional_knapsack
{
    static double bestLoot = -1.00;
    static int bestLootX = -1;
    static int bestLootY = -1;
    static double[][] loot;
    static int n;
    static double bestLootVal;
    static double bestLootWeight;
    static boolean toggle = false;
    public static void main(String[] args)
    {
        //set up the input
        Scanner in = new Scanner(System.in);

        //read in the number of items
        n = in.nextInt();

        //now read in the size/capacity of the bag
        double capacity = in.nextDouble();
        if (capacity == 0)
        {
            System.out.println(0);
            toggle = true;
        }
        //wealth will keep track of how much value that we have in our bag
        double wealth = 0;

        loot = new double[n][3];
        //store the objects weight as well as their value in this array
        //the first column will hold the value of the loot
        //the second column will hold the weight of the loot (how much capacity it takes up in the knapsack)
        //the last column will hold the ratio of the value to the weight of the item (how valuable each item is based on its weight) (best bargain)

        //value, weight, ratio(value/weight)
        for(int i = 0; i< n; i++)
        {
            for(int j = 0; j< 1; j++)
            {
                loot[i][j] = in.nextDouble();
                loot[i][j+1] = in.nextDouble();
                loot[i][j+2] = loot[i][j]/loot[i][j+1];
            }
        }

        if (!toggle)
        {

            //now that we have stored the data calculate the ratios of value to weight and all the values we need, we can solve the problem
            while (bestLoot!=0 &&capacity>0)
            {
                //calculate the bestLoot
                bestLoot();
                if (bestLootVal == 0)
                {
                    break;
                } else if (bestLootWeight > 0 && bestLootWeight <= capacity)
                {
                    //if the loot with the greatest value is still left and if the loot is less than the capacity
                    //just put the loot in our bag and change the necessary values
                    wealth += loot[bestLootX][0];
                    capacity -= loot[bestLootX][1];
                    loot[bestLootX][0] = 0;
                    loot[bestLootX][1] = 0;
                    loot[bestLootX][2] = 0;
                    bestLoot = -1;

                } else if (bestLootVal > 0 && bestLootWeight > capacity)
                {
                    //if the loot with the greatest value still exists but we can't fit the entire loot in our bag
                    //we must split the loot into a smaller piece that we can fit in our bag
                    //find the biggest piece that we can split the loot into to fit into our bag
                    //to do this we just divide the capacity of our bag into the item
                    //this will give us the fraction of the loot we should take
                    double fraction = capacity / loot[bestLootX][1];
                    //now change the necessary values
                    wealth += fraction * loot[bestLootX][0];
                    capacity -= fraction * loot[bestLootX][1];
                    loot[bestLootX][0] *= (1 - fraction);
                    loot[bestLootX][1] *= (-fraction);
                    loot[bestLootX][2] *= (1 - fraction);
                    bestLoot = loot[bestLootX][2];
                } else
                {
                    //there is no more of that material left
                    //in this case assign all the values to be 0 and run bestLoot again
                    loot[bestLootX][0] = 0;
                    loot[bestLootX][1] = 0;
                    loot[bestLootX][2] = 0;
                    bestLoot = loot[bestLootX][2];
                    bestLoot();
                }

            }
            System.out.println(wealth);
        }
    }

    public static void bestLoot()
    {
        //find the bestLoot currently
        for(int i = 0; i< n; i++)
        {
            if(bestLoot < loot[i][2])
            {
                bestLoot = loot[i][2];
                bestLootX = i;
                bestLootY = 2;
                bestLootVal = loot[bestLootX][0];
                bestLootWeight = loot[bestLootX][1];
            }
        }
    }
}
