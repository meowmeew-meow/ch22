package j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import static j.SwingConsole.run;
//1060 9
public class ShowMethods extends JFrame {
    private JTextField name = new JTextField(25);
    private JTextArea results = new JTextArea(40, 65);
    private static Pattern qualifier =
            Pattern.compile("\\w+\\.");

    class NameL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nm = name.getText().trim();
            if (nm.length() == 0) {
                results.setText("No match");
                return;
            }
            Class<?> kind;
            try {
                kind = Class.forName(nm);
            } catch (ClassNotFoundException ex) {
                results.setText("No match");
                return;
            }
            Method[] methods = kind.getMethods();
            Constructor[] ctors = kind.getConstructors();
            results.setText("");
            for (Method m : methods) {
                results.append(qualifier.matcher(m.toString()).replaceAll(""));
                results.append("\n");
            }
            for (Constructor ctor : ctors) {
                results.append(qualifier.matcher(ctor.toString()).replaceAll(""));
                results.append("\n");
            }
        }
    }
    public ShowMethods() {
        NameL nameListener = new NameL();
        name.addActionListener(nameListener);
        JPanel top = new JPanel();
        top.add(new JLabel("Swing class name (press Enter):"));
        top.add(name);
        add(BorderLayout.NORTH, top);
        add(new JScrollPane(results));
// Исходные данные и проверка:
        name.setText("");
        nameListener.actionPerformed(
                new ActionEvent("", 0 ,""));
    }
    public static void main(String[] args){
        run(new ShowMethods(), 400, 400);
    }
}

