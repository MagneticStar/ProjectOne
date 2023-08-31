public class And extends Gate {
    private boolean boolIn1;
    private boolean boolIn2;
    private boolean boolOut;

    public And() {
        super();
    }

    public void evaluate(){
        boolOut = boolIn1 && boolIn2;
    }

    public void setBoolIn1(boolean bool1) {
        boolIn1 = bool1;
    }

    public void setBoolIn2(boolean bool2) {
        boolIn2 = bool2;
    }

    public boolean getBoolOut() {
        return boolOut;
    }
}
