package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestGlbSignIn {

    @Test
    public void negativeTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_signin_url"));
        GlbSignInPage glbSignInPage = new GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigReader.getProperty("gecersiz_email"));
        glbSignInPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        glbSignInPage.loginButton.click();

        Assert.assertTrue(glbSignInPage.mesaj.getText().equals("Sorry!"));

        Driver.closeDriver();
    }
}
