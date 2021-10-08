package week5;

public class FormattingString {
    public static void main(String[] args){


        int minute = 5;

        double seconds = 7.1;

      //  System.out.println(minute + ":" + seconds);

        // placeholder
        // %d -> placeholder for integers
        // %s -> place holder for strings
        //%f -> placeholder for double 

        System.out.printf("%d:%06.3f", minute, seconds);

    }
    
}
