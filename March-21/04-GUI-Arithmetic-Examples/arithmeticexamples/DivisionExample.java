package arithmeticexamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DivisionExample extends JFrame {
    JTextField textField, textField1, result;
    JLabel label;

    DivisionExample() {
        this.setLayout(new FlowLayout());
        textField = new JTextField(5);
        textField1 = new JTextField(5);
        textField.addActionListener(new Enter());
        textField1.addActionListener(new Enter());
        label = new JLabel("Type a number in each box.");
        result = new JTextField(18);

        this.add(label);
        this.add(textField);
        this.add(textField1);
        this.add(result);

        textField.setText("0");
        textField1.setText("0");

        this.setTitle("Division (/)");

        this.setSize(230, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class Enter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String res = "";

            try {
                int i = Integer.parseInt(textField.getText());
                int j = Integer.parseInt(textField1.getText());
                res = i / j + "";
            } catch (NumberFormatException ex) {
                res = "Integers in each box, please!";
            } catch (ArithmeticException ex) {
                res = "You cannot divide by zero!";
            } finally {
                result.setText(res);
            }
        }
    }

    public static void main(String[] args) {
        new DivisionExample();
    }
}
