import java.awt.Point;

public class Node {
    private Gate gate;
    private Point location;

    public Node() { 
        
    }
    public void setGate(Gate g) {
        gate = g;
    }
    public void evaluateNode() {
        gate.setBoolIn1();

    }
}
