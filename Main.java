import java.awt.Point;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Node> nodeList = new ArrayList<Node>();

    

    public static void main(String args[]) {
        createScreens();
        // while(true) {
        //     tick();
        // }
        for(int i = 0; i < 20; i++) {
            nodeList.add(new Node());
        }
        for(int i = 0; i < 20; i++) {
            nodeList.get(i).setPoint(new Point(1, 5));
        }
    }

    static void tick() {

    }

    static void createScreens() {
        Screen sc = new Screen();
        Panel p = new Panel();
        Translation worldSpaceToScreenSpace = new Translation(10000, 10000);
        sc.add(p);
        sc.setVisible(true);
    }

}
