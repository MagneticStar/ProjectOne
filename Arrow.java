import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class Arrow {
    static class Up extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            for (Node workingNode : Main.nodeList) {
                workingNode.panY -= 10;
            }
            Main.p.repaint();
        } 
    }
    static class Down extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            for (Node workingNode : Main.nodeList) {
                workingNode.panY += 10;
            }
            Main.p.repaint();
        } 
    }
    static class Left extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            for (Node workingNode : Main.nodeList) {
                workingNode.panX -= 10;
            }
            Main.p.repaint();
        } 
    }
    static class Right extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            for (Node workingNode : Main.nodeList) {
                workingNode.panX += 10;
            }
            Main.p.repaint();
        } 
    }
}
