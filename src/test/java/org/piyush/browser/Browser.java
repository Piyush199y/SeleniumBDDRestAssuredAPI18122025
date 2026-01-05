package org.piyush.browser;
import org.openqa.selenium.WebDriver;

public abstract class Browser {

    protected WebDriver driver;

    public abstract WebDriver start();

    public abstract void quit();
}
