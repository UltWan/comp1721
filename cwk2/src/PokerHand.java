public class PokerHand extends CardCollection
{
  public PokerHand()
  {
    super();
  }

  public PokerHand(String cards)
  {
    if (cards > 5)
    {
      throw new PokerException("Error: Exceeded maximum number of cards");
    }
    else
    {
      
    }
  }

  public void add(Card card)
  {
    if (cards == 5)
    {
      throw new PokerException("Error: Hand is already full");
    }
    if (cards == 5)
    {
      throw new PokerException("Error: Card is already in hand");
    }
    else
    {
      cards.add(card);
    }
  }

  public void discard(Deck deck)
  {
    if (cards.isEmpty())
    {
      throw new PokerException("Error: Hand is already empty");
    }
    else
    {
      return cards.discard();
    }
  }

  public String toString()
  {
    return toString();
  }

  public String toFancyString()
  {
    return toFancyString();
  }

  public boolean isFourOfAKind()
  {
    if (cards == 5 && ...)
    {
      return true;
    }
  }

  public boolean isFlush()
  {
    if (cards == 5 && ...)
    {
      return true;
    }
  }
}
