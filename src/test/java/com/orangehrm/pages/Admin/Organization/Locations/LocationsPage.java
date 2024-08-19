package com.orangehrm.pages.Admin.Organization.Locations;

import com.orangehrm.base.TestBase;
import org.openqa.selenium.WebDriver;

public class LocationsPage extends TestBase {
    public WebDriver driver;
    public LocationsLocators locationsLocators;

    public LocationsPage(WebDriver driver) {
        this.driver = driver;
        this.locationsLocators = new LocationsLocators(driver);
    }

    public void validate_Locations_Header() {
        validateText(locationsLocators.locationsTitle, "Locations", "Validated Locations Title", 30);
    }

    public void enter_Location_Name(String locationName) {
        sendKeys(locationsLocators.locationsNameInputBox, locationName, "Entered location name: " + locationName, 30);
    }

    public void enter_City_Name(String cityName) {
        sendKeys(locationsLocators.cityInputBox, cityName, "Entered city name: " + cityName, 30);
    }

    public void select_Country(String countryName) {
        selectOptionFromDropdown(locationsLocators.locationsCountryDropdown, countryName, "Selected " + countryName + " from Country dropdown", 30);
    }

    public void click_On_Search_Button() {
        clickElement(locationsLocators.searchButton, "Clicked on Search button", true, 30);
    }

    public void click_On_Reset_Button() {
        clickElement(locationsLocators.resetButton, "Clicked on Reset Button", true, 30);
    }

    public void click_On_Add_Button() {
        clickElement(locationsLocators.addButton, "Clicked on Add Button", true, 30);
    }
}
