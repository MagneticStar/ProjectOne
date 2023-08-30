public class Main {
    public static void main(String args[]) {
        createScreens();
        // while(true) {
        //     tick();
        // }
        
    }

    static void tick() {

    }

    static void createScreens() {
        Screen sc = new Screen();
        Panel p = new Panel();
        sc.add(p);
        sc.setVisible(true);
    }

}
