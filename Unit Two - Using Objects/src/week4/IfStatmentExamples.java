package week4;

public class IfStatmentExamples {
    public static void main(String[] args){
        ExampleOne();
        //String letterGrade = getLetterGrade(78);
        exampleThree();
    }

    private static void exampleThree() {
        /**
         * > greater then
         * < less then
         * == equal to
         * >= greater than or equal to
         * <= less then or equal to 
         * !=   (not equal)
         * 
         * || or (x>7) || (y>7) either are TRUE to be TRUE
         * && AND (x>7)||(y>7)  both are TRUE to be TRUE
         * ! NOT !(x>7) x=<7
         * 
         */
    }

   /**  private static String getLetterGrade(int mark) {
        String letter;
        
        if (mark >= 90){
            return "A+";
        } else if (mark >= 80){
            return "A";
        } else if (mark >= 70){
            return "B";
        } else if (mark >= 60){
            return "C";
        }else if (mark >= 50){
            return "d";
        } else {
            letter "F";
        }
        
        return letter;
    }
    */

    private static void ExampleOne() {
        int x = 7;
        
        if (x % 2 == 0){
            System.out.println(x + " is even");
        } else {
            System.out.println(x + " is odd");
        }
        /** 
        if (x % 2 == 0){
            System.out.println(x + "x is odd");
        }*/
        
    }
    
}
