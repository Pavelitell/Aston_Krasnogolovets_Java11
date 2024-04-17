package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {
    /* задание 13
 Необходимо написать автотесты для сайта mts.by. Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
1. Проверить название указанного блока;
2. Проверить наличие логотипов платёжных систем;
3. Проверить работу ссылки «Подробнее о сервисе»;
4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
  */
    /* Задание 14
    Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке), номера телефона,
 а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем.
     */

    public String moreInfoUrl = "poryadok-oplaty-i-bezopasnost-internet-platezhey";
    public String testPhoneNumber = "297777777";



    @FindBy(xpath = "//*[@id=\"cookie-agree\"]") public WebElement cookieButton;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2") public WebElement title;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button") public WebElement selectHeader;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p") public WebElement homeInternetSelectHeader;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p") public WebElement selectHeaderRassrochca;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")public WebElement selectHeaderZadolzhennost;
    //---------------------Услуги связи------------------------------
    @FindBy(xpath = "//*[@id=\"connection-phone\"]") public WebElement phoneTextBox;
    @FindBy(xpath = "//*[@id=\"connection-sum\"]") public WebElement sumTextBox;
    @FindBy(xpath = "//*[@id=\"connection-email\"]") public WebElement emailTextBox;
    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button") public WebElement continueButton;
    //---------------------------------Домашний интернет-----------------------
    @FindBy(xpath = "//*[@id=\"internet-phone\"]") public WebElement phoneTextBoxHomeInt;
    @FindBy(xpath = "//*[@id=\"internet-sum\"]") public WebElement sumTextBoxHomeInt;
    @FindBy(xpath = "//*[@id=\"internet-email\"]") public WebElement emailTextBoxHomeInt;
    @FindBy(xpath = "//*[@id=\"pay-internet\"]/button") public WebElement continueButtonHomeINt;
    //--------------------------------Рассрочка--------------------------------
    @FindBy(xpath = "//*[@id=\"score-instalment\"]") public WebElement rassrochkaAccountNumber;
    @FindBy(xpath = "//*[@id=\"instalment-sum\"]") public WebElement instalmentSumTextBox;
    @FindBy(xpath = "//*[@id=\"instalment-email\"]") public WebElement instalmentEmailTextBox;
    @FindBy(xpath = "//*[@id=\"pay-instalment\"]/button") private WebElement instalmentContinueButton;
    //--------------------------------Задолженность----------------------------
    @FindBy(xpath = "//*[@id=\"score-arrears\"]") public WebElement scoreAccountNumber;
    @FindBy(xpath = "//*[@id=\"arrears-sum\"]") public WebElement scoreSumTextBox;
    @FindBy(xpath = "//*[@id=\"arrears-email\"]") public WebElement scoreEmailTextBox;
    @FindBy(xpath = "//*[@id=\"pay-arrears\"]/button") private WebElement scoreContinueButton;
    //------------------------------------------------------------------------------------
    @FindBy(className = "pay__partners") public List<WebElement> logoPaySystem;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a") public WebElement moreInfoButton;
    @FindBy(xpath = "//*[@id=\"pay-connection\"]/div[1]/p") public WebElement ErrorPhoneNumbermessege;

    public MainPage() {
        driver.get("https://www.mts.by/");
        PageFactory.initElements(driver, this);
    }


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
}
