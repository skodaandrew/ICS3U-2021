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
            String result = playRound(in);
            int firstDash = result.indexOf("-");
            int secondDash = result.lastIndexOf("-");
            //int secondDash = result.indexOf("-",firstDash + 1);
            
            playerScore += Integer.parseInt(result.substring(0, firstDash));
            computerPlayer1Score += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            computerPlayer2Score += Integer.parseInt(result.substring(secondDash + 1));

            System.out.println(playerScore + " " + computerPlayer1Score + " " + computerPlayer2Score);

         }


      }
    

   private static String playRound(Scanner in) {
      String playerHand = "";
      String computer1Hand = "";
      String computer2Hand = "";
      String topCard = "";
      boolean GameIsPlaying = true;
      String strProcessResult = "";
      String[] arrProcResult;

      for(int i = 0; i < 5; i++){
        playerHand += getCard() + " ";
        
        computer1Hand += getCard() + " ";

        computer2Hand += getCard() + " ";
      }

      // trim off the extra spaces at the end
      playerHand = playerHand.trim();
      computer1Hand = computer1Hand.trim();
      computer2Hand = computer2Hand.trim();

      topCard = getCard();
      
      while(GameIsPlaying){

         
         System.out.println("Your cards: " + playerHand);
            
         System.out.println("Com 1 cards: " + computer1Hand);
   
         System.out.println("Com 2 cards: " + computer2Hand);
   
         System.out.println("Top card: " + topCard);
         
         //String UserInput = in.nextLine();

         // 1. Human player goes 1st
         //topCard = processPlayer(playerHand, topCard,in);
         // remove the card from player's hand
         strProcessResult = processPlayer(playerHand, topCard, in, true);
         // strTopCard + ":" + playerHand
         arrProcResult = strProcessResult.split(":");
         if (arrProcResult.length == 2)
         {
            topCard = arrProcResult[0];
            playerHand = arrProcResult[1];
         }

         // 2. Computer 1 goes
         strProcessResult = processPlayer(computer1Hand, topCard, in, true);
         // strTopCard + ":" + playerHand
         arrProcResult = strProcessResult.split(":");
         if (arrProcResult.length == 2)
         {
            topCard = arrProcResult[0];
            computer1Hand = arrProcResult[1];
         }


         // 3. Computer 2 goes
         strProcessResult = processPlayer(computer2Hand, topCard, in, true);
         // strTopCard + ":" + playerHand
         arrProcResult = strProcessResult.split(":");
         if (arrProcResult.length == 2)
         {
            topCard = arrProcResult[0];
            computer2Hand = arrProcResult[1];
         }

      // Check conditions (scores, player out of cards, etc)
      // if any of them is true, then set GameIsPlaying to false.

      // Parse UserInput, make a function called ParseUserInput
      // 1. If user type in 'g' then draw cards until there is a valid card in user hand to play.
      // 2. User enter a card in his hand. In this case take card off user's hands and place it in as top card.

      

      }
      
      /*
      hand out 5 cards 
      hand-topcard   
      */
/*
      playerHand = playCard(in, playerHand);

      
     while (playerHand.length() > 0 && computer1Hand.length() > 0 && computer2Hand.length() > 0){
     strProcessResult  = processPlayer(playerHand, topCard, in, false);
*/
      // strTopCard + ":" + playerHand

      /*
     temp = processComputer(computer1Hand, topCard, playerHand, computer1Hand, true);
     computer1Hand = temp.substring(0, temp.indexOf("-"));
     topCard = temp.substring(temp.indexOf("-") + 1);

     temp = processComputer(computer2Hand, topCard, playerHand, computer2Hand, true);
     computer2Hand = temp.substring(0, temp.indexOf("-"));
     topCard = temp.substring(temp.indexOf("-") + 1);
*/    
         return "";
     
      }

     //return "";
     //return "10-20-30";
   
   

   
   private static String playCard(Scanner in, String playerHand) {
      return playerHand;
   }

