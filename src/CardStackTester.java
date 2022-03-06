import java.util.Arrays;

public class CardStackTester
{
    public static void main(String[] args)
    {
        Card c1 = new Card("Spades",13);
        Card c2 = new Card("diamonds",2);
        Card c3 = new Card("Hearts",2);
        Card c4 = new Card("diamonds",8);
        Card c5 = new Card("Spades",7);

        CardStack cardStack = new CardStack();

        //pushing operation

        cardStack.push(c1);
        cardStack.push(c2);
        cardStack.push(c3);
        cardStack.push(c4);
        System.out.println(cardStack.toString());


        //perform pop operations
        System.out.println("popping");
        System.out.println(cardStack.poptop());
        System.out.println(" ");
        System.out.println(cardStack.poptop());
        System.out.println(cardStack.poptop());
        System.out.println(cardStack.poptop());
        if(cardStack.isEmpty())
        {
            System.out.println(cardStack.getSize());
        }


    }
}
