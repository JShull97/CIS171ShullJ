import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InformationalDisplay extends Application{
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: #aaffd3;");
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(2);
        pane.setVgap(2);
        Text title = new Text("\t\t\t\tKing Gizzard & the Lizard Wizard");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(title, 4, 0);
        pane.add(new ImageView("kinggizz.jpg"), 4, 10);
        
        TextField text = new TextField();
        Text txt1 = new Text();
        Text txt2 = new Text();
        Text txt3 = new Text();
        text.setText("Australian psychedelic/experimental rock septet group. Here are some interesting facts.");
        pane.add(text, 4, 12);
        txt1.setText("They have two drummers. Why? Who knows. One of those drummers dones't have kick bass permissions");
        pane.add(txt1, 4, 13);
        txt2.setText("They released 5 albums in 2017. In 2016 they came out with an album that loops infinitly.");
        pane.add(txt2, 4, 14);
        txt3.setText("One of the band members, Eric, started his own record label, under which the band releases their music.");
        pane.add(txt3, 4, 15);
        
        Button button = new Button("Listen");
        pane.add(button, 4, 17);
               
        Hyperlink link = new Hyperlink("https://www.youtube.com/watch?v=Aosfvd5vQbE"); 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                pane.add(link, 4, 18); 
            } 
        }; 
        button.setOnAction(event);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Info on KGATLW");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
