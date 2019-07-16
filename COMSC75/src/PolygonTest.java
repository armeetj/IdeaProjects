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
    System.out.println("Perimeter: " + polygon1.getPerimeter());
    System.out.println("Area: " + polygon1.getArea() + "\n");

    //Display Perimeter and Area for Polygon 2
    System.out.println("Polygon 2: ");
    System.out.println("Perimeter: " + polygon2.getPerimeter());
    System.out.println("Area: " + polygon2.getArea() + "\n");

    //Display Perimeter and Area for Polygon 3
    System.out.println("Polygon 3: ");
    System.out.println("Perimeter: " + polygon3.getPerimeter());
    System.out.println("Area: " + polygon3.getArea() + "\n");
  }
}

class RegularPolygon
{
  //fields
  private int n;
  private double side;
  private double x;
  private double y;

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
    return getN() * getSide();
  }

  //get the area of this regular polygon
  //use A = (n * s^2 / 4) * (tan(pi / n))
  public double getArea()
  {
    return ((getN() * (getSide() * getSide())) / (4 * (Math.tan((Math.PI) / getN()))));
  }

  //default constructor
  RegularPolygon()
  {
    this.n = 3;
    this.side = 1.0;
    this.x = 0.0;
    this.y = 0.0;
  }

  //constructor with n and sidelength
  RegularPolygon(int n, double side)
  {
    this.n = n;
    this.side = side;
    this.x = 0.0;
    this.y = 0.0;
  }

  //constructor with n, sidelength, xcoord, and ycoord
  RegularPolygon(int n, double side, double x, double y)
  {
    this.n = n;
    this.side = side;
    this.x = x;
    this.y = y;
  }

}
