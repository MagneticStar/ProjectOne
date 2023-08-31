public class Or extends Gate {

    public Or() {
        super();

    }
    @Override
    public boolean evaluate(boolean one, boolean two){
        return one || two;
    }

}
