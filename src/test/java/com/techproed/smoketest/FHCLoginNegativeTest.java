package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCLoginNegativeTest extends TestBase {

    @Test
    public  void gecersizUsername(){   //http://www.fhctrip.com/Account/Logon
        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButton.click();
        //wait problemi varsa bunu kullanmaliyiz.
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
        Assert.assertTrue(tryAgain.isDisplayed());

        //Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
        //Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());

    }

    @Test(groups = "group test1")
    public void gecersizPassword(){
        driver.get("http://fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("manager12!");
        fhcLoginPage.loginButton.click();

        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());

    }
    @Test
    public  void gecersizUsernamePass(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manage");
        fhcLoginPage.password.sendKeys("manager12!");
        fhcLoginPage.loginButton.click();

        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));

    }
}
