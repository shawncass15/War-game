import java.util.List;

public class Player
{
    private String name;
    private final CardStack discardStack;
    private final CardStack drawStack;   // still need this to allocate the object in memory


    public Player(String name, CardStack drawStack) {
        this.name = name;

        // Passing in the pre-made draw stack from the game manager
        this.drawStack = drawStack;
        discardStack = new CardStack();
    }

    public void replenishDrawStack() {

        while (!discardStack.isEmpty()) {
            drawStack.push(discardStack.poptop());
        }

    }

    public Card draw() {

        if(drawStack.isEmpty())
        {
            replenishDrawStack();
        }
        return drawStack.poptop();
    }

    public void discard(Card card)
 {
        discardStack.push(card);
    }

    public boolean hasCards() {
        return !drawStack.isEmpty() || !discardStack.isEmpty();
    }

@Override
    public String toString() {
        return name + " has" +drawStack.getSize() + "left";
    }

    public int cardCount()
    {
        return drawStack.getSize();
    }

    public void clearDrawstack()
    {
        drawStack.clear();
    }

}