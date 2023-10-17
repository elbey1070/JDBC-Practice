import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1-ADIM:driverı göster
        Class.forName("org.postgresql.Driver");//Java 7 ile birlikte gerek kalmadı.

        //2-ADIM:Database e bağlanma
        Connection connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");

        //3-ADIM:Statement oluşturma:SQL sorgularını oluşturma ve DB ye göndermek ve çalıştırmak için
        Statement st =connection.createStatement();

        // System.out.println("Connection is success");

        //4-ADIM: Query i yazıp çalıştırma

        //ÖRNEK 1:"workers" adında bir tablo oluşturup "worker_id,worker_name,salary" sütunlarını ekleyiniz.

        boolean sql1=st.execute("CREATE TABLE IF NOT EXISTS workers(worker_id INT,worker_name VARCHAR(50),salary REAL)");
        System.out.println("sql1: "+sql1);

        //execute metodu DQL veya DDL komutları için kullanılır
        //DQL için kullanılırsa:ResultSet nesnesi alırsa TRUE döndürür, aksi halde false döndürür
        //DDL için kullanılırsa:geriye FALSE döndürür.

        //ÖRNEK 2:"workers" tablosuna VARCHAR(20) tipinde "city" sütununu ekleyiniz.

//        boolean sql2=st.execute("ALTER TABLE workers ADD COLUMN city VARCHAR(20)");
//        System.out.println("sql2:"+sql2);

        //ÖRNEK 3:"workers" tablosunu SCHEMAdan siliniz.

        boolean sql3=st.execute("DROP TABLE workers");
        System.out.println("sql3:"+sql3);

        //5-ADIM:bağlantıyı ve statement kapatma
        st.close();
        connection.close();

}}