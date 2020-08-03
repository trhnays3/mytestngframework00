package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingAlerts extends TestBase {

    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        // locate 1. buton
        WebElement buton1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        buton1.click();
        //Alert uzerindeki mesaji konsolda yazdir
        System.out.println("Alert mesaji: " +driver.switchTo().alert().getText());

       // uyarıdaki(alert) OK butonuna tıklayın
        driver.switchTo().alert().accept(); // accept() => click OK demektir
        //result mesajının görüntülendiğini doğrulayın =>idDisplayed()
        //locate result message
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMesaj.isDisplayed());  //Hard assert

    }
    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        //2.butonu locate edelim
        WebElement buton2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        buton2.click();
        //uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss(); //dismiss() => Cancel butonuna basmak demektir.
        //result mesajının "You clicked: Cancel" oldugunu doğrulayın.
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultMesaj.getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);  //Hard assert

    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        //Locate 3.buton
        WebElement buton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton3.click();
        //uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("AYSE");
        //OK butonuna tıklayın
        driver.switchTo().alert().accept();
        //result mesajının görüntülendiğini doğrulayın
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMesaj.isDisplayed());

    }


}
