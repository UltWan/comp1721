import java.util.*;
import java.io.*;

/**
 * A class to show the probability of getting a certain type of hand by simulating
 * five card hands being dealt.
 *
 * <p>Provided for use in COMP1721 Coursework 2.</p>
 *
 * @author Ryan Wan
 */

public class PokerStats
{
  public static void main(String[] args)
  {
    // asks for the number of deck to be created
    int decksCreated = Integer.parseInt(args[0]);
    Deck[] pokerStats;
    pokerStats = new Deck[decksCreated];

    PokerHand[][] allHands;
    
    // only can be a maximum of 10 hands dealt from each deck
    allHands = new PokerHand[decksCreated][10];
    PokerHand hand = new PokerHand();

    double countFlush = 0;
    double countFour = 0;
    double countPair = 0;
    double countTwoPairs = 0;
    double countThree = 0;
    double countFullHouse = 0;
    double countStraight = 0;

    // loop for number of decks created
    for (int i = 0; i < decksCreated; i++)
    {
      pokerStats[i] = new Deck();
      pokerStats[i].shuffle();
      
      // loop for number of hands dealt
      for (int j = 0; j < 10; j++)
      {
        // loop for each card in these hands
        for (int k = 0; k < 5; k++)
        {
          hand.add(pokerStats[i].deal());
        }

        allHands[i][j] = hand;
        System.out.println(allHands[i][j].toFancyString());

        // counts each type of hand
        if (hand.isFlush())
        {
          countFlush++;
        }

        if (hand.isFourOfAKind())
        {
          countFour++;
        }

        if (hand.isPair())
        {
          countPair++;
        }

        if (hand.isTwoPairs())
        {
          countTwoPairs++;
        }

        if (hand.isThreeOfAKind())
        {
          countThree++;
        }

        if (hand.isFullHouse())
        {
          countFullHouse++;
        }

        if (hand.isStraight())
        {
          countStraight++;
        }

        while (!hand.isEmpty())
        {
          hand.discard();
        }
      }
      System.out.println();
    }

    // can only be ten hands dealt for one deck
    int handsDealt = decksCreated * 10;

    // prints out probabilities
    System.out.println(handsDealt + " Deals");
    System.out.printf("%s %.3f %s %n","P(Flush)           =", (countFlush / handsDealt * 100), "%");
    System.out.printf("%s %.3f %s %n","P(Four of a Kind)  =", (countFour / handsDealt * 100), "%");
    System.out.printf("%s %.3f %s %n","P(Pair)            =", (countPair / handsDealt * 100), "%");
    System.out.printf("%s %.3f %s %n","P(Two Pairs)       =", (countTwoPairs / handsDealt * 100), "%");
    System.out.printf("%s %.3f %s %n","P(Three of a Kind) =", (countThree / handsDealt * 100), "%");
    System.out.printf("%s %.3f %s %n","P(Full House)      =", (countFullHouse / handsDealt * 100), "%");
    System.out.printf("%s %.3f %s %n","P(Straight)        =", (countStraight / handsDealt * 100), "%");
  }
}
