package packages;
import javax.swing.*;

public class Gui {
    public static void main (String[] args) {
        Gui gui = new Gui();
        gui.Home(args);
    }


    public void Home(String[] args) {
        JFrame frame = new JFrame("JAVA LIBRARY GUI");
        JLabel label = new JLabel("Welcome to the Java Library GUI");
        frame.getContentPane().add(label);
        JButton button = new JButton("Click Me!");

        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button Clicked!"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().add(button);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}