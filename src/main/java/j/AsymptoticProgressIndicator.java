package j;

import javax.swing.*;
import java.awt.*;
import static j.SwingConsole.run;
//1096 31
public class AsymptoticProgressIndicator extends JFrame {
    private JProgressBar pb = new JProgressBar();
    public AsymptoticProgressIndicator(){
        setLayout(new FlowLayout());
        add(pb);
        pb.setValue(0);
        pb.setStringPainted(true);
        Timer t = new Timer(100, e->{
            int v = pb.getValue();
           if (v<100){
               pb.setValue((int) ((v+1)*Math.exp(0.002*100)));
           }else ((Timer)e.getSource()).stop();
        });
        t.start();
    }
    public static void main(String[] args){
        run(new AsymptoticProgressIndicator(), 400, 400);
    }
}
