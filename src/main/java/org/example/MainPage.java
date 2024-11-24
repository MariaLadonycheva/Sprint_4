
package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MainPage {

    private final WebDriver webDriver;

    private final String url = "https://qa-scooter.praktikum-services.ru/";
    // локатор для кнопки "Заказать" вверху страницы
    private final By orderButtonTop = By.xpath(".//button [@class='Button_Button__ra12g']");
    // локатор для кнопки "Заказать" внизу страницы
    private final By orderButtonBottom = By.xpath(".//button [@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор для кнопки подтверждения использования кук
    private final By confirmCookie = By.xpath(".//button[@id='rcc-confirm-button']");

    private final By beginningQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    //Локатор для вопроса
    private final String question = ".//div[text()='%s']";
    //Локатор для ответа на вопрос
    private final String accordionPanel = ".//div[@id='accordion__panel-%d']";
    private int itemIndex;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage open() {
        webDriver.get(url);
        return this;
    }

    public MainPage clickOrderButtonTop() {
        webDriver.findElement(orderButtonTop).click();
        return this;
    }


    public MainPage clickOrderButtonBottom() {
        webDriver.findElement(orderButtonBottom).click();
        return this;
    }
    public MainPage scrollToQuestions()
    {
        webDriver.findElement(confirmCookie).click();
        // локатор для вопросов о важном
        WebElement element = webDriver.findElement(beginningQuestions);
        new Actions(webDriver)
                .scrollToElement(element)
                .perform();

        return this;


    }

    public MainPage acteptCookie() {
        webDriver.findElement(confirmCookie).click();
        return this;
    }

    public String getItemText(String questionText) {
        webDriver.findElement(By.xpath(String.format(question, questionText))).click();
        try {
            Thread.sleep(6000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath(String.format(accordionPanel))).isDisplayed();
        return webDriver.findElement(By.xpath(String.format(accordionPanel))).getText();
    }


}


