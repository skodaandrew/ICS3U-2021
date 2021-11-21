package week8;

public class Die{
    //attributes define the state of an instance of the class at any particular time
    private int numSides;   //private means that they are only accessible (visible) inside the class
    private int topSide;

    /*
    has the same names as the class
    initialieses the state of he class (attributes)
    returns the object (although we do not say return)
    */

    /**
     * if we do not explicity create our own constructor 
     * java will supply a no argument constructor 
     * that does not initilise the state of the class
     * (attributes)
     */
    
    public Die(){
        this.numSides = 6;
        topSide = (int)(Math.random() * numSides) + 1;
    }

    public Die(int numSides){
        this.numSides = numSides;
        topSide = (int)(Math.random() * numSides) + 1;
    }

    public int getTopSide(){
        return topSide;
    }

    public void roll(){
        this.topSide = (int)(Math.random() * numSides) + 1;
    }
    
}