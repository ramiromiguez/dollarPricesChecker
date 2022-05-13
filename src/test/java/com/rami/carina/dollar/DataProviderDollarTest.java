package com.rami.carina.dollar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.rami.carina.dollar.gui.pages.HomePageDollar;
import com.rami.carina.dollar.utils.Transformer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class DataProviderDollarTest implements IAbstractTest {
    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/dollarPrices.xlsx", sheet = "Sheet1", dsUid = "date", dsArgs = "date, buyer, seller")
    public void datesProvider(String date, String buyer, String seller) throws ParseException {

        Transformer transformer = new Transformer();
        String dateTransformed = transformer.dateConvert(date);
        String buyerTransformed = transformer.buyerConvert(buyer);
        String sellerTransformed = transformer.sellerConvert(seller);

        HomePageDollar homePage = new HomePageDollar(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.changeDateFrom();
        homePage.clickViewDates();
        boolean isInPage = homePage.validateDate(dateTransformed, buyerTransformed, sellerTransformed);
        Assert.assertTrue(isInPage, "The buyer or seller info is incorrect");
    }
}
