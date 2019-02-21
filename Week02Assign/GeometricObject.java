public abstract class GeometricObject implements Comparable<GeometricObject>{
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new java.util.Date();
  }

  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /** Get dateCreated */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  @Override
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color +
      " and filled: " + filled;
  }

  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
 
// not properly implemented. The compareTo should have the if logic tbat
// is in the max method. positive number returned if first value is >, negative
// value returned if first value is <, 0 if equal
  public int compareTo(GeometricObject o) {
      return 1;
  }

// max method should use your compareTo 
  // Static method to compare two objects' size
  public static void max (GeometricObject oj1, GeometricObject oj2) {
      if (oj1.getArea() > oj2.getArea()) {
          System.out.println("Object 1 is larger");
      }
      else if (oj2.getArea() > oj1.getArea()){
          System.out.println("Object 2 is larger");
      }
      else
           System.out.println("Objects are equal"); 
  }
}

  
