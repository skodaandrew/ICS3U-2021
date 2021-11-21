package week9;



public class ShapeDriver {
    public static void main(String[] args) {
    Rectangle r1 = new Rectangle(5, 3);
    Rectangle r2 = new Rectangle(6);

    if(r1.isSquare())
        System.out.println("r1 is a square");
    else
        System.out.println("r1 is not a square");

    if(r2.isSquare())
       System.out.println("r2 is a square");
    else
        System.out.println("r2 is not a square");

    if(r1.equals(r2))
        System.out.println("they are equal");
    else
        System.out.println("there are not equal");

    System.out.println("r1 area" + r1.getArea());
    System.out.println("r2 area" + r2.getArea());
    System.out.println("r1 perimeter" + r1.getPerimeter());
    System.out.println("r2 perimeter" + r2.getPerimeter());

    System.out.println(r1);
    System.out.println(r2);


    }
}
