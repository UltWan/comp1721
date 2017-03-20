public class Ex9
{
  public static void main(String[] args)
  {
    Rectangle rectangle1 = new Rectangle(4, 40);
    System.out.println("Rectangle 1\n" + rectangle1.toString() + "\n");

    Rectangle rectangle2 = new Rectangle(-1, 6);
    System.out.println("Rectangle 2\n" + rectangle2.toString());
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
      if (w <= 0)
      {
        throw new IllegalArgumentException("Width must be > 0");
      }
      height = h;
      if (h <= 0)
      {
        throw new IllegalArgumentException("Height must be > 0");
      }
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

    public String toString()
    {
      return String.format("Width:     %.2f\nHeight:    %.2f\nArea:      %.2f\nPerimeter: %.2f", width, height, getArea(), getPerimeter());
    }
}
