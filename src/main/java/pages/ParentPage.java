package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElement {

    final String baseUrl = "https://a-shop.ua";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    abstract String getRelativeUrl();

    protected void checkUrl() {
        Assert.assertEquals("Invalid page ", baseUrl + getRelativeUrl(), webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern() {
        Assert.assertTrue("Invalid page \n"
                + "Expected result: " + baseUrl + getRelativeUrl() + "\n"
                + "Actual result: " + webDriver.getCurrentUrl(),
                webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl()));
    }
}
