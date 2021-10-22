package week7;

import java.util.Scanner;


/*
1: game starts

2: deal cards [loop] i=0; i<5

3:loop thru who played untile pts is reached

*/

/*
a: add card to hand

private static String addCardToHand

str.substring (carhand,stringnew(card))

if currenthand.length == 0
newhand = 0
else
newhand = currenthand+ "_" +next card

returb new hand 
*/

    public class CrazyEightProject{
    private static final double NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final int CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";



    public static void main(String[] args) {

    int computerPlayer1Score = 0;
    int computerPlayer2Score = 0;
    int playerScore = 0;
    Scanner in = new Scanner(System.in);
   // String face = getFace();


    while(!gameOver(playerScore, computerPlayer1Score, computerPlayer2Score)){
      String result = playRound();
      int firstDash = result.indexOf("-");
      int secondDash = result.lastIndexOf("-");
      //int secondDash = result.indexOf("-",firstDash + 1);
      playerScore += Integer.parseInt(result.substring(0, firstDash));
      computerPlayer1Score += Integer.parseInt(result.substring(firstDash + 1, secondDash));
      computerPlayer2Score += Integer.parseInt(result.substring(secondDash + 1));

      System.out.println(playerScore + " " + computerPlayer1Score + " " + computerPlayer2Score);

      }


   }
    

    private static String playRound() {
      String playerHand = "";
      String computer1Hand = "";
      String computer2Hand = "";
      String topCard = "";

      for(int i = 0; i < 5; i++){
        playerHand += getCard(playerHand) + " ";
        
        computer1Hand += getCard(playerHand + computer1Hand) + " ";

        computer2Hand += getCard(playerHand + computer2Hand) + " ";
      }
      
      topCard += getCard(topCard) + " ";

      System.out.println("Your cards:" + playerHand);

      System.out.println("Com 1 cards: ");

      System.out.println("Com 2 cards: ");

      System.out.println("Top card: " + topCard);
      
      /*
      hand out 5 cards 
      hand-topcard
      */
      
     String temp = processPlayer(playerHand, topCard);
     playerHand = temp.substring(0, temp.indexOf("-"));
     topCard = temp.substring(temp.indexOf("-") + 1);

     temp = processComputer(computer1Hand, topCard, playerHand, computer2Hand);
     computer1Hand = temp.substring(0, temp.indexOf("-"));
     topCard = temp.substring(temp.indexOf("-") + 1);

     temp = processComputer(computer2Hand, topCard, playerHand, computer1Hand);
     computer2Hand = temp.substring(0, temp.indexOf("-"));
     topCard = temp.substring(temp.indexOf("-") + 1);

     return "17-0-8";
   }


   private static String processComputer(String computer1Hand, String topCard, String playerHand,
         String computer2Hand) {
            return "3H 7H-AD";
      
   }


   private static String processPlayer(String playerHand, String topCard) {
      return "7H 7D-AD";
   }


   private static boolean gameOver(int playerScore, int computerPlayer1Score, int computerPlayer2Score) {
      return playerScore >= 100 || computerPlayer1Score >=100 || computerPlayer1Score >= 100;
   }


   //private static void playCrazyEight() {

      /*
        String playerHand = "";
        String computer1Hand = "";
        String computer2Hand = "";
        int computer1Score = 0;
        int computer2Score = 0;
        int playerScore = 0;
         
        for (int i = 0; i < 5; i++){
            playerHand += getCard(playerHand) + " ";
        }

        for(int i = 0; i < 5; i++){
            computer1Hand += getCard(playerHand) + " ";
        }

        for(int i = 0; i < 5; i++){
            computer2Hand += getCard(playerHand) + " ";
        }
        
        
   
        */
    //}
    


    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
  
        if (suit == 0)
           return HEARTS;
        else if (suit == 1)
           return DIAMONDS;
        else if (suit == 2)
           return CLUBS;
        else
           return SPADES;
  
     }

     private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
           return suit + "";
        else if (suit == 1)
           return ACE;
        else if (suit == 11)
           return JACK;
        else if (suit == 12)
           return QUEEN;
        else
           return KING;
  
     }

     private static String getCard(String usedCards) {
        String card = getFace() + getSuit();
  
        while (usedCards.indexOf(card) >= 0) {
           card = getFace() + getSuit();
        }
        return card;
     }


}