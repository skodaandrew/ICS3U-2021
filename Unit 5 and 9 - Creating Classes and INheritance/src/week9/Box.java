package week9;

public class Box extends Rectangle {
    /**
     * 
     * if you do not explicity write a constructor 
     * then java will implicity write one for you and 
     * takes no arguments and then calls no arguemnt constructor
     
     *public Box(){
     *  super();        //super refers to the parents class
     *}
     */

     private int height;

     public Box(int l, int w, int h)
     {
         /**
          * we do not get to directly sccess the parents class private attributes and methods
          *length = l;
          *width = w;
          */
        

        /**
         * first statment of a constructor 
         * must be a call to the classes 
         * parent constructor
         * 
         * (if you dont not explicity do it java will implicity 
         * do it by calling the
         * no arg parent constructor)
         */

        super(l,w);
        height = h;
        
     }

     public Box(int Side)
     {
        super(Side);
        height = Side;
     }

     public int getArea()
     {
         return 2 * super.getArea() + 2 * width * height + 2 * length * height;
     }

     
}
