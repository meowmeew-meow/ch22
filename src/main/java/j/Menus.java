package j;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static j.SwingConsole.run;
//1084 19
public class Menus extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };
    private JTextField t = new JTextField("No flavor", 30);
    private JMenuBar mbl = new JMenuBar();
    private JMenu
            f = new JMenu("File"),
            m = new JMenu("Flavors"),
            s = new JMenu("Safety");
    // Альтернативное решение:
    private JRadioButtonMenuItem[] safety = {
            new JRadioButtonMenuItem("Guard"),
            new JRadioButtonMenuItem("Hide")
    };
    private ButtonGroup group = new ButtonGroup();
    private JMenuItem[] file = {new JMenuItem("Open")};
    private JMenuBar mb2 = new JMenuBar();
    private JMenu fooBar = new JMenu("fooBar");
    private JMenuItem[] other = {
// Добавить мнемонику очень просто, однако
// в конструкторе это можно сделать только для 3MenuItem:
            new JMenuItem("Foo", KeyEvent.VK_F),
            new JMenuItem("Bar", KeyEvent.VK_A),
// Без мнемоник:
            new JMenuItem("Baz"),
    };
    private JButton b = new JButton("Swap Menus");

    class BL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuBar m = getJMenuBar();
            setJMenuBar(m == mbl ? mb2 : mbl);
            validate(); // Обновляем окно
        }
    }

    class ML implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuItem target = (JMenuItem) e.getSource();
            String actionCommand = target.getActionCommand();
            if (actionCommand.equals("Open")) {
                String s = t.getText();
                boolean chosen = false;
                for (String flavor : flavors)
                    if (s.equals(flavor))
                        chosen = true;
                if (!chosen)
                    t.setText("Choose а flavor first!");
                else
                    t.setText("Opening " + s + ". Mmm, mm!");
            }
        }
    }

    class FL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuItem target = (JMenuItem) e.getSource();
            t.setText(target.getText());
        }
    }

    class FooL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            t.setText("Foo selected");
        }
    }

    class BarL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            t.setText("Bar selected");
        }
    }

    class BazL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            t.setText("Baz selected");
        }
    }

    class CMIL implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            JRadioButtonMenuItem target =
                    (JRadioButtonMenuItem) e.getSource();
            String actionCommand = target.getActionCommand();
            if (actionCommand.equals("Guard"))

                t.setText("Guard the Ice Cream! " +
                        "Guarding is " + target.getText());
            else if (actionCommand.equals("Hide"))
                t.setText("Hide the Ice Cream! " +
                        "Is it hidden? " + target.getText());
        }
    }

    public Menus() {
        ML ml = new ML();
        CMIL cmil = new CMIL();
        safety[0].setActionCommand("Guard");
        safety[0].setMnemonic(KeyEvent.VK_G);
        safety[0].addItemListener(cmil);
        safety[1].setActionCommand("Hide");
        safety[1].setMnemonic(KeyEvent.VK_H);
        safety[1].addItemListener(cmil);
        other[0].addActionListener(new FooL());
        other[1].addActionListener(new BarL());
        other[2].addActionListener(new BazL());
        FL fl = new FL();
        int n = 0;
        for (String flavor : flavors) {
            JMenuItem mi = new JMenuItem(flavor);
            mi.addActionListener(fl);
            m.add(mi);
// Добавление разделителей с интервалами:
            if ((n++ + 1) % 3 == 0)
                m.addSeparator();
        };
        for (JRadioButtonMenuItem sfty : safety) {
            s.add(sfty);
            group.add(sfty);
        }
        group.setSelected(new JToggleButton.ToggleButtonModel(), true);
        s.setMnemonic(KeyEvent.VK_A);
        f.add(s);
        f.setMnemonic(KeyEvent.VK_F);
        for (int i = 0; i < file.length; i++) {
            file[i].addActionListener(fl);
            f.add(file[i]);
        }
        mbl.add(f);
        mbl.add(m);
        setJMenuBar(mbl);
        t.setEditable(false);
        add(t, BorderLayout.CENTER);
// Настройка системы для переключения меню:
        b.addActionListener(new BL());
        b.setMnemonic(KeyEvent.VK_S) ;
        add(b, BorderLayout.NORTH);
        for (JMenuItem oth : other)
            fooBar.add(oth);
        fooBar.setMnemonic(KeyEvent.VK_B);
        mb2.add(fooBar);
    }

    public static void main(String[] args) {
        run(new Menus(), 300, 200);
    }
}
