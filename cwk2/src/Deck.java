import java.util.*;


public class Deck
{
  public Deck()
  {
    deck = new LinkedList<Card>();

    for (int i = 2; i < 15; i++)
    {
      deck.add(new Card("" + i, "spades"));
      deck.add(new Card("" + i, "diamonds"));
      deck.add(new Card("" + i, "clubs"));
      deck.add(new Card("" + i, "hearts"));
    }
  }

  /*public Deck()
  {
    cards.add(new CardCollection(52));
  }

  Card.Suit.values(size);

  Card.Rank.values(size);


  Deck()
  {
    cards = new ArrayList<Card>();
    int index_1, index_2;
    Random generator = new Random();
    Card temp;

    for (int a=1; a<=4; a++)
    {
      for (int b=1; b<=13; b++)
      {
        cards.add( new Card(a,b) );
      }
    }

     int size       

        for (int i=0; i<100; i++)
        {
            index_1 = generator.nextInt( cards.size() - 1 );
            index_2 = generator.nextInt( cards.size() - 1 );

            temp = cards.get( index_2 );
            cards.set( index_2 , cards.get( index_1 ) );
            cards.set( index_1, temp );
        }
    }
  if (line.size != 52) 
  {
    throw new InputMismatchException("Invalid record format");
  }

  public CardCollection(52);

  List <Card> cards = new ArrayList <Card>

  public Card.Suit.values(size)

  public Card.Rank.values(size)
  
  public sort(size)*/
}
