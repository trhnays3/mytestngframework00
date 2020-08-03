package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {
    //driver ====>>> Driver.getDriver()
    public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "mobile")
    public WebElement phone;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "re_password")
    public WebElement repassword;

    @FindBy(xpath = "//button[@value='Login']")
    public WebElement signUpButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successMesaj;




}
