package com.techproed.tests;

import com.mongodb.DBRefCodecProvider;
import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReports2 extends TestBaseFinal {
    @Test
    public void negativeTest(){
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());

        extentTest = extentReports.createTest("FHC Login Test","FHC Login fonksiyonunun testi");
        extentTest.info("url'e git");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        extentTest.info("gecersiz username gonder");
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        extentTest.info("gecersiz password gonder");
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        extentTest.info("login butonuna tikla");
        fhcLoginPage.loginButton.click();

        extentTest.info("assertion yap");
        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
        extentTest.pass("PASSED: Try again please");
        Driver.closeDriver();
        extentTest.pass("Driver kapatildi");


    }
}
