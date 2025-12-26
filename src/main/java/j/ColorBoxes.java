package j;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static j.SwingConsole.run;
//1112 34
class CBox extends JPanel implements Runnable {
    private int pause;
    private static Random rand = new Random();
    private Color color = new Color(0);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        Dimension s = getSize();
        int[] x = new int[10];
        int[] y = new int[10];
        int degrees = 0;
        for (int i=0;i<10;i++) {
            if (i%2==0) {
                x[i] = (int) (s.width / 2 + (Math.sqrt(Math.pow(s.height / 2, 2) +
                        Math.pow(s.width / 2, 2)) / 2) * Math.cos(Math.toRadians(degrees)));
                y[i] = (int) (s.height / 2 + (Math.sqrt(Math.pow(s.height / 2, 2) +
                        Math.pow(s.width / 2, 2)) / 2) * Math.sin(Math.toRadians(degrees)));
            }else {
                x[i] = (int) (s.width / 2 + (Math.sqrt(Math.pow(s.height / 4, 2) +
                        Math.pow(s.width / 4, 2)) / 2) * Math.cos(Math.toRadians(degrees)));
                y[i] = (int) (s.height / 2 + (Math.sqrt(Math.pow(s.height / 4, 2) +
                        Math.pow(s.width / 4, 2)) / 2) * Math.sin(Math.toRadians(degrees)));
            }
            degrees+=36;
        }
        g.drawPolygon(x, y, 10);
    }

    public CBox(int pause) {
        this.pause = pause;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
            while (!Thread.interrupted()) {
                color = new Color(rand.nextInt(0xFFFFFF));
                repaint(); // Асинхронный запрос paint()
                TimeUnit.MILLISECONDS.sleep(pause);
            }
        } catch (InterruptedException e) {
// Допустимый способ выхода
        }
    }
}

public class ColorBoxes extends JFrame {
    private int grid = 12;
    private int pause = 50;
    private static ExecutorService exec =
            Executors.newCachedThreadPool();

    public ColorBoxes() {
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++) {
            CBox cb = new CBox(pause);
            add(cb);
            exec.execute(cb);
        }
    }

    public static void main(String[] args) {
        ColorBoxes boxes = new ColorBoxes();
        if (args.length > 0)
            boxes.grid = new Integer(args[0]);
        if (args.length > 1)
            boxes.pause = new Integer(args[1]);
        run(boxes, 500, 400);
    }
}