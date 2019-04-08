import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ListView extends Pane {
    private final int startingX = 20;
    private final int startingY = 20;
    private final int boxWidth = 30;
    private final int boxHeight = 20;

    protected void repaint(MyLinkedList<Integer> list) {
        getChildren().clear();
        int x = startingX + 10;
        int y = startingY + 10;        

        getChildren().add(new Text(startingX + 80, startingY, "size = " + list.size() + " and capacity = " + list.getCapacity()));
        
        if (list.size() == 0) {
            getChildren().add(new Text(startingX, startingY, "list is empty."));
        }
        else {
            getChildren().add(new Text(startingX, startingY, "linked list"));        
            for (int i = 0; i < list.size(); i++) {
                Rectangle rectangle = new Rectangle(x, y, boxWidth, boxHeight);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                getChildren().add(rectangle);
                getChildren().add(new Text(x + 10, y + 15, list.get(i) + ""));
                x = x + boxWidth;
            }
        }
        
        for (int i = list.size(); i < list.getCapacity(); i++) {
            Rectangle rectangle = new Rectangle(x, y, boxWidth, boxHeight);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);
            getChildren().add(rectangle);
            getChildren().add(new Line(x + boxWidth, y, x, y + boxHeight));
            x = x + boxWidth;
      }
    }
}