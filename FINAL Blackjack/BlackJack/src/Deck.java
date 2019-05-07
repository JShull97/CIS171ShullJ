import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.image.Image;

public final class Deck {
   private List deck;
   private int index;
   
   String[] suits = {"c", "d", "h", "s"};
   String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};

   //public Deck(){this(1);}
   
   public Deck(int numDecks) {
        deck = new ArrayList();
        index = 0;
       
        try{
            for (int suit = 0; suit < 4; suit++) {
                for (int faceNum = 0; faceNum < 13; faceNum++) {
                    Card card = new Card(suits[suit], values[faceNum], new Image(Card.getFilename(suits[suit], values[faceNum])));
                    addCard(card);
                }
            }
            shuffle(); 
        } catch (Exception ex){
            System.out.println(ex.getMessage()); 
        }
   }

   public void addCard(Card card) {
      deck.add(card);
   }

   public int getSizeOfDeck() {
      return deck.size();
   }

   public int getNumberOfCardsRemaining() {
      return deck.size() - index;
   }

   public Card dealCard() {
      if (index >= deck.size()) return null;
      else return (Card) deck.get(index++);
   }

   public void shuffle() {
      Collections.shuffle(deck);
   }

   public boolean isEmpty() {
       return index >= deck.size();
   }

   public void restoreDeck() {
      index = 0;
   }   
}