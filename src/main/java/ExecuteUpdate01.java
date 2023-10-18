import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");
        Statement st =con.createStatement();

        //executeUpdate():DML için kullanılır; INSERT,UPDATE,DELETE
        //return:sorgudan etkilen kayıt sayısını döndürür.

        //ÖRNEK1:it_persons tablosunda maaşı ortalama maaştan az olanların maaşını 5111 olarak güncelleyiniz.
//        String query="UPDATE it_persons SET salary=5111 WHERE salary<(SELECT AVG(salary) FROM it_persons)";
//        int updated=st.executeUpdate(query);
//        System.out.println("güncellenen kayıt sayısı = " + updated);

        //maaşı 5111 olan kayıtları görelim.
        ResultSet rs =st.executeQuery("SELECT * FROM it_persons WHERE salary=5111");
        while (rs.next()){
            System.out.println(rs.getString("name")+"----"+rs.getDouble("salary"));
        }

        System.out.println("--------------------2-------------------------");

        //ÖRNEK2:it_persons tablosuna yeni bir kayıt ekleyiniz.
        String query2="INSERT INTO it_persons(name,salary,prog_lang) VALUES('Safa',5000.0,'Java')";
        int inserted=st.executeUpdate(query2);
        System.out.println("eklenen kayıt sayısı = " + inserted);

        //tüm kayıtları listeleyelim
        ResultSet rs2 =st.executeQuery("SELECT * FROM it_persons");
        while (rs2.next()){
            System.out.println(rs2.getString("name")+"----"+rs2.getDouble("salary"));
        }


        System.out.println("--------------------3-------------------------");

        //ÖRNEK3:it_persons tablosundan id'si 11 olanı siliniz.
        int deleted=st.executeUpdate("DELETE FROM it_persons WHERE id=11");
        System.out.println("silinen kayıt sayısı = " + deleted);

        //tüm kayıtları listeleyelim
        ResultSet rs3 =st.executeQuery("SELECT * FROM it_persons");
        while (rs3.next()){
            System.out.println(rs3.getString("name")+"----"+rs3.getInt("id"));
        }

        int silenenSayi =st.executeUpdate("Delete From it_persons WHERE id=11");
        System.out.println("silenenSayi = " + silenenSayi);

        ResultSet rs77 = st.executeQuery("SELECT * FROM it_persons");

        while (rs77.next()){
            System.out.println(rs77.getString("name")+"-----"+rs77.getInt("it"));
        }


        st.close();
        con.close();

    }
}

