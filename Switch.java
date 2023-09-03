import java.awt.Color;
import java.awt.event.ActionEvent;

public class Switch extends Gate{
    public boolean switchVal;

    public boolean getSwitchVal() {
        return this.switchVal;
    }

    public void setSwitchVal(boolean bool) {
        this.switchVal = bool;
    }
    public Color getColor() {
        return Color.CYAN;
    }
}
