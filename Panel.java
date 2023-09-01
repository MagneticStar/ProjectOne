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
    private void paintnodes(Graphics g) {
        Node workingNode;
        for (int i = 0; i < Main.nodeList.size(); i++) {
            workingNode = Main.nodeList.get(i);
            g.setColor(workingNode.getGate().getColor());
            g.fillRect(Main.nodeList.get(i).getPrintPos().x,Main.nodeList.get(i).getPrintPos ().y, 10, 10);
        }
    }
}
