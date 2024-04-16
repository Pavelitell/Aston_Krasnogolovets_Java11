package tests;

import core.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        actions.moveToElement(mainPage.title);
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
    //Тест заполнения полей и работы кнопки продолжить
    public void e2e() {
        mainPage.e2eEmail();
        iframeClass.goToIframe();
        assertTrue(iframeClass.getPayMentContainerTitleSum().contains("123.00 BYN"));
        assertTrue(iframeClass.getPayMentContainerNumber().contains("Оплата: Услуги связи Номер:375" + mainPage.testPhoneNumber));
    }

    @Test
    @Order(5)
    //Тест заполнения полей и работы кнопки продолжить без ввода Email
    public void e2eNoEmail() {
        mainPage.NoEmailE2e();
        iframeClass.goToIframe();
        assertTrue(iframeClass.getPayMentContainerTitleSum().contains("123.00 BYN"));
        assertTrue(iframeClass.getPayMentContainerNumber().contains("Оплата: Услуги связи Номер:375" + mainPage.testPhoneNumber));
    }
    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class NegtiveTest {
        MainPage mainPage = new MainPage();
        MainPage.Iframe iframeClass = new MainPage.Iframe();

        @Test
        @Order(1)
        /*не оч понимаю как отловить всплывающее окно введите текст, в DOMе не могу найти локатор
        поэтому решил ориентировать на исключение, тк элемента действительно не должно быть*/
        public void CommunicationServiciesNoNoMany() {
            mainPage.cookieButton.click();
            mainPage.NoSumE2e();
          assertThrows(NoSuchElementException.class,() ->iframeClass.getPayMentContainerNumber().contains("Оплата: Услуги связи Номер:375" + mainPage.testPhoneNumber));
        }

        @Test
        @Order(2)
        //Проверка Сообщения об ошибке, если ввести неправельный телефон
        public void CommunicationServiciesNoPhone() {
            mainPage.wrongPhoneNumberE2e();
            assertTrue(mainPage.getErrorPhoneNumbermessege().contains("Введите номер телефона"));
        }
    }
}