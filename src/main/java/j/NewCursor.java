package j;

import javax.swing.*;
import java.awt.*;
import static j.SwingConsole.run;
//1050 8
public class NewCursor extends JFrame {
    private JButton b = new JButton("Button");
    private JTextArea ta = new JTextArea(20, 40);
    public NewCursor(){
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ta.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        setLayout(new FlowLayout());
        add(b);
        add(new JScrollPane(ta));
    }
    public static void main(String[] args){
        run(new NewCursor(), 400, 400);
    }
}
