package Models;

import Controllers.Controller;
import Views.MenuView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Model {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_nilai_un";
    static final String USER = "root";
    static final String PASS = ""; 
    public Connection koneksi;
    public Statement statement;

    public Model() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
        
        
    }
    
    public String[][] readData(){ // read Data
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][7]; //baris, kolom nya ada 5

            String query = "Select * from nilai";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nisn"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("mtk");
                data[jmlData][3] = resultSet.getString("ipa");              
                data[jmlData][4] = resultSet.getString("bindo");
                data[jmlData][5] = resultSet.getString("bing");
                data[jmlData][6] = resultSet.getString("rata_rata");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM nilai";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void insertData(String nisn, String nama, String mtk, String ipa, String bindo, String bing){
        int jmlData = 0;
        int fnisn = Integer.parseInt(nisn);
        double fmtk = Float.parseFloat(mtk);
        double fipa = Float.parseFloat(ipa);
        double fbindo = Float.parseFloat(bindo);
        double fbing = Float.parseFloat(bing);
        double nilaiAkhir = (fmtk + fipa + fbindo + fbing)/4;
        try {
            String query = "Select * from nilai WHERE nisn = '"+ fnisn + "'"; // cek apakah data sudah ada
            System.out.println(fnisn);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData == 0) { // jika data dengan tsb belum ada
                query = "INSERT INTO nilai VALUES('"+fnisn+"','"+nama+"','"+fmtk+"','"+fipa+"','"+fbindo+"','"+fbing+"','"+nilaiAkhir+"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String nisn, String nama, String mtk, String ipa, String bindo, String bing){ // Update Data
        int jmlData = 0;
        int fnisn = Integer.parseInt(nisn);
        double fmtk = Float.parseFloat(mtk);
        double fipa = Float.parseFloat(ipa);
        double fbindo = Float.parseFloat(bindo);
        double fbing = Float.parseFloat(bing);
        double nilaiAkhir = (fmtk + fipa + fbindo + fbing)/4;
        
        try {
            String query = "Select * from nilai WHERE nisn = '"+ fnisn + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData == 1) { 
                query = "UPDATE nilai SET nisn ='" + fnisn + "', nama ='" + nama + "', mtk='" + fmtk +"', ipa='" + fipa  + "', bindo = '" + fbindo+ "', bing = '" + fbing+ "', rata_rata = '" + nilaiAkhir+ "' WHERE nisn = '" + fnisn +"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void deleteData(String nisn) { // Delete Data
        try{
            String query = "DELETE FROM nilai WHERE nisn = '"+ nisn +"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
    public String[][] cariData(String nama){
        try{
            int jmlData = 0;

            String query = "Select * from nilai WHERE nama LIKE '%" + nama + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++; // hitung jumlah data
            }

            String data[][] = new String[jmlData][7]; //baris, kolom nya ada 7


            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                query = "Select * from nilai WHERE Nama LIKE '%" + nama + "%'";
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){ // menampilkan data yang memenuhi satu persatu
                    data[jmlData][0] = resultSet.getString("nisn"); //harus sesuai nama kolom di mysql
                    data[jmlData][1] = resultSet.getString("nama");
                    data[jmlData][2] = resultSet.getString("mtk");
                    data[jmlData][3] = resultSet.getString("ipa");
                    data[jmlData][4] = resultSet.getString("bindo");
                    data[jmlData][5] = resultSet.getString("bing");
                    data[jmlData][6] = resultSet.getString("rata_rata");
                    
                    jmlData++;
                }

            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public boolean cekLogin(String username, String password){ // read Data
        try{
            int jmlData = 0;
            String query = "Select * from users WHERE username = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(query);
               
            while (resultSet.next()){
                jmlData++; // hitung jumlah data
            }
            
            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Username Belum Terdaftar");
                return false;
            }else{
                jmlData = 0;
                String query2 = "Select * from users WHERE username = '" + username + "'" + " and password = '" + password + "'";
                resultSet = statement.executeQuery(query2);
                
                while(resultSet.next()){
                    jmlData++; // hitung jumlah data
                }
                
                if(jmlData == 1){
                    return true;
                }else{
                    return false;
                }
                
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Login!");
            return false;
        }
    }
    
    public void cekRegister(String username, String password){
        try {
                        
            String query1 = "SELECT * FROM users where username = '" + username + "'";
            ResultSet rs = statement.executeQuery(query1);
                       
            if(!rs.next())
            {
                String query = "insert into users values (NULL, '" + username +
                    "', '" + password + "')";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil mendaftarkan User");
            }                                             
            else
            {
                JOptionPane.showMessageDialog(null, "Username Sudah Terpakai");
            }

        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Insert Data Gagal!");
        }         
        
    }
}
