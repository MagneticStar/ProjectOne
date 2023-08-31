public class Or extends Gate {
    private boolean boolIn1;
    private boolean boolIn2;
    private boolean boolOut;
    
    public Or() {
        super();

    }

    public boolean evaluate(){
        return boolIn1 || boolIn2;
    }

    public void setBool1(boolean bool1) {
        boolIn1 = bool1;
    }

    public void setBool2(boolean bool2) {
        boolIn2 = bool2;
    }

    public boolean getBoolOut() {
        return boolOut;
    }
}
