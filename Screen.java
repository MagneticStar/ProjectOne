import javax.swing.JFrame;

public class Screen extends JFrame {
    private int height = 500;
    private int width = 500;

    public Screen() {
        this.setSize(width, height);
        this.setDefaultCloseOperation(Screen.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setUndecorated(false);
    }
}


