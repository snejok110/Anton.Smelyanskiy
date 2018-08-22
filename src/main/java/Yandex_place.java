import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

 class Yandex_place {

    private WebDriver driver;
    Yandex_place(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String MarketUrl = "https://www.yandex.ru/";

    @FindBy(xpath = "//*[@data-id=\"market\"]")
       WebElement YandexMarket;

    @FindBy(xpath = "//a[text()=\"Компьютеры\"]")
         WebElement computer;

    @FindBy(xpath = "//div[@class=\"catalog-menu__list\"]/a[text()=\"Ноутбуки\"]")
      WebElement notebook;

    @FindBy(xpath = "//div[@class=\"catalog-menu__list\"]/a[text()=\"Планшеты\"]")
       WebElement tablet;

    @FindBy(xpath = "//*[@id=\"glpriceto\"]")     //maxPriceField
       WebElement maxPriceField;
    @FindBy(xpath = "//*[@id=\"glpricefrom\"]")   //minPriceField
       WebElement minPriceField;


    @FindBy(xpath = "//div[@class=\"n-snippet-card2__hover\"]/..")
         List<WebElement> elements;


    @FindBy(xpath = "//*[@id=\"header-search\"]")
       WebElement searchProduct;
    @FindBy(xpath ="//span[text()= \"Найти\"]/..")
      WebElement FindProduct;


    @FindBy(xpath ="//div[@class=\"n-title__text\"]/h1")
      WebElement DeviseName;


    //Установка галки в чек-боксах
    public void selectCheckBox(String name) {
        String checkXpath = "//input[@name=\"Производитель " + name + "\"]";
             WebElement manufacture = driver.findElement(By.xpath(checkXpath));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
              executor.executeScript("arguments[0].click()", manufacture);
    }


    }
