import javafx.scene.image.Image;

public class Card {
   private final String suitValue;
   private final String rankValue;
   private final Image cardImage;

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
           return Integer.parseInt(rank);  // tries to return as an integer
       } catch (NumberFormatException ex){
            return 10;   // if failed, it's a face card
       }
   }

   public Image getCardImage() {
      return cardImage;
   }
   
   public String writeRank() {
       int rank = getValue();
       if (rank == 1) return "Ace";
       if (rank < 10) return Integer.toString(rank);
       else if (this.rankValue.equals("j")) return "Jack";
       else if (this.rankValue.equals("q")) return "Queen";
       else if (this.rankValue.equals("k")) return "King";
       else return "10";
   }
   
   public String writeSuit() {
       String suit = getSuit();
       switch (suit) {
           case "s":
               return "Spades";
           case "h":
               return "Hearts";
           case "c":
               return "Clubs";
           default:
               return "Diamonds";
       }
   }
}