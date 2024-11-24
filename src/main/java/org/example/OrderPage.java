
package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class OrderPage {

    private final WebDriver webDriver;
    // локатор для поля ввода имена
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    // локатор для поля ввода фамилии
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    // локатор для поля ввода адреса
    private final By locationField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор для селектора станции
    private final By stationSelector= By.xpath("//input[@placeholder='* Станция метро']");
    // локатор для поля ввода номера телефона
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // локатор для кнопки далее
    private final By nextButton = By.xpath(".//button [@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор для поля выбора даты
    private final By datePicker = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // локатор для поля срок аренды
    private final By rentalPeriod= By.xpath(".//div[@class='Dropdown-placeholder']");
    // локатор для поля ввода комментария
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор для кнопки заказать
    private final By orderButton = By.xpath(".//button [@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    // локатор для кнопки подтверждения заказа
    private final By confirmOrderButton = By.xpath(".//button [@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    // локатор для проверки номера заказа
    private final By orderReady = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void fullOrderForm (String name, String surname, String location, String phone, String station, String date, String period, String color, String commentForСourier) {
        webDriver.findElement(nameField).sendKeys(name);
        webDriver.findElement(surnameField).sendKeys(surname);
        webDriver.findElement(locationField).sendKeys(location);
        webDriver.findElement(stationSelector).click();
        String stationXpath = String.format(".//div[@class ='Order_Text__2broi' and text()='%s']",station );
        webDriver.findElement(By.xpath(stationXpath)).click();
        webDriver.findElement(phoneField).sendKeys(phone);
        webDriver.findElement(nextButton).click();
        webDriver.findElement(datePicker).sendKeys((CharSequence) date);
        webDriver.findElement(datePicker).sendKeys(Keys.ENTER);
        webDriver.findElement(rentalPeriod).click();
        String periodXpath = String.format(".//div[@class ='Dropdown-option' and text()='%s']",period );
        webDriver.findElement(By.xpath(periodXpath)).click();
        String checkboxColorXpath = String.format(".//label[text()='%s']",color);
        webDriver.findElement(By.xpath(checkboxColorXpath)).click();
        webDriver.findElement(comment).sendKeys(commentForСourier);
        webDriver.findElement(orderButton).click();
        webDriver.findElement(confirmOrderButton).click();

    }

    // Проверка того, что заказ оформлен

    public void checkingOrder () {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        String result = webDriver.findElement(orderReady).getAttribute("textContent");
        assertTrue(result.startsWith("Заказ оформлен"));
    }
}


// public boolean checkNotFoundPageShown() {
//     return !webDriver.findElements(By.xpath(".//img[@alt='Not found']")).isEmpty();
// }


