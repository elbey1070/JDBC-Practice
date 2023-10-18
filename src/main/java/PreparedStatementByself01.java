import java.sql.*;

public class PreparedStatementByself01 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");
        Statement st = con.createStatement();

        String query = "UPDATE bolumler SET taban_puani=? WHERE bolum=?";

        PreparedStatement prst11 = con.prepareStatement(query);
        prst11.setInt(1,475);
        prst11.setString(2,"Math");
        int sayiEtkilen=prst11.executeUpdate();








    }
}
