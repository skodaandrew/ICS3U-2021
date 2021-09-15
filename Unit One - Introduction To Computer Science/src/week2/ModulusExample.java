package week2;

public class ModulusExample{
    public static void main(String[] args){
    int num = 5672;
    int num1 = num / 1000; //5
    int num4 = num % 10; //2
    int num2 = num % 1000 / 100; //5672 % 1000 => 672 / 100 =>6
    
    num2 = num / 100 % 10;
    int num3 = num % 100 /10;

    System.out.println (num + num1 + num2 + num3 + num4);

    }

}
