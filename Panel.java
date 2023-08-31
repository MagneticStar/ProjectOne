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
        for (int i = 0; i < Main.nodeList.size(); i++) {
            g.setColor(Color.WHITE);
            g.drawRect(Main.nodeList.get(i).getPrintPos().x,Main.nodeList.get(i).getPrintPos().y, 10, 10);
        }
    }
}
