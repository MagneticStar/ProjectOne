import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Node {
    private Gate gate;
    private Point2D.Double location;
    public ArrayList<Node> connectionsInput1 = new ArrayList<Node>(); 
    public ArrayList<Node> connectionsInput2 = new ArrayList<Node>(); 
    private boolean input1 = false;
    private boolean input2 = false;
    private boolean output = false;
    private boolean nextOutput = false;
    private double width = 10;
    private double height = 10;
    public double panX;
    public double panY;
    public Node() {

    }

    public void scaleDimensions(double xScaler, double yScaler) {
        width *= xScaler;
        height *= yScaler;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return (int)width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return (int)height;
    }
    public void setPoint(Point2D.Double p) {
        location = p;
    }
    public void setGate(Gate g) {
        gate = g;
    }
    public void setConnection1(Node n) {
        connectionsInput1.add(n);
    }
    public void setConnection2(Node n) {
        connectionsInput2.add(n);
    }

    public void recieveinput1(boolean input) {
        input1 = input;
    }
    public void recieveinput2(boolean input) {
        input2 = input;
    }
    public void evaluateGate() {
        nextOutput = gate.evaluate(input2, input1);
    }
    public void nextOuputToCurrentOutput() {
        output = nextOutput;
    }
    public boolean getOutput() {
        return output;
    }
    public Gate getGate() {
        return gate;
    }
    public Point2D.Double getPoint() {
        return location;
    }
    public double[] getPosMat() {
        double[] ans = new double[2];
        ans[0] = location.getX();
        ans[1] = location.getY();
        return ans;
    }
    public Point2D.Double getPrintPos() {
        Main.worldSpaceToScreenSpace.setWorld();
        double[] ans = Main.worldSpaceToScreenSpace.translate(this.getPosMat());
         
        // sets center
        ans[0] += Main.p.getWidth()/2 + panX;
        ans[1] += Main.p.getHeight()/2 + panY;
        
        return new Point2D.Double(ans[0], ans[1]);
    }
    
    public void addConnectionIn1(Node nodeIn) {
        this.connectionsInput1.add(nodeIn);
    }

    public void addConnectionIn2(Node nodeIn) {
        this.connectionsInput2.add(nodeIn);
    }

    public void extractIn1() {
        for(Node i: connectionsInput1) {
            if(i.getOutput() == true) {
                input1 = true;
                return;
            }
        }
    }

    public void extractIn2() {
        for(Node i: connectionsInput2) {
            if(i.getOutput() == true) {
                input2 = true;
                return;
            }
        }
    }

    public void clicked() {
        // called when clicked
        System.out.println("clicked");
    }
}
