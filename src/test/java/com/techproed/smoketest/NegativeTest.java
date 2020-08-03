package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {


    @Test(groups = "group test1")
    public  void gecersizUsername(){   //http://www.fhctrip.com/Account/Logon
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButton.click();
        //wait problemi varsa bunu kullanmaliyiz.
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
//        Assert.assertTrue(tryAgain.isDisplayed());

        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));
        //Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());

    }

    @Test(groups = "group test1")
    public void gecersizPassword(){
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        fhcLoginPage.loginButton.click();

        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());

    }
    @Test
    public  void gecersizUsernamePass(){
        driver.get("http://fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manage");
        fhcLoginPage.password.sendKeys("manager12!");
        fhcLoginPage.loginButton.click();

        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));

    }

}
