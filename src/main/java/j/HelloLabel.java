package j;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HelloLabel {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("A Label");
                frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        label.setText("Hey! This is Different!");
        TimeUnit.SECONDS.sleep(1);
        label.setText("mEOW");
        TimeUnit.SECONDS.sleep(1);
        label.setText("MEOW MEOW");
        TimeUnit.SECONDS.sleep(1);
        label.setText("meow meow meow");
    }
}
