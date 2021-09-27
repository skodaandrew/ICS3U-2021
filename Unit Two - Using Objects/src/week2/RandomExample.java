package week2;

public class RandomExample {
    public static void main(String[] args){
    String s1 = "Max"; //string literal
    String s2 = "Fred"; //string literal
    String s3 = "Max"; //string literal
    String s4 = new String("Kyle"); //string object
    String s5 = new String("Max"); //string object

    System.out.println(s1.length()); //length returns the number of characters in the String

    System.out.println(s1.equals(s5)); //true - same sequence of characters
    System.out.println(s1.equals("max"));// false - m and m are different
    System.out.println("Brad".indexOf("ra")); //index of ra in brad is 1
    System.out.println(s2.indexOf("Red")); //red is not in Fred so return -1
    
    
    String x = "ABCDEF";

    System.out.println(x.substring(2));
    System.out.println(x.substring(2, 4));
    System.out.println(x.substring(2,3));
    System.out.println("Friday".substring(1, "Friday".length()));

    }
}
