import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class And extends Gate {

    public And() {
        super();
    }
    @Override
    public boolean evaluate(boolean one, boolean two){
        return one && two;
    }
    public Color getColor() {
        return Color.WHITE;
    }
    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new And();
        } 
    }
}
