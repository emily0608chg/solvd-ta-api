package com.demoblaze;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.gui.pages.HomePageDemoBlaze;
import com.solvd.gui.pages.ModelInfoPageDemoBlaze;
import com.solvd.gui.pages.PhonesPageDemoBlaze;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebDemoBlazeTest implements IAbstractTest {

    // is not complete

    @Test
    public void testLogIn() {

        SoftAssert softAssert = new SoftAssert();

        HomePageDemoBlaze homePageDemoBlaze = new HomePageDemoBlaze(getDriver());
        homePageDemoBlaze.open();
        softAssert.assertTrue(homePageDemoBlaze.isPageOpened(), "Home page is not opened");

        homePageDemoBlaze.clickLogIn();
        homePageDemoBlaze.setInsertLoginUserName("Emily");
        homePageDemoBlaze.setInsertLoginPassword("1234567");
        //homePageDemoBlaze.clickSendLogIn();
        homePageDemoBlaze.clickLogInClose();
    }

    @Test
    public void testSignIn() {

        SoftAssert softAssert = new SoftAssert();

        HomePageDemoBlaze homePageDemoBlaze = new HomePageDemoBlaze(getDriver());
        homePageDemoBlaze.open();
        softAssert.assertTrue(homePageDemoBlaze.isPageOpened(), "Home page is not opened");

        homePageDemoBlaze.clickSingIn();
        homePageDemoBlaze.setUserName("Dafne");
        homePageDemoBlaze.setUserPassword("3456778");
        homePageDemoBlaze.clickSendSingUp();
        //homePageDemoBlaze.clickSingInClose();
    }

    @Test
    public void testContactUs() {

        SoftAssert softAssert = new SoftAssert();

        HomePageDemoBlaze homePageDemoBlaze = new HomePageDemoBlaze(getDriver());
        homePageDemoBlaze.open();
        softAssert.assertTrue(homePageDemoBlaze.isPageOpened(), "Home page is not opened");

        homePageDemoBlaze.clickContact();
        homePageDemoBlaze.setInsertContactEmail("ecguerrero@solvd.com");
        homePageDemoBlaze.setContactName("Emily");
        homePageDemoBlaze.setContactMessage("It wasn't easy -.-");
        //homePageDemoBlaze.clickSendMessage();
        homePageDemoBlaze.clickCloseContactButton();

    }

    @Test
    public void testModelSpecsDemoB() {
        //Open Demo Blaze page and verify is opened

        HomePageDemoBlaze homePageDemoBlaze = new HomePageDemoBlaze(getDriver());
        homePageDemoBlaze.open();
        Assert.assertTrue(homePageDemoBlaze.isPageOpened(), "Home page is not opened");

        /* Select phone brand */
        //homePageDemoBlaze = new HomePageDemoBlaze(getDriver());
        PhonesPageDemoBlaze productsPage = homePageDemoBlaze.selectBrandPhone("Samsung galaxy s6");

        ModelInfoPageDemoBlaze modelInfoPageDemoBlaze = productsPage.readModel("Samsung galaxy s6");


    }
}

