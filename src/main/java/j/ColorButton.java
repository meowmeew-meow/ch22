package j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static j.SwingConsole.run;
//1063 11
public class ColorButton extends JFrame {
    Random rand = new Random();
    ArrayList<Color> colors = new ArrayList<>();
    private CButton b = new CButton(Color.WHITE, "button");
    class CButton extends JButton{
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setBackground(colors.get(rand.nextInt(colors.size())));
            }
        };
        public CButton(Color color, String label){
            super(label);
            setBackground(color);
            addActionListener(al);
        }
    }
    public ColorButton(){
        colors.addAll(Arrays.asList(Color.BLACK, Color.BLUE,
                Color.MAGENTA, Color.GREEN, Color.ORANGE,
                Color.PINK, Color.RED, Color.YELLOW));
        setLayout(new FlowLayout());
        add(b);
    }
    public static void main(String[] args){
        run(new ColorButton(), 400, 400);
    }
}
