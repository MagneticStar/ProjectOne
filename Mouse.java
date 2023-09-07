import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
public class Mouse extends MouseAdapter {
    //listens for mouse clicks and tests if near a node
    @Override
    public void mouseClicked(MouseEvent e) {

        for (Node workingNode : Main.nodeList) {
            if (Math.abs(e.getPoint().x - workingNode.getPrintPos().x) < workingNode.getWidth()/2 && Math.abs(e.getPoint().y - workingNode.getPrintPos().y) < workingNode.getWidth()/2) {
                workingNode.clicked();
                workingNode.setConnection();
                return;
            }
        }
        if (Main.nextGatePlacement != null) {
            Main.nodeList.add(new Node(Node.getWorldPos(e.getPoint()), Main.nextGatePlacement));
            Main.deletedNodeList.clear();
        }
        Main.lastNodeClicked = null;
        Main.p.repaint();
    }
    //sets the scale of nodes and moves them accordingly about the world center for zooming effect
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
