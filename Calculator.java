import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static float value_1, value_2, result;
    public static int operation;

    public static void main(String[] args) {
        showGUI();

    }

    static void showGUI() {

        // set Frame
        JFrame frame = new JFrame();  // JFrame is class for create form(window)
        frame.setSize(400,430); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // define event of object CreateFrame when click close on titlebar 
        frame.setTitle("Calculator");  //set title bar
        frame.getContentPane().setBackground(new Color(15,76,129));
    
        // set lable of display number
        JPanel panel1 = new JPanel(); // create panel for container component
        panel1.setLayout(null);
        panel1.setBackground(new Color(15,76,129));
        frame.add(panel1);
    
        JTextField displayNumber = new JTextField(); // rect for display number
        displayNumber.setBounds(15,15,355,82);
        panel1.add(displayNumber);
    
        // for display on screen
        frame.setVisible(true);

    }

    static void Calculate() {

        if (operation == 1) {
            result = value_1 + value_2;
        }
        else if (operation == 2) {
            result = value_1 - value_2;
        }
        else if (operation == 3) {
            result = value_1 * value_2;
        }
        else if (operation == 4) {
            result = value_1 / value_2;
        }

    }

}
