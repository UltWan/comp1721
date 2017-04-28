import java.util.*;

/**
 * A class to represent a hand.
 *
 * <p>Provided for use in COMP1721 Coursework 2.</p>
 *
 * @author Ryan Wan
 */

public class PokerHand extends CardCollection
{
  /**
   * Creates an empty hand.
   */
  public PokerHand()
  {
    super();
  }

  /**
   * Creates a five card hand.
   * @param card String to be create
   */
  public PokerHand(String cards)
  {
    int spaces = cards.length() - cards.replace(" ", "").length();
 
    if (spaces > 4)
    {
      throw new PokerException("Error: Exceeded maximum number of cards");
    }
    else
    {
      String drawnCard;
      Scanner input = new Scanner(cards);

      while (input.hasNext())
      {
        drawnCard = input.next();
        this.cards.add(new Card(drawnCard));
      }
    }
  }

  /**
   * Adds a single card to the hand.
   * @param card Card to be added
   */
  public void add(Card card)
  {
    if (cards.size() >= 5)
    {
      throw new PokerException("Error: Hand already contains five cards");
    }
    if (cards.contains(card))
    {
      throw new PokerException("Error: The same card is already in hand");
    }
    else
    {
      cards.add(card);
    }
  }

  /**
   * Discard entire hand back to deck.
   * @param deck Deck to be discarded.
   */
  public void discard(Deck deck)
  {
    if (cards.isEmpty())
    {
      throw new PokerException("Error: Hand is already empty");
    }
    else
    {
      for (Card hand : cards)
      {
        deck.add(hand);
      }
    discard();
    }
  }

  /**
   * @returns String of cards in hand.
   */
  public String toString()
  {
    String output = "";

    for (int spaces = 0; spaces < cards.size(); spaces++)
    {
      if (spaces != cards.size() - 1)
      {
        output = output + cards.get(spaces) + " ";
      }
      else
      {
        output = output + cards.get(spaces);
      }
    }
    return output;
  }

  /**
   * @returns Fancy string of cards in hand.
   */
  public String toFancyString()
  {
    String output = "";

    for (int spaces = 0; spaces < cards.size(); spaces++)
    {
      if (spaces != cards.size() - 1)
      {
        output = output + cards.get(spaces) + " ";
      }
      else
      {
        output = output + cards.get(spaces);
      }
    }
    String clubs = output.replace("C", "\u2663");
    String diamonds = clubs.replace("D", "\u2666");
    String hearts = diamonds.replace("H", "\u2665");
    String spades = hearts.replace("S", "\u2660");
    String finalOutput = spades;

    return finalOutput;
  }

