package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenCategoryPage extends Utility {
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Women']")
    WebElement women;
    @FindBy(xpath = "//span[@class='category-name']")
    WebElement womenTab;
    @FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_3']//li")
    List<WebElement> colourList;
    @FindBy(xpath = "//ul[@class='product_list grid row']//h5//a")
    List<WebElement> productList;

          //

    public void clickOnWomen() {
        clickOnElement(women);
    }

    public String verifyWomen() {
        return getTextFromElement(womenTab);
    }

    public void selectColour(String colour){
        for (WebElement colur:colourList) {

            if (colur.getText().contains(colour)){
                System.out.println(colur);
                mouseHoverToElementAndClick(colur);
//                colur.click();
//                break;
            }

        }

    }




}
