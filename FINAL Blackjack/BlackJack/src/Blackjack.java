import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Blackjack extends Application {
    // class level fields
    private final Deck deck = new Deck(1);
    private final Hand hand = new Hand("Player");
    private final Hand dealer = new Hand("Dealer");
    private boolean busted;
    private boolean playerTurn;
    FlowPane cards = new FlowPane();
    FlowPane dealerCards = new FlowPane();
    Label totalLabel = new Label();
    Label totalLabelDealer = new Label();
    Label dealerLbl = new Label("Dealer's Hand");
    Label playerLbl = new Label("Your Hand");
    Label deckStatus = new Label();
    Label status = new Label();
    Label winTally = new Label();
    Image imageback = new Image("Images/table.jpg");
    TextArea actionLog = new TextArea();
    int dealerWins = 0;
    int playerWins = 0;
    int draws = 0;
    
    @Override
    public void start(Stage primaryStage) {
        // Update all text colors and fonts
        Font fontLarge = new Font("Arial", 20);
        Font fontSmall = new Font("Arial", 12);
        totalLabel.setFont(fontLarge);
        totalLabel.setTextFill(Color.WHITE);
        totalLabelDealer.setFont(fontLarge);
        totalLabelDealer.setTextFill(Color.WHITE);
        status.setTextFill(Color.WHITE);
        status.setFont(fontLarge);
        dealerLbl.setTextFill(Color.WHITE);
        dealerLbl.setFont(fontLarge);
        playerLbl.setTextFill(Color.WHITE);
        playerLbl.setFont(fontLarge);
        deckStatus.setFont(fontSmall);
        deckStatus.setTextFill(Color.WHITE);
        winTally.setFont(fontSmall);
        winTally.setTextFill(Color.WHITE);
        actionLog.setEditable(false);
        actionLog.setPrefWidth(160);
        updateTally();       
        
        // add table background
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        
        // create buttons
        Button drawbtn = new Button("Hit");
        Button newbtn = new Button("New Hand");
        Button standbtn = new Button("Stand");
        
        // button event listeners
        drawbtn.setOnAction((e) -> {
            if (playerTurn == true && busted != true) {
                drawCard(hand, cards, totalLabel);
                if (hand.evaluateHand() > 21) {
                    if(hand.getSoft() > 0) {
                        hand.softAce();
                        System.out.println(hand.evaluateHand());
                        return;
                    }
                    // you busted 
                    busted = true;
                    playerTurn = false;
                    dealerWins++;
                    updateTally();
                    actionLog.appendText("\nThe player busted");
                    status.setText("You've busted");
                }
            }
        });
                
        standbtn.setOnAction((e) -> {
            if (playerTurn == true && !busted) {
                playerTurn = false;
                while (dealer.evaluateHand() < 17) { // because dealer can't hit again if over 17
                    drawCard(dealer, dealerCards, totalLabelDealer);
                }
                int playerTotal = hand.evaluateHand();
                int dealerTotal = dealer.evaluateHand();
                if (dealerTotal <= 21 && playerTotal == dealerTotal) {
                    // tie, push
                    draws++;
                    updateTally();
                    actionLog.appendText("\nThe game was a draw");
                    status.setText("You've pushed");
                } else if (dealerTotal <= 21 && playerTotal <= dealerTotal) {
                    // you lost 
                    dealerWins++;
                    updateTally();
                    actionLog.appendText("\nThe Dealer won the game");
                    status.setText("You've lost");
                } else {
                    // you won
                    playerWins++;
                    updateTally();
                    actionLog.appendText("\nThe player won the game");
                    status.setText("You've won");
                }
            }
        });
             
        newbtn.setOnAction((e) -> newHand());
        
        // set pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11, 12, 13, 14));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.add(dealerCards, 0, 0, 3, 1);
        grid.add(dealerLbl, 0, 1);
        grid.add(totalLabelDealer, 1, 1, 2, 1);
        // padding
        Pane p = new Pane();
        p.setPrefSize(0, 100);
        grid.add(p, 0, 2);
        grid.add(cards, 0, 3, 3, 1);
        grid.add(playerLbl, 0, 4);
        grid.add(totalLabel, 1, 4, 2, 1);
        grid.add(drawbtn, 0, 5);
        grid.add(standbtn, 1, 5);
        grid.add(newbtn, 2, 5);
        grid.add(status, 0, 6, 3, 1);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(grid);
        pane.setBackground(background);
        
        // add deck stack to the scene
        VBox deckBox = new VBox();
        deckBox.getChildren().addAll(new ImageView("Images/b2fv.png"), deckStatus);
        pane.setLeft(deckBox);
        
        // add action log and win tally
        VBox actionBox = new VBox();
        actionBox.getChildren().addAll(actionLog, winTally);
        pane.setRight(actionBox);
        
        // set scene and stage
        Scene scene = new Scene(pane, 1600, 900);
        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("Images/hq.png"));
        primaryStage.show();
        newDeck();
        newHand();
    }

    // deals a card to the passed hand, add that card's image to the appropriate flowpane and update the total label
    public void drawCard(Hand hand, FlowPane pane, Label label) {
        Card card = deck.dealCard();
        deckStatus.setText("Cards remaining in deck: " + deck.getNumberOfCardsRemaining());
        actionLog.appendText("\n" + hand.getName() + " drew " + card.getRank() + " of " + card.getSuit());
        ImageView img = new ImageView(card.getCardImage());
        pane.getChildren().add(img);
        hand.addCard(card);
        int handTotal = hand.evaluateHand();
        StringBuilder total = new StringBuilder();
        if (hand.getSoft() > 0) {
            if (hand.evaluateHand() - 10 > 0)
                total.append(handTotal - 10);
        } else total.append(handTotal);
        label.setText(total.toString());
    }

    // make and shuffle a new deck when needed
    public void newDeck() {
        deck.restoreDeck();
        deck.shuffle();
    }
    
    // update per win
    public void updateTally() {
        winTally.setText("Player: " + playerWins + 
                "\nDealer: " + dealerWins + 
                "\nDraws: " + draws);
    }

    // discard all the cards in play and start a new one
    public void newHand() {
        // shuffles deck if not enough cards remain
        if (deck.getNumberOfCardsRemaining() <= deck.getSizeOfDeck() * 0.2) newDeck();
        // clear everything for a new hand
        hand.discardHand();
        dealer.discardHand();
        cards.getChildren().removeAll(cards.getChildren());
        dealerCards.getChildren().removeAll(dealerCards.getChildren());
        totalLabel.setText("");
        totalLabelDealer.setText("");
        status.setText("");
        busted = false;
        playerTurn = true;
        actionLog.appendText("\nNew game started");
        // draw cards for the initial hands, player gets 2, dealer 1 
        drawCard(hand, cards, totalLabel);
        drawCard(dealer, dealerCards, totalLabelDealer);
        drawCard(hand, cards, totalLabel);
    }

    public static void main(String[] args) {
        launch(args);
    }
}