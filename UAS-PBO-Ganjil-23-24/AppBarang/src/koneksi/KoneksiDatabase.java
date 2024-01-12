package koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
public class KoneksiDatabase {
    Connection Nadya;
    public static Connection BukaKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Nadya = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mahasiswa","root","");
            return Nadya;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
