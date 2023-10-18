import org.junit.Test;
import java.sql.*;
public class CountryTest01 {
    /*
    Given = Ön hazırlık
      Kullanıcı veritabanına bağlanır
    When = Eyleme geçme
      Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir
    Then = Doğrulama (Assertion)
      Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular
    And = Önceki kullanılan anahtar kelimenin devamı niteliğindedir.
      Kullanıcı, bağlantıyı kapatır
    */
    @Test
    public void countryTest() throws SQLException {
        // Kullanıcı veritabanına bağlanır
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","techpro","password");
        // Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir
        Statement st = con.createStatement();
        String sql = "select country_name from countries";
        ResultSet resultSet = st.executeQuery(sql);

        // Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular

    }
}
