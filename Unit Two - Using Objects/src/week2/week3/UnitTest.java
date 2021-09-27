package week2.week3;

public class UnitTest {
    public static void main(String[] args){
        System.out.println(threeCopies("Apple", 3));
        System.out.println(threeCopies("Apple", 2));
        System.out.println(removeChars("chicken bone", 2, 4)); 
        System.out.println(sqrSum(9999));
    }
    
    /**
     * write a function that accepts a String and an integer. return 3 copies of a substring of length 2
     */
    //three copies("happy" 2) => 2 "pppppp" //this grabs the second letter
    //three copies ("Apple", 3) => "lelele" //this grabs the fourth letter

     public static String threeCopies(String str, int index){
         String s = str.substring(index, index+2);
         return s + s + s;
     }

     public static String removeChars(String str, int index, int n){
         String first = str.substring(0,index);
         String last = str.substring(index+n);
         return first + last;

     }
     public static double sqrSum(int number){
         int n1 = number /1000; //7463 / 1000 = 7
         int n2 = number/100 % 10; //7463 / 100 = 74 % 10 =4
         int n3 = number / 10 % 10; // 643/10 =746 % 10 = 6
         int n4 = number % 10;

         int sum = n1 + n2 + n3 + n4;
         return Math.sqrt(sum);
     }
}
