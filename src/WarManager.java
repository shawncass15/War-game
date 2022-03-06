import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Shawn Cassie
CIS252 - Computer Science II
War Game Project
This program players the game war between two players
Comp Statement- I completed the entirety of the assignment but also struggled in my war function and making it clean.
i didnt know how to go about testing if player has enough cards to continue war so just made it so the player draws
whatever cards they have left unless they 0. if player has 0 cards he automatically loses the war

*/

public class WarManager
{
    private CardDeckArrayList deck;
    private String player1Name = "Shawn";
    private String player2Name = "Ben";
    private Player player1;
    private Player player2;


public void setup()
{

    this.deck = new CardDeckArrayList();
    deck.shuffle();
    // You'll want to shuffle before splitting them

    List<CardStack> sortedPlayerDecks = deal(deck);

    //TODO: Split the deck into two separate CardStack
    player1 = new Player(player1Name, sortedPlayerDecks.get(0));
    player2 = new Player(player2Name, sortedPlayerDecks.get(1));


}

public List<CardStack> deal(CardDeckArrayList deck)
{

    CardStack playerOneDeck = new CardStack();
    CardStack playerTwoDeck = new CardStack();
    int decksize = deck.size();
    for (int i = 0; i < decksize ; i++)
    {
        if(i % 2 == 0)
        {
            playerOneDeck.push(deck.draw());
        }
        else
        {
            playerTwoDeck.push(deck.draw());
        }
    }

    List<CardStack> allDrawDecks = new ArrayList<>();
    allDrawDecks.add(playerOneDeck);
    allDrawDecks.add(playerTwoDeck);
    return allDrawDecks;

}

public void play()
{
    ArrayList<Card> warDeck = new ArrayList<>();


    while(player1.hasCards() && player2.hasCards())
    {
        System.out.println();
        System.out.println(player1.toString());
        System.out.println(player2.toString());

        Card playerOneCard = player1.draw();
        System.out.println("Shawn's hand"+playerOneCard);

        Card playerTwoCard = player2.draw();
        System.out.println("Ben's hand" +playerTwoCard);

        if (playerOneCard.getFace()> playerTwoCard.getFace())
        {
            player1.discard(playerOneCard);
            player1.discard(playerTwoCard);
            System.out.println(player1.toString());
            System.out.println(player1Name +"won the round");

        }
        else if (playerOneCard.getFace() < playerTwoCard.getFace()) {

            player2.discard(playerOneCard);
            player2.discard(playerTwoCard);
            System.out.println(player2.toString() );
            System.out.println(player2Name +"won the round");
        }
       else if (playerOneCard.getFace() == playerTwoCard.getFace())
        {
            war(warDeck, playerOneCard, playerTwoCard);
        }

    }

    if(player1.hasCards())
    {
        System.out.println(player1Name +"Won the game");
    }
    else
    {
        System.out.println(player2Name +"Won the game");
    }

   }

    public void war(ArrayList<Card> warDeck, Card playerOneCard, Card playerTwoCard)
    {


        Boolean warIsActive = true;
        warDeck.add(playerOneCard);
        warDeck.add(playerTwoCard);


        while(player1.hasCards() && player2.hasCards() &&  warIsActive)
        {
            System.out.println("WAR!!!!!!!");

            for (int i = 0; i <3; i++)
            {
                playerOneCard= player1.draw();
                playerTwoCard = player2.draw();
                Collections.addAll(warDeck, playerOneCard, playerTwoCard);
            }


           Card playerOneCard_NEW= player1.draw();
           Card playerTwoCard_NEW = player2.draw();
           System.out.println("Shawn's hand"+playerOneCard_NEW);
           System.out.println("Ben's hand"+playerTwoCard_NEW);
           Collections.addAll(warDeck, playerOneCard_NEW, playerTwoCard_NEW);


            if (playerOneCard_NEW.getFace()> playerTwoCard_NEW.getFace())
            {
                for (Card card: warDeck)
                {
                    player1.discard(card);
                }
                System.out.println(player1.toString() +"   Won the round. Adding cards to discard pile");


                warIsActive = false;
            }
            else if (playerOneCard_NEW.getFace() < playerTwoCard_NEW.getFace())
            {
                for (Card card: warDeck)
                {
                    player2.discard(card);
                }

                System.out.println(player1.toString());

                warIsActive = false;
            }
            else if (playerOneCard_NEW.getFace() == playerOneCard_NEW.getFace())
            {

                warIsActive = true;
            }

        }
    }

    public static void main(String[] args)
    {
        WarManager war = new WarManager();

        war.setup();
        war.play();
    }
}
