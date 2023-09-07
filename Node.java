import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
    public static double panX;
    public static double panY;

    public Node(Point2D.Double location, Gate gate) {
        this.location = location;
        this.gate = gate;
    }
    //dimension scaler for zooming
    public void scaleDimensions(double xScaler, double yScaler) {
        width *= xScaler;
        height *= yScaler;
    }

    //setters and getters
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
    public Point2D.Double getPoint() {
        return location;
    }

    public void setGate(Gate g) {
        gate = g;
    }
    public Gate getGate() {
        return gate;
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

    //evaluates the gate with the current inputs/outputs    
    public void evaluateGate() {
        nextOutput = gate.evaluate(input1, input2);
    }

    public void nextOuputToCurrentOutput() {
        output = nextOutput;
    }
    public boolean getOutput() {
        return output;
    }

    //creates a matrix of the point    
    public double[] getPosMat() {
        double[] ans = new double[2];
        ans[0] = location.getX();
        ans[1] = location.getY();
        return ans;
    }

    public Point getPrintPos() {
        Main.worldSpaceToScreenSpace.setWorld();
        double[] ans = Main.worldSpaceToScreenSpace.translate(this.getPosMat());
         
        // sets center
        ans[0] += Main.p.getWidth()/2 + panX;
        ans[1] += Main.p.getHeight()/2 + panY;
        
        return new Point((int)ans[0], (int)ans[1]);
    }
    public static Point2D.Double getWorldPos(Point screenPoint) {
        Main.worldSpaceToScreenSpace.setWorld();
        double[] screenArray = {screenPoint.getX(), screenPoint.getY()};
        // sets center
        screenArray[0] -= Main.p.getWidth()/2 + panX;
        screenArray[1] -= Main.p.getHeight()/2 + panY;
        System.out.println(screenArray[0] + "," + screenArray[1]);
        double[] ans = Main.worldSpaceToScreenSpace.inverseTranslate(screenArray);
        
        
        
        return new Point2D.Double(ans[0], ans[1]);
    }
    //adds the nodeIn to the connectionsInput ArrayLists
    public void addConnectionIn1(Node nodeIn) {
        this.connectionsInput1.add(nodeIn);
    }
    public void addConnectionIn2(Node nodeIn) {
        this.connectionsInput2.add(nodeIn);
    }

    //extracts the values of the inputs for each node in the input ArrayLists
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

        System.out.println("clicked");
    }

    public void setLastNodeClicked() {
        Main.lastNodeClicked = this;
    }

    static class setNextInput1 extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextInputChoice = 1;
        } 
    }

    static class setNextInput2 extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextInputChoice = 2;
        } 
    }

    public void setConnection() {
        if(Main.lastNodeClicked == null) {
            Main.lastNodeClicked = this;
        }
        else {
            if(Main.nextInputChoice == 1) {
                addConnectionIn1(Main.lastNodeClicked);
            }
            else {
                addConnectionIn2(Main.lastNodeClicked);
            }
            Main.lastNodeClicked = null;
        }
        Main.p.repaint();
    }
}
