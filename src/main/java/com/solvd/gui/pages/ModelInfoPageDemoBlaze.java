package com.solvd.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModelInfoPageDemoBlaze extends AbstractPage {

    @FindBy(xpath = "//div/div[2]/div/div/div/div/h4")
    private ExtendedWebElement modelName;

    //.row .col-md-7 .price-container
    @FindBy(xpath = " //div[@class='row']/div[2]/h3")
    private ExtendedWebElement modelPrice;

    @FindBy(xpath = "//div[@class='row']/div[2]/div/div/div")
    private ExtendedWebElement modelDescription;


    public ModelInfoPageDemoBlaze(WebDriver driver) {
        super(driver);
    }

    public String readModelName() {
        assertElementPresent(modelName);
        return modelName.getText();
    }

    public String readPrice() {
        assertElementPresent(modelPrice);
        return modelPrice.getText();
    }

    public String modelDescription() {
        assertElementPresent(modelDescription);
        return modelDescription.getText();
    }
}
