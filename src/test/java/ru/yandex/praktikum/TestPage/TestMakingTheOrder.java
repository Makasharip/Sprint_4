package ru.yandex.praktikum.TestPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktilum.HomePage.MainPageScooterService;
import ru.yandex.praktilum.HomePage.OrderInformationPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class TestMakingTheOrder {
    private WebDriver driver;
    @Before
    public void setPropAndStartBrowser() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.get("https://qa-scooter.praktikum-services.ru/");


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void TestWithUpperOrderButton() {
        OrderInformationPage orderInformationPage = new OrderInformationPage(driver);
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.clickUpperOrderButton();
        orderInformationPage.creatingAnOrder(
                "Макашарип",
                "Муртазалиев",
                "Махачкала, Пугачева 3А",
                "Лубянка",
                "+79993332211",
                "01.07.2022",
                "сутки",
                "чёрный жемчуг",
                "Домофон не работает, позвоните на мобильный");
    }
    @Test
    public void TestWithLowerOrderButton() {
        OrderInformationPage orderInformationPage = new OrderInformationPage(driver);
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.clickLowerOrderButton();
        orderInformationPage.creatingAnOrder(
                "Атаев",
                "Магомед",
                "Каспийск, Орджоникидзе 28",
                "Тверская",
                "+79214463322",
                "12.08.2022",
                "двое суток",
                "серая безысходность",
                "Желательно, чтобы привезли до обеда");
    }
    @After
    public void teardown(){
        OrderInformationPage orderInformationPage = new OrderInformationPage(driver);
        String expected = "Заказ оформлен";
        String actual = orderInformationPage.getNotificationOfOrderCreation();
        Assert.assertThat("Уведомление о создании заказа не появилось, или заказ не создан", actual, startsWith(expected));
        driver.quit();
    }
}
