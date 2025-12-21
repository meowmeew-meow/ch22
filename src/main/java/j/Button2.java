package j;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static j.SwingConsole.run;

//1048 5
public class Button2 extends JFrame {
    private JButton
            b1 = new JButton("Button1"),
            b2 = new JButton("Button2"),
            b3 = new JButton("Button3");
    private JTextField txt= new JTextField(10);
    private ActionListener al= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    };
    public Button2(){
        b1.addActionListener(al);
        b2.addActionListener(al);
        b3.addActionListener(al);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(txt);
    }
    public static void main(String[] args){
        run(new Button2(), 200, 150);
    }
}
