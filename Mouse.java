import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
public class Mouse extends MouseAdapter {
    private int panX;
    private int panY;

    public int getPanX() {
        return panX;
    }
    public int getPanY() {
        return panY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Node workingNode : Main.nodeList) {
            if (e.getPoint().distance(workingNode.getPrintPos()) < 10) {
                workingNode.clicked();
            }
        }
    }
    // public void mouseMoved(MouseEvent e) {
    //     panX = e.getPoint().x - Main.p.getWidth()/2;
    //     panY = e.getPoint().y - Main.p.getHeight()/2;
    //     Main.worldSpaceToScreenSpace.setWorld();
    //     Main.p.repaint();
    // }
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
         // mouse pan
        panX = e.getPoint().x - Main.p.getWidth()/2;
        panY = e.getPoint().y - Main.p.getHeight()/2;
    
        // for (Node workingNode : Main.nodeList) {
        //         workingNode.setPoint(new Point2D.Double());
        //     }

        Main.worldSpaceToScreenSpace.setWorld();
        Main.p.repaint();
    }
}
