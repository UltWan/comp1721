import java.util.*;


public class Deck extends CardCollection
{
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

  public void shuffle()
  {
    Collections.shuffle(cards);
  }
}
