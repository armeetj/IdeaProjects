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
