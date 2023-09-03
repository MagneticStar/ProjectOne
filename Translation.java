public class Translation {
    private double[][] transMat = new double[2][2];
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
    public Translation(double[][] m) {
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
        transMat[0][0] = xScaler/worldSizeX;
        transMat[1][1] = yScaler/worldSizeY;
    }
    public void addScalers(double xScaler, double yScaler) {
        this.xScaler *= xScaler;
        this.yScaler *= yScaler;
    }
    // getters
    public double[][] getMat() {
        return transMat;
    }

    // multiplies two matrices for translating
    public double[] translate(double[] input) {

        double[] result = new double[2];

        for (int i = 0; i < result.length; i++) {
                result[i] = multiplycell(input, i);
        }
        return result;
    }
    public double[] inverseTranslate(double[] input) {

        double[] result = new double[2];

        for (int i = 0; i < result.length; i++) {
                result[i] = imultiplycell(input, i);
        }
        
        return result;
    }
    public double multiplycell(double[] input, int col) {
        double cell = 0.0;
        for (int i = 0; i < transMat.length; i++) {
            cell += input[i] * transMat[i][col];
            System.out.println(transMat[i][col]);
        }
        return cell;
    }
    public double imultiplycell(double[] input, int col) {
        double cell = 0.0;
        for (int i = 0; i < transMat.length; i++) {
            cell += input[i] / transMat[i][col];
            System.out.println(transMat[i][col]);
        }
        return cell;
    }
}