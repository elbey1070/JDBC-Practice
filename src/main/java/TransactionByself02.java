import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionByself02 {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");

        String sql = "Update hesaplar SET bakiye=bakiye+? Where hesap_no=?";
        PreparedStatement prst88 = con.prepareStatement(sql);

        prst88.setInt(1,-1000);
        prst88.setInt(2,1234);

        prst88.executeUpdate();
        // Failure
        if (true){
            throw new Exception();
        }

        prst88.setInt(1,+1000);
        prst88.setInt(2,5678);

        prst88.executeUpdate();










    }

}
