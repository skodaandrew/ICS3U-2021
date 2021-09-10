package week1;

public class ExampleThree {
    public static void main(String[] args){
        //System.out.println("This is "very" important!") //double quotes encapsulate 
        //string literals - putting quotes in a stringing literal get java upset

        System.out.println("This is \"very\" important!");
        //- creates a escape sequence

        //System.out.println("This is \very important!"); // \v is not a valid escape

        //System.out.println("This is "\very\" important!");

        System.out.println("This is very \\important!");

        System.out.println("This\nis\nvery\nimportant!"); // \n is a new line
    }
}
