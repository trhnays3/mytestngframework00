package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbHomePage {
    public GlbHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "header_search_category")
    public WebElement allCategoriesDropdown;

    @FindBy(linkText = "Join Now")
    public WebElement joinNowLink;

}
