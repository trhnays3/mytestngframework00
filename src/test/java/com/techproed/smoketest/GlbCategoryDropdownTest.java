package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbCategoryDropdownTest {
    GlbHomePage glbHomePage=new GlbHomePage();
    @Test
    public void glbDropdownTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        Select options = new Select(glbHomePage.allCategoriesDropdown);

        boolean flag = false;
        for(WebElement option : options.getOptions()){
            if(option.getText().equals("Furniture")){
                System.out.println("Dropdownda Furniture vardir.");
                flag=true;
                break;
            }
        }
        Assert.assertTrue(flag);
        Driver.closeDriver();
    }
}
