public class Not extends Gate {
    private boolean boolIn;
    private boolean boolOut;
    
    public Not() {
        super();

    }

    public boolean evaluate(){
        return !boolIn;
    }

    public void setBool(boolean bool1) {
        boolIn = bool1;
    }

    public boolean getBoolOut() {
        return boolOut;
    }
}
