
public class Deck {
    String[] ranks = {"a", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};
    Card[] deck = new Card[52];
    
    public Deck() {
    }
    
    public void fillDeck() {
        for (int i = 1; i <= 4; i++) {
            for (String rank : ranks) {
                if (i == 1) Card.setSuit("c");
                else if (i == 2) Card.setSuit("d");
                else if (i == 3) Card.setSuit("h");
                else if (i == 4) Card.setSuit("s");
                Card.setRank(rank);
            }
        }          
    }
}
