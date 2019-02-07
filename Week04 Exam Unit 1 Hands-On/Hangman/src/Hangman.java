import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Hangman extends Application{
    @Override
    public void start(Stage primaryStage) {
        //create a pane
        Pane pane = new Pane();
        
        //create noose
        Line noose1 = new Line(25, 25, 200, 25);
	noose1.setStroke(Color.BROWN);
	noose1.setStrokeWidth(3);
	pane.getChildren().add(noose1);

	Line noose2 = new Line(25, 25, 25, 300);
	noose2.setStroke(Color.BROWN);
        noose2.setStrokeWidth(3);
	pane.getChildren().add(noose2);

	Line noose3 = new Line(300, 300, 25, 300);
	noose3.setStroke(Color.BROWN);
	noose3.setStrokeWidth(3);
	pane.getChildren().add(noose3);

	Line rope = new Line(200, 25, 200, 75);
	rope.setStroke(Color.BROWN);
	rope.setStrokeWidth(3);
        pane.getChildren().add(rope);
        
        
        //create body
        Circle head = new Circle(200, 100, 200);
        head.setRadius(25);
        head.setStroke(Color.BLACK);
        head.setStrokeWidth(3);
        head.setFill(Color.WHITE);
        pane.getChildren().add(head);
        
        Line body = new Line(200, 125, 200, 200);
        body.setStroke(Color.BLACK);
	body.setStrokeWidth(3);
        pane.getChildren().add(body);
        
        Line leg1 = new Line(175, 250, 200, 200);
        leg1.setStroke(Color.BLACK);
	leg1.setStrokeWidth(3);
        pane.getChildren().add(leg1);
        
        Line leg2 = new Line(225, 250, 200, 200);
        leg2.setStroke(Color.BLACK);
	leg2.setStrokeWidth(3);
        pane.getChildren().add(leg2);
        
        Line arm1 = new Line(225, 150, 200, 130);
        arm1.setStroke(Color.BLACK);
	arm1.setStrokeWidth(3);
        pane.getChildren().add(arm1);
        
        Line arm2 = new Line(175, 150, 200, 130);
        arm2.setStroke(Color.BLACK);
	arm2.setStrokeWidth(3);
        pane.getChildren().add(arm2);
        
        
        //create a scene and place it in the stage
        Scene scene = new Scene(pane, 350, 350);
        primaryStage.setTitle("Draw Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
