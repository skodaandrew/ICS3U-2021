package week6;

public class comparingobjects {
    public static void main(String[] args){
        // when comparing strings never ever use == in java

        // why

        //i fwe don't instantiate a object then the variable stores null
        //other wise the variable stores the address 

        //why 
        
        //when you use == you are comparing what is stored in the variable
        //which is the address (location in memory where the object is stored).

        //equals method compares the sequence of the characters in the two object

        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(s1.equals(s2));

        String str1 = "ABCD";
        String str2 = "BCD";

       // System.out.println(str1.compareTo(str2));
       System.out.println("a".compareTo("g"));
    }
}
