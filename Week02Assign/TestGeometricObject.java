public class TestGeometricObject {
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize two circles and two rectangle objects
    Circle circ1 = new Circle(5);
    Circle circ2 = new Circle(3);
    
    Rectangle rect1 = new Rectangle(3, 4);
    Rectangle rect2 = new Rectangle(3, 5);
    
    // Compare the objects 
    GeometricObject.max(circ1, circ2);
    GeometricObject.max(rect1, rect2);
  }
}
