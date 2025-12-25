package j;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

import static j.SwingConsole.run;
//1088 23
class SquareDraw extends JPanel{
    private int size =10, rotate =0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        int x1 = (int) (cx+size * Math.cos(Math.toRadians(45+rotate)));
        int x2 = (int) (cx+size * Math.cos(Math.toRadians(135+rotate)));
        int y1 = (int) (cy+size * Math.sin(Math.toRadians(225+rotate)));
        int y2 = (int) (cy+size * Math.sin(Math.toRadians(315+rotate)));
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(y1, x1, y2, x2);
        int x12 = (int) (cx+size * Math.sin(Math.toRadians(45+rotate)));
        int x22 = (int) (cx+size * Math.sin(Math.toRadians(135+rotate)));
        int y12 = (int) (cy+size * Math.cos(Math.toRadians(225+rotate)));
        int y22 = (int) (cy+size * Math.cos(Math.toRadians(315+rotate)));
        g.drawLine(x12, y12, x22, y22);
        g.drawLine(y12, x12, y22, x22);
    }

    public void changeSize(int size){
        this.size = size;
        repaint();
    }

    public void rotate(int r){
        rotate = r;
        repaint();
    }
}

public class Square extends JFrame{
    private SquareDraw square = new SquareDraw();
    private JSlider size = new JSlider(),
    rotation = new JSlider(0, 360);
    public Square(){
        setLayout(new FlowLayout());
        add(square);
        square.setPreferredSize(new Dimension(300, 300));
        size.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                square.changeSize(((JSlider)e.getSource()).getValue());
            }
        });
        add(size);
        rotation.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                square.rotate(((JSlider)e.getSource()).getValue());
            }
        });
        add(rotation);
    }
    public static void main(String[] args){
        run(new Square(), 500, 400);
    }
}
