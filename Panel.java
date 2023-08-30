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
    }
}
