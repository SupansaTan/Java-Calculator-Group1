import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    static String num1 = "", num2 = "";
    static char operator;
    static String numberInput = "";

    static JButton[] buttons;
    static String[] TextButton;
    static JTextField displayNumber;
    static JPanel centerPanel, innerButtonPanel;
    static GridBagConstraints Upper, Center, Below;
    
    public static void main(String[] args) {
        showGUI();

    }

    // method for create and show GUI of calculator
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
            buttons[i].setActionCommand(TextButton[i]);  // define action command for the button
            buttons[i].addActionListener(new ActionListener() {  // set action listeners for buttons

                // set action when click pressed button
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

    //method for action when pressed button 
    static void selectionButtonPressed(String action) {
        if (action.equals("+")) {
            setOperator(action);
            displayNumber.setText("" + operator);
        }
        else if(action.equals("-")){
            setOperator(action);
            displayNumber.setText("" + operator);
        }
        else if(action.equals("*")){
            setOperator(action);
            displayNumber.setText("" + operator);
        }
        else if(action.equals("/")){
            setOperator(action);
            displayNumber.setText("" + operator);
        }
        else if("0123456789".contains(action))
        {
            numberInput = setNumber(action);
            displayNumber.setText(numberInput);
        }
        else if(action.equals("=")){
            numberInput = "";
            num1 = Calculate(num1, operator, num2).toString();
            num2 = ""; operator = 0;
            displayNumber.setText(num1);
        }
        else if(action.equals("<--")){
            displayNumber.setText(pressedBackspaceBtn());
        }
    }

    // method for set value of operator
    static char setOperator(String input_op){
        if (operator == 0){  
            // when operator is null
            operator = input_op.charAt(0);
        } 
        else {
            if (num2 == ""){
                // if num2 is yet to define value & for case when pressed operator again
                operator = input_op.charAt(0);
            } 
            else {
                // if value of both num1 and num2 is defined, will calculate its and define result to num1
                num1 = Calculate(num1, operator, num2).toString();
                num2 = "";
                operator = input_op.charAt(0);
            }
        }
        return operator;
    }

    // method for set value of num1, num2 when pressed number button
    static String setNumber(String input){
        if (num1 == ""){
            // when num1 is undefine value
            num1 = input;
            return num1;
        } 
        else if (operator == 0){
            // when num1 is incomplete define value
            num1 += input;
            return num1;  
        } 
        else {
            // when want to define value of num2 
            num2 += input;
            return num2;
        }  
    }

    // method for when pressed backspace button
    static String pressedBackspaceBtn(){
        if (operator == 0){
            // when want to remove the last of 'num1'
            num1 = num1.substring(0,num1.length()-1);
            return num1;
        }
        else if (num2 == ""){
            // when want to change operator 
            operator = 0;
            return num1;
        } 
        else {
            // when want to remove the last of 'num2'
            num2 = num2.substring(0,num2.length()-1);
            return num2;
        }
    }

    // method for calculate 
    static Float Calculate(String num1, char op, String num2) {
        float num1_float = Float.parseFloat(num1);
        float num2_float = Float.parseFloat(num2);
        Float result = 1.0f;

        if (op == '+') {
            result = num1_float + num2_float;
        }
        else if (op == '-') {
            result = num1_float - num2_float;
        }
        else if (op == '*') {
            result = num1_float * num2_float;
        }
        else if (op == '/') {
            result = num1_float / num2_float;
        }
        return result;
    }

    
}
