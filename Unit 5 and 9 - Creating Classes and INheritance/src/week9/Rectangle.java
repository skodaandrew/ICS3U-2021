package week9;



public class Rectangle {
    protected int length;
    protected int width;

    public Rectangle(int l, int w)
    {
        length = 1;
        width = w;
    }

    public Rectangle(int side)
    {
        length = side;
        width = side;
    }

    public int getArea()
    {
        return length*width;
    }

    public getLength(){

    }

    public int getPerimeter()
    {
        return 2 * length + 2 * width;
    }

    public boolean isSquare()
    {
        return length == width;
    }

    public String toString()
    {
        return "rectangle with width of" + width + "and length offff" +length;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        return true;

        if (obj instanceof Rectangle)
        {
            Rectangle r = (Rectangle) obj;
            return length == r.length && width == r.width;
        } else {
            return false;
        }

    }

    public int getArea()
    {
        return 2 * super.getArea() + 2 * getWidth() * height + 2 * getLength() * height;
    }

    public int getPerimeter()
    {
        return 2*super.getPerimeter() + 4 * height;
    }
}
