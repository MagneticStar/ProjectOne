import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
public class Mouse extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
    }
    public void mouseDragged(MouseEvent e) {
        // e.getPoint(); // Point
        System.out.println("dragged");
    }
    public void mouseMoved(MouseEvent e) {
        e.getPoint(); // Point
        System.out.println("Moved");
    }
    public void mouseWheelMoved(MouseWheelEvent e) {
        e.getPreciseWheelRotation(); // Double
        System.out.println("Wheel");
    }
}
