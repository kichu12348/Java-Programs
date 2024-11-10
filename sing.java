import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sing extends JFrame implements ActionListener {
    private JTextField display;
    private double result = 0;
    private String lastCommand = "=";
    private boolean start = true;

    public sing() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            buttonPanel.add(button);
            button.addActionListener(this);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setSize(300, 400);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            if (start) {
                display.setText(command);
                start = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else {
            if (!start) {
                calculate(Double.parseDouble(display.getText()));
                start = true;
            }
            lastCommand = command;
        }
    }

    public void calculate(double x) {
        if (lastCommand.equals("+")) result += x;
        else if (lastCommand.equals("-")) result -= x;
        else if (lastCommand.equals("*")) result *= x;
        else if (lastCommand.equals("/")) result /= x;
        else if (lastCommand.equals("=")) result = x;
        display.setText("" + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            sing calculator = new sing();
            calculator.setVisible(true);
        });
    }
}