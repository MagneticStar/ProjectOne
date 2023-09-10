import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Nor extends Gate {
    
    public Nor() {
        super();

    }
    public void copy() {
        Main.nextGatePlacement = new Nor();
    }
    @Override
    public boolean evaluate(boolean one, boolean two){
        return !(one || two);
    }
    public Color getColor() {
        return Color.GREEN;
    }
    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new Nor();
        } 
    }
}
