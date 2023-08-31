public class Xor extends Gate{
    
    public Xor() {
        super();
    }
    @Override
    public boolean evaluate(boolean one, boolean two){
        return one ^ two;
    }

}
