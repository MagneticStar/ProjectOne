import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Node extends JPanel{
    private Gate gate;
    private Point location;
    private ArrayList<Node> connectionsInput1 = new ArrayList<Node>(); 
    private ArrayList<Node> connectionsInput2 = new ArrayList<Node>(); 
    private boolean input1 = false;
    private boolean input2 = false;
    private boolean output = false;
    public Node() {
        this.addMouseListener(Main.mouseListener);
    }
    public void setPoint(Point p) {
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
        output = gate.evaluate(input2, input1);
    }
    public boolean getOutput() {
        return output;
    }
    public Gate getGate() {
        return gate;
    }
    public Point getPoint() {
        return location;
    }
    public int[] getPosMat() {
        int[] ans = new int[2];
        ans[0] = (int)location.getX();
        ans[1] = (int)location.getY();
        return ans;
    }
    public Point getPrintPos() {
        Main.worldSpaceToScreenSpace.setWorld(Main.p.getWidth(), Main.p.getHeight());
        int[] ans = Main.worldSpaceToScreenSpace.translate(this.getPosMat());
        return new Point(ans[0], ans[1]);
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

    


    
}
