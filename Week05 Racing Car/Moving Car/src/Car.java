/**
* Program: Racing Car
* Developer: Justin Shull
* Date: 2/21/19
* Purpose: Create a new Car pane
*/
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Car extends Pane{
    Rectangle body = new Rectangle(250, 40);
    Circle wheel1 = new Circle(30);
    Circle wheel2 = new Circle(30);
    Polygon top = new Polygon();
    
    public void setCar() {
        body.setStroke(Color.BLACK);
        body.setFill(Color.RED);
        body.setX(20);
        body.setY(100);
        wheel1.setStroke(Color.BLACK);
        wheel1.setFill(Color.BLACK);
        wheel1.setLayoutX(70);
        wheel1.setLayoutY(150);
        wheel2.setStroke(Color.BLACK);
        wheel2.setFill(Color.BLACK);
        wheel2.setLayoutX(225);
        wheel2.setLayoutY(150);
        
        top.getPoints().addAll(new Double[]{
           50.0, 100.0, 
           100.0, 50.0,
           150.0, 50.0,
           200.0, 100.0
        });
        top.setStroke(Color.BLACK);
        top.setFill(Color.BLUE);
        
        getChildren().clear();
        getChildren().addAll(body, wheel1, wheel2,top);   
    }
  
    @Override
  public void setWidth(double width) {
    super.setWidth(width);
    setCar();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    setCar();
  }
}
