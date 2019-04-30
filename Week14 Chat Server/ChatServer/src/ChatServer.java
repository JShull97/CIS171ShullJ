import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ChatServer extends Application {

    private TextArea ta = new TextArea();
    private int clientNo = 0;

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Chat Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() { //close scene
            @Override
            public void handle(WindowEvent t) {
                primaryStage.close();
                Platform.exit();
                System.exit(0);
            }
        });

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("Chat server started at " + new Date() + "\n");

                while (true) {
                    Socket socket = serverSocket.accept();

                    //Increment clientNo
                    clientNo++;

                    Platform.runLater(() -> {
                        ta.appendText("Starting thread for client " + clientNo + " at " + new Date() + "\n");

                        // Find the client's host name, and IP address
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client " + clientNo + "'s host name " + inetAddress.getHostName() + "\n");
                        ta.appendText("Client " + clientNo + "'s IP Address is " + inetAddress.getHostName() + "\n");
                    });

                    // Create and start a new thread for the connection
                    new Thread(new HandleAClient(socket)).start();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }

    class HandleAClient implements Runnable {

        private Socket socket;

        // Construct a thread
        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                // continusly server the client
                while (true) {
                    String msg = inputFromClient.readUTF();
                    outputToClient.writeUTF(msg);

                    Platform.runLater(() -> {
                        ta.appendText(msg + "\n");
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
