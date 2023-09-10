import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Xor extends Gate{
    
    public Xor() {
        super();
    }

    public void copy() {
        Main.nextGatePlacement = new Xor();
    }

    @Override
    public boolean evaluate(boolean one, boolean two){
        System.out.println(one);
        return one ^ two;
    }
    public Color getColor() {
        return Color.PINK;
    }
    static class action extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            Main.nextGatePlacement = new Xor();
        } 
    }
}
