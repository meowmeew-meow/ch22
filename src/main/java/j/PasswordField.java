package j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.security.*;
import java.util.Base64;

import static j.SwingConsole.run;

public class PasswordField extends JFrame{
    private String password = "admin";
    private MessageDigest md =MessageDigest.getInstance("SHA-256");
    byte[] hash= md.digest(password.getBytes());
    String encodingHash = Base64.getEncoder().encodeToString(hash);
    String a;
    private JPasswordField p = new JPasswordField(20);
    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            byte[] inHash = md.digest(new String(p.getPassword()).getBytes());
            String encodingInHash = Base64.getEncoder().encodeToString(inHash);
            System.out.println(encodingHash + "\n" + encodingInHash);
            if (encodingInHash.equals(encodingHash)) {
                JOptionPane.showMessageDialog(null, "Success",
                        "Right password", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Try again",
                        "Incorrect password", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public PasswordField() throws NoSuchAlgorithmException {
        setLayout(new FlowLayout());
        add(p);
        p.addActionListener(al);
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        run(new PasswordField(), 400, 400);
    }
}
