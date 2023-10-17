import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");

        Statement st =con.createStatement();


        ResultSet rs3=st.executeQuery("SELECT * FROM it_persons WHERE salary=(SELECT MIN(salary) FROM it_persons)");

        while (rs3.next()){
            System.out.println(rs3.getInt("id")+"--"+rs3.getString("name")+"--"+
                    rs3.getDouble("salary")+"--"+rs3.getString("prog_lang"));
        }

        st.close();
        con.close();




    }
}
