package Controllers;

import Models.Model;
import Views.LoginView;
import Views.MenuView;
import Views.RegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller {
    
    LoginView lv;
    RegisterView rv;
    MenuView mv;
    Model modell;

    public String dataterpilih;
    public Controller(LoginView lv, RegisterView rv, MenuView mv, Model modell) {
        this.lv = lv;
        this.rv = rv;
        this.mv = mv;
        this.modell = modell;
        
        if(modell.getBanyakData()!=0){
            String dataNilai[][] = modell.readData();
            mv.tabel.setModel((new JTable(dataNilai, mv.namaKolom)).getModel());
        }
        
        lv.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = lv.getUsername();
                String password = lv.getPassword();               
                try {
                    if(modell.cekLogin(username, password)){
                        lv.dispose();
                        MenuView mvv = new MenuView();
                        Controller ctt = new Controller(lv, rv, mvv, modell);
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Gagal Mendaftar!");
                }             
            }
        });
        
        lv.btnToRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lv.dispose();
                    RegisterView rvv = new RegisterView();
                    Controller ctt = new Controller(lv,rvv,mv,modell);
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Gagal Ke Register");
                } 
            }
        });
        
        rv.btnDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!rv.getUsername().equals("") & !rv.getPassword().equals("") ){
                    String username = rv.getUsername();
                    String password = rv.getPassword();    
                    try {                       
                        modell.cekRegister(username, password);
                        Controller ctt = new Controller(lv,rv,mv,modell);
                    } catch (Exception exception){
                        System.out.println("Error bOs");
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "Username & Password Wajib Diisi!");
                }                             
                
            }
        });
        
        rv.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rv.dispose();
                    LoginView lvv = new LoginView();
                    Controller ctt = new Controller(lvv,rv,mv,modell);
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Gagal Ke Login");
                } 
            }
        });
        
        mv.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nisn = mv.getNisn();
                String nama = mv.getNama();
                String mtk = mv.getMtk();
                String ipa = mv.getIPA();
                String bindo = mv.getIndo();
                String bing = mv.getEng();
                modell.insertData(nisn, nama, mtk, ipa, bindo, bing);
         
                String dataNilai[][] = modell.readData();
                mv.tabel.setModel((new JTable(dataNilai, mv.namaKolom)).getModel());
            }
        });
        
        mv.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mv.tNisn.setText(null);
                mv.tNama.setText(null);
                mv.tNilaiMtk.setText(null);  
                mv.tNilaiIPA.setText(null);
                mv.tNilaiIndo.setText(null);
                mv.tNilaiEng.setText(null);
                
                String dataNilai[][] = modell.readData();
                mv.tabel.setModel((new JTable(dataNilai, mv.namaKolom)).getModel());
            }
        });
        
        mv.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nisn = mv.getNisn();
                String nama = mv.getNama();
                String mtk = mv.getMtk();
                String ipa = mv.getIPA();
                String bindo = mv.getIndo();
                String bing = mv.getEng();
                modell.updateData(nisn, nama, mtk, ipa, bindo, bing);
                
                String dataNilai[][] = modell.readData();
                mv.tabel.setModel((new JTable(dataNilai, mv.namaKolom)).getModel());
            }
        });
        
        mv.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Aslab " + dataterpilih + "? ", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {      
                    String nisn = mv.getNisn();
                    modell.deleteData(nisn);  
                    
                    String dataNilai[][] = modell.readData();
                    mv.tabel.setModel((new JTable(dataNilai, mv.namaKolom)).getModel());
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }                     
                
            }
        });
        
        mv.tabel.addMouseListener(new MouseAdapter(){    
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = mv.tabel.getSelectedRow();

                String nisn = mv.tabel.getValueAt(baris, 0).toString();
                String nama = mv.tabel.getValueAt(baris, 1).toString();
                String mtk = mv.tabel.getValueAt(baris, 2).toString();
                String ipa = mv.tabel.getValueAt(baris, 3).toString();
                String bindo = mv.tabel.getValueAt(baris, 4).toString();
                String bing = mv.tabel.getValueAt(baris, 5).toString();
                //String rata_rata = mv.tabel.getValueAt(baris, 6).toString();                                         

                mv.dispose();
                MenuView ed = new MenuView();
                ed.tNisn.setText(nisn);
                ed.tNama.setText(nama);
                ed.tNilaiMtk.setText(mtk);
                ed.tNilaiIPA.setText(ipa);
                ed.tNilaiIndo.setText(bindo);
                ed.tNilaiEng.setText(bing);
                //ed.tNisn.setText(rata_rata);               

                Model am = new Model();
                Controller ct = new Controller(lv, rv, ed, am);
            }          
        });
        
        mv.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = mv.getCari();

                if (Nama.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    String datanama[][] = modell.cariData(Nama);
                    mv.tabel.setModel((new JTable(datanama, mv.namaKolom)).getModel());
                }

            }
        });
        
        mv.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataNilai[][] = modell.readData();
                mv.tabel.setModel((new JTable(dataNilai, mv.namaKolom)).getModel());
            }
        });
    }
    
    
}
