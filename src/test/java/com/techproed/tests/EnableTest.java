package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableTest extends TestBase {

    @Test
    public void isEnabled(){
        //3.	https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4.	Enable butonuna basin.
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();
        //6.	“It's enabled!” mesajinin goruntulendigini dogrulayin.
        //explicit wait gerekli cunku yukleme icin zaman gerekiyor. Ve belirli bir kosul var.
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement enableMesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(enableMesaj.getText(),"It's enabled!");

        //5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        boolean isEnable = textBox.isEnabled();
        Assert.assertTrue(isEnable);
        //Assert.assertTrue(textBox.isEnabled());

        //isEnabled(); => bir elementin etkin olup olmadigini kontrol eder
        //isDisplayed(); => bir elementin gorunup gorunmedigini kontrol eder
        //isSelected(); => radio button ve checkbox

    }
}
