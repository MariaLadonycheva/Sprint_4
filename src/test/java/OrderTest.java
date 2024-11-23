import org.example.MainPage;
import org.example.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderTest {


    //String geckoPath = "C:\\\\Users\\\\pc\\\\Downloads\\\\sprint4\\\\drivers\\\\";
    private WebDriver driver;


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
        orderPage.fullOrderForm("Ирина", "Петрова","Комсомольская, дом 1","+7988888888","Сокол","01.12.2024","трое суток","серая безысходность","");
        orderPage.checkingOrder();
    }
    @Test
    public void positiveOrderButtonAtTheTop() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage=new OrderPage(driver);
        mainPage.open()
                .acteptCookie()
                .clickOrderButtonTop();
        orderPage.fullOrderForm("Фёдор", "Туманов","Проспект мира, дом 78","+7983338888","Фили","06.12.2024","сутки","чёрный жемчуг","Секция 8");
        orderPage.checkingOrder();

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

