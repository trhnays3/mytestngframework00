package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //Iki tane metod oluşturun : isExist() ve downloadTest()
    @Test
    public void isExist(){
       String mevcutKlasor =  System.getProperty("user.dir");
       System.out.println("MEVCUT KLASOR => "+ mevcutKlasor);

       String userKlasor = System.getProperty("user.home");
                                          //  Users/PC/
       System.out.println("USER KLASOR => "+userKlasor);

       String filePath = userKlasor + "/Downloads/logo.jpg";
        //String filePath = "C:/Users/PC/Downloads/logo.jpg";  bu da kullanilabilir.
        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);  //Eger dosya varsa(file exist) true ve Pass,yoksa false ve test Fail olur..

    }
    @Test
    public void downloadTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidin.
        driver.get("https://the-internet.herokuapp.com/download");
        //image1.jpg dosyasını indir
        WebElement image1 = driver.findElement(By.linkText("image1.jpg"));
        image1.click();

        //Dosyanin yuklenmesi icin biraz zamana ihtiyac olabilir.
        Thread.sleep(5000);  //HARD WAIT

        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
            //Kullanici klasoru
        String userKlasor = System.getProperty("user.home");
            // indirilen dosyanin konumunu(path) buluyoruz.
        String filePath = userKlasor + "/Downloads/image1.jpg";
        //String filePath = "C:/Users/PC/Downloads/image1.jpg";  bu da kullanilabilir.

        //dosya var mi yok mu kontrol ediyoruz.
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);  // dosya yuklendi ise PASS, Degilse FAIL

    }

}
