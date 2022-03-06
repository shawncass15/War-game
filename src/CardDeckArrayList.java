import java.util.Collections;
import java.util.ArrayList;

    public class CardDeckArrayList implements CardDeckInterface
    {
        private  ArrayList<Card> deck;

        public CardDeckArrayList()
        {
            deck = new ArrayList<>();

            for (int j = 2; j < 15; j++)
            {
                deck.add(new Card("Spades",j));
                deck.add(new Card("Clubs",j));
                deck.add(new Card("Hearts",j));
                deck.add(new Card("Diamonds",j));
            }
        }

        @Override
        public Card draw()
        {
            if(deck.size()>=0) //if deck is not empty
            {
                Card temp = deck.get((deck.size()-1)); //save the top card in temp card object
                deck.remove(temp);
                return temp;
            }

            return null; //if the deck is empty
        }

        @Override
        public void shuffle()
        {
            Collections.shuffle(deck);

        }

        @Override
        public int size()
        {
            return deck.size();
        }
    }



