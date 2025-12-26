package j;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import static j.SwingConsole.run;
//1088 22
class Slider extends JPanel{
    public int r = 0, g= 0, b=0;
    public void setColor(Color color){
        this.setBackground(color);
    }
}

public class RGBSlider extends JFrame{
    private JLabel r = new JLabel("Red"),
    g = new JLabel("Green"),
    b = new JLabel("Blue");
    private Slider s= new Slider();
    private JSlider slider1 = new JSlider(0,255),
    slider2 = new JSlider(0,255),
    slider3 = new JSlider(0,255);
    private JTextField redI = new JTextField(String.valueOf(s.r), 10),
    greenI = new JTextField(String.valueOf(s.g), 10),
    blueI = new JTextField(String.valueOf(s.b), 10);
    public RGBSlider(){
        setLayout(new FlowLayout());
        add(r);
        add(slider1);
        add(g);
        add(slider2);
        add(b);
        add(slider3);
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                s.setColor(new Color(s.r=((JSlider)e.getSource()).getValue(), s.g, s.b));
                redI.setText(String.valueOf(s.r));
                redI.getText();
            }
        });
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                s.setColor( new Color(s.r,s.g=((JSlider)e.getSource()).getValue(), s.b));
                greenI.setText(String.valueOf(s.g));
                greenI.getText();
            }
        });
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                s.setColor(new Color(s.r, s.g, s.b= ((JSlider)e.getSource()).getValue()));
                blueI.setText(String.valueOf(s.b));
                blueI.getText();
            }
        });
        add(redI);
        redI.setEnabled(false);
        redI.getText();
        add(greenI);
        greenI.setEnabled(false);
        greenI.getText();
        add(blueI);
        blueI.getText();
        blueI.setEnabled(false);
        add(s);
        s.setPreferredSize(new Dimension(300, 300));
    }
    public static void main(String[] args){
        run(new RGBSlider(), 800, 400);
    }
}
