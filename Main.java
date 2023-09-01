import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Node> nodeList = new ArrayList<Node>();
    public static Translation worldSpaceToScreenSpace;
    public static Panel p;
    public static Mouse mouseListener = new Mouse();
    public static void main(String args[]) {
        createScreens();
        // while(true) {
        //     tick();
        // }
        for(int i = 0; i < 1; i++) {
            nodeList.add(new Node());
            
        }
        nodeList.get(0).setPoint(new Point2D.Double(1, 1));
        nodeList.get(0).setGate(new Or());
        // nodeList.get(1).setPoint(new Point2D.Double(5, 7));
        // nodeList.get(1).setGate(new Or());
        // nodeList.get(2).setPoint(new Point2D.Double(-4, -4));
        // nodeList.get(2).setGate(new And());
    }

    static void tick() {

    }

    static void createScreens() {
        Screen sc = new Screen();
        p = new Panel();
        p.addMouseListener(mouseListener);
        p.addMouseMotionListener(mouseListener);
        p.addMouseWheelListener(mouseListener);
        sc.add(p);
        
        sc.setVisible(true);
        worldSpaceToScreenSpace = new Translation(10, 10, p.getWidth(), p.getHeight());
    }

    

}
