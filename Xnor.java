public class Xnor extends Gate {
    
    public Xnor() {
        super();
    }

    public boolean evaluate(boolean one, boolean two){
        return !(one ^ two);
    }

}
