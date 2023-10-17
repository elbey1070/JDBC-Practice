import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        //1-ADIM:Java 7 ile birlikte gerek kalmadı.
        //2-ADIM:Database e bağlanma
        Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");

        Statement st =con.createStatement();

        System.out.println("success");

        System.out.println("------------------ÖRNEK 1------------------------");

        //ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.
        boolean sql1=st.execute("SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10");
        System.out.println("sql1:"+sql1);

        //kayıtları görmek için executeQuery()
        ResultSet resultSet =st.executeQuery("SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10");
//        resultSet.next();//bir sonraki satıra geçmeyi sağlar
//        System.out.println("Ülke ismi : "+resultSet.getString("country_name"));

        while (resultSet.next()){
            System.out.println("Ülke ismi : "+resultSet.getString("country_name"));
            // System.out.println("Ülke ismi : "+resultSet.getString(1));

        }

        //ResultSet'te geriye dönüş yoktur.

        System.out.println("------------------ÖRNEK 2------------------------");
        //ÖRNEK 2: phone_code'u 600 den büyük olan ülkelerin "phone_code" ve "country_name" bilgisini listeleyiniz.

        ResultSet rs2=st.executeQuery("SELECT phone_code,country_name FROM countries WHERE phone_code>600");
        while (rs2.next()){

            System.out.println("tel_kodu: "+rs2.getInt("phone_code")+"--ülke ismi:"+rs2.getString("country_name") );

        }

        System.out.println("------------------ÖRNEK 3------------------------");

        //ÖRNEK 3:it_persons tablosunda "salary" değeri en düşük salary olan yazılımcıların tüm bilgilerini gösteriniz.

        ResultSet rs3=st.executeQuery("SELECT * FROM it_persons WHERE salary=(SELECT MIN(salary) FROM it_persons)");

        while (rs3.next()){
            System.out.println(rs3.getInt("id")+"--"+rs3.getString("name")+"--"+
                    rs3.getDouble("salary")+"--"+rs3.getString("prog_lang"));

            //resultset nesnesindeki datayı uygulama içerisine get... metodları ile aldıktan sonra
            //uygulama içinde her türlü kullanılabilir.

//           String name= rs3.getString("name");
//            System.out.println(name+ "Bey");
//            List<String > names=new ArrayList<>();
//            names.add( rs3.getString("name"));
        }

        System.out.println("------------------ÖRNEK 4------------------------");

        //ÖRNEK 4:Puanı bölümlerin taban puanlarının ortalamasından yüksek olan öğrencilerin isim ve puanlarını listeleyiniz.ÖDEVVV

        ResultSet rs4= st.executeQuery("SELECT isim, puan FROM ogrenciler WHERE puan>(SELECT AVG(taban_puani) FROM bolumler)");
        while (rs4.next()){
            System.out.println(rs4.getString("isim")+"--"+rs4.getInt("puan"));
        }

        //ÖRNEK5:bolumler tablosunda taban puanı en yüksek 2. bölümün ismini ve puanını yazdırınız.

        System.out.println("------------------ÖRNEK 5------------------------");


        //ÖRNEK5:bolumler tablosunda taban puanı en yüksek 2. bölümün ismini ve puanını yazdırınız.
        String query5="SELECT bolum,taban_puani FROM bolumler WHERE taban_puani=" +
                "(SELECT MAX(taban_puani) FROM bolumler " +
                "WHERE taban_puani<(SELECT MAX(taban_puani) FROM bolumler))";
        ResultSet rs5= st.executeQuery(query5);
        while (rs5.next()){
            System.out.println(rs5.getString("bolum")+"---"+rs5.getInt("taban_puani"));
        }


        st.close();
        con.close();

    }
}