
import org.junit.Assert;
import org.junit.Test;
import utils.JdbcLocalDBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

        import static utils.JdbcLocalDBUtils.executeQuery;

    public class Deneme {
    /*
    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir

    Then
      Kullanıcı, ülke isimlerini doğrular: "Belgium", "Switzerland", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom"

    And
      Kullanıcı, bağlantıyı kapatır
    */

        @Test
        public void countryTest() throws SQLException {
            // Kullanıcı veritabanına bağlanır


            String sql = "select country_name from countries where region_id = 1";

            ResultSet resultSet = JdbcLocalDBUtils.executeQuery(sql);

            // Kullanıcı, ülke isimlerini doğrular
            List<String> actualData = new ArrayList<>();
            while (resultSet.next()){
                String ulkeAdi = resultSet.getString("country_name");
                actualData.add(ulkeAdi);
            }

            List<String> expectedData = List.of("Belgium", "Switzerland", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom");
            List<String> mixedData = List.of("Switzerland", "Belgium", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom");
            List<String> someData = List.of("Belgium", "Switzerland", "Germany");

            Assert.assertEquals(expectedData, actualData);
            Assert.assertTrue(actualData.containsAll(mixedData));
            Assert.assertTrue(actualData.contains("Germany") && actualData.contains("Denmark"));
            Assert.assertTrue(actualData.containsAll(someData));



        }
    }



