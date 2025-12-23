package j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static j.SwingConsole.run;
//1079 18
public class MessageBoxes extends JFrame {
    private JButton[] b = {
            new JButton("Alert"), new JButton("Yes/No"),
            new JButton("Color"), new JButton("Input"),
            new JButton("3 Vals")
    };
    private JTextField txt = new JTextField(15);
    private ActionListener al = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,
                    "There's а bug on you!", "Hey!",
                    JOptionPane.ERROR_MESSAGE);
        }
    };
    private ActionListener al2 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog(null,
                    "or no", "choose yes",
                    JOptionPane.YES_NO_OPTION);
        }
    };
    private ActionListener al3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Red", "Green"};
            int sel = JOptionPane.showOptionDialog(
                    null, "Choose a Color!", "Warning",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null,
                    options, options[0]);
            if(sel != JOptionPane.CLOSED_OPTION)
            txt.setText("Color Selected: " + options[sel]);

        }
    };
    private ActionListener al4 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String val = JOptionPane.showInputDialog(
                    "How many fingers do you see?");
            txt.setText(val);
        }
    };
    private ActionListener al5 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] selections = {"First", "Second", "Third"};
            Object val = JOptionPane.showInputDialog(
                    null, "Choose one", "Input",
                    JOptionPane.INFORMATION_MESSAGE,
                    null, selections, selections[0]);
            if (val != null)
                txt.setText(val.toString());
        }
    };
    public MessageBoxes() {
        setLayout(new FlowLayout());
        for(int i = 0; i < b.length; i++) {
            add(b[i]);
        }
        add(txt);
        b[0].addActionListener(al);
        b[1].addActionListener(al2);
        b[2].addActionListener(al3);
        b[3].addActionListener(al4);
        b[4].addActionListener(al5);
    }
    public static void main(String[] args) {
        run(new MessageBoxes(), 200, 200);
    }
}
