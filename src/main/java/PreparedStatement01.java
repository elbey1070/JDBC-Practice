/*
PreparedStatement, Statementı extend eder(Statementın gelişmiş hali)
PreparedStatement ile önceden derlenmiş tekrar tekrar kullanılabilen
parametreli sorgular oluşturup çalıştırabiliriz.

 */

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");
        Statement st =con.createStatement();

        //ÖRNEK1:(Prepared Statement kullanarak) bolumler tablosunda Matematik bölümünün taban_puani'nı 475 olarak güncelleyiniz.
        //st.executeUpdate("UPDATE bolumler SET taban_puani=475 WHERE bolum='Matematik'");

        //sorguyu parametreli olarak oluştur
        String query="UPDATE bolumler SET taban_puani=? WHERE bolum=?";

        PreparedStatement prst=con.prepareStatement(query);
        //parametreleri verelim
        prst.setInt(1,475);
        prst.setString(2,"Matematik");
        //sorguyu çalıştıralım
        int updated=prst.executeUpdate();
        System.out.println("updated = " + updated);

        //Ornek 2:  Prepared statement

        prst.setInt(1,455);
        prst.setString(2,"Edebiyyat");
        // use query
        int updated2 = prst.executeUpdate();
        System.out.println("updated2 = " + updated2);
        System.out.println("--------------------3-----------------------");

        //ÖRNEK3:Prepared Statement kullanarak ogrenciler tablosundan Matematik bölümünde okuyanları siliniz.
        PreparedStatement prst2=con.prepareStatement("DELETE FROM ogrenciler WHERE bolum ILIKE ?");
        //parametreyi set edelim
        prst2.setString(1,"matematik");
        //çalıştıralım
        int deleted=prst2.executeUpdate();
        System.out.println("deleted = " + deleted);

        System.out.println("--------------------4-----------------------");
        //ÖRNEK4:Prepared Statement kullanarak bolumler tablosuna
        // Yazılım Mühendisliği(id=5006,taban_puanı=475, kampus='Merkez') bölümünü ekleyiniz.
        String sql="INSERT INTO bolumler VALUES(?,?,?,?)";
        PreparedStatement prst3=con.prepareStatement(sql);

        prst3.setString(2,"Yazılım Mühendisliği");
        prst3.setInt(1,5006);
        prst3.setString(4,"Merkez");
        prst3.setInt(3,475);

        int inserted=prst3.executeUpdate();
        System.out.println("inserted = " + inserted);


        st.close();
        prst.close();
        con.close();

    }
}