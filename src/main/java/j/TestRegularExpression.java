package j;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.util.regex.*;
import static j.SwingConsole.run;
//1050 6
class TextArea extends JFrame {
    private JTextArea
            input = new JTextArea(20, 40),
            output = new JTextArea(20,40);
    private JTextField regularExp = new JTextField(40);
    public TextArea(){
        input.append(System.in.toString());
        regularExp.setText(System.in.toString());
        regularExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.append("Input: \"" + input.getText() + "\""+"\n");
                for (String arg : input.getText().split("")) {
                    output.append("Regular expression: \"" + regularExp.getText() + "\""+"\n");
                    Pattern p = Pattern.compile(arg);
                    Matcher m = p.matcher(input.getText());
                    while (m.find()) {
                        output.append("Match \"" + m.group() + "\" at positions " +
                                m.start() + "-" + (m.end() - 1));
                    }
                }
            }
        });
        setLayout(new FlowLayout());
        add(new JScrollPane(input));
        add(regularExp);
        add(new JScrollPane(output));
    }
}

public class TestRegularExpression {
    public static void main(String[] args) {
        run(new TextArea(), 474, 425);
    }
}