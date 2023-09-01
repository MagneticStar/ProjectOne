import java.awt.Color;

public class Not extends Gate {

    public Not() {
        super();

    }

    public boolean evaluate(boolean one, boolean two){
        return !one;
    }
    public Color getColor() {
        return Color.BLUE;
    }
}
