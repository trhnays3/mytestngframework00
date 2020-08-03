package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FHCLoginPage {
    WebDriver driver;

    public FHCLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id ="btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton2;

    @FindBy(xpath = "//span[.='Try again please']")
    public WebElement error_mesaj;

    //create login button
    public void login2(){
        username.sendKeys("manager2");
        password.sendKeys("Man1ager2!");
        loginButton2.click();
    }
}
