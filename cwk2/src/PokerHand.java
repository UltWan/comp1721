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
      throw new PokerException("Error: Hand is already full");
    }
    if (cards.contains(card))
    {
      throw new PokerException("Error: Same card is already in hand");
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
   * @returns True if four cards of the same rank, false otherwise.
   */
  public boolean isFourOfAKind()
  {
    if (cards.size() == 5)
    {
      for (int i = 0; i < 2; i++)
      {
        if (cards.get(i).getRank() == cards.get(i+1).getRank() &&
            cards.get(i+1).getRank() == cards.get(i+2).getRank() &&
            cards.get(i+2).getRank() == cards.get(i+3).getRank())
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * @returns True if all cards are the same suit, false otherwise.
   */
  public boolean isFlush()
  {
    if (cards.size() == 5)
    {
      for (int i = 0; i < 4; i++)
      {
        if (cards.get(i).getSuit() == cards.get(i+1).getSuit() &&
            cards.get(i+1).getSuit() == cards.get(i+2).getSuit() &&
            cards.get(i+2).getSuit() == cards.get(i+3).getSuit() &&
            cards.get(i+3).getSuit() == cards.get(i+4).getSuit())
        {
          return true;
        }
      }
    }
    return false;
  }
}
