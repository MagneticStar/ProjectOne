import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Or extends Gate {

    public Or() {
        super();

    }

    public void copy() {
        Main.nextGatePlacement = new Or();
    }

    @Override
    public boolean evaluate(boolean one, boolean two){
        return one || two;
    }
    public Color getColor() {
        return Color.YELLOW;
    }
    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new Or();
        } 
    }
}
