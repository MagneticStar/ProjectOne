import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Switch extends Gate{
    boolean value = false;
    public void clicked() {
        if (value == true) {
            value = false;
        }
        else {
            value = true;
        }
    }

    public void copy() {
        Main.nextGatePlacement = new Switch();
    }

    public boolean evaluate(boolean one, boolean two){
        return value;
    }

    public Color getColor() {
        return Color.CYAN;
    }

    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new Switch();
        } 
    }
}
