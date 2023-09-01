import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Xor extends Gate{
    
    public Xor() {
        super();
    }
    @Override
    public boolean evaluate(boolean one, boolean two){
        return one ^ two;
    }
    public Color getColor() {
        return Color.PINK;
    }
    static class action extends AbstractAction {
        public action() {
            
        }
        public void actionPerformed(ActionEvent e) {

        } 
    }
}
