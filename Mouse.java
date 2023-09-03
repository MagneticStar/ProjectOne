import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
public class Mouse extends MouseAdapter {
    
    @Override
    public void mouseClicked(MouseEvent e) {
        for (Node workingNode : Main.nodeList) {
            if (e.getPoint().distance(workingNode.getPrintPos()) < 10) {
                workingNode.clicked();
            }
        }
    }
    
    public void mouseWheelMoved(MouseWheelEvent e) {

        if (e.getWheelRotation() == 1.0) {
            Main.worldSpaceToScreenSpace.addScalers(1.1, 1.1);
            for (Node workingNode : Main.nodeList) {
                workingNode.scaleDimensions(1.1, 1.1);
            }
        }
        if (e.getWheelRotation() == -1.0) {
            Main.worldSpaceToScreenSpace.addScalers((1.0/1.1), (1.0/1.1));
            for (Node workingNode : Main.nodeList) {
                workingNode.scaleDimensions((1.0/1.1), (1.0/1.1));
            }
        }
        
        Main.worldSpaceToScreenSpace.setWorld();
        Main.p.repaint();
    }
}
