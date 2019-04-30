import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ChatClient extends Application{
    // IO Streams
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-bordercolor: green");
        paneForTextField.setLeft(new Label("Enter message: "));
        
        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);
        
        BorderPane mainPane = new BorderPane();
        // text area to display the contents
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);
        
        // create our scene
        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        tf.setOnAction(e -> {
            try {
                // get the radius from the textField
                String msgSend = tf.getText().trim();
                // send to the server
                toServer.writeUTF(msgSend);
                toServer.flush();
                
                // get area from the server
                String msgRec = fromServer.readUTF();
                // display to text area
                ta.appendText("Message recieved: " + msgRec + "\n");
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        });
        
        try {
            // create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);
            
            // create an input data stream from the server
            fromServer = new DataInputStream(socket.getInputStream());
            
            // create output data stream to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            ta.appendText(ex.toString() + "\n");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
