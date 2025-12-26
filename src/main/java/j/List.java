package j;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import static j.SwingConsole.run;
//1076 16
public class List extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };
    private JList lst = new JList(flavors);
    private JTextArea t =
            new JTextArea(flavors.length, 20);
    private ListSelectionListener ll = new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) return;
            t.setText("");
            for (Object item : lst.getSelectedValues())
                t.append(item + "\n");
        }
    };
    private int count = 0;

    public List() {
        t.setEditable(false);
        setLayout(new FlowLayout());
// Создание рамки для компонентов:
        Border brd = BorderFactory.createMatteBorder(
                1, 1, 2, 2, Color.BLACK);
        lst.setBorder(brd);
        t.setBorder(brd);
        add(t);
        add(lst);
// Регистрация слушателей событий
        lst.addListSelectionListener(ll);
    }

    public static void main(String[] args) {
        run(new List(), 250, 375);
    }
}
