package net.prodigylabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{
    @FindBy(xpath = "//li[@id='menu-item-5797']/a[text()='Contact']")
    public WebElement contactLink;

    @FindBy(xpath = "//h4[text()='info@prodigylabs.net']")
    public WebElement emailText;

    @FindBy(xpath = "//h4[text()='80 Richmond St. West, Suite 1401']")
    public WebElement addressText;

    @FindBy(xpath = "//iframe[@id='hs-form-iframe-0']")
    public WebElement iframeID;

    @FindBy(xpath = "//input[contains(@id,'firstname')]")
    public WebElement firstnameBox;
    @FindBy(xpath = "//input[contains(@id,'lastname')]")
    public WebElement lastnameBox;
    @FindBy(xpath = "//input[contains(@id,'email')]")
    public WebElement emailBox;
    @FindBy(xpath = "//select[contains(@id,'industry')]")
    public WebElement industryDropdown;
    @FindBy(xpath = "//input[contains(@id,'city')]")
    public WebElement cityBox;
    @FindBy(xpath = "//textarea[contains(@id,'message')]")
    public WebElement messageBox;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = " //label[text()='Email must be formatted correctly.']")
    public WebElement emailErrorMessage;





















}
