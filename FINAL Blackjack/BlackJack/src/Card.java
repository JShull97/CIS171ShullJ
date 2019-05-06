import javafx.scene.image.Image;

public class Card {
   private final String suitValue;
   private final String rankValue;
   private final Image cardImage;
   
   String[] suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
   String[] value = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};

   public Card(String suit, String rank, Image cardFace) {
      cardImage = cardFace;
      suitValue = suit;
      rankValue = rank;
   }

   public static String getFilename(String suit, String rank) {
      return "Images/"+ suit + rank + ".png";
   }

   public String getSuit() {
      return suitValue;
   }

   public String getRank() {
      return rankValue;
   }

   public int getValue() {
       String rank = this.rankValue;  
       try{
           // try to turn it into an integer 
           return Integer.parseInt(rank);  
       } catch (Exception ex){
           // if failed, it's a face card
               return 10; 
       }
   }

   public Image getCardImage() {
      return cardImage;
   }
}