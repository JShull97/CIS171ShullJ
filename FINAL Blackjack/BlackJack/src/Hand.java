import java.util.ArrayList;
import java.util.Collections;

public class Hand {
   private final String handName;
   private int total; 
   private final ArrayList hand = new ArrayList();
   
   public Hand(String name) {
       this.handName = name;
   }

   public void addCard(Card card) {
      total += card.getValue(); 
      // Ace checking
      if(card.getRank().equals("1") && total < 12) total += 10;
      else if(card.getRank().equals("1") && total > 21) total -= 10;
      hand.add(card);
   }

   public Card getCard(int i) {
      return (Card) hand.get(i);
   }

   public void discardHand() {
      hand.clear();
      total = 0; 
   }

   public int getNumberOfCards() {
      return hand.size();
   }

   public void sort() {
      Collections.sort(hand);
   }

   public boolean isEmpty() {
      return hand.isEmpty();
   }

   public int findCard(Card card) {
      return hand.indexOf(card);
   }
   
   public String getName() {
       return handName;
   }

   public int evaluateHand() {
       return total; 
   }     

   @Override
    public String toString() {
        return hand.toString();
    }
   
}