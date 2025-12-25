package j;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static j.SwingConsole.run;

public class MenuFile extends JFrame {
    private File f;
    List<String> text = new ArrayList<>();
    List<String> menuWords = new ArrayList<>();
    private JFileChooser file = new JFileChooser();
    private FileNameExtensionFilter filter =
            new FileNameExtensionFilter("Текстовый файл", "txt");
    private List<String> read() throws FileNotFoundException {
        Reader r = new FileReader(f);
        try {
            return r.readAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<String> words(){
        List<String> strings = new ArrayList<>();
        for(String s: text){
            strings.addAll(Arrays.asList(s.split(" ")));
        }
        return strings;
    }
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu();
    private JMenuItem menuItem = new JMenu();
    public MenuFile() {
        add(file);
        file.setFileFilter(filter);
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = file.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    f = file.getSelectedFile();
                }
            }
        });
        try {
            text=this.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        menuWords =this.words();
        add(menuBar);
    }
    public static void main(String[] args){
        run(new MenuFile(), 400, 400);
    }
}
