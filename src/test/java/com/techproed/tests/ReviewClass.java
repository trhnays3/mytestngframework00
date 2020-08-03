package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReviewClass {
    //https://www.airbnb.co.in/ adresine git
    //Sayfa basligini(title) al ve konsolda yazdir.
    //Sayfanin mevcut url’ ini (current url) al
    //Sayfanin source(page source) ‘u al.
    @Test
    public void airbnbTest(){
        Driver.getDriver().get("https://www.airbnb.co.in/");
        String title = Driver.getDriver().getTitle();
        System.out.println("Page Title : "+title);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("Current url : "+currentUrl);
        String pageSource = Driver.getDriver().getPageSource();
        System.out.println("Page source : "+pageSource);

    }

    @Test
    public void ebayTest(){
        //http://ebay.com adresine git
        //Search box’a “Selenium” yaz
        //Search butonuna tikla
        //Selenium icin kac sonuc var kontrol et ve konsolda yazdir.
        //Sayfa basligini(title) al ve konsolda yazdir.
        //Sayfanin mevcut url’ini (current url) al
        //Sayfanin source(page source) ‘u al.
        Driver.getDriver().get("http://ebay.com");

        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        searchBox.sendKeys("Selenium");

        WebElement searchButton = Driver.getDriver().findElement(By.id("gh-btn"));
        searchButton.click();

        WebElement results = Driver.getDriver().findElement(By.className("srp-controls__count-heading"));
        System.out.println(results.getText());

        String title = Driver.getDriver().getTitle();
        System.out.println(title);

        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);

        String pageSource = Driver.getDriver().getPageSource();
        System.out.println(pageSource);

    }

}
