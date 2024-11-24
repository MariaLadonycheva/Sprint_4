import org.example.MainPage;
import org.example.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class OrderTest {


    //String geckoPath = "C:\\\\Users\\\\pc\\\\Downloads\\\\sprint4\\\\drivers\\\\";
    private WebDriver driver;
    private final String name,surname,location,phone,station,date,period,color,commentForCourier ;

    public OrderTest(String name, String surname, String location, String phone, String station, String date, String period, String color, String commentForCourier) {
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.phone = phone;
        this.station = station;
        this.date = date;
        this.period = period;
        this.color = color;
        this.commentForCourier = commentForCourier;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Ирина", "Петрова", "Комсомольская, дом 1", "+7988888888", "Сокол", "01.12.2024", "трое суток", "серая безысходность", ""},
                {"Фёдор", "Туманов", "Проспект мира, дом 78", "+7983338888", "Фили", "06.12.2024", "сутки", "чёрный жемчуг", "Секция 8"}
        });
    }

    @Before
    public void initSession() {
        // System.out.println("Запускаем браузер Firefox");
        //  System.setProperty("webdriver.gecko.driver", geckoPath + "geckodriver.exe");
        driver = new ChromeDriver();

    }


    @Test
    public void positiveOrderButtonAtTheBottom() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage=new OrderPage(driver);
        mainPage.open()
                .acteptCookie()
                .clickOrderButtonBottom();
        orderPage.fullOrderForm(name,surname,location,phone,station,date,period,color,commentForCourier);
        orderPage.checkingOrder();
    }
    @Test
    public void positiveOrderButtonAtTheTop() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage=new OrderPage(driver);
        mainPage.open()
                .acteptCookie()
                .clickOrderButtonTop();
        orderPage.fullOrderForm(name,surname,location,phone,station,date,period,color,commentForCourier);
        orderPage.checkingOrder();

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

