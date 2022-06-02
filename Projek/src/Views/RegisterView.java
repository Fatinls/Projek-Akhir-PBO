package Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegisterView extends JFrame{
    JLabel lJudul = new JLabel("REGISTER");
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");
    JLabel lKembali = new JLabel("Menuju Login");
    
    public JTextField fUsername = new JTextField();
    public JTextField fPassword = new JTextField();
    
    public JButton btnDaftar = new JButton("Daftar");
    public JButton btnKembali = new JButton("Kembali");

    public RegisterView() {
        setTitle("Register");
        setSize(400, 400);
        setLayout(null);
        
        add(lJudul);
        add(lUsername);
        add(lPassword);
        add(lKembali);
        add(fUsername);
        add(fPassword);
        add(btnDaftar);
        add(btnKembali);
        
        lJudul.setBounds(150, 20, 250, 30);
        lUsername.setBounds(40, 60, 250, 30);
        fUsername.setBounds(40, 90, 250, 30);
        lPassword.setBounds(40, 120, 250, 30);
        fPassword.setBounds(40, 150, 250, 30);
        btnDaftar.setBounds(100, 240, 100, 30);
        lKembali.setBounds(20, 320, 250, 30);
        btnKembali.setBounds(100, 325, 100, 20);
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getUsername(){
        return fUsername.getText();
    }

    public String getPassword(){
        return fPassword.getText();
    }
    
    
}
