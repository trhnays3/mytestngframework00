package com.techproed.smoketest;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLoginTest extends TestBase {

    @Test
    public void faceLoginTest(){
        driver.get("https://www.facebook.com/");

        FaceLoginPage faceLoginPage = new FaceLoginPage(driver);

        faceLoginPage.email.sendKeys("fakeusername");
        faceLoginPage.password.sendKeys("fakepassword");
        faceLoginPage.loginButton.click();
        //wait'e ihtiyac oldugunda explicit wait kullanmaliyiz.
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement errorMesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
        Assert.assertTrue(errorMesaj.isDisplayed());

        //Assert.assertTrue(faceLoginPage.error_mesaj.isDisplayed());  //Wait problemi yoksa bu satir calisir.



    }
}
