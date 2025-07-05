package Week_5.Lab5SampleCode;
// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.

public class DeckOfCardsTest
{
   // execute application
   public static void main( String args[] )
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order

      // -20s% => means that we want a text that is 20 symbols;
      // the minus says where the empty space should be put => behind the words
      // without it -> it is put in front

      Card[] leftHand = new Card[5];
      Card[] rightHand = new Card[5];

      System.out.printf("%-20s%-20s%n", "Left Hand:", "Right Hand:\n");
      for (int i = 0; i < leftHand.length; i++) {
         rightHand[i] = myDeckOfCards.dealCard();
         leftHand[i] = myDeckOfCards.dealCard();
         System.out.printf("%-20s%-20s%n", leftHand[i], rightHand[i]);
      }

      System.out.println("\nHand Values:\n");
      System.out.printf("%-20s%-20s%n", "Left Hand:", "Right Hand:");

      int rightHandRank = myDeckOfCards.getHandRank(rightHand);
      int leftHandRank = myDeckOfCards.getHandRank(leftHand);

      String LeftHandLabel = myDeckOfCards.getHandRankLabel(rightHandRank);
      String RightHandLabel = myDeckOfCards.getHandRankLabel(leftHandRank);
      System.out.printf("%-20s%-20s%n", LeftHandLabel, RightHandLabel);

      String winningHand = rightHandRank > leftHandRank ? "Right" : "Left";

      if (rightHandRank == leftHandRank) {
         System.out.println("Both are the same.");
      } else {
         System.out.printf("%nResult: %s is better", winningHand);
      }
      // print all 52 Cards in the order in which they are dealt
//      for ( int i = 0; i < 13; i++ )
//      {
//         // deal and print 4 Cards
//         System.out.printf( "%-20s%-20s%-20s%-20s\n",
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
//      } // end for
   } // end main
} // end class DeckOfCardsTest

