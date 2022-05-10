package com.solvd.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class HomePageDemoBlaze extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public HomePageDemoBlaze(WebDriver driver) {
        super(driver);
        open();
    }

    //Log IN Elements

    @FindBy(id = "login2")
    private ExtendedWebElement logIn;

    @FindBy(xpath = "//input[contains(@id, 'loginusername')]")
    private ExtendedWebElement insertLoginUserName;

    @FindBy(xpath = "//input[contains(@id, 'loginpassword')]")
    private ExtendedWebElement insertLoginPassword;

    @FindBy(xpath = "//div[@id='logInModal']/div/div/div[3]/button[1]")
    private ExtendedWebElement buttonLogInClose;

    @FindBy(xpath = "//div/button[@class='btn btn-primary'][contains(., 'Log in')]")
    private ExtendedWebElement buttonSendLogIn;

    //Sign Up Elements

    @FindBy(id = "signin2")
    private ExtendedWebElement singIn;

    @FindBy(xpath = "//input[contains(@id, 'sign-username')]")
    private ExtendedWebElement insertSignInUsername;

    @FindBy(xpath = "//input[contains(@id, 'sign-password')]")
    private ExtendedWebElement insertSignInPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary'][contains(., 'Sign up')]")
    private ExtendedWebElement buttonSendSignUp;

    @FindBy(xpath = "//div[@id='signInModal']/div/div/div[3]/button[1]")
    private ExtendedWebElement buttonSignInClose;

    //Contact Us Elements

    @FindBy(xpath = "//a[text()='Contact']")
    private ExtendedWebElement contact;

    //input[contains(@id, 'recipient-email')]
    @FindBy(xpath = "//div[@class='form-group']/input[contains(@id, 'recipient-email')]")
    private ExtendedWebElement insertContactEmail;

    @FindBy(xpath = "//input[contains(@id, 'recipient-name')]")
    private ExtendedWebElement insertContactName;

    @FindBy(xpath = "//textarea[contains(@id, 'message-text')]")
    private ExtendedWebElement insertContactMessage;

    //div[@id='exampleModal']/div/div/div/button[@class= 'close']

    @FindBy(xpath = "//div[@id='exampleModal']/div/div/div[3]/button[@class='btn btn-secondary']")
    private ExtendedWebElement closeButtonContact;

    @FindBy(xpath = "//button[text()= 'Send message']")
    private ExtendedWebElement buttonSendMessage;

    //xpath= "//div[contains(@class, navbar-brand)]//ul//li/a/span"
    //@FindBy(css ="ul>li>a :nth-child(1)")
    @FindBy(css = "a.nav-link span")
    private ExtendedWebElement home;

    //Phone Elements

    @FindBy(xpath = "//a[@id='itemc'][contains(.,'Phones')])")
    private ExtendedWebElement phonesBlock;

    @FindBy(xpath = "//div[@id='tbodyid']/div")
    private List<ExtendedWebElement> allPhonesDiv;

    @FindBy(xpath = "//div[@id='tbodyid']/div/div/div/h4/a")
    private List<ExtendedWebElement> phonesNames;

    @FindBy(xpath = "//div[@id='tbodyid']/div/div/div/h5")
    private List<ExtendedWebElement> pricePhones;

    @FindBy(xpath = "//div[@id='tbodyid']/div/div/div/h4/a")
    private ExtendedWebElement namePhone;

    //Laptops Elements

    @FindBy(xpath = "//a[@id='itemc'][contains(.,'Laptops')]")
    private List<ExtendedWebElement> laptopsLinks;

    //Methods Log in

    public void clickLogIn() {
        logIn.click();
    }

    public void setInsertLoginUserName(String loginUserName) {
        insertLoginUserName.type(loginUserName);
    }

    public void setInsertLoginPassword(String loginPassword) {
        insertLoginPassword.type(loginPassword);
    }

    public void clickLogInClose() {
        buttonLogInClose.click();
    }

    public void clickSendLogIn() {
        buttonSendLogIn.click();
    }

    // Methods Sign Up

    public void clickSingIn() {
        singIn.click();
    }

    public void setUserName(String userName) {
        insertSignInUsername.type(userName);
    }

    public void setUserPassword(String password) {
        insertSignInPassword.type(password);
    }

    public void clickSingInClose() {
        buttonSignInClose.click();
    }

    public void clickSendSingUp() {
        buttonSendSignUp.click();
    }

    // Methods Contact Us

    public void clickContact() {
        contact.click();
    }

    public void setInsertContactEmail(String contactEmail) {
        insertContactEmail.type(contactEmail);
    }

    public void setContactName(String contactName) {
        insertContactName.type(contactName);
    }

    public void setContactMessage(String contactMessage) {
        insertContactMessage.type(contactMessage);
    }

    public void clickSendMessage() {
        buttonSendMessage.click();
    }

    public void clickCloseContactButton() {
        closeButtonContact.click();
    }

    // Methods Phone

    public PhonesPageDemoBlaze selectBrandPhone(String namePhones) {
        LOGGER.info("Selecting '" + namePhones + "' phone...");
        for (ExtendedWebElement phonesBlock : allPhonesDiv) {
            String currentPhone = phonesBlock.getText();
            LOGGER.info("currentPhone: " + currentPhone);
            if (namePhones.equals(currentPhone)) {
                phonesBlock.click();
                return new PhonesPageDemoBlaze(driver);
            }
        }
        throw new RuntimeException("unable to open phone: " + namePhones);
    }


}

