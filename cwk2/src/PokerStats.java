import java.util.*;
import java.io.*;

public class PokerStats
{
  public static void main(String[] args)
  {
    int countDecks = Integer.parseInt(args[0]);
    Deck[] PokerStatsDeck;
    PokerStatsDeck = new Deck[countDecks];

    PokerHand[][] EveryHand;
    EveryHand = new PokerHand[countDecks][10];
    PokerHand Hand = new PokerHand();

    double numberFlush = 0.0;
    double numberFour = 0.0;
    double numberPair = 0.0;
    double numberTwoPairs = 0.0;
    double numberThree = 0.0;
    double numberFullHouse = 0.0;
    double numberStraight = 0.0;

    for (int i = 0; i < countDecks; i++)
    {
      PokerStatsDeck[i] = new Deck();
      PokerStatsDeck[i].shuffle();
      
      for (int j = 0; j < 10; j++)
      {
        for (int k = 0; k < 5; k++)
        {
          Hand.add(PokerStatsDeck[i].deal());
        }
        EveryHand[i][j] = Hand;
        System.out.println(EveryHand[i][j].toFancyString());

        if (Hand.isFlush())
        {
          numberFlush++;
        }

        if (Hand.isFourOfAKind())
        {
          numberFour++;
        }

        if (Hand.isPair())
        {
          numberPair++;
        }

        if (Hand.isTwoPairs())
        {
          numberTwoPairs++;
        }

        if (Hand.isThreeOfAKind())
        {
          numberThree++;
        }

        if (Hand.isFullHouse())
        {
          numberFlush++;
        }

        if (Hand.isStraight())
        {
          numberStraight++;
        }

        while (!Hand.isEmpty())
        {
          Hand.discard();
        }
      }
      System.out.println();
    }

    int numberDeals = countDecks * 10;
    System.out.println(numberDeals + " Deals");
    System.out.printf("P(Flush)           = ");
    System.out.printf("%.3f", (numberFlush / numberDeals * 100));
    System.out.println("%");
    System.out.printf("P(Four of a Kind)  = ");
    System.out.printf("%.3f", (numberFour / numberDeals * 100));
    System.out.println("%");
    System.out.printf("P(Pair)            = ");
    System.out.printf("%.3f", (numberPair / numberDeals * 100));
    System.out.println("%");
    System.out.printf("P(Two Pairs)       = ");
    System.out.printf("%.3f", (numberTwoPairs / numberDeals * 100));
    System.out.println("%");
    System.out.printf("P(Three of a Kind) = ");
    System.out.printf("%.3f", (numberThree / numberDeals * 100));
    System.out.println("%");
    System.out.printf("P(Full House)      = ");
    System.out.printf("%.3f", (numberFullHouse / numberDeals * 100));
    System.out.println("%");
    System.out.printf("P(Straight)        = ");
    System.out.printf("%.3f", (numberStraight / numberDeals * 100));
    System.out.println("%");
  }
}
