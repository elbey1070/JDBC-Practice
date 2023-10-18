import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/*
Transaction:DB deki parçalanamaz(atomik) en küçük işlem
birden fazla işlem için tek bir transaction oluşturabiliriz
Bu işlemlerden en az bir tanesi başarısız olursa ROLLBACK ile diğer işlemleri de iptal edebiliriz.
Bu işlemlerin tamamı başarılı olursa değişiklikleri DBde kalıcı hale getirmek için Transaction COMMIT edilir.
 */
public class Transaction01 {
    public static void main(String[] args) throws Exception {
//olmaması gereken senaryo
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");
        //hesap_no:1234 olan müşteri hesap_no:5678 olan müşteriye 1000 para transferi gerçekleştirsin.
        String sql="UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
        PreparedStatement prst= con.prepareStatement(sql);
        //para transferi yapan hesap
        prst.setInt(1,-1000);
        prst.setInt(2,1234);
        prst.executeUpdate();

        //sistemsel hata oluştu
        if (true){
            throw new Exception();//burada uygulama durur
        }

        //para transferi alan hesap
        prst.setInt(1,1000);
        prst.setInt(2,5678);

        prst.executeUpdate();

    }
}