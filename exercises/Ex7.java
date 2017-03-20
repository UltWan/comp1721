public class Ex7
{
  public static void main(String[] args)
  {
    Rectangle rectangle1 = new Rectangle(4, 40);
    System.out.println("Rectangle 1");
    System.out.println("The width of the rectangle is: " + rectangle1.getWidth());
    System.out.println("The height of the rectangle is: " + rectangle1.getHeight());
    System.out.println("The area of the rectangle is: " + rectangle1.getArea());
    System.out.println("The perimeter of the rectangle is: " + rectangle1.getPerimeter() + "\n");

    Rectangle rectangle2 = new Rectangle(3.5, 35.9);
    System.out.println("Rectangle 2");
    System.out.println("The width of the rectangle is: " + rectangle2.getWidth());
    System.out.println("The height of the rectangle is: " + rectangle2.getHeight());
    System.out.println("The area of the rectangle is: " + rectangle2.getArea());
    System.out.println("The perimeter of the rectangle is: " + rectangle2.getPerimeter());
  }
}

  class Rectangle
  {
    double width;
    double height;

    Rectangle()
    {
      width = 1;
      height = 1;
    }

    Rectangle(double w, double h)
    {
      width = w;
      height = h;
    }

    double getWidth()
    {
      return width;
    }

    double getHeight()
    {
      return height;
    }

    double getArea()
    {
      return width * height;
    }

    double getPerimeter()
    {
      return (2*width) + (2*height);
    }
}
