package j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static j.SwingConsole.run;
//1094 29
public class ColorChooser extends JFrame {
    private JButton b = new JButton("Choose color");
    private JPanel p = new JPanel();
    public ColorChooser(){
        setLayout(new FlowLayout());
        add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(ColorChooser.this,
                        "Color", p.getBackground());
                p.setBackground(c);
            }
        });
        add(p);
        p.setPreferredSize(new Dimension(200, 150));
    }
    public static void main(String[] args){
        run(new ColorChooser(), 400, 400);
    }
}
