public class Nor extends Gate {
    
    public Nor() {
        super();

    }
    @Override
    public boolean evaluate(boolean one, boolean two){
        return !(one || two);
    }

}
