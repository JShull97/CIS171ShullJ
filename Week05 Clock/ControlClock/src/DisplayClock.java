import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class DisplayClock extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a clock and a label
    ClockPane clock = new ClockPane();
    
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    Button btStart = new Button("Start");
    Button btStop = new Button("Stop");
    hBox.getChildren().addAll(btStart, btStop);
    
    Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(1000)), e -> move()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play();

    btStart.setOnAction((e) -> {
        
    });
    
    btStop.setOnAction((e) -> {
        
    });

    // Place clock and label in border pane
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(hBox);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("DisplayClock"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

    public static void timeBuild() {
        Timeline animation = new Timeline();
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(1000)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

class StartHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        
    }
}
