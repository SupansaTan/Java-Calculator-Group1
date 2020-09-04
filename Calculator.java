import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    static float value1, value2, result;
    static char operator;
    static JButton[] buttons;
    static JTextField displayNumber;
    static JPanel centerPanel, innerButtonPanel;
    static GridBagConstraints Upper, Center, Below;
    static String[] TextButton;
    
    static String numberInput = "";
    public static void main(String[] args) {
        showGUI();

    }

    static void showGUI() {
        // set Colors
        Color darkBlue = new Color(15,76,129);
        Color white = new Color(255,255,255);
        Color bluePastel = new Color(197,229,239);
        Color lightGrey = new Color(244,239,239);

        // set Frame 
        JFrame frame = new JFrame();  // JFrame is class for create window
        frame.setSize(500,500); 
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // define event of object CreateFrame when click close on titlebar 
        frame.setTitle("Calculator");  //set title bar
        frame.getContentPane().setBackground(darkBlue);
        
        // grid Upper in frame for container part of display number
        Upper = new GridBagConstraints();
        Upper.fill = GridBagConstraints.VERTICAL;
        Upper.gridx = 15;
        Upper.gridy = 15;
        Upper.ipady = 90;
        Upper.ipadx = 455;
    
        displayNumber = new JTextField(); // rect for display number
        displayNumber.setBorder(null);
        frame.add(displayNumber, Upper);
        
        // grid Center for container empty panel between grid Upper and Below
        Center = new GridBagConstraints();
        Center.fill = GridBagConstraints.VERTICAL;
        Center.gridx = 15;
        Center.ipadx = 470;
        Center.ipady = 15;

        centerPanel = new JPanel(); 
        centerPanel.setBackground(darkBlue);
        frame.add(centerPanel,Center);
        
        // grid Below for container part of buttons
        Below = new GridBagConstraints();
        Below.fill = GridBagConstraints.VERTICAL;
        Below.gridx = 15;
        Below.ipadx = 350;
        Below.ipady = 200;
 
        // set panel of buttons
        innerButtonPanel = new JPanel();
        innerButtonPanel.setLayout(new GridLayout(5,4,10,6));
        innerButtonPanel.setBackground(darkBlue);
        frame.add(innerButtonPanel,Below);
        
        String[] TextButton = {"C","/","x^2","<--","9","8","7","*","6","5","4","-","3","2","1","+","+/-","0",".","="}; // text on buttons
        buttons = new JButton[20]; // create buttons 
        
        for (int i=0; i < TextButton.length; i++){
            buttons[i] = new JButton(TextButton[i]);  
            if (TextButton[i] == "-" || TextButton[i] == "*" || TextButton[i] == "/" || TextButton[i] == "C" || TextButton[i] == "x^2" || TextButton[i] == "<--" || TextButton[i] == "+"){
                buttons[i].setBackground(lightGrey);
            }
            else if (TextButton[i] == "="){
                buttons[i].setBackground(bluePastel);
            }
            else{
                buttons[i].setBackground(white);
            }
            buttons[i].setBorder(null); // No border
            buttons[i].setActionCommand(TextButton[i]); 
            buttons[i].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    String action = e.getActionCommand();
                    selectionButtonPressed(action);
                } 
            });
            innerButtonPanel.add(buttons[i]);     
        }
    
        // for display on screen
        frame.setVisible(true);

    }

    static void selectionButtonPressed(String action) {
        String oldExp = displayNumber.getText();

        if (action.equals("+")) {
            System.out.println("ytes + ");
            operator = '+';
            displayNumber.setText("+");
        }
        else if(action.equals("-")){
            operator = '-';
            displayNumber.setText("-");
        }
        else if(action.equals("*")){
            operator = '*';
            displayNumber.setText("*");
        }
        else if(action.equals("/")){
            operator = '/';
            displayNumber.setText("/");
        }
        else if("0123456789".contains(action))
        {
            numberInput += action;
            displayNumber.setText(numberInput);
        }
    }

    static Float Calculate() {

        if (operator == '+') {
            result = value1 + value2;
        }
        else if (operator == '-') {
            result = value1 - value2;
        }
        else if (operator == '*') {
            result = value1 * value2;
        }
        else if (operator == '/') {
            result = value1 / value2;
        }
        return result;
    }

    
}
