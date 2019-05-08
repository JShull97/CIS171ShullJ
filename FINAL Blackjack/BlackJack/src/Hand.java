import java.util.ArrayList;
import java.util.Collections;

public class Hand {
   private final String handName;
   private int total; 
   private int soft; 
   private final ArrayList hand = new ArrayList(); 
   
   public Hand(String name) {
       this.handName = name;
   }

   public void addCard(Card card) {
      total += card.getValue(); 
      // Ace checking
      if(card.getRank().equals("1") && total < 10)
          total += 10;
//      } else if (card.getRank().equals("1")) total += 10; // because we are already adding 1 for the ace
      if(soft > 0){
           if(total > 21){
               total -= 10; 
               //soft -= 1; 
           }
       }
      hand.add(card);
   }

   public Card getCard(int i) {
      return (Card) hand.get(i);
   }

   public void discardHand() {
      hand.clear();
      total = 0; 
      soft = 0; 
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

   public int getSoft() {
       return soft; 
   }

   public int evaluateHand() {
       return total; 
   }     

   @Override
    public String toString() {
        return hand.toString();
    }
   
}