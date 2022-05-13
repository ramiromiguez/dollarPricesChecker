package com.rami.carina.dollar.gui.pages;


import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;


public class HomePageDollar extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy (xpath = "//button[normalize-space()='VER DATOS']")
    private ExtendedWebElement viewDates;

    @FindBy (xpath = "//input[@class='datepicker desde form-control']")
    private ExtendedWebElement dateFrom;

    @FindBy (xpath = "//tbody")
    private List<ExtendedWebElement> datesData;

    public HomePageDollar(WebDriver driver) {
        super(driver);
    }

    public void changeDateFrom(){
        dateFrom.type("20-02-2002");
    }

    public void clickViewDates(){
        viewDates.click();
    }

    public boolean validateDate(String date, String buyer, String seller) {
        for (ExtendedWebElement element : datesData) {
            String dateOption = element.getText();
            if (dateOption.contains(date)) {
                if(dateOption.contains(buyer)){
                    if (dateOption.contains(seller)){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        throw new RuntimeException("Unable to open date: " + date);
    }
}
