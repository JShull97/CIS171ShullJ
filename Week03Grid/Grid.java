import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Grid extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(2);
        pane.setVgap(2);
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int status = (int)Math.floor(Math.random() * 2);
                if (status == 0) {
                    TextField text = new TextField();
                    text.setMaxWidth(22);
                    text.setText("0");
                    pane.add(text, j, i);
                }
                else if (status == 1) {
                    TextField text = new TextField();
                    text.setMaxWidth(22);
                    text.setText("1");
                    pane.add(text, j, i);
                }
            }
        }
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Display random numbers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
