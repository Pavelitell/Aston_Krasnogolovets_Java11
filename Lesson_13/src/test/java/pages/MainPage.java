package pages;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v121.browser.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {
    /*
 Необходимо написать автотесты для сайта mts.by. Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
1. Проверить название указанного блока;
2. Проверить наличие логотипов платёжных систем;
3. Проверить работу ссылки «Подробнее о сервисе»;
4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
  */
    @FindBy(xpath = "//*[@id=\"cookie-agree\"]") public WebElement cookieButton;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2") public WebElement title;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button") public WebElement selectHeader;
    //---------------------Услуги связи------------------------------
    @FindBy(xpath = "//*[@id=\"connection-phone\"]") private WebElement phoneTextBox;
    @FindBy(xpath = "//*[@id=\"connection-sum\"]") private WebElement sumTextBox;
    @FindBy(xpath = "//*[@id=\"connection-email\"]") private WebElement emailTextBox;
    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button") private WebElement continueButton;
    //---------------------------------Домашний интернет-----------------------
    @FindBy(xpath = "//*[@id=\"internet-phone\"]") private WebElement phoneTextBoxHomeInt;
    @FindBy(xpath = "//*[@id=\"internet-sum\"]") private WebElement sumTextBoxHomeInt;
    @FindBy(xpath = "//*[@id=\"internet-email\"]") private WebElement emailTextBoxHomeInt;
    @FindBy(xpath = "//*[@id=\"pay-internet\"]/button") private WebElement continueButtonHomeINt;
    //--------------------------------Рассрочка--------------------------------
    @FindBy(xpath = "//*[@id=\"score-instalment\"]") private WebElement accountNumber;
    @FindBy(xpath = "//*[@id=\"instalment-sum\"]") private WebElement instalmentSumTextBox;
    @FindBy(xpath = "//*[@id=\"instalment-email\"]") private WebElement instalmentEmailTextBox;
    @FindBy(xpath = "//*[@id=\"pay-instalment\"]/button") private WebElement instalmentContinueButton;
    //--------------------------------Задолженность----------------------------
    @FindBy(xpath = "//*[@id=\"score-arrears\"]") private WebElement scoreAccountNumber;
    @FindBy(xpath = "//*[@id=\"arrears-sum\"]") private WebElement scoreSumTextBox;
    @FindBy(xpath = "//*[@id=\"arrears-email\"]") private WebElement scoreEmailTextBox;
    @FindBy(xpath = "//*[@id=\"pay-arrears\"]/button") private WebElement scoreContinueButton;
    //------------------------------------------------------------------------------------
    @FindBy(className = "pay__partners") public List<WebElement> logoPaySystem;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a") public WebElement moreInfoButton;
    @FindBy(xpath = "//*[@id=\"pay-connection\"]/div[1]/p") public WebElement ErrorPhoneNumbermessege;

    public MainPage() {
        driver.get("https://www.mts.by/");
        PageFactory.initElements(driver, this);
    }
    public String moreInfoUrl = "poryadok-oplaty-i-bezopasnost-internet-platezhey";
    public String testPhoneNumber = "297777777";

    public String getMainTitle() {
        return title.getText();
    }

    public String getErrorPhoneNumbermessege(){
        return ErrorPhoneNumbermessege.getText();
    }

    public void e2eEmail() {
        phoneTextBox.click();
        phoneTextBox.sendKeys(testPhoneNumber);
        sumTextBox.click();
        sumTextBox.sendKeys("123");
        emailTextBox.click();
        emailTextBox.sendKeys("123@yandex.ru");
        continueButton.click();
    }

    public void NoEmailE2e() {
        phoneTextBox.click();
        phoneTextBox.sendKeys(testPhoneNumber);
        sumTextBox.click();
        sumTextBox.sendKeys("123");
        continueButton.click();
    }

    public void NoPhoneNumberE2e() {
        sumTextBox.click();
        sumTextBox.sendKeys("123");
        continueButton.click();
    }

    public void wrongPhoneNumberE2e() {
        phoneTextBox.click();
        phoneTextBox.sendKeys("2977777");
        sumTextBox.click();
        sumTextBox.sendKeys("123");
        continueButton.click();
    }

    public void NoSumE2e() {
        phoneTextBox.click();
        phoneTextBox.sendKeys(testPhoneNumber);
        continueButton.click();
    }

    public static class Iframe {
        @FindBy(xpath = "//iframe[@class = 'bepaid-iframe']")
        private WebElement payMentContainer;
        @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/div/span[1]")
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

        public Iframe() {
            PageFactory.initElements(driver, this);
        }

        public String getPayMentContainerTitleSum() {
            return payMentContainerTitleSumm.getText();
        }

        public String getPayMentContainerNumber() {
            return payMentContainerNumber.getText();
        }

        public void goToIframe() {
            driver.switchTo().frame(payMentContainer);
        }
    }
}
