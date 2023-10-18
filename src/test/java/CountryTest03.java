import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryTest03 {

    @Test
    public void countryTestByself() throws SQLException {

// Kullanıcı veritabanına bağlanır
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "techpro", "password");
        // Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir
        Statement st = con.createStatement();

        // Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısının 8 olduğunu doğrular

        String sql = "select country_name from countries WHERE region_id=1";
        ResultSet resultSet = st.executeQuery(sql);






    }
}
