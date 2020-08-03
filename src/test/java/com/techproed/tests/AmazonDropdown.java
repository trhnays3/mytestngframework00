package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonDropdown extends TestBase {
    //Bir metod olusturun : amazonDropdownTest
    @Test
    public void amazonDropdownTest(){
        //2. https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //3. Dropdown elementini bulun.
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //4. İlk seçilen seçeneği(firstSelectedOption) konsolda yazdırın ve
        // ilk secenegin "All Departments" ile esit oldugunu dogrulayin.
        Select select = new Select(dropdownElement);
        String firstOption = select.getFirstSelectedOption().getText();
        System.out.println(firstOption);
        Assert.assertEquals(firstOption,"All Departments");
        //5. 6.seçeneği(option) index kullanarak secin ve 6.seçeneğin "Books" oldugunu dogrulayin.
        // (Seçtikten sonra getFirstSelectedOption() metodunu kullanmanız gerekir)
        select.selectByIndex(5);
        String option6 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option6,"Books");
        //6. Butun dropdown seçeneklerini konsolda yazdırın
        List<WebElement> allOptions = select.getOptions();
        for(WebElement option : allOptions){
            System.out.println(option.getText());
        }

        //7. Dropdowndaki eleman sayisini konsolda yazdırın
        int optionsSayisi = allOptions.size();
        System.out.println("Dropdowndaki eleman sayisi: " + optionsSayisi);
        //8. "Electronics" ın dropdownda olup olmadığını kontrol edin.
        // "Electronics" dropdownda bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.

        boolean flag = false;
        for(WebElement option : allOptions){
            if(option.getText().equals("Electronics")){
                flag = true;
                break;
            }
        }
        System.out.println(flag);

    }

}
