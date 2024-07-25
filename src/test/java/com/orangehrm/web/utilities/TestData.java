package com.orangehrm.web.utilities;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"}
        };
    }
}
