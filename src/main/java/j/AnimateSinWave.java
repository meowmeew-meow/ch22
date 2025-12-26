package j;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static j.SwingConsole.run;

class SinDraw extends JPanel {
    private static final int SCALEFACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    public SinDraw() {
        setCycles(5);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = getWidth();
        double hstep = (double) maxWidth / (double) points;
        int maxHeight = getHeight();
        pts = new int[points];
        for (int i = 0; i < points; i++)
            pts[i] =
                    (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
        g.setColor(Color.RED);
        for (int i = 1; i < points; i++) {
            int xl = (int) ((i - 1) * hstep);
            int x2 = (int) (i * hstep);
            int yl = pts[i - 1];
            int y2 = pts[i];
            g.drawLine(xl, yl, x2, y2);
        }
    }

    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALEFACTOR * cycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALEFACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        repaint();
    }
}
public class AnimateSinWave extends JFrame{
    private SineDraw sines = new SineDraw();
    private JSlider adjustCycles = new JSlider(1, 30, 5);
    private int del=1;
    public AnimateSinWave() {
        add(sines);
        ActionListener a;
        Timer t = new Timer(del, e-> {
            for (int i=0; i<100;i++) {
                sines.setCycles(i);
            }
        });
        t.start();
        adjustCycles.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                del= ((JSlider)e.getSource()).getValue();
            }
        });
        add(BorderLayout.SOUTH, adjustCycles);
    }

    public static void main(String[] args) {
        run(new AnimateSinWave(), 700, 400);
    }
}
