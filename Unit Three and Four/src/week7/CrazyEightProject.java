package week7;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

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


      Scanner in = new Scanner(System.in);


      String result = playRound(in);

   // String face = getFace();

         int playerScore = 0;
         int computerPlayer1Score = 0;
         int computerPlayer2Score = 0;


         while(!gameOver(playerScore, computerPlayer1Score, computerPlayer2Score)){
            result = playRound(in);
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
      
/*
      // looking for card 3S
      String strTest1 = GetThePlayableCard("2A 3S 5C 5S", "3", "D");
      // looking for card 2A
      String strTest2 = GetThePlayableCard("2A 8S 5C 5S", "2", "D");
      // look for 8S
      String strTest3A = GetThePlayableCard("2A 8S 10C 5S", "2", "C");
      String strTest3B = GetThePlayableCard("8S 2A 10C 5S", "2", "C");
      String strTest3C = GetThePlayableCard("2A 5S 10C 8S", "2", "C");
      // looking for 5D
      String strTest4 = GetThePlayableCard("2A 3S 5C 5D", "3", "D");

*/

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
         topCard = strProcessResult.substring(0, strProcessResult.indexOf(":"));
         playerHand = strProcessResult.substring(strProcessResult.indexOf(":") + 1);
         if (playerHand.trim().length() == 0)
         {
            GameIsPlaying = false;
            break;
         }

         // 2. Computer 1 goes
         strProcessResult = processPlayer(computer1Hand, topCard, in, true);
         // strTopCard + ":" + playerHand
         topCard = strProcessResult.substring(0, strProcessResult.indexOf(":"));
         computer1Hand = strProcessResult.substring(strProcessResult.indexOf(":") + 1);
         if (computer1Hand.trim().length() == 0)
         {
            GameIsPlaying = false;
            break;
         }

         // 3. Computer 2 goes
         strProcessResult = processPlayer(computer2Hand, topCard, in, true);
         // strTopCard + ":" + playerHand
         topCard = strProcessResult.substring(0, strProcessResult.indexOf(":"));
         computer2Hand = strProcessResult.substring(strProcessResult.indexOf(":") + 1);
         if (computer2Hand.trim().length() == 0)
         {
            GameIsPlaying = false;
            break;
         }
      }
      
      // game is over
      int computerPlayer1Score = GetPlayerScore(computer1Hand);
      int computerPlayer2Score = GetPlayerScore(computer2Hand);
      int playerScore = GetPlayerScore(playerHand);
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

   private static int GetPlayerScore(String TheHand)
   {
      int intScore = 0;

      return intScore;
   }

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
            strTheCard = GetThePlayableCard(playerHand, strTopCardFace, strTopCardSuit);
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

      // Since strTheCard will become TopCard, we need to check whether it is an 8.
      // If so we need to replace it with another card
      if (strTheCard.indexOf("8") >= 0)
      {
         strTheCard = getCard();
      }

      // We are passing back The Current TopCard and the current Player's hand
      return strTheCard + ":" + playerHand;


   }

   
   
   private static Object validInput() {
      return null;
   }

/*
      // looking for card 3S
      String strTest1 = GetThePlayableCard("2A 3S 5C 5S", "3", "D");
      // looking for card 2A
      String strTest2 = GetThePlayableCard("2A 8S 5C 5S", "2", "D");
      // look for 8S
      String strTest3A = GetThePlayableCard("2A 8S 10C 5S", "2", "C");
      String strTest3B = GetThePlayableCard("8S 2A 10C 5S", "2", "C");
      String strTest3C = GetThePlayableCard("2A 5S 10C 8S", "2", "C");
      // looking for 5D
      String strTest4 = GetThePlayableCard("2A 3S 5C 5D", "3", "D");
*/
   private static String GetThePlayableCard(String Hand, String Face, String Suit)
   {
      String strTheCard = "";
      int intFaceIndex = -1;
      int intSuitIndex = -1;
      int intNextSpaceIndex = -1;
      boolean isFound = false;

      // 8 - beginning
      if (Hand.indexOf("8") >= 0)
      {
         // get the index of 8
         intFaceIndex = Hand.indexOf("8");
         // where is the 8?
         if (intFaceIndex == 0)
         {
            // at the begining
            // need to find the next space
            intNextSpaceIndex = Hand.indexOf(" ");
            // now extract the card from indexes
            strTheCard = Hand.substring(intFaceIndex, intNextSpaceIndex);
         }
         else if ((Hand.length() - intFaceIndex) <= 3)
         {
            // at the end
            strTheCard = Hand.substring(intFaceIndex);
         }
         else
         {
            // in the middle
            // need to find the next space
            intNextSpaceIndex = Hand.indexOf(" ", intFaceIndex);
            // now extract the card from indexes
            strTheCard = Hand.substring(intFaceIndex, intNextSpaceIndex);      
         }

         isFound = true;
      }
      // 8 - end

      // FACE - beginning
      if (Hand.indexOf(Face) >= 0 && isFound == false)
      {
         // find face index
         intFaceIndex = Hand.indexOf(Face);

         // where is the Face?
         if (intFaceIndex == 0)
         {
            // at the begining
            // need to find the next space
            intNextSpaceIndex = Hand.indexOf(" ");
            // now extract the card from indexes
            strTheCard = Hand.substring(intFaceIndex, intNextSpaceIndex);
         }
         else if ((Hand.length() - intFaceIndex) <= 3)
         {
            // at the end
            strTheCard = Hand.substring(intFaceIndex);
         }
         else
         {
            // in the middle
            // need to find the next space
            intNextSpaceIndex = Hand.indexOf(" ", intFaceIndex);
            // now extract the card from indexes
            strTheCard = Hand.substring(intFaceIndex, intNextSpaceIndex);      
         }

         isFound = true;
      }
      // FACE - end

      // SUIT - beginning
      if (Hand.indexOf(Suit) >= 0 && isFound == false)
      {
         intSuitIndex = Hand.indexOf(Suit);
      }     
      // SUIT - end


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