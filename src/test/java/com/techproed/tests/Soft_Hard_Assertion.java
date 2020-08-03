package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Hard_Assertion {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        //http://a.testaddressbook.com/sign_in adresine gidin.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void login(){
        //email textbox,password textbox, ve signin button elementlerini locate edin.
        //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
        //Username :  testtechproed@gmail.com
        //Password :   Test1234!
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");
        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");
        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();
        driver.manage().window().maximize();

    }

    @Test(dependsOnMethods = "login")
    public void homePage(){
        //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
        System.out.println(welcomeMessage.getText());
        //Assert.assertTrue(welcomeMessage.isDisplayed());  //HARD ASSERT  //pass
        System.out.println("Hard assert fail olursa bu satir calismayacak.");

        //SOFT ASSERT
        //1.Adim: create object
        SoftAssert softAssert = new SoftAssert();
        //2.Adim: assertion icin olusturdugumuz objecti kullan
        //softAssert.assertTrue(!welcomeMessage.isDisplayed());  //fail
        softAssert.assertTrue(welcomeMessage.isDisplayed());  //pass
        //softAssert.assertEquals(3,5);    //fail
        //3.adim: assertAll();


        //Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com beklenen kullanıcı  kimliğinin(userID) doğrulayın
        WebElement userID = driver.findElement(By.className("navbar-text"));
        String actualID = userID.getText();
        String expectedID = "testtechproed@gmail.";
        //Assert.assertEquals(actualID,expectedID); //Hard assert  //pass

        //SOFT ASSERT
        //2.adim
        softAssert.assertEquals(actualID,expectedID);
        //3.adim:  assertAll();
        softAssert.assertAll();  //Bu satir cok ONEMLI. assertAll(),gercek assertioni yapar.
                                 // assertAll() yazilmazsa test fail olmasi gerektiginde de pass olur.


    }
}
