package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Iframe extends BasePage {
    @FindBy(xpath = "/html/body/div[9]/div/iframe")
    public WebElement payMentContainer;
    @FindBy(xpath = "*//div[@class = 'pay-description__cost']")
    public WebElement payMentContainerTitleSumm;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/p")
    public WebElement payMentContainerNumber;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/app-header/header/app-back-navigation/div/div/svg-icon/svg")
    public WebElement payMentContainerESCButtun;
    @FindBy(xpath = "//*[@id=\"cc-number\"]")
    public WebElement cartNumber;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/input")
    public WebElement cartValidity;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/input")
    public WebElement cartCVC;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/input")
    public WebElement cartName;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/button") public WebElement payButton;

    public Iframe (){
        PageFactory.initElements(driver,this);
    }

    public String getPayMentContainerTitleSum() {
        return payMentContainerTitleSumm.getText();
    }

    public String getPayMentContainerNumber() {
        return payMentContainerNumber.getText();
    }

    public void goToIframe() {
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame(iframe);
        System.out.println(payMentContainerTitleSumm.getText());
    }
}
