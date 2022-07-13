package ru.yandex.praktikum.TestPage;

import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktilum.HomePage.MainPageScooterService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;


public class TestAnswers {
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
    public void checkAnswer1(){
        String Answer1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.getHowMuchDoesItCostAnswer();
        assertEquals("Ответ на первый вопрос неверный", Answer1, mainPageScooterService.getHowMuchDoesItCostAnswer());
    }
    @Test
    public void checkAnswer2(){
        String Answer2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                "можете просто сделать несколько заказов — один за другим.";
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.getWantSeveralScootersAtOnceAnswer();
        assertEquals("Ответ на второй вопрос неверный", Answer2, mainPageScooterService.getWantSeveralScootersAtOnceAnswer());
    }
    @Test
    public void checkAnswer3(){
        String Answer3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.getHowRentalTimeCalculatedAnswer();
        assertEquals("Ответ на третий вопрос неверный", Answer3, mainPageScooterService.getHowRentalTimeCalculatedAnswer());
    }
    @Test
    public void checkAnswer4(){
        String Answer4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.getPossibleToOrderScooterToday();
        assertEquals("Ответ на четвертый вопрос неверный", Answer4, mainPageScooterService.getPossibleToOrderScooterToday());
    }
    @Test
    public void checkAnswer5(){
        String Answer5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.getPossibleToExtendOrderOrReturnEarlier();
        assertEquals("Ответ на пятый вопрос неверный", Answer5, mainPageScooterService.getPossibleToExtendOrderOrReturnEarlier());
    }
    @Test
    public void checkAnswer6(){
        String Answer6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                "даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.getChargingAlongWithScooter();
        assertEquals("Ответ на шестой вопрос неверный", Answer6, mainPageScooterService.getChargingAlongWithScooter());
    }
    public void checkAnswer7(){
        String Answer7 = "Да, пока самокат не привезли. Штрафа не будет, " +
                "объяснительной записки тоже не попросим. Все же свои.";
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.getPossibleToCancelOrder();
        assertEquals("Ответ на седьмой вопрос неверный", Answer7, mainPageScooterService.getPossibleToCancelOrder());
    }
    @Test
    public void checkAnswer8(){
        String Answer8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.closeCookieButton();
        mainPageScooterService.getBringScooterBeyondMKAD();
        assertEquals("Ответ на восьмой вопрос неверный", Answer8, mainPageScooterService.getBringScooterBeyondMKAD());
    }



    @After
    public void teardown(){

        driver.quit();
    }


}
