package week2;

public class MoneyCount {
    public static void main(String[]args){
        
        double pennies = 0.01;
        double nickels = 0.05;
        double dimes = 0.1;
        double quarters = 0.25;
        int loonies = 1;
        int toonies = 2;
        double totalmoney = pennies + nickels + dimes + quarters + loonies + toonies;

        System.out.println("you have " + totalmoney);

    }
}
