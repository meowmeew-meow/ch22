package j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static j.SwingConsole.run;

public class HTMLComponents extends JFrame {
    JMenuItem m = new JMenuItem("<html><b><font size=+2>" +
            "<center>Hello!<br><i>Press mе now!");
    JRadioButton r = new JRadioButton("<html><b><font size=+2>" +
            "<center>Hello!<br><i>Press mе now!");
    JCheckBox c = new JCheckBox("<html><b><font size=+2>" +
            "<center>Hello!<br><i>Press mе now!");
    HTMLComponents(){
        setLayout(new FlowLayout());
        add(m);
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new JLabel("<html>" +
                        "<i><font size=+4>Kapow!"));
                validate();
            }
        });
        add(r);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new JLabel("<html>" +
                        "<i><font size=+4>Kapow!"));
                validate();
            }
        });
        add(c);
    }
    public static void main(String[] args){
        run(new HTMLComponents(), 400, 400);
    }
}
