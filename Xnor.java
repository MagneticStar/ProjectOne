import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Xnor extends Gate {
    
    public Xnor() {
        super();
    }

    public void copy() {
        Main.nextGatePlacement = new Xnor();
    }

    public boolean evaluate(boolean one, boolean two){
        return !(one ^ two);
    }
    public Color getColor() {
        return Color.ORANGE;
    }
    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new Xnor();
        } 
    }
}
