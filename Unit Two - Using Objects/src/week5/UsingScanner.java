package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        //exampleone(in);
        exampletwo(in);
        in.close();
    }

    private static void exampletwo(Scanner in) {
        System.out.print("enter a number: ");
     //   double num = in.nextDouble();

        double num = 0;

        boolean validinput = false;

        while(!validinput){
        try {
         num = Double.parseDouble(in.nextLine());
         validinput = true;
        }catch(Exception ex){
            System.out.print("invalid input !1!1!!! enter a number: ");
        }
        
    }
        
        double result = Math.pow(num, 2);
        System.out.println(result);
    }

    private static void exampleone(Scanner in) {
    System.out.print("type you name: ");
    String name = in.nextLine();

    System.out.println("hewwwwooooo " + name);
    }
    
}
