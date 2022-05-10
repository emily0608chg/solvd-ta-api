package com.solvd.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PhonesPageDemoBlaze extends AbstractPage {

    @FindBy(xpath = "//div[@id='tbodyid']/div")
    private List<ModelItemDemoB> model;

    public PhonesPageDemoBlaze(WebDriver driver) {
        super(driver);
    }

    public ModelInfoPageDemoBlaze readModel(String modelName) {
        for (ModelItemDemoB modelI : model)
            if (modelI.readModelDescription().equalsIgnoreCase(modelName)) {
                return modelI.openModelPage();
            }
        throw new RuntimeException("Unable to open model; " + modelName);
    }
}

