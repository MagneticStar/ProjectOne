import java.awt.Point;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Node> nodeList = new ArrayList<Node>();
    public static Translation worldSpaceToScreenSpace;
    public static Panel p;

    public static void main(String args[]) {
        createScreens();
        // while(true) {
        //     tick();
        // }
        for(int i = 0; i < 1; i++) {
            nodeList.add(new Node());
            nodeList.get(i).setPoint(new Point(1, 5));
            nodeList.get(i).setGate(new Or());
        }

    }

    static void tick() {

    }

    static void createScreens() {
        Screen sc = new Screen();
        p = new Panel();
        worldSpaceToScreenSpace = new Translation(10, 10);
        sc.add(p);
        sc.setVisible(true);
    }

    

}
