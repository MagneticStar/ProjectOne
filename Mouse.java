import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
public class Mouse extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        e.getPoint(); // Point
    }
    public void mouseDragged(MouseEvent e) {
        e.getPoint(); // Point
    }
    public void mouseMoved(MouseEvent e) {
        e.getPoint(); // Point
    }
    public void mouseWheelMoved(MouseWheelEvent e) {
        e.getPreciseWheelRotation(); // Double
    }
}
