/**
* Program: RaiseFlagThread
* Developer: Justin Shull (Revel)
* Date: 4/23/19
* Purpose: Animate a flag rising with a thread
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class RaiseFlag extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
       
        ImageView imgV = new ImageView("Images/us.gif");
        PathTransition pt = new PathTransition(Duration.millis(1000),
            new Line(100, 200, 100, 0), imgV);
        
        new Thread(() -> {
            Platform.runLater(() -> {
                pt.play();
            });
        }).start();
        
        pane.getChildren().add(imgV);
        
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("Raise Flag Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}