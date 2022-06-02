package Views;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MenuView extends JFrame{
    
    JLabel lJudul = new JLabel("FORM PENGISIAN NILAI");
    JLabel lNisn = new JLabel("NISN");
    JLabel lNama = new JLabel("Nama");
    JLabel lNilaiMtk = new JLabel("Nilai Matematika");
    JLabel lNilaiIPA = new JLabel("Nilai IPA");
    JLabel lNilaiIndo = new JLabel("Nilai B. Indonesia");
    JLabel lNilaiEng = new JLabel("Nilai B. Inggris");
    JLabel lCari = new JLabel("SEARCH NAMA");
    
    public JTextField tNisn = new JTextField();
    public JTextField tNama = new JTextField();
    public JTextField tNilaiMtk = new JTextField();
    public JTextField tNilaiIPA = new JTextField();
    public JTextField tNilaiIndo = new JTextField();
    public JTextField tNilaiEng = new JTextField();
    public JTextField tCari = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Reset");
    public JButton btnCari = new JButton("Cari");
    public JButton btnRefresh = new JButton("Refresh");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"NISN", "Nama", "MTK", "IPA", "B.Indonesia", "B.Inggris", "NEM"};

    public MenuView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Main Menu");       
        setSize(1000,450);
        setLayout(null);
        
        add(scrollPane);
        add(lJudul);
        add(lNisn);
        add(lNama);
        add(lNilaiMtk);
        add(lNilaiIPA);
        add(lNilaiIndo);
        add(lNilaiEng);
        add(lCari);
        add(tNisn);
        add(tNama);
        add(tNilaiMtk);
        add(tNilaiIPA);
        add(tNilaiIndo);
        add(tNilaiEng);
        add(tCari);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnReset);
        add(btnCari);
        add(btnRefresh);
       
        lJudul.setBounds(150, 10, 170, 30);
        lNisn.setBounds(20, 60, 100, 20);
        tNisn.setBounds(150, 60, 200, 20);
        lNama.setBounds(20, 100, 100, 20);
        tNama.setBounds(150, 100, 200, 20);
        lNilaiMtk.setBounds(20, 140, 100, 20);
        tNilaiMtk.setBounds(150, 140, 200, 20);
        lNilaiIPA.setBounds(20, 180, 100, 20);
        tNilaiIPA.setBounds(150, 180, 200, 20);
        lNilaiIndo.setBounds(20, 220, 100, 20);
        tNilaiIndo.setBounds(150, 220, 200, 20);
        lNilaiEng.setBounds(20, 260, 100, 20);
        tNilaiEng.setBounds(150, 260, 200, 20);
        
        btnTambah.setBounds(150, 300, 100, 30);
        btnTambah.setBackground(Color.blue);
        btnTambah.setForeground(Color.white);
        
        btnUpdate.setBounds(270, 300, 100, 30);
        btnUpdate.setBackground(Color.yellow);
        btnUpdate.setForeground(Color.black);
        
        btnDelete.setBounds(150, 340, 100, 30);
        btnDelete.setBackground(Color.red);
        btnDelete.setForeground(Color.white);
        
        btnReset.setBounds(270, 340, 100, 30);
        btnReset.setBackground(Color.GRAY);
        btnReset.setForeground(Color.white);
        
        scrollPane.setBounds(400, 0, 400, 410);
        
        lCari.setBounds(820, 20, 100, 20);
        tCari.setBounds(820, 50, 100, 20);
        
        btnCari.setBounds(820, 90, 100, 30);
        btnCari.setBackground(Color.green);
        btnCari.setForeground(Color.black);
        
        btnRefresh.setBounds(820, 130, 100, 30);  
        btnRefresh.setBackground(Color.cyan);
        btnRefresh.setForeground(Color.black);
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public String getNisn(){
        return tNisn.getText();
    }
    public String getNama(){
        return tNama.getText();
    }
    public String getMtk(){
        return tNilaiMtk.getText();
    }
    public String getIPA(){
        return tNilaiIPA.getText();
    }
    public String getIndo(){
        return tNilaiIndo.getText();
    }
    public String getEng(){
        return tNilaiEng.getText();
    }
    public String getCari(){
        return tCari.getText();
    }
    
}
