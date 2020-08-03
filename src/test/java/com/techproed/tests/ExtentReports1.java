package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ExtentReports1 {
    //ExtentReports==>> raporlamaya baslamak icin buna ihtiyacimiz var.Raporu kapatmak(flush()) icin kullaniyoruz.
    //ExtentHtmlReporter==>> Raporlari yapilandirmaya(configuration) yardimci olur. Html raporlarini create eder.
    //ExtentTest==>>> Aciklama(logs) eklemek icin, test adimlarini belirlemek icin kullanilir.
    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;

    @BeforeTest
    public void setup(){
        //reporter'i baslatalim ve konumunu ayarlayalim.
        //                                             klasor: reports, dosya adi: extentreport.html
        extentHtmlReporter = new ExtentHtmlReporter("./reports/extentreport.html");
        // extentHtmlReporter'la bazi yapilandirmalar  yapalim.
        extentHtmlReporter.config().setReportName("GLB trader Report");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.config().setDocumentTitle("GLB sign up report");
        extentHtmlReporter.config().setEncoding("UTF-8");

        //ExtentReports'u create edelim
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //daha fazla aciklama ekleyebiliriz.
        extentReports.setSystemInfo("Automation engineer", "Ayse");
        extentReports.setSystemInfo("Browser","chrome");

    }

    @AfterTest
    public void endReport(){
        extentReports.flush();  //close report
    }
    @Test
    public void glbSignUp() throws InterruptedException {
        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
        GlbHomePage glbHomePage = new GlbHomePage();

        extentTest=extentReports.createTest("GLB Sign Up Test");
        extentTest.info("Url'e git");
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        extentTest.info("join now linkine tikla");
        glbHomePage.joinNowLink.click();
        extentTest.info("email gonder");
        glbSignUpPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        extentTest.info("usermame gonder");
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        extentTest.info("telefon numarasi gonder");
        glbSignUpPage.phone.sendKeys(ConfigReader.getProperty("test_phone"));
        extentTest.info("password Yaz");
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        extentTest.info("password'u tekrar yaz");
        glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        extentTest.info("sign up'a tikla");
        glbSignUpPage.signUpButton.click();

        Thread.sleep(3000);
        System.out.println("SUCCESS MESAJ : "+ glbSignUpPage.successMesaj.getText());
        Assert.assertFalse(glbSignUpPage.successMesaj.getText().equals("Success!"));
        //Test fail olacak cunku actual Success! ! fakat expected Success!
        extentTest.pass("PASSED: Test basariyla tamamlandi.");

       Driver.closeDriver();
        extentTest.pass("Driver basariyla kapatildi.");


    }

}

