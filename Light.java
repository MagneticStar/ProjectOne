import javax.swing.AbstractAction;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class Light extends Gate {
    private boolean onOff = false;
    public boolean evaluate(boolean one, boolean two){
        onOff = one;
        return one;
    }

    public Color getColor() {
        return onOff?Color.LIGHT_GRAY:Color.DARK_GRAY;
    }

    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new Light();
        } 
    }
}
