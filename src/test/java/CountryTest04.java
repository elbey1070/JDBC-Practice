import org.junit.Assert;
import org.junit.Test;
import utils.JdbcLocalDBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.JdbcLocalDBUtils.closeConnection;
import static utils.JdbcLocalDBUtils.executeQuery;

public class CountryTest04 {

     /*
    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' table'dan region id'leri almak üzere query gönderir

    Then
      Kullanıcı, 1'den büyük region id'lerin sayısının 17 olduğunu doğrular

    And
      Kullanıcı, bağlantıyı kapatır
    */

    @Test
    public void countryTest01() throws SQLException {
        String sql = "SELECT COUNT(*) FROM countries WHERE region_id>1";

        ResultSet resultSet = executeQuery(sql);
        resultSet.next();
        int toplamRegion = resultSet.getInt("count"); //= 17

        System.out.println(toplamRegion);

        Assert.assertEquals(17, toplamRegion);
        closeConnection();

    }

    @Test
    public void countryTest02() throws SQLException {
        String sql = "SELECT region_id FROM countries WHERE region_id>1";

        ResultSet resultSet = executeQuery(sql);
        int toplamRegion =0;
        while (resultSet.next()){
            toplamRegion++;
        }
        Assert.assertEquals(17,toplamRegion);

        closeConnection();
    }
}
