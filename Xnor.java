import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Xnor extends Gate {
    
    public Xnor() {
        super();
    }

    public boolean evaluate(boolean one, boolean two){
        return !(one ^ two);
    }
    public Color getColor() {
        return Color.ORANGE;
    }
    static class action extends AbstractAction {
        public action() {
            
        }
        public void actionPerformed(ActionEvent e) {

        } 
    }
}
