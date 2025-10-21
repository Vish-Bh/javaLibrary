package packages;
import javax.swing.*;

public class Window {
    public static void main(String[] args) {
        new Window();
    }
    public Window() {
        JFrame frame = new JFrame("My App");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
