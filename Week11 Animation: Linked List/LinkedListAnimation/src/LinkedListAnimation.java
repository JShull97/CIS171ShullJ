/**
* Program: LinkedListAnimation
* Developer: Justin Shull (Revel)
* Date: 4/7/19
* Purpose: Create an animation to show the changes being made to an array
*/
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;

public class LinkedListAnimation extends Application {  
    private final MyArrayList<Integer> list = new MyArrayList<>();
    private final ListView view = new ListView();
    private final Button btSearch = new Button("Search");
    private final Button btInsert = new Button("Insert");
    private final Button btDelete = new Button("Delete");
    private final TextField tfNumber = new TextField();
    private final TextField tfIndex = new TextField();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {         
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a value: "),
        tfNumber, new Label("Enter an index: "), tfIndex, btSearch, btInsert, btDelete);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(view);
        borderPane.setBottom(hBox);
        Label lblStatus = new Label();
        borderPane.setTop(lblStatus);
        BorderPane.setAlignment(lblStatus, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 500, 250);
        primaryStage.setTitle("ArrayList Animation"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        view.repaint(list);
        tfNumber.setPrefColumnCount(2); 
        tfIndex.setPrefColumnCount(2); 

        // Set event listeners
        btSearch.setOnAction(e -> {
            lblStatus.setText("");
            if (!list.contains(Integer.parseInt(tfNumber.getText()))) {
                lblStatus.setText("key is not in the list");
            }   
            else lblStatus.setText("key is in the list");
            view.repaint(list);
        });

        btInsert.setOnAction(e -> {
            lblStatus.setText("");
            if (tfIndex.getText().trim().length() > 0)
                list.add(Integer.parseInt(tfIndex.getText()), Integer.parseInt(tfNumber.getText()));
            else list.add(Integer.parseInt(tfNumber.getText()));
            view.repaint(list);
        });
        
        btDelete.setOnAction(e -> {
            lblStatus.setText("");
            if (!list.contains(Integer.parseInt(tfNumber.getText()))) {
                lblStatus.setText("key is not in the list");
            }       
            else {
                lblStatus.setText("key is deleted from the list");
                list.remove(new Integer(Integer.parseInt(tfNumber.getText())));
                view.repaint(list);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}