import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Nand extends Gate{

    public Nand() {
        super();
    }
    @Override
    public boolean evaluate(boolean one, boolean two){
        return !(one && two);
    }
    public Color getColor() {
        return Color.RED;
    }
    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new Nand();
        } 
    }
}
