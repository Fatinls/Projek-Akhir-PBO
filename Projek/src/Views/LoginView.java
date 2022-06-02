package Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginView extends JFrame{  
    JLabel lJudul = new JLabel("LOGIN");
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");
    JLabel lTanya = new JLabel("Belum memiliki akun? Klik Daftar Disini");
    
    public JTextField fUsername = new JTextField();
    public JTextField fPassword = new JTextField();
    
    public JButton btnLogin = new JButton("Login");
    public JButton btnToRegister = new JButton("Daftar");

    public LoginView() {
        setTitle("Login");
        setSize(400, 400);
        setLayout(null);
        
        add(lJudul);
        add(lUsername);
        add(lPassword);
        add(lTanya);
        add(fUsername);
        add(fPassword);
        add(btnLogin);
        add(btnToRegister);
        
        lJudul.setBounds(150, 20, 250, 30);
        lUsername.setBounds(40, 60, 250, 30);
        fUsername.setBounds(40, 90, 250, 30);
        lPassword.setBounds(40, 120, 250, 30);
        fPassword.setBounds(40, 150, 250, 30);
        btnLogin.setBounds(100, 240, 100, 30);
        lTanya.setBounds(20, 320, 250, 30);
        btnToRegister.setBounds(250, 325, 100, 20);
        
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
