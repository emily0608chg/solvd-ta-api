package com.solvd.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModelItemDemoB extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private ExtendedWebElement modelLabel;

    @FindBy(xpath = "//a")
    private ExtendedWebElement modelLink;

    public ModelItemDemoB(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readModelDescription(){
        return modelLabel.getText();
    }

    public ModelInfoPageDemoBlaze openModelPage(){
        modelLink.click();
        return new ModelInfoPageDemoBlaze(driver);
    }
}

