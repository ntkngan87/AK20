package modules;

import org.testng.annotations.*;

public class DebugTest {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test
    public void tco1(){
        System.out.println("test case 01");
    }

    @Test
    public void tc02(){
        System.out.println("test case 02");
    }

    @Test
    public void tco3(){
        System.out.println("test case 03");
    }

    @Test
    public void tco4(){
        System.out.println("test case 04");
    }

    @Test
    public void tco5(){
        System.out.println("test case 05");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

}
