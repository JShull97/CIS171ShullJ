import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFields extends Application{
    @Override
    public void start(Stage primaryStage) {
        //Set textfields
        TextField tTextField = new TextField();
        TextField tPrefColumnSize =  new TextField();
        
        tTextField.setAlignment(Pos.BOTTOM_RIGHT);
        tPrefColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        
        tTextField.setPrefColumnCount(13);
        tPrefColumnSize.setPrefColumnCount(3);
        
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("Text Field"), tTextField);
        
        //create radio buttons and group them together
        RadioButton rLeft = new RadioButton("Left");
        RadioButton rRight = new RadioButton("Right");
        RadioButton rCenter = new RadioButton("Center");
        
        ToggleGroup group = new ToggleGroup();
        rLeft.setToggleGroup(group);
        rRight.setToggleGroup(group);
        rCenter.setToggleGroup(group);
        
        //HBoxes to get everything positioned correctly
        HBox hBox2 = new HBox(5);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(rLeft, rRight, rCenter);
        
        HBox hBox3 = new HBox(5);
        hBox3.getChildren().addAll(new Label("Column Size"), tPrefColumnSize);
        
        HBox hBox4 = new HBox(15);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(hBox2, hBox3);
        
        //vBox to hold the HBoxes
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox, hBox4);
        
        //set stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Radio Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Event Listeners
        tPrefColumnSize.setOnAction(e -> {
            tTextField.setPrefColumnCount(
                    Integer.parseInt(tPrefColumnSize.getText())
            );
        });
        
        rLeft.setOnAction((e) -> tTextField.setAlignment(Pos.BASELINE_LEFT));
        rRight.setOnAction((e) -> tTextField.setAlignment(Pos.BASELINE_RIGHT));
        rCenter.setOnAction((e) -> tTextField.setAlignment(Pos.BASELINE_CENTER));
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
