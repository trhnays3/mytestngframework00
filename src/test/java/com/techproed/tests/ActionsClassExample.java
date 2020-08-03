package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClassExample extends TestBase {
    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    @Test
    public void contextClickMethod(){
        //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Dikdörtgen kutu icinde sağa tıklayın.
        WebElement dikdortgen = driver.findElement(By.id("hot-spot"));
        //create Actions class
        //Actions actions = new Actions(driver);  ===>> TestBase e alalim
        actions.contextClick(dikdortgen).perform();
        //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(actualText,expectedText);
        //Alert’te OK ye basin
        driver.switchTo().alert().accept();
    }
    @Test
    public void hoverOver(){
        //https://www.amazon.com/  web sitesine gidin.
        driver.get("https://www.amazon.com/");
        //“Your Account” linkine tıklayın.
        WebElement helloSignIn = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        actions.moveToElement(helloSignIn).perform();
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();
        //Sayfa basliginin(page title) “Your Account" icerdigini(contains) dogrulayin.  //HOMEWORK
    }

    @Test
    public void keysUpDown(){
        //https://www.google.com/ adresine gidin.
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        //searchBox.sendKeys("iphone");
        //( input(giris) => iphone , output => IPHONE
        //BUYUK HARF ICIN
        //1.YOL:
       // searchBox.sendKeys(Keys.SHIFT+"iphone");
        //2.yol: ACTIONS CLASS
//        actions.
//                moveToElement(searchBox).
//                click().
//                keyDown(Keys.SHIFT).
//                sendKeys("iphone").
//                perform();
        actions.
                keyDown(searchBox,Keys.SHIFT).
                sendKeys("iphone").
                keyUp(searchBox,Keys.SHIFT).
                perform();

        //Text box’ta cift tiklayin(double click).
        actions.doubleClick(searchBox).perform();

    }
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //Sayfayi asagi dogru kaydirma
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        //Bir sayfada birden fazla page_down ve page_up kullanabiliriz.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        //ARROW_DOWN da sayfa asagi inmeyi saglar ama daha az miktarda
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        //Sayfayi yukari dogru kaydirma
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        //ARROW_UP sayfayi yukari kaydiri ama daha az miktarda.
        actions.sendKeys(Keys.ARROW_UP).perform();
    }
}
