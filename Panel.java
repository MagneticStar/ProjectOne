import java.awt.*;


import javax.swing.JPanel;

public class Panel extends JPanel {
    public Panel() {
        setBackground(Color.black);
    }

    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Where all graphics are rendered
        paintnodes(g);
    }

    //sets the color and creates the square graphic for each node in nodeList
    private void paintnodes(Graphics g) {
        Node workingNode;
        for (int i = 0; i < Main.nodeList.size(); i++) {
            workingNode = Main.nodeList.get(i);
            g.setColor(workingNode.getGate().getColor());
            g.fillRect((int)workingNode.getPrintPos().x - workingNode.getWidth()/2, (int)workingNode.getPrintPos ().y - workingNode.getHeight()/2, workingNode.getWidth(), workingNode.getHeight());
            for (Node input1 : workingNode.connectionsInput1) {
                g.drawLine(workingNode.getPrintPos().x, workingNode.getPrintPos().y, input1.getPrintPos().x, input1.getPrintPos().y);
            }
            for (Node input2 : workingNode.connectionsInput2) {
                g.drawLine(workingNode.getPrintPos().x, workingNode.getPrintPos().y, input2.getPrintPos().x, input2.getPrintPos().y);
            }
        }
    }
}
