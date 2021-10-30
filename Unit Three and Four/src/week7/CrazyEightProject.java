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
      }
    

      private static String playRound(Scanner in) {
         String playerHand = "";
         String computer1Hand = "";
         String computer2Hand = "";
         String topCard = "";
         boolean GameIsPlaying = true;
         String strProcessResult = "";
         int computerPlayer1Score = 0;
         int computerPlayer2Score = 0;
         int playerScore = 0;
         
         while (!gameOver(playerScore, computerPlayer1Score, computerPlayer2Score))
         {

            playerHand = "";
            computer1Hand = "";
            computer2Hand = "";

            GameIsPlaying = true;

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
               System.out.println("");
               System.out.println("Your cards: " + playerHand);
               System.out.println("Com 1 cards: " + computer1Hand);
               System.out.println("Com 2 cards: " + computer2Hand);
               System.out.println("Top card: " + topCard);
               System.out.println("");

               // 1. Human player goes 1st
               strProcessResult = processPlayer(playerHand, topCard, in, true);
               // strTopCard + ":" + playerHand
               topCard = strProcessResult.substring(0, strProcessResult.indexOf(":"));
               playerHand = strProcessResult.substring(strProcessResult.indexOf(":") + 1);

               GameIsPlaying = !(playerHand.trim().length() == 0);

               // 2. Computer 1 goes
               strProcessResult = processPlayer(computer1Hand, topCard, in, true);
               // strTopCard + ":" + playerHand
               topCard = strProcessResult.substring(0, strProcessResult.indexOf(":"));
               computer1Hand = strProcessResult.substring(strProcessResult.indexOf(":") + 1);

               GameIsPlaying = !(computer1Hand.trim().length() == 0);

               // 3. Computer 2 goes
               strProcessResult = processPlayer(computer2Hand, topCard, in, true);
               // strTopCard + ":" + playerHand
               topCard = strProcessResult.substring(0, strProcessResult.indexOf(":"));
               computer2Hand = strProcessResult.substring(strProcessResult.indexOf(":") + 1);

               GameIsPlaying = !(computer2Hand.trim().length() == 0);
            } // while(GameIsPlaying)
            
            // game is over
            computerPlayer1Score = GetPlayerScore(computer1Hand);
            computerPlayer2Score = GetPlayerScore(computer2Hand);
            playerScore = GetPlayerScore(playerHand);

            System.out.println(playerScore + "-" + computerPlayer1Score + "-" + computerPlayer2Score);
         } // while (!gameOver(playerScore, computerPlayer1Score, computerPlayer2Score))

            return "";
      
      }


      private static int GetPlayerScore(String TheHand)
      {
         int intScore = 0;
         String strCurrentCard = "";
         
         if (TheHand.trim().length() == 0)
         {
            // this player has no card, score 0
            intScore += 0;

            return intScore;
         }
         else if (TheHand.trim().length() <= 3)
         {
            //  only 1 card remaining
            strCurrentCard = TheHand.trim();
            //
            // Calculate the Current Card score
            //
            intScore = GetScoreOfCard(strCurrentCard);
         }
         else 
         {

            while (TheHand.trim().length() > 0)
            {
               if (TheHand.trim().length() <2)
               {
                  // last card
                  strCurrentCard = TheHand.trim();
                  // Hand will be empty
                  TheHand = "";
                  intScore = intScore + GetScoreOfCard(strCurrentCard);
               }
               else
               {
                  // find next space
                  int intNextSpace = TheHand.indexOf(" ");
                  // extract the card
                  if (intNextSpace!=-1){
                     strCurrentCard = TheHand.substring(0,intNextSpace);
                     TheHand = TheHand.substring(intNextSpace).trim();
                  }else{
                     strCurrentCard = TheHand;
                     TheHand = "";
                  }
                  intScore = intScore + GetScoreOfCard(strCurrentCard);
               }


            }

         }

         return intScore;
      }

      private static int GetScoreOfCard(String TheCard)
      {
         int intScore = 0;
        // suit is always the last character of hand
        String strCardSuit = TheCard.substring(TheCard.length() - 1);
        // face is the other piece
        String strCardFace = TheCard.substring(0, TheCard.length() - 1);

         if (strCardFace.equals("10")||strCardFace.equals("J") || strCardFace.equals("Q") || strCardFace.equals("K"))
         {
            intScore += 10;
         } 
         else if (strCardFace.equals("A")) {
            intScore += 1;
         }
         else if (strCardFace.equals("8")){
            intScore += 50;
         } else {
            intScore += Integer.parseInt(strCardFace);
         }

         return intScore;
      }

      private static String processPlayer(String playerHand, String topCard, Scanner in, boolean IsComputer) {
         int cardsDrawn = 0;
         String card = "";
         String strTheCard = "";
         // Cards are in this format: [Face][Suit]

         // suit is always the last character of hand
         String strTopCardSuit = topCard.substring(topCard.length() - 1);
         // face is the other piece
         String strTopCardFace = topCard.substring(0, topCard.length() - 1);

         boolean blnCanPlay = canPlay(playerHand, strTopCardSuit, strTopCardFace);
         
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
               card = "xx"; // a dummy card to get the loop going
               while (playerHand.indexOf(card) < 0)
               {
                  System.out.print("which card would you like to play: ");
                  card = in.nextLine().toUpperCase();
               }
               // if you decide to play an 8, you need to change suit.
               if (card.indexOf("8") > 0)
               {
                  String strNewSuit = "X";

                  while (strNewSuit.equals("C") == false || 
                         strNewSuit.equals("D") == false || 
                         strNewSuit.equals("S") == false ||
                         strNewSuit.equals("H") == false) 
                  {
                     System.out.print("which suit do you want to change to ");
                     strNewSuit = in.nextLine().toUpperCase();                     
                  }

                  card = "8" + strNewSuit;

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
               if (intNextSpaceIndex < 0)
               {
                  strTheCard = Hand;
               }
               else
               {
                  strTheCard = Hand.substring(intFaceIndex, intNextSpaceIndex);    
               }
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
               if (intNextSpaceIndex < 0)
               {
                  strTheCard = Hand;
               }
               else
               {
                  strTheCard = Hand.substring(intFaceIndex, intNextSpaceIndex);    
               }
  
            }
            
            // auto play will play the 8 but we need to change the suit
            if (Hand.indexOf("C") >= 0)
               strTheCard = "8C";
            else if (Hand.indexOf("D") >= 0)
               strTheCard = "8D";
            else if (Hand.indexOf("H") >= 0)
               strTheCard = "8H";
            else if (Hand.indexOf("S") >= 0) 
               strTheCard = "8S";
            // if all of these fall through, we just us whatever in strTheCard.


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
               if (intNextSpaceIndex < 0)
               {
                  // only 1 card left in hand
                  strTheCard = Hand;
               }
               else 
               {
                  // more than 1 card
                  strTheCard = Hand.substring(intFaceIndex, intNextSpaceIndex);
               }

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
               if (intNextSpaceIndex < 0)
               {
                  strTheCard = Hand;
               }
               else
               {
                  strTheCard = Hand.substring(intFaceIndex, intNextSpaceIndex);   
               }
            }

            isFound = true;
         }
         // FACE - end

         // SUIT - beginning
         if (Hand.indexOf(Suit) >= 0 && isFound == false)
         {
            intSuitIndex = Hand.indexOf(Suit);
            
            // where is the Face?
            if (intSuitIndex <= 2)
            {
               // at the begining, it could be a 10C
               // now extract the card from indexes
               strTheCard = Hand.substring(0, intSuitIndex + 1);
            }
            else if (intSuitIndex == (Hand.length() - 1))
            {
               // at the end
               // find the last space
               intNextSpaceIndex = Hand.lastIndexOf(" ");
               // extract the last card
               strTheCard = Hand.substring(intNextSpaceIndex + 1);
            }
            else
            {
               // in the middle
               // need to find the last previous space
               intNextSpaceIndex = Hand.lastIndexOf(" ", intSuitIndex);
               // now extract the card from indexes
               if (intNextSpaceIndex < 0)
               {
                  strTheCard = Hand;
               }
               else
               {
                  strTheCard = Hand.substring(intNextSpaceIndex + 1, intSuitIndex + 1);   
               }
   
            }
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