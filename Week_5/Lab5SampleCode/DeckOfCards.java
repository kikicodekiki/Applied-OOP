package Week_5.Lab5SampleCode;
// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.Random;

public class DeckOfCards
{
   private Card[] deck; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator
   private final String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
           "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
   private final String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

   // constructor fills deck of Cards
   public DeckOfCards()
   {
      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ ) 
         deck[ count ] = 
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   } // end DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard

      // for each Card, pick another random Card and swap them
      for ( int first = 0; first < deck.length; first++ ) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
         // swap current Card with randomly selected Card
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];   
         deck[ second ] = temp;            
      } // end for
   } // end method shuffle

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } // end method dealCard

   // the idea is to return an array of face counters -> index 0: number of Aces, 1-> number of Deuces...
   private int[] totalHand(Card[] hand) {
      final int NUMBER_OF_CARDS = 13;
      int[] counters = new int[ NUMBER_OF_CARDS];

      for (int i = 0; i < hand.length; i++) {
         String face = hand[i].getFace();
         // need to find which face is it
         // instead of if or switch-cases => using the array faces
         for(int j = 0; j < faces.length; j++) {
            if(face.equals(faces[j])) {
               counters[j]++;
            }
         }
      }
      return counters;

   }

   // the public method, used in the Test class
   public int getHandRank(Card[] hand) {
      // we want to know how strong the card is numerically
      if(hasFourOfKind(hand)) {
         return 1;
      }

      if(hasFullHouse(hand)) {
         return 2;
      }

      if(hasFlush(hand)) {
         return 3;
      }
      if(hasStraight(hand)) {
         return 4;
      }

      if(hasThreeOfKind(hand)) {
         return 5;
      }

      if(hasTwoPairs(hand)) {
         return 6;
      }

      if(hasPair(hand)) {
         return 7;
      }

      // when we do not have anything
      return 8;


   }

   public String getHandRankLabel(int rank) {
       // we will make a String array
      String[] rankLabels = {
              "Four of a kind",
              "Full House",
              "Flush",
              "Straight",
              "Three of a kind",
              "Two Pairs",
              "One Pair",
              "None"
      };

      return rankLabels[rank - 1];
   }

   // 1.a)
   private boolean hasPair(Card[] hand) {
      int[] counters = totalHand(hand);

      for (int i = 0; i < counters.length; i++) {

         if (counters[i] == 2) {

            return true;

         }
      }

      return false;
   }

   // 1.b)
   private boolean hasTwoPairs(Card[] hand) {
      int[] counters = totalHand(hand);
      int pairs = 0;

      for (int i = 0; i < counters.length; i++) {

         if (counters[i] == 2) {
            pairs++;
         }

         if (pairs == 2) {
            return true;
         }

      }

      return false;
   }

   // 1.c)
   private boolean hasThreeOfKind(Card[] hand) {
      int[] counters = totalHand(hand);

      for (int i = 0; i < counters.length; i++) {

         if (counters[i] == 3) {
            return true;
         }

      }
      return false;
   }

   // 1.d)
   private boolean hasFourOfKind(Card[] hand) {
      int[] counters = totalHand(hand);

      for (int i = 0; i < counters.length; i++) {

         if (counters[i] == 4) {
            return true;
         }

      }

      return false;
   }

   // 1.e)
   private boolean hasFlush(Card[] hand) {
      // easier to see if a given card has a different color than the others
      String suit = hand[0].getSuit();
      // a flush means that all five cards are of the same color
      for (int i = 1; i < hand.length; i++) {
         if (!suit.equals(hand[i].getSuit())) {
            return false;
         }
      }
      return true;
   }

   // 1.f)
   private boolean hasStraight(Card[] hand) {
      // [1, 1, 1, 1, 1, 0, 0, ..., 0]
      int[] counters = totalHand(hand);
      int consecutive = 0;
      for (int i = 0; i < counters.length; i++) {
         if (counters[i] == 1) {
            consecutive++;
         } else {
            consecutive = 0;
         }
         if (consecutive == 5) {
            return true;
         }
      }
      // one more special case for the Ace -> it works circularly
      // if the last four are 1s => consecutive equals 4 and if
      // the Ace is also up => there is also a straight
      if (consecutive == 4 && counters[0] == 1) {
         return true;
      }
      return false;
   }

   // 1.g)
   private boolean hasFullHouse(Card[] hand) {
      int[] counters = totalHand(hand);
      return hasPair(hand) && hasThreeOfKind(hand);
   }
} // end class DeckOfCards


