public class CardDeckTester
{
    public static void main(String[] args) {
        //using the interface as the type for the reference variable
        CardDeckInterface deck = new CardDeckArray();

        Card player1Card, player2Card;

        System.out.println("There are "+deck.size()+" cards in the deck");
        System.out.println("Deck is being shuffled");
        deck.shuffle();

        System.out.println("Player 1 draws a card");
        player1Card = deck.draw();
        System.out.println("Player 1 drew the " + player1Card);
        System.out.println("There are "+deck.size()+" cards in the deck");


        System.out.println("Player 2 draws a card");
        player2Card = deck.draw();
        System.out.println("Player 2 drew the " + player2Card);
        System.out.println("There are "+deck.size()+" cards in the deck");
    }
}


