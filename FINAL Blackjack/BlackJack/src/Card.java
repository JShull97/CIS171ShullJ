import javafx.scene.image.Image;

public class Card {
    private Image cardImage;
    private String cardRank;
    private String cardSuit;
    
    public Card(Image cardFace, String rank, String suit) {
        cardImage = cardFace;
        cardRank = rank;
        cardSuit = suit;
    }
    
    public static int getValue(int cardValue) {
        return 0;
    }
    
    public String getRank() {
        return this.cardRank;
    }
    
    public String getSuit() {
        return this.cardSuit;
    }
    
    public static String getImage() {
        return "Images" + "";
    }
    
    public void setRank(String rank) {
        this.cardRank = rank;
    }
    
    public void setSuit(String suit) {
        this.cardSuit = suit;
    }
}