/*
   private static String processComputer(String computer1Hand, String topCard, String playerHand,
         String computer2Hand) {
            return "3H 7H-AD";
      
   }
*/

   private static String processPlayer(String playerHand, String topCard, Scanner in, boolean IsComputer) {
      int cardsDrawn = 0;
      String card = "";
      boolean validInput = false;
      String strTheCard ="" ;
      // Cards are in this format: [Face][Suit]

      // suit is always the last character of hand
      String strTopCardSuit = topCard.substring(topCard.length() - 1);
      // face is the other piece
      String strTopCardFace = topCard.substring(0, topCard.length() - 1);

      boolean blnCanPlay = canPlay(playerHand, strTopCardSuit, strTopCardFace);
      
      /*
      while (!validInput){
      System.out.print("which card woud you like to play: ");
         card = in.nextLine();
         if ()
         validInput = true;
      }
      */
      if (blnCanPlay)
      {

         if (IsComputer)
         {
            // computer is playing, find 1st suitable card.
            strTheCard = GetFirstSuitableCard(playerHand, strTopCardFace, strTopCardSuit);
         }
         else
         {
            // human is playing
            card = "xx";

            while (playerHand.indexOf(card) < 0)
            {
               System.out.print("which card woud you like to play: ");
               card = in.nextLine().toUpperCase();
            }

            strTheCard = card;
         }

         playerHand = playerHand.replaceAll(strTheCard, "");
         // trim off double space left by replaceAll
         playerHand = playerHand.replaceAll("  ", " ");
         // trim off whatever spaces at the ends
         playerHand = playerHand.trim();

      }
      else
      {
         // player doesn't has card, need to draw
         // draw 1st card first
         String strDrawnSuit = getSuit();
         String strDrawnFace = getFace();
         cardsDrawn = 1;

         while (!canPlay(playerHand, strDrawnSuit, strDrawnFace) && cardsDrawn < 5)
         {
            playerHand += " " + strDrawnFace + strDrawnSuit;
            cardsDrawn++;
            // draw again
            strDrawnSuit = getSuit();
            strDrawnFace = getFace();
         }

         if (canPlay(playerHand, strDrawnSuit, strDrawnFace))
         {
            // add the playable card to player hand
            playerHand += " " + strDrawnFace + strDrawnSuit;
            // set this last drawn as TheCard
            strTheCard = strDrawnFace + strDrawnSuit;

            playerHand = playerHand.replaceAll(strTheCard, "");
            // trim off double space left by replaceAll
            playerHand = playerHand.replaceAll("  ", " ");
            // trim off whatever spaces at the ends
            playerHand = playerHand.trim();
         }
         
      }

      // We are passing back The Current TopCard and the current Player's hand
      return strTheCard + ":" + playerHand;


   }

   
   
   private static Object validInput() {
      return null;
   }


   private static String GetFirstSuitableCard(String Hand, String Face, String Suit)
   {
      String[] arrHand = Hand.trim().split(" ");
      String strTheCard = "";

      for (String strTemp : arrHand)
      {
         if (strTemp.indexOf(Face) >= 0 || strTemp.indexOf(Suit) >= 0)
         {
            strTheCard = strTemp;
            break;
         }
      }

      // If strTheCard remains blank, it could mean there is an '8' wildcard in here.
      // We need to find the '8' card and make that TheCard
      for (String strTemp : arrHand)
      {
         if (strTemp.indexOf("8") >= 0)
         {
            strTheCard = strTemp;
            break;
         }
      }

      return strTheCard;
   }



   private static boolean canPlay(String playerHand, String suit, String face) {
      return playerHand.indexOf("8") >= 0 || playerHand.indexOf(suit) >= 0 || playerHand.indexOf(face) >= 0;
   }




   private static boolean gameOver(int playerScore, int computerPlayer1Score, int computerPlayer2Score) {
      return playerScore >= 100 || computerPlayer1Score >=100 || computerPlayer1Score >= 100;
   }


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

     private static String getCard() {
        String card = getFace() + getSuit();
  
        return card;
     }


}