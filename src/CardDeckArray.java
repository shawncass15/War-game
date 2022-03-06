import java.util.Random;

public class CardDeckArray implements CardDeckInterface

{
    private Card[] deck;
    int top;
    private final int size=52;

    public CardDeckArray()
    {
        deck= new Card[size];
        top = -1;

        for (int j = 2; j < 15; j++)
        {
            top++;
            deck[top] = new Card("Spades",j);
            top++;
            deck[top] = new Card("Clubs",j);
            top++;
            deck[top] = new Card("Hearts",j);
            top++;
            deck[top] = new Card("Diamonds",j);
        }



    }

    @Override
    public Card draw()
    {
        if(top>=0) //if deck is not empty
        {
            Card temp = deck[top]; //save the top card in temp card object
            top--;
            return temp;
        }

        return null; //if the deck is empty
    }

    @Override
    public void shuffle()
    {
        Random rand = new Random();

        for (int i = 0; i < deck.length ; i++)
        {
            int r=rand.nextInt(i+1);
            Card temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

    }

    @Override
    public int size()
    {
        return top +1;
    }
}
