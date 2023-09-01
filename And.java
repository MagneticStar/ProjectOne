import java.awt.Color;

public class And extends Gate {

    public And() {
        super();
    }
    @Override
    public boolean evaluate(boolean one, boolean two){
        return one && two;
    }
    public Color getColor() {
        return Color.WHITE;
    }
}
