//Armeet Singh Jatyani
//Final Program COMSC 75 Summer Session
/*
 * Description: In this program, we put in 20 orders for
 * clothes. We print the number of each category of clothing
 * and the price for that category of clothing. We use an array
 * of Clothing to store the Shirts and Pants.
 * The super class in this program is Clothing, and subclasses of
 * this class are Shirt and Pants.
 * Orders is the class used to enter the 20 clothes and display output.
 */

//import statements
import java.text.DecimalFormat;

public class Orders {
  public static void main (String[] args)
  {
    //make our Array of Clothes
    Clothing[] clothes = new Clothing[4];

    //create the 8 XXL green shirts
    Shirt greenShirts = new Shirt(8, "Green", "XXL");
    //create the 6 brown pants with 48 waist and 30 inseam
    Pants brownPants = new Pants(6, "Brown", 48, 30);
    //create the 2 M white shirts
    Shirt whiteShirts = new Shirt(2, "White", "M");
    //create the 4 blue pants with 36 waist and 34 inseam
    Pants bluePants = new Pants(4, "Blue", 36, 34);

    //put Clothes in array
    clothes[0] = greenShirts;
    clothes[1] = brownPants;
    clothes[2] = whiteShirts;
    clothes[3] = bluePants;


    //calculate quantities and prices for shirts
    int shirtQuantity = greenShirts.getQuantity() +
            whiteShirts.getQuantity();
    double shirtPrice = greenShirts.getQuantity() *
            greenShirts.calculatePrice() +
            whiteShirts.getQuantity() *
                    whiteShirts.calculatePrice();

    //calculate quantities and prices for pants
    int pantsQuantity = brownPants.getQuantity() +
            bluePants.getQuantity();
    double pantsPrice = brownPants.getQuantity() *
            brownPants.calculatePrice() +
            bluePants.getQuantity() *
                    bluePants.calculatePrice();

    //calculate avg waist and inseam sizes
    double waistSum = brownPants.getQuantity() *
            brownPants.getWaist() +
            bluePants.getQuantity() *
                    bluePants.getWaist();
    double inseamSum = brownPants.getQuantity() *
            brownPants.getInseam() +
            bluePants.getQuantity() *
                    bluePants.getInseam();

    double avgWaist = waistSum / pantsQuantity;
    double avgInseam = inseamSum / pantsQuantity;

    //make two DecimalFormat objects to format prices and measurements
    DecimalFormat priceFormat = new DecimalFormat("#0.00");
    DecimalFormat measurementFormat = new DecimalFormat("#0.0");

    //print out quantity and prices of shirts
    System.out.println("Total number of shirts ordered: "
            + shirtQuantity);
    System.out.println("Total price of all shirts: $"
            + priceFormat.format(shirtPrice));

    //print out quantity and prices of pants
    System.out.println("Total number of pants ordered: "
            + pantsQuantity);
    System.out.println("Total price of all pants: $"
            + priceFormat.format(pantsPrice));

    //print out avg waist and inseam sizes
    System.out.println("Average waist size: " +
            measurementFormat.format(avgWaist));
    System.out.println("Average inseam size: " +
            measurementFormat.format(avgInseam));
  }
}

//Clothing "superclass"
class Clothing
{
  //public fields
  public int quantity;
  public String color;

  //default constructor (no args)
  public Clothing()
  {
    //pass to the 2 arg constructor with default vals
    this(0, "");
  }

  //two arg constructor
  public Clothing(int quantity, String color)
  {
    this.quantity = quantity;
    this.color = color;
  }

  //getters and setters (accessor and mutator methods)
  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  public String getColor()
  {
    return color;
  }

  public void setColor(String color)
  {
    this.color = color;
  }


  //calculate and return the price of the clothing
  public double calculatePrice()
  {
    return 0.0;
  }
}

//the Shirt class is a subclass of Clothing
class Shirt extends Clothing
{
  //public fields
  public String size;

  //no arg constructor
  public Shirt()
  {
    //call the 3 arg constructor and pass the default values
    this(0, "", "");
  }

  //3 arg constructor
  public Shirt(int quantity, String color, String size)
  {
    super(quantity, color);
    this.size = size;
  }

  //getters and setters for size
  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  //calculate the price of a shirt by overriding the super method
  @Override
  public double calculatePrice()
  {
    //use a switch to return the correct price
    //break statements are unneeded
    //because we are using return statements
    switch(size)
    {
      case "S" :
        return 11.00;
      case "M" :
        return 12.50;
      case "L" :
        return 15.00;
      case "XL" :
        return 16.50;
      case "XXL" :
        return 18.50;
      default:
        return -1;
    }
  }
}

//Pants is another subclass of Clothing
class Pants extends Clothing
{
  //public fields
  public int waist;
  public int inseam;

  //no arg constructor
  public Pants()
  {
    //call the 4 arg constructor, passing default values
    this(0, "", 0, 0);
  }

  //4 arg constructor
  public Pants(int quantity, String color, int waist, int inseam)
  {
    //call the super class's constructor to set quantity and color
    super(quantity, color);
    //set waist and inseam values
    this.waist = waist;
    this.inseam = inseam;
  }

  //getters and setters
  public int getWaist() {
    return waist;
  }

  public void setWaist(int waist) {
    //only setWaist if the given waist size is positive and not 0
    if(waist > 0)
    {
      this.waist = waist;
    }
  }

  public int getInseam() {
    return inseam;
  }

  public void setInseam(int inseam) {
    //only setInseam if the given measurement is positive and not 0
    if(inseam > 0)
    {
      this.inseam = inseam;
    }
  }

  //calculate the price of pants
  //over ride the super class's calculatePrice method
  @Override
  public double calculatePrice()
  {
    //if waist is > 48 or inseam >36
    //charge (return) $65.50
    if(waist > 48 || inseam > 36)
    {
      return 65.50;
    }

    //otherwise charge (return) only $50.00
    return 50.00;
  }
}