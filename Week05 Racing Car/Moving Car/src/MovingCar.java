/**
* Program: racing Car
* Developer: Justin Shull
* Date: 2/21/19
* Purpose: Animate the car moving across the screen
*/
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class MovingCar extends Application {
  @Override 
  public void start(Stage primaryStage) {
    Car car = new Car();
    
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    Button btStart = new Button("Start");
    Button btStop = new Button("Stop");
    hBox.getChildren().addAll(btStart, btStop);
   
    PathTransition pt = new PathTransition(Duration.millis(10000),
           new Line(475, 200, 2250, 200), car 
    );
    pt.setCycleCount(Timeline.INDEFINITE);
    
    EventHandler<ActionEvent> start = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {  
            pt.play();
        }
    };
    btStart.setOnAction(start);
    
    EventHandler<ActionEvent> stop = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            pt.pause();
        }
    };
    btStop.setOnAction(stop);
    
    EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
        @Override 
        public void handle(KeyEvent event) {
            if(event.getCode() == KeyCode.UP) {
                pt.setRate(pt.getRate() + 0.1);
            } else if (event.getCode() == KeyCode.DOWN) {
                pt.setRate(pt.getRate() > 0 ? pt.getRate() - 0.1 : 0);
            }
        }
    };
      
    // Place car and buttons in border pane
    BorderPane pane = new BorderPane();
    pane.setCenter(car);
    pane.setBottom(hBox);
    pane.setOnKeyPressed(keyListener);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 1500, 300);
    primaryStage.setTitle("Moving Car"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  public static void main(String[] args) {
    launch(args);
  }
}