  /**
   * @returns True if four cards are the same rank, otherwise false.
   */
  public boolean isFourOfAKind()
  {
    int count;

    if (cards.size() == 5)
    {
      for (int i = 0; i < 5; i++)
      {
        count = 0;
        for (int j = 0; j < 5; j++)
        {
          if (cards.get(i).getRank() == cards.get(j).getRank())
          {
            count++;
          }
        }
        if (count == 4)
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * @returns True if all cards are the same suit, otherwise false.
   */
  public boolean isFlush()
  {
    int i = 0;

    if (cards.size() == 5)
    {
      if (cards.get(i).getSuit() == cards.get(i+1).getSuit() &&
          cards.get(i+1).getSuit() == cards.get(i+2).getSuit() &&
          cards.get(i+2).getSuit() == cards.get(i+3).getSuit() &&
          cards.get(i+3).getSuit() == cards.get(i+4).getSuit())
      {
        return true;
      }    
    }
    return false;
  }

  /**
   * @returns True if there is only one pair of the same rank, otherwise false.
   */
  public boolean isPair()
  {
    int count;

    if (cards.size() == 5)
    {
      for (int i = 0; i < 5; i++)
      {
        count = 0;
        for (int j = 0; j < 5; j++)
        {
          if (cards.get(i).getRank() == cards.get(j).getRank())
          {
            count++;
          }
        }
        if (count == 2 && isTwoPairs() == false && isFullHouse() == false)
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * @returns True if there are two pairs, otherwise false.
   */
  public boolean isTwoPairs()
  {
    int i = 0;

    if (cards.size() == 5)
    {
      // for all possible two pairs combinations
      if (cards.get(i).getRank() != cards.get(i+1).getRank() && //1) 2,3,3,4,4
          cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+3).getRank() &&
          cards.get(i+3).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank()||
          cards.get(i).getRank() == cards.get(i+1).getRank() && //2) 3,3,2,4,4
          cards.get(i+1).getRank() != cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() != cards.get(i).getRank() &&
          cards.get(i+3).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+2).getRank() || 
          cards.get(i).getRank() == cards.get(i+1).getRank() && //3) 3,3,4,4,2
          cards.get(i+1).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+3).getRank() != cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() ||
          cards.get(i).getRank() == cards.get(i+2).getRank() && //4) 3,2,3,4,4
          cards.get(i+1).getRank() != cards.get(i).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+1).getRank() ||
          cards.get(i).getRank() == cards.get(i+1).getRank() && //5) 3,3,4,2,4
          cards.get(i+1).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+3).getRank() ||
          cards.get(i).getRank() != cards.get(i+1).getRank() && //6) 2,3,4,3,4
          cards.get(i+1).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() ||
          cards.get(i).getRank() == cards.get(i+3).getRank() && //7) 3,2,4,3,4 
          cards.get(i+1).getRank() != cards.get(i).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+1).getRank() || 
          cards.get(i).getRank() == cards.get(i+3).getRank() && //8) 3,4,2,3,4
          cards.get(i+1).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+2).getRank() != cards.get(i).getRank() &&
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+2).getRank() || 
          cards.get(i).getRank() == cards.get(i+2).getRank() && //9) 3,4,3,2,4
          cards.get(i+1).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+1).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() && 
          cards.get(i+4).getRank() != cards.get(i+3).getRank() || 
          cards.get(i).getRank() == cards.get(i+2).getRank() && //10) 3,4,3,4,2
          cards.get(i+1).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+1).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() ||
          cards.get(i).getRank() != cards.get(i+1).getRank() && //11) 2,3,4,4,3
          cards.get(i+1).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+2).getRank() ||
          cards.get(i).getRank() == cards.get(i+4).getRank() && //12) 3,2,4,4,3
          cards.get(i+1).getRank() != cards.get(i).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+2).getRank() ||
          cards.get(i).getRank() == cards.get(i+1).getRank() && //14) 3,3,4,2,4
          cards.get(i+1).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+3).getRank() ||
          cards.get(i).getRank() == cards.get(i+4).getRank() && //14) 3,4,2,4,3
          cards.get(i+1).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() != cards.get(i).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+1).getRank() ||
          cards.get(i).getRank() == cards.get(i+3).getRank() && //15) 3,4,4,3,2
          cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() ||
          cards.get(i).getRank() != cards.get(i+2).getRank() && //16) 2,4,3,3,4
          cards.get(i+1).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() ||
          cards.get(i).getRank() == cards.get(i+4).getRank() && //17) 4,2,3,3,4
          cards.get(i+1).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+1).getRank() ||
          cards.get(i).getRank() == cards.get(i+4).getRank() && //18) 4,3,2,3,4
          cards.get(i+1).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+1).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+3).getRank() ||
          cards.get(i).getRank() == cards.get(i+4).getRank() && //19) 4,3,3,2,4
          cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() != cards.get(i).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+3).getRank() ||
          cards.get(i).getRank() == cards.get(i+3).getRank() && //20) 4,3,3,4,2
          cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() != cards.get(i).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+1).getRank() ||
          cards.get(i).getRank() != cards.get(i+2).getRank() && //21) 2,4,3,4,3
          cards.get(i+1).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+1).getRank() ||
          cards.get(i).getRank() == cards.get(i+3).getRank() && //22) 4,2,3,4,3
          cards.get(i+1).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() ||
          cards.get(i).getRank() == cards.get(i+3).getRank() && //23) 4,3,2,4,3
          cards.get(i+1).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+1).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() ||
          cards.get(i).getRank() == cards.get(i+2).getRank() && //24) 4,3,4,2,3
          cards.get(i+1).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() ||
          cards.get(i).getRank() == cards.get(i+2).getRank() && //25) 4,3,4,3,2
          cards.get(i+1).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+1).getRank())
      {
        return true;
      }
    }
    return false;
  }

  /**
   * @returns True if there are three cards of the same rank, 
   *  with the other two being of different ranks, otherwise false.
   */
  public boolean isThreeOfAKind()
  {
    int count;

    if (cards.size() == 5)
    {
      for (int i = 0; i < 5; i++)
      {
        count = 0;
        for (int j = 0; j < 5; j++)
        {
          if (cards.get(i).getRank() == cards.get(j).getRank())
          {
            count++;
          }
        }
        if (count == 3 && isFullHouse() == false)
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * @returns True if there are three cards of the same rank, 
   *  with the other two being the same rank as each other, otherwise false.
   */
  public boolean isFullHouse()
  {
    int i = 0;

    if (cards.size() == 5)
    {
      // for all posible full house combinations
      if (cards.get(i).getRank() == cards.get(i+1).getRank() && //1) 3,3,3,2,2 
          cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() != cards.get(i+3).getRank() &&
          cards.get(i+3).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() || 
          cards.get(i).getRank() == cards.get(i+1).getRank() && //2) 2,2,3,3,3
          cards.get(i+1).getRank() != cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() || 
          cards.get(i).getRank() == cards.get(i+4).getRank() && //3) 2,3,3,3,2
          cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+3).getRank() != cards.get(i).getRank() && 
          cards.get(i+4).getRank() != cards.get(i+1).getRank() || 
          cards.get(i).getRank() == cards.get(i+1).getRank() && //4) 3,3,2,3,2
          cards.get(i+1).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+3).getRank() != cards.get(i+2).getRank() && 
          cards.get(i+4).getRank() != cards.get(i).getRank() || 
          cards.get(i).getRank() == cards.get(i+2).getRank() && //5) 3,2,3,3,2
          cards.get(i+1).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() || 
          cards.get(i).getRank() == cards.get(i+3).getRank() && //6) 2,3,3,2,3
          cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i+1).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() || 
          cards.get(i).getRank() == cards.get(i+2).getRank() && //7) 2,3,2,3,3
          cards.get(i+1).getRank() == cards.get(i+3).getRank() && 
          cards.get(i+2).getRank() != cards.get(i+1).getRank() && 
          cards.get(i+3).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+4).getRank() != cards.get(i).getRank() || 
          cards.get(i).getRank() == cards.get(i+1).getRank() && //8) 3,3,2,2,3
          cards.get(i+1).getRank() == cards.get(i+4).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+3).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() &&
          cards.get(i+4).getRank() != cards.get(i+2).getRank() || 
          cards.get(i).getRank() == cards.get(i+2).getRank() && //9) 3,2,3,2,3
          cards.get(i+1).getRank() == cards.get(i+3).getRank() &&
          cards.get(i+2).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+3).getRank() != cards.get(i).getRank() && 
          cards.get(i+4).getRank() != cards.get(i+1).getRank() && 
          cards.get(i).getRank() == cards.get(i+3).getRank() && //10) 3,2,2,3,3
          cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
          cards.get(i+2).getRank() != cards.get(i).getRank() && 
          cards.get(i+3).getRank() == cards.get(i+4).getRank() && 
          cards.get(i+4).getRank() != cards.get(i+1).getRank()) 
      {
        return true;
      }
    }
    return false;
  }

  /**
   * @returns True if cards can form a ascending/descending numerical sequence.
   */
  public boolean isStraight()
  {
    int i = 0;

    if (cards.size() == 5)
    {
      // if ordered correctly, would return correct probability in PokerStats
      Card.Rank.values();
      if (cards.get(i+1).value() == cards.get(i).value() + 1 && // A,2,3,4,5
          cards.get(i+2).value() == cards.get(i+1).value() + 1 &&
          cards.get(i+3).value() == cards.get(i+2).value() + 1 &&
          cards.get(i+4).value() == cards.get(i+3).value() + 1 ||
          cards.get(i+2).value() == cards.get(i+1).value() + 1 && // 5,A,2,3,4
          cards.get(i+3).value() == cards.get(i+2).value() + 1 &&
          cards.get(i+4).value() == cards.get(i+3).value() + 1 &&
          cards.get(i).value() == cards.get(i+4).value() + 1 ||
          cards.get(i+3).value() == cards.get(i+2).value() + 1 && // 4,5,A,2,3
          cards.get(i+4).value() == cards.get(i+3).value() + 1 &&
          cards.get(i).value() == cards.get(i+4).value() + 1 &&
          cards.get(i+1).value() == cards.get(i).value() + 1 ||
          cards.get(i+4).value() == cards.get(i+3).value() + 1 && // 3,4,5,A,2
          cards.get(i).value() == cards.get(i+4).value() + 1 &&
          cards.get(i+1).value() == cards.get(i).value() + 1 &&
          cards.get(i+2).value() == cards.get(i+2).value() + 1 ||
          cards.get(i).value() == cards.get(i+4).value() + 1 && // 2,3,4,5,A
          cards.get(i+1).value() == cards.get(i).value() + 1 &&
          cards.get(i+2).value() == cards.get(i+1).value() + 1 &&
          cards.get(i+3).value() == cards.get(i+2).value() + 1 ||
          isPair() == false &&                                  // 7,8,9,T,J
          cards.get(i+1).value() == cards.get(i).value() + 1 && 
          cards.get(i+2).value() == cards.get(i+1).value() + 1 &&
          cards.get(i+3).value() == cards.get(i+2).value() + 1 &&
          cards.get(i+4).value() == cards.get(i+3).value() ||
          isPair() == false && isThreeOfAKind() == false && // 8,9,T,J,Q
          isFullHouse() == false &&
          cards.get(i+1).value() == cards.get(i).value() + 1 && 
          cards.get(i+2).value() == cards.get(i+1).value() +1 &&
          cards.get(i+3).value() == cards.get(i+2).value() &&
          cards.get(i+4).value() == cards.get(i+3).value() ||
          isPair() == false && isThreeOfAKind() == false && // 9,T,J,Q,K
          isFullHouse() == false && isTwoPairs() == false &&
          isFourOfAKind() == false &&
          cards.get(i+1).value() == cards.get(i).value() + 1 && 
          cards.get(i+2).value() == cards.get(i+1).value() &&
          cards.get(i+3).value() == cards.get(i+2).value() &&
          cards.get(i+4).value() == cards.get(i+3).value() ||
          cards.get(i).value() == cards.get(i+1).value() && // T,J,Q,K,A
          cards.get(i+1).value() == cards.get(i+2).value() &&
          cards.get(i+2).value() == cards.get(i+3).value() &&
          cards.get(i+3).value() == cards.get(i+4).value() + 9)
      {
        return true;
      }
    }
  return false;
  }
}
