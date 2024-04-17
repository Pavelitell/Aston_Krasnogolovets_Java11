package tests;

import core.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;

//Определяю последовательность
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OnlineReplenishmentTest extends BaseTest {
    MainPage mainPage = new MainPage();
    MainPage.Iframe iframeClass = new MainPage.Iframe();
    Actions actions = new Actions(driver);

    @Test
    @Order(1)
    //Тест отображения тайтла
    public void cookieDisaktiveAndCheckRightWorkPlaceTest() {
        mainPage.cookieButton.click();
        actions.moveToElement(mainPage.continueButton);
        actions.perform();
        assertTrue(mainPage.getMainTitle().contains("Онлайн пополнение"));
    }

    @Test
    @Order(2)
    //Тест наличия логотипов оплаты
    public void logos() {
        Assertions.assertFalse(mainPage.logoPaySystem.isEmpty());
    }

    @Test
    @Order(3)
    //Тест работы ссылки "Подробнее о сервере"
    public void moreInfo() {
        mainPage.moreInfoButton.click();
        assertTrue(driver.getCurrentUrl().contains(mainPage.moreInfoUrl));
    }

    @Test
    @Order(4)
    //Тест заполнения полей и работы кнопки продолжить.
    public void e2e() throws InterruptedException {
        mainPage.e2eEmail();
        iframeClass.goToIframe();
        assertTrue(iframeClass.getPayMentContainerTitleSum().contains("123.00 BYN"));
        Thread.sleep(1000);
        assertTrue(iframeClass.getPayMentContainerNumber().contains("Оплата: Услуги связи Номер:375" + mainPage.testPhoneNumber));
    }

    @Test
    @Order(5)
    //Тест заполнения полей и работы кнопки продолжить без ввода Email
    public void e2eNoEmail() throws InterruptedException {
        mainPage.NoEmailE2e();
        iframeClass.goToIframe();
        assertTrue(iframeClass.getPayMentContainerTitleSum().contains("123.00 BYN"));
        Thread.sleep(1000);
        assertTrue(iframeClass.getPayMentContainerNumber().contains("Оплата: Услуги связи Номер:375" + mainPage.testPhoneNumber));
    }

    @Test
    @Order(6)
    public void communicationGetInputText() {
        Assertions.assertTrue(mainPage.phoneTextBox.getDomProperty("placeholder").contains("Номер телефона"));
        Assertions.assertTrue(mainPage.sumTextBox.getDomProperty("placeholder").contains("Сумма"));
        Assertions.assertTrue(mainPage.emailTextBox.getDomProperty("placeholder").contains("E-mail для отправки чека"));
    }

    @Test
    @Order(7)
    public void homeInternetGetInputText() {
        mainPage.selectHeader.click();
        mainPage.homeInternetSelectHeader.click();
        Assertions.assertTrue(mainPage.phoneTextBoxHomeInt.getDomProperty("placeholder").contains("Номер абонента"));
        Assertions.assertTrue(mainPage.sumTextBoxHomeInt.getDomProperty("placeholder").contains("Сумма"));
        Assertions.assertTrue(mainPage.emailTextBoxHomeInt.getDomProperty("placeholder").contains("E-mail для отправки чека"));
    }

    @Test
    @Order(8)
    public void rassrochkaGetInputText() {
        mainPage.selectHeader.click();
        mainPage.selectHeaderRassrochca.click();
        Assertions.assertTrue(mainPage.rassrochkaAccountNumber.getDomProperty("placeholder").contains("Номер счета на 44"));
        Assertions.assertTrue(mainPage.instalmentSumTextBox.getDomProperty("placeholder").contains("Сумма"));
        Assertions.assertTrue(mainPage.instalmentEmailTextBox.getDomProperty("placeholder").contains("E-mail для отправки чека"));
    }

    @Test
    @Order(9)
    public void zadolzhennostGetInputText() {
        mainPage.selectHeader.click();
        mainPage.selectHeaderZadolzhennost.click();
        Assertions.assertTrue(mainPage.scoreAccountNumber.getDomProperty("placeholder").contains("Номер счета на 2073"));
        Assertions.assertTrue(mainPage.scoreSumTextBox.getDomProperty("placeholder").contains("Сумма"));
        Assertions.assertTrue(mainPage.scoreEmailTextBox.getDomProperty("placeholder").contains("E-mail для отправки чека"));
    }

    @Test
    @Order(10)
    //Проверяем полную информацию с платежного фрейма
    public void cartInputText() throws InterruptedException {
        mainPage.e2eEmail();
        iframeClass.goToIframe();
        Thread.sleep(2000);
        assertTrue(iframeClass.getPayMentContainerTitleSum().contains("123.00 BYN"));
        assertTrue(iframeClass.getPayMentContainerNumber().contains("Оплата: Услуги связи Номер:375" + mainPage.testPhoneNumber));
        assertTrue(iframeClass.cartNumberInputMessege.getText().contains("Номер карты"));
        assertTrue(iframeClass.cartValidityInputMessege.getText().contains("Срок действия"));
        assertFalse(iframeClass.cartIcons.isEmpty());
        assertTrue(iframeClass.cartCVCInputMessege.getText().contains("CVC"));
        assertTrue(iframeClass.cartNameInputMessege.getText().contains("Имя держателя"));
        assertTrue(iframeClass.payButtonMessege.getText().contains("Оплатить 123.00 BYN"));
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class NegtiveTest {

        @Test
        @Order(1)
        //Проверка Сообщения об ошибке, если ввести неправельный телефон
        public void CommunicationServiciesNoPhone() {
            mainPage.wrongPhoneNumberE2e();
            assertTrue(mainPage.getErrorPhoneNumbermessege().contains("Введите номер телефона"));
        }

        @Test
        @Order(2)
        /*не оч понимаю как отловить всплывающее окно введите текст, в DOMе не могу найти локатор
        поэтому решил ориентировать на исключение, тк элемента, которого я указал в асерте действительно не должно быть*/
        public void CommunicationServiciesNoNoMany() {
            mainPage.NoSumE2e();
            assertThrows(NoSuchElementException.class, () -> iframeClass.getPayMentContainerNumber().contains("Оплата: Услуги связи Номер:375" + mainPage.testPhoneNumber));
        }

    }
}