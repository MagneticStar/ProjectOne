import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Not extends Gate {

    public Not() {
        super();

    }

    public void copy() {
        Main.nextGatePlacement = new Nor();
    }

    public boolean evaluate(boolean one, boolean two){
        return !one;
    }
    public Color getColor() {
        return Color.BLUE;
    }
    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new Not();
        } 
    }
}
