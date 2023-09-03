import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Switch extends Gate{
    
    public boolean evaluate(boolean one, boolean two){
        return one;
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
