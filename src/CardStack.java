public class CardStack implements StackInterface<Card> {
    private int count;
    protected LLNode<Card> top;   // reference to the top of this stack

    public CardStack() {
        count = 0;
        top = null;
    }

    public void push(Card card)
    // Places element at the top of this stack.
    {
        LLNode<Card> newNode = new LLNode<Card>(card);
        newNode.setLink(top);
        top = newNode;
        count++;
    }

    public void pop()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    {
        if (isEmpty()) {
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        } else {
            top = top.getLink();
            count--;
        }
    }

    public Card top()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element of this stack.
    {
        if (isEmpty()) {
            throw new StackUnderflowException("Top attempted on an empty stack.");
        } else {
            return top.getInfo();
        }
    }

    public boolean isEmpty()
    // Returns true if this stack is empty, otherwise returns false.
    {
        return (top == null);
    }


    public int getSize() {
        return count;
    }

    public String toString() {

        StringBuilder result = new StringBuilder();
        LLNode<Card> next = top;
        while (next != null) {
            result.append(next.getInfo().toString()).append("\n");
            next = next.getLink();
        }
        return result.toString();
    }


    public Card poptop() {
        Card temp = top();
        pop();
        return temp;
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }


}

