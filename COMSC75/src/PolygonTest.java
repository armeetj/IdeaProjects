//Armeet Singh Jatyani
// PolygonTest
/*
   In this program we make a Regular Polygon object with attributes:
   n sides, length of side, x coord, and y coord
   We make 3 constructors (default, 2 params, and 4 params)
   Then we make 3 regular polygon objs and print out their
   area and perimeter.
*/
public class PolygonTest
{
  public static void main(String[] args)
  {
    //make the 3 polygons
    RegularPolygon polygon1 = new RegularPolygon();
    RegularPolygon polygon2 = new RegularPolygon(6, 4);
    RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

    //Display Perimeter and Area for Polygon 1
    System.out.println("Polygon 1: ");
    System.out.print("Perimeter: ");
    System.out.printf("%.2f",polygon1.getPerimeter());
    System.out.print("\nArea: ");
    System.out.printf("%.2f",polygon1.getArea());

    //Display Perimeter and Area for Polygon 2
    System.out.println("\n\nPolygon 2: ");
    System.out.print("Perimeter: ");
    System.out.printf("%.2f",polygon2.getPerimeter());
    System.out.print("\nArea: ");
    System.out.printf("%.2f",polygon2.getArea());

    //Display Perimeter and Area for Polygon 3
    System.out.println("\n\nPolygon 3: ");
    System.out.print("Perimeter: ");
    System.out.printf("%.2f",polygon3.getPerimeter());
    System.out.print("\nArea: ");
    System.out.printf("%.2f",polygon3.getArea());
  }
}

class RegularPolygon
{
  //fields
  private int n;
  private double side;
  private double x;
  private double y;

  //default constructor
  RegularPolygon()
  {
    this(3, 1.0);
  }

  //constructor with n and sidelength
  RegularPolygon(int n, double side)
  {
    this(n, side, 0, 0);
  }

  //constructor with n, sidelength, xcoord, and ycoord
  RegularPolygon(int n, double side, double x, double y)
  {
    this.n = n;
    this.side = side;
    this.x = x;
    this.y = y;
  }

  //getters and setters (accessor and mutator methods
  public int getN()
  {
    return n;
  }

  public void setN(int n)
  {
    this.n = n;
  }

  public double getSide()
  {
    return side;
  }

  public void setSide(double side)
  {
    this.side = side;
  }

  public double getX()
  {
    return x;
  }

  public void setX(double x)
  {
    this.x = x;
  }

  public double getY()
  {
    return y;
  }

  public void setY(double y)
  {
    this.y = y;
  }

  //object methods

  //get the perimeter of this regular polygon
  //use P = number of sides * side length
  public double getPerimeter()
  {
    return n * side;
  }

  //get the area of this regular polygon
  //use A = (n * s^2 / 4) * (tan(pi / n))
  public double getArea()
  {
    return (n * (side * side) /
            (4 * (Math.tan((Math.PI) / n))));
  }
}
