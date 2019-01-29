public class TestGeometricObject {
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize two geometric objects
    Circle geoObject1 = new Circle(5);
    Rectangle geoObject2 = new Rectangle(5, 3);

    System.out.println("The two objects have the same area? " +
      equalArea(geoObject1, geoObject2));

    // Display circle
    displayGeometricObject(geoObject1);

    // Display rectangle
    displayGeometricObject(geoObject2);
    
    // add code to creat a hexagon
    Hexagon[] hexArr = new Hexagon[4];
    hexArr[0] = new Hexagon(7);
    hexArr[1] = new Hexagon(9);

    
    
    hexArr[2] = new Hexagon(3);
    hexArr[3] = new Hexagon(6);
    for (Hexagon one : hexArr) {
        displayGeometricObject(one);
    }
    java.util.Arrays.sort(hexArr);
    for (Hexagon one : hexArr) {
        displayGeometricObject(one);
    }
  }

  /** A method for comparing the areas of two geometric objects */
  public static boolean equalArea(GeometricObject object1,
      GeometricObject object2) {
    return object1.getArea() == object2.getArea();
  }

  /** A method for displaying a geometric object */
  public static void displayGeometricObject(GeometricObject object) {
    System.out.println();
    System.out.println("The area is " + object.getArea());
    System.out.println("The perimeter is " + object.getPerimeter());
  }
}
