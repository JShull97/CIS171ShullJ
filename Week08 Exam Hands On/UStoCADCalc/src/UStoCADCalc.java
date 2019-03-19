/**
* Program: UStoCADCalc
* Developer: Justin Shull
* Date: 3/16/19
* Purpose: Convert USD to CAD
*/
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UStoCADCalc extends Application {
    TextField tfUS = new TextField(); 
    TextField tfCAD = new TextField();
    @Override
    public void start(Stage primaryStage) {
        // set the variables
        VBox vBox = new VBox(5);
        HBox hBox1 = new HBox(5);
        HBox hBox2 = new HBox(5);
        HBox hBox3 = new HBox(5);
        Button convertCAD = new Button("Convert to CAD");
        Button convertUSD = new Button("Convert to USD");
        
        // design scene
        tfUS.setAlignment(Pos.BOTTOM_RIGHT);
        tfCAD.setAlignment(Pos.BOTTOM_RIGHT);
        hBox1.getChildren().addAll(new Label("US Dollars\t   "), tfUS);
        hBox2.getChildren().addAll(new Label("Canadian Dollars"), tfCAD);
        hBox3.getChildren().addAll(convertCAD, convertUSD);
        hBox3.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3);
        
        // set event listener
        convertCAD.setOnAction(e -> convertCAD());
        convertUSD.setOnAction(e -> convertUSD());
        
        // set stage
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("US to CAD Conversion");
        primaryStage.show();
    }
    
    public void convertCAD() {
        // convert USD to CAD
        tfCAD.setText(String.format("%.2f", ((Double.parseDouble(tfUS.getText())) * 1.5)));
    }
    
    public void convertUSD() {
        // convert USD to CAD
        tfUS.setText(String.format("%.2f", ((Double.parseDouble(tfCAD.getText())) / 1.5)));
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
