public class Translation {
    private double[] transMat = new double[2];
    private double worldSizeX;
    private double worldSizeY;
    private double xScaler;
    private double yScaler;
    // constructors
    public Translation(double worldSizeX, double worldSizeY, double xScaler, double yScaler) {
        this.worldSizeX = worldSizeX;
        this.worldSizeY = worldSizeY;
        this.xScaler = xScaler;
        this.yScaler = yScaler;
    }
    public Translation(double[] m) {
        transMat = m;
    }
    
    // setters
    public void setXScaler(double xScaler) {
        this.xScaler = xScaler;
    }
    public void setYScaler(double yScaler) {
        this.yScaler = yScaler;
    }
    public void setWorld() {
        transMat[0] = xScaler/worldSizeX;
        transMat[1] = yScaler/worldSizeY;
    }
    public void addScalers(double xScaler, double yScaler) {
        this.xScaler *= xScaler;
        this.yScaler *= yScaler;
    }
    // getters
    public double[] getMat() {
        return transMat;
    }

    // multiplies two matrices for translating
    public double[] translate(double[] input) {

        double[] result = new double[2];

        for (int i = 0; i < result.length; i++) {
                result[i] = transMat[i] * input[i];
        }
        return result;
    }
    public double[] inverseTranslate(double[] input) {

        double[] result = new double[2];
        for (int i = 0; i < result.length; i++) {
                result[i] = input[i] / transMat[i];
        }
        
        return result;
    }
    
}