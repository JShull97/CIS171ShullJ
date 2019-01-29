public class Hexagon extends GeometricObject implements Comparable<Hexagon>{
    //class fields
    private int sideSize;
    
    /**
     * default no-arg constructor 
     */
    public Hexagon() {
    }

    /**
     * constructor for a hexagon object
     * @param sideSize 
     */
    public Hexagon(int sideSize) {
        this.sideSize = sideSize;
    }    
    
    public int getSideSize() {
        return sideSize;
    }
    
    public void setSideSize(int value) {
        sideSize = value;
    }
    
    @Override
    public double getArea() {
        return sideSize * 60;
    }
    
    @Override
    public double getPerimeter() {
        return sideSize * 6;
    }
    
    @Override
    public int compareTo(Hexagon o) {
        if (this.sideSize > o.getSideSize())
            return 1;           //return positive value 
        else if (this.sideSize < o.getSideSize()) 
            return -1;
        else
            return 0;
    }
}
