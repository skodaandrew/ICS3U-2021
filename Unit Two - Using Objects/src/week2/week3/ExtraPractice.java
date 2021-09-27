package week2.week3;

public class ExtraPractice {
    public static void main(String[]args){
        exampleOne();
        
        exampleTwo();

        System.out.println(questionSix("this is a sentence.", "ent")); 
       
        System.out.println(rollDice());
       
        System.out.println(randomNumber(5, 50));

       System.out.println(removeWord("sussy", "hamburger", 5));

       System.out.println(removeE("hello"));

       volumeOfcylinder(10, 5);

       System.out.println(slopeOfline(2, 4, 1, 3));

       System.out.println(removeRandomcharacters("james"));

    }

    private static String questionSix(String string, String substr) {
        int index = string.indexOf(substr);
        String first = string.substring(0,index);
        String last = string.substring(index + substr.length());
        return first + last;
    }
    /**
     * obtains and display a integer between 1 and 100
     */
    public static void exampleOne(){
        int num = (int)(Math.random()*100) + 1;
        // (int)(math.random)() * numberofpossibilities) + starting place
        System.out.println(num);
    }

    public static void exampleTwo(){
        int number = (int)(Math.random()*50) - 50;
        System.out.println(number);
    }

    public static int rollDice(){
        int dice = (int)(Math.random()*6) + 1;
        return dice;
    }

    public static int randomNumber(int smaller, int bigger){
        int Number = (int)(Math.random()*bigger) + smaller;
        return Number;     


    }
    
    public static String removeE(String str){
    int s = str.indexOf('e');
    String word = str.substring(0, s) + str.substring(s+1);
        
    return word;

        
    }
    

    public static String removeWord(String str, String b, int index){
        String ss = str.substring(0, index);
        String aa = b.substring(0, 0);
        return ss + aa;
   }

   //public static String addTwoString(String a, String b){
       //String la = a.substring();

    public static double slopeOfline (int x1, int x2, int y1, int y2){
        double slope = x1 - x2 / y1 - y2;
        return slope;
    }

    public static void volumeOfcylinder (double radius, double height){
        double volume = Math.PI*(Math.pow(radius, 2))*height;
        System.out.println(volume);
    }

    public static String removeRandomcharacters(String str){
    int r   = (int)(Math.random()*str.length());
    String p = str.substring(0, r) + str.substring(r+1);
    return p;

    }
}

   
    

