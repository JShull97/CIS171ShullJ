import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.image.Image;

public final class Deck {
   private final List deck;
   private int cardIndex;
   
   String[] suits = {"c", "d", "h", "s"};
   String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};
   
   public Deck(int numDecks) {
        deck = new ArrayList();
        cardIndex = 0;

        for (int suit = 0; suit < 4; suit++) {
            for (int faceNum = 0; faceNum < 13; faceNum++) {
                Card card = new Card(suits[suit], values[faceNum], new Image(Card.getFilename(suits[suit], values[faceNum])));
                addCard(card);
            }
        }      
        shuffle(); 
   }

   public void addCard(Card card) {
      deck.add(card);
   }

   public int getSizeOfDeck() {
      return deck.size();
   }

   public int getNumberOfCardsRemaining() {
      return deck.size() - cardIndex;
   }

   public Card dealCard() {
      if (cardIndex >= deck.size()) return null;
      else return (Card) deck.get(cardIndex++);
   }

   public void shuffle() {
      Collections.shuffle(deck);
   }

   public boolean isEmpty() {
       return cardIndex >= deck.size();
   }

   public void restoreDeck() {
      cardIndex = 0;
   }   
}