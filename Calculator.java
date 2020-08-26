import javax.swing.*;

public class Calculator {

    public static void main(String[] args) {
        JFrame frame = new JFrame();  // JFrame is class for create form(window)
        frame.setSize(400,430); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define event of object CreateFrame when click close on titlebar 
        frame.setVisible(true);  // for display on screen 
        frame.setTitle("Calculator"); //set title bar
    }

}