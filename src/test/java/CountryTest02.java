import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest02 {

    @Test
    public void countryTest() throws SQLException {

        // Kullanıcı veritabanına bağlanır
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");
        // Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir
        Statement st = con.createStatement();

       // Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısının 8 olduğunu doğrular

        String sql = "select country_name from countries WHERE region_id=1";
        ResultSet resultSet = st.executeQuery(sql);

        // Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısının 8 olduğunu doğrular

        int actualData =0;

        while (resultSet.next()){
            actualData++;
        }

        int expectedData = 8;
        Assert.assertEquals(expectedData,actualData);

        // Kullanici baglantiyi kapatir
        con.close();
        st.close();

    }
}
