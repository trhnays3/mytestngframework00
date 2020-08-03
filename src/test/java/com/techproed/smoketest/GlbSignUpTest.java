package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignUpTest {
    GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
    GlbHomePage glbHomePage = new GlbHomePage();

    @Test
    public  void signUpTest() throws InterruptedException {
        //driver ===>> Driver.getDriver()

       // Driver.getDriver().get(ConfigReader.getProperty("glb_signup_url"));
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        glbHomePage.joinNowLink.click();

        glbSignUpPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        glbSignUpPage.phone.sendKeys(ConfigReader.getProperty("test_phone"));
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.signUpButton.click();

        Thread.sleep(3000);
        System.out.println("SUCCESS MESAJ : "+ glbSignUpPage.successMesaj.getText());
        Assert.assertTrue(glbSignUpPage.successMesaj.getText().equals("Success!"));
        //Test fail olacak cunku actual Success! ! fakat expected Success!

      // Driver.closeDriver();

    }
}
