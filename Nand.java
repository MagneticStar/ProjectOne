import java.awt.Color;

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
}
