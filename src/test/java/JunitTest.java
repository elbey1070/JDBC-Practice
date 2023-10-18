import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test01(){
        String expectedData = "Selam";
        String actualData = "Selam";

        Assert.assertEquals(expectedData, actualData);

    }
    @Test
    public void test02(){

        int sayi =5;

        Assert.assertTrue(sayi>5);
    }
    @Test
    public void test03(){
        int sayi1= 5;
        int sayi2= 6;
        Assert.assertNotEquals(sayi1 ,sayi2);

    }

    @Test
    public void test04(){
        int sayi =5;
        Assert.assertFalse(sayi>5);

    }



}
