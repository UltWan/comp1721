import java.util.*;

/**
 * A class to represent a standard deck of 52 cards (no Jokers).
 *
 * <p>Provided for use in COMP1721 Coursework 2.</p>
 *
 * @author Ryan Wan
 */

public class Deck extends CardCollection
{

  /**
   * Creates a full sorted deck.
   */
  public Deck()
  {
    super();

    for (Card.Suit suit: Card.Suit.values())
    {
      for (Card.Rank rank: Card.Rank.values())
      {
        Card card = new Card (rank, suit);
        cards.add(card);
      }
    }
  }

  /**
   * @returns Removes one card from the deck as long as the deck is not empty.
   */
  public Card deal()
  {
    if (cards.isEmpty())
    {
      throw new PokerException("Error: Cannot deal, deck is empty");
    }
    else
    {
      return cards.remove(0);
    }
  }

  /**
   * Randomly shuffles deck.
   */
  public void shuffle()
  {
    Collections.shuffle(cards);
  }
}
