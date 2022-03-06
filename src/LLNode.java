//----------------------------------------------------------------------------
// LLNode.java                by Dale/Joyce/Weems                    Chapter 2
//
// Implements <T> nodes for a Linked List.
//----------------------------------------------------------------------------

public class LLNode<Card>
{
  protected LLNode<Card> link;
  protected Card info;
  
  public LLNode(Card info)
  {
    this.info = info;
    link = null;
  }
 
  public void setInfo(Card info){ this.info = info;}
  public Card getInfo(){ return info; }
  public void setLink(LLNode<Card> link){this.link = link;}
  public LLNode<Card> getLink(){ return link;}


}
 
 