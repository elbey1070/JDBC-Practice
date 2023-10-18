public class IlkTest {
    public static void main(String[] args) {

        String expectedData = "Selam";
        String actualData = "Selam";

        System.out.println("__________TEST-01__________");

        if (expectedData.equals(actualData)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        int expectedNumber = 5;
        int actualNumber=5;
        System.out.println("__________TEST-02__________");
        if (expectedNumber == actualNumber){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        System.out.println("__________TEST-03__________");
        if (expectedNumber > actualNumber){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

    }
}
