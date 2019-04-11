import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

 
public class Exam3 extends Application{
    int[] list50;
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Label("Array Size"), new Label("\tSelection Sort"), 
                new Label("\tRadix Sort"), new Label("\tBubble Sort"), new Label("\tMerge Sort"),
                new Label("\tQuick Sort"), new Label("\tHeap Sort"));
        pane.setTop(hBox);
        Line line = new Line(20, 0, 600, 0);
        
        HBox row1 = new HBox();
        row1.getChildren().addAll(new Label("50\t"), new Label(String.valueOf(timeSelectionSort(50))));
        
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox, line, row1);
        pane.setLeft(vBox);

        // Set scene
        Scene scene = new Scene(pane, 600, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle(" ");
        primaryStage.show();
    }

    public static void main(String[] args) {
        fillArrays(); //TODO
        launch(args);
    }
    
    public long timeSelectionSort(int arrayLength) {
        for (int i = 0; i < list.length; i++) list[i] = (int)(Math.random() * arrayLength) + 1;
        int[] listCopy = list.clone();
    }
}
