package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {

    @Test
    public void newWindowTest(){
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("PARENT WINDOW HANDLE => "+parentWindowHandle);

        //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
       Set<String> allWindowHandles = driver.getWindowHandles();
        for (String childWindowHandle : allWindowHandles){
            if(!childWindowHandle.equals(parentWindowHandle)){
                driver.switchTo().window(childWindowHandle);
                System.out.println("CHILD WINDOW HANDLE => "+childWindowHandle);

            }
        }
        String newWindowTitle = driver.getTitle();
        Assert.assertEquals(newWindowTitle,"New Window");

        //Sayfadaki textin   “New Window” olduğunu doğrulayın.
        String newWindowText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(newWindowText,"New Window");

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(parentWindowHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }

}
