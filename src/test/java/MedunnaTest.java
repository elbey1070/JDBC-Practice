import org.junit.Assert;
import org.junit.Test;
import utils.JdbcMedunnaDBUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MedunnaTest {
    /*
    Given
      Kullanıcı veritabanına bağlanır
      (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6)
    When
      Kullanıcı, oluşturulan odayı getirmek için room_number ile sorgu gönderir
    Then
      Kullanıcı, oda bilgilerinin doğru kaydedildiğini doğrular
    And
      Kullanıcı, bağlantıyı kapatır
   */
    @Test
    public void medunnaTest() throws SQLException {
        // Expected Datalar
        int roomNumberEX = 72245540;
        String roomTypeEX = "SUITE";
        boolean statusEX = true;
        double priceEX = 5000.00;
        String descriptionEX = "B189 - Krallara layık oda";
        String sql = "select * from room where room_number = 72245540";
        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery(sql);
        resultSet.next();
        // Actual Datalar
        int roomNumberAD = resultSet.getInt("room_number");
        String roomTypeAD = resultSet.getString("room_type");
        boolean statusAD = resultSet.getBoolean("status");
        double priceAD = resultSet.getDouble("price");
        String descriptionAD = resultSet.getString("description");
        Assert.assertEquals(roomNumberEX, roomNumberAD);
        Assert.assertEquals(roomTypeEX, roomTypeAD);
        Assert.assertEquals(statusEX, statusAD);
        Assert.assertEquals(priceEX, priceAD, 0.01);
        Assert.assertEquals(descriptionEX, descriptionAD);
    }
    @Test
    public void medunnaTest2() throws SQLException {
        String sql = "select * from room where room_number = 72245540";
        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery(sql);
        resultSet.next();
        Assert.assertEquals(72245540, resultSet.getInt("room_number"));
        Assert.assertEquals("SUITE", resultSet.getString("room_type"));
        Assert.assertTrue(resultSet.getBoolean("status"));
        Assert.assertEquals(5000.00, resultSet.getDouble("price"), 0.01);
        Assert.assertEquals("B189 - Krallara layık oda", resultSet.getString("description"));
    }
}
